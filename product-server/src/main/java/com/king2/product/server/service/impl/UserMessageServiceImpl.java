package com.king2.product.server.service.impl;

import com.king2.commons.mapper.K2MessageMapper;
import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.pojo.K2Message;
import com.king2.commons.pojo.K2MessageExample;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.appoint.SystemIndexManageAppiont;
import com.king2.product.server.appoint.UserMessageAppoint;
import com.king2.product.server.enmu.K2MessageEnum;
import com.king2.product.server.service.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*=======================================================
	说明:    用户消息Service实现类

	作者		时间					注释
  	俞烨		2019.08.25   			创建
=======================================================*/
@Service
public class UserMessageServiceImpl implements UserMessageService {

    // 注入消息Mapper
    @Autowired
    private K2MessageMapper k2MessageMapper;

    // 注入首页管理委托类
    @Autowired
    private SystemIndexManageAppiont systemIndexManageAppiont;


    /**
     * -----------------------------------------------------
     * 功能:  根据传过来的状态设置消息的状态
     * <p>
     * 参数:
     * k2MemberAndElseInfo      K2MemberAndElseInfo     登入的用户信息
     * messageId                Integer                 消息的id
     * statw                    String                  消息的状态
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult messageRead(Integer messageId, K2MemberAndElseInfo k2MemberAndElseInfo, String state) {

        // 判断消息状态是否正确
        if (!state.equals(K2MessageEnum.YD.getValue() + "") && !state.equals(K2MessageEnum.DEL.getValue() + "")) {
            return new SystemResult(100, "消息的状态错误", null);
        }

        // 查询消息是否存在
        K2Message k2Message = k2MessageMapper.selectByPrimaryKey(messageId);
        if (k2Message == null) return new SystemResult(100, "该消息不存在", null);

        // 判断该消息是否属于该用户
        if (!k2Message.getUserId().toString().equals(k2MemberAndElseInfo.getK2Member().getMemberId().toString())) {
            return new SystemResult(100, "请勿修改别人的数据", null);
        }

        // 获取修改前的信息状态
        Integer oldState = k2Message.getState();

        // 修改消息的状态
        k2Message.setState(Integer.parseInt(state));
        // 修改商品的数据
        k2MessageMapper.updateByPrimaryKeySelective(k2Message);

        // 更改缓存数据
        SystemResult result = systemIndexManageAppiont.editUserMessageById(state, oldState.toString(), k2MemberAndElseInfo, messageId.toString());

        return result;
    }

    /**
     * -----------------------------------------------------
     * 功能:  清空或删除所有信息
     * <p>
     * 参数:
     * state      String     状态
     * userId     Integer    操作人的id
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult clearOrReadMessage(String state, Integer userId) {

        // 创建消息状态
        K2Message k2Message = new K2Message();

        // 根据状态做出不同的操作
        if ("2".equals(state)) {
            // 将消息变成已读
            k2Message.setState(K2MessageEnum.YD.getValue());
        } else if ("3".equals(state)) {
            // 将消息全部删除
            k2Message.setState(K2MessageEnum.DEL.getValue());
        }

        // 根据状态清空或删除缓存中的数据
        UserMessageAppoint.clearOrReadMessageByUserIdAndState(userId, state);

        // 查询是否需要修改数据库的数据
        if (k2Message.getState() != null && k2Message.getState() != 0) {
            K2MessageExample example = new K2MessageExample();
            example.createCriteria().andUserIdEqualTo(userId).andStateNotEqualTo(K2MessageEnum.DEL.getValue());
            k2MessageMapper.updateByExampleSelective(k2Message, example);
        }

        return new SystemResult("ok");
    }
}
