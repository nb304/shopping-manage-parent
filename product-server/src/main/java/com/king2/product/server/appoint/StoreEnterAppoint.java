package com.king2.product.server.appoint;

import com.king2.commons.mapper.K2MessageMapper;
import com.king2.commons.mapper.K2StoreCheckMapper;
import com.king2.commons.mapper.K2StroeMapper;
import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.pojo.K2StoreCheck;
import com.king2.commons.pojo.K2Stroe;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.enmu.StoreEnterStateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * 店铺入驻委托类
 */
@Component
public class StoreEnterAppoint {

    // 注入店铺Mapper
    @Autowired
    private K2StoreCheckMapper k2StoreCheckMapper;
    // 注入后台主页的信息
    @Value("${SHOP_SYSTEM_ADMIN_URL}")
    private String SHOP_SYSTEM_ADMIN_URL;
    // 注入信息Mapper
    @Autowired
    private K2MessageMapper k2MessageMapper;
    // 注入店铺Mapper
    @Autowired
    private K2StroeMapper k2StroeMapper;
    // 暂无图片
    @Value("${PRODUCT_IMAGE_NOT_DEFINITION}")
    private String PRODUCT_IMAGE_NOT_DEFINITION;

    /**
     * 校验店铺信息并返回对应的数据
     *
     * @return
     */
    public SystemResult checkStoreInfoAndReturnResult(Integer state, Integer enterId, String content, K2MemberAndElseInfo k2MemberAndElseInfo) {

        // 判断状态
        if (!(state + "").equals(StoreEnterStateEnum.TG.getValue() + "") &&
                !(state + "").equals(StoreEnterStateEnum.WTG.getValue() + "")) {
            return new SystemResult(100, "状态未通过");
        } else if ((state + "").equals(StoreEnterStateEnum.WTG.getValue() + "") &&
                StringUtils.isEmpty(content)) {
            return new SystemResult(100, "拒绝理由不能为空");
        }

        // 查询店铺信息是否存在
        K2StoreCheck k2StoreCheck = k2StoreCheckMapper.selectByPrimaryKey(enterId);
        if (k2StoreCheck == null) {
            return new SystemResult(100, "店铺的信息不存在");
        } else if (!(k2StoreCheck.getStoreCheckState() + "").equals(StoreEnterStateEnum.WCL.getValue() + "")) {
            return new SystemResult(100, "该入驻信息已经被处理，请刷新页面重试");
        }

        // 设置状态值
        if ((state + "").equals(StoreEnterStateEnum.WTG.getValue() + "")) {
            k2StoreCheck.setRetain1(content);
        }
        k2StoreCheck.setStoreCheckDisposeName(k2MemberAndElseInfo.getK2Member().getMemberAccount());
        k2StoreCheck.setStoreCheckDisposeId(k2MemberAndElseInfo.getK2Member().getMemberId());
        k2StoreCheck.setStoreCheckState(state);
        return new SystemResult(k2StoreCheck);
    }


    /**
     * 通过状态 操作该店铺的信息
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public SystemResult functionStoreByState(K2StoreCheck k2StoreCheck, String content) {

        // 定义发送的消息
        StringBuffer msg = new StringBuffer();

        // 校验状态
        if (k2StoreCheck.getStoreCheckState().toString().equals(StoreEnterStateEnum.TG.getValue() + "")) {
            // 状态为通过

            // 往店铺的表中插入数据
            // 获取店铺的信息
            K2Stroe storeByStoreEnterInfo = getStoreByStoreEnterInfo(k2StoreCheck);
            // 插入信息
            k2StroeMapper.insert(storeByStoreEnterInfo);
            // 给该用户发送信息 通知审核已经通过
            msg.append("您的入住审核已经通过,感谢您对我们的信任,登入后台商家系统即可对店铺进行管理,系统地址为：");
            msg.append(SHOP_SYSTEM_ADMIN_URL);
            msg.append(",若有其他疑问,请联系系统管理员。---来自于系统管理员");
        } else {
            // 不通过
            // 给该用户发送信息 通知审核不通过
            msg.append("很遗憾您的入驻审核没有通过,拒绝理由为:");
            msg.append(content);
            msg.append(",感谢您对我们的信任,你可以根据拒绝信息,重新填写资料并重新发起申请。---来自于系统管理员");
        }

        // 给用户发送信息
        UserMessageAppoint.addMessageGotoMysql(msg.toString(), k2StoreCheck.getStoreCheckUserId(), k2MessageMapper);
        return new SystemResult("ok");
    }

    /**
     * 返回店铺的信息
     *
     * @param k2StoreCheck
     * @return
     */
    public K2Stroe getStoreByStoreEnterInfo(K2StoreCheck k2StoreCheck) {
        K2Stroe store = new K2Stroe();
        store.setStroeName(k2StoreCheck.getStoreCheckName());
        store.setStoreImage(PRODUCT_IMAGE_NOT_DEFINITION);
        store.setStoreLogoImage(PRODUCT_IMAGE_NOT_DEFINITION);
        store.setBelongUserId(k2StoreCheck.getStoreCheckUserId());
        store.setStoreProceedsZfb(k2StoreCheck.getStoreCheckZfb());
        store.setStoreDescribe("没有签名的我可以更酷");
        store.setStorePhone(k2StoreCheck.getStoreCheckPhone());
        store.setStoreState(1);
        store.setStoreLeven(1);
        store.setCreateTime(new Date());
        return store;
    }

}
