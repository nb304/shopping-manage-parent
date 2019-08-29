package com.king2.product.server.service.impl;

import com.king2.commons.mapper.K2ProductEvaluateMapper;
import com.king2.commons.pojo.*;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.appoint.UserMessageAppoint;
import com.king2.product.server.dto.LockPojo;
import com.king2.product.server.dto.ProductEvaluateIndexDto;
import com.king2.product.server.enmu.K2ProductEvaluateEnum;
import com.king2.product.server.enmu.ProductQueueLockFactoryTypeEnum;
import com.king2.product.server.locks.ProductQueueLockFactory;
import com.king2.product.server.mapper.ProductEvaluateMapper;
import com.king2.product.server.pojo.ProductEvaluatePojo;
import com.king2.product.server.service.ProductEvaluateManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/*=======================================================
	说明:   商品评价管理Service实现类

	作者		时间					注释
  	俞烨		2019.08.29   			创建
=======================================================*/
@Service
@SuppressWarnings("all")
public class ProductEvaluateManageServiceImpl implements ProductEvaluateManageService {

    // 注入管理员标识符
    @Value("${SYSTEM_ROLE_PROVE}")
    private String SYSTEM_ROLE_PROVE;

    // 注入商品评价Mapper
    @Autowired
    private ProductEvaluateMapper productEvaluateMapper;

    // 注入远程的商品评价Mapper
    @Autowired
    private K2ProductEvaluateMapper k2ProductEvaluateMapper;

    /**
     * -----------------------------------------------------
     * 功能:  显示商品评价的首页
     * <p>
     * 参数:
     * k2MemberAndElseInfo         K2MemberAndElseInfo        操作的用户信息
     * dto              ProductEvaluateIndexDto 分页数据
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult index(ProductEvaluateIndexDto evaluateIndexDto, K2MemberAndElseInfo k2MemberAndElseInfo) {

        // 查看用户是否是管理员 如果是管理员 就查询该系统的评价信息
        Boolean adminRole = isAdminRole(SYSTEM_ROLE_PROVE, k2MemberAndElseInfo);

        // 给时间做校验
        SystemResult result = checkTimeData(evaluateIndexDto);
        if (result.getStatus() != 200) return result;

        // 店铺Id
        Integer stroeId = null;
        // 校验返回值
        if (adminRole) {
            //是管理员 就查询该系统的评价信息
            stroeId = null;
        } else {
            // 如果不是管理员 就查询该店铺的信息
            stroeId = Integer.parseInt(k2MemberAndElseInfo.getK2Member().getRetain1());
        }

        // 总数量
        int totalSize = productEvaluateMapper.getProductEvaluateSize
                (
                        StringUtils.isEmpty(evaluateIndexDto.getOrderNumber()) ? null : evaluateIndexDto.getOrderNumber(),
                        StringUtils.isEmpty(evaluateIndexDto.getUserName()) ? null : evaluateIndexDto.getUserName(),
                        evaluateIndexDto.getIsHZCState() == null ? null : evaluateIndexDto.getIsHZCState(),
                        evaluateIndexDto.getStartTime(), evaluateIndexDto.getEndTime(), stroeId
                );

        evaluateIndexDto.setTotalSize(totalSize);
        // 求出总页数
        int totalPage = (totalSize + evaluateIndexDto.getCurrentSize() - 1) / evaluateIndexDto.getCurrentSize();
        evaluateIndexDto.setTotlaPage(totalPage);

        // 查看当前页数是否大于总页数
        if (evaluateIndexDto.getCurrentPage() > totalPage) evaluateIndexDto.setCurrentPage(totalPage);

        // 计算出索引值
        int index = (evaluateIndexDto.getCurrentPage() - 1) < 0 ? 0 : (evaluateIndexDto.getCurrentPage() - 1) * evaluateIndexDto.getCurrentSize();

        // 查询评价值
        List<ProductEvaluatePojo> productEvaluateList = productEvaluateMapper.getProductEvaluateList
                (
                        StringUtils.isEmpty(evaluateIndexDto.getOrderNumber()) ? null : evaluateIndexDto.getOrderNumber(),
                        StringUtils.isEmpty(evaluateIndexDto.getUserName()) ? null : evaluateIndexDto.getUserName(),
                        evaluateIndexDto.getIsHZCState() == null ? null : evaluateIndexDto.getIsHZCState(),
                        evaluateIndexDto.getStartTime(), evaluateIndexDto.getEndTime(), stroeId, index, evaluateIndexDto.getCurrentSize()
                );
        // 处理商品的图片
        productEvaluateList.forEach((e) -> {
            e.setpImage(StringUtils.isEmpty(e.getpImage()) ? "" : e.getpImage().split(",")[0]);
            e.setCreateTimeStr(UserMessageAppoint.sdf.format(e.getCreateTime()));
        });
        evaluateIndexDto.setProductEvaluateDatas(productEvaluateList);
        return new SystemResult(evaluateIndexDto);
    }

    /**
     * -----------------------------------------------------
     * 功能:  回复买家的评论
     * <p>
     * 参数:
     * k2MemberAndElseInfo         K2MemberAndElseInfo        操作的用户信息
     * evaId            Integer                 评价的id
     * content          String                  回复的内容
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult replyContent(Integer evaId, K2MemberAndElseInfo k2MemberAndElseInfo, String content) {

        // 获取锁
        LockPojo lockPojo = ProductQueueLockFactory.getInstance().getLockMaps().get(ProductQueueLockFactoryTypeEnum.PRODUCT_EVALUATE_KEY.getValue());
        // 加锁
        lockPojo.getLock().lock();

        try {
            // 校验评价是否存在
            K2ProductEvaluateExample example = new K2ProductEvaluateExample();
            example.createCriteria()
                    .andProductEvaluateIdEqualTo(evaId)
                    .andProductEvaluateStateNotEqualTo(K2ProductEvaluateEnum.DEL.getValue())
                    .andRetain1IsNull();
            List<K2ProductEvaluateWithBLOBs> k2ProductEvaluates = k2ProductEvaluateMapper.selectByExampleWithBLOBs(example);

            if (CollectionUtils.isEmpty(k2ProductEvaluates)) return new SystemResult(100,"该评价已被删除或以回复");
            K2ProductEvaluateWithBLOBs k2ProductEvaluate = k2ProductEvaluates.get(0);

            // 设置值
            k2ProductEvaluate.setIsRead(K2ProductEvaluateEnum.IS_READ_TRUE.getValue());
            k2ProductEvaluate.setRetain1(content);
            // 回复时间
            k2ProductEvaluate.setRetain2(UserMessageAppoint.sdf.format(new Date()));
            // 修改数据
            k2ProductEvaluateMapper.updateByPrimaryKeySelective(k2ProductEvaluate);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lockPojo.getLock().unlock();
        }


        return new SystemResult("回复成功");
    }

    /**
     * 校验登入的用户是否是管理员
     *
     * @param SYSTEM_ROLE_PROVE
     * @param k2MemberAndElseInfo
     * @return
     */
    public static Boolean isAdminRole(String SYSTEM_ROLE_PROVE, K2MemberAndElseInfo k2MemberAndElseInfo) {

        // 遍历该用户的角色的信息
        if (!CollectionUtils.isEmpty(k2MemberAndElseInfo.getK2Roles())) {
            for (K2Role k2Role : k2MemberAndElseInfo.getK2Roles()) {
                if (k2Role.getRetain1().equals(SYSTEM_ROLE_PROVE)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 校验时间是否正确
     *
     * @param evaluateIndexDto
     * @return
     */
    public static SystemResult checkTimeData(ProductEvaluateIndexDto evaluateIndexDto) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (StringUtils.isEmpty(evaluateIndexDto.getStartTimeStr())) {
            evaluateIndexDto.setStartTime(null);
        } else if (!StringUtils.isEmpty(evaluateIndexDto.getStartTimeStr())) {
            evaluateIndexDto.setStartTimeStr(evaluateIndexDto.getStartTimeStr() + " 00:00:00");
            try {
                evaluateIndexDto.setStartTime(sdf.parse(evaluateIndexDto.getStartTimeStr()));
            } catch (Exception e) {
                e.printStackTrace();
                return new SystemResult(100, "请选择正确的时间");
            }
        }

        if (StringUtils.isEmpty(evaluateIndexDto.getEndTimeStr())) {
            evaluateIndexDto.setEndTime(null);
        } else if (!StringUtils.isEmpty(evaluateIndexDto.getEndTimeStr())) {
            evaluateIndexDto.setEndTimeStr(evaluateIndexDto.getEndTimeStr() + " 23:59:59");
            try {
                evaluateIndexDto.setEndTime(sdf.parse(evaluateIndexDto.getEndTimeStr()));
            } catch (Exception e) {
                e.printStackTrace();
                return new SystemResult(100, "请选择正确的时间");
            }
        }

        return new SystemResult(evaluateIndexDto);
    }
}
