package com.king2.product.server.service;

import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.dto.ProductEvaluateIndexDto;

/*=======================================================
	说明:   商品评价管理Service

	作者		时间					注释
  	俞烨		2019.08.29   			创建
=======================================================*/
public interface ProductEvaluateManageService {


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
    SystemResult index(ProductEvaluateIndexDto evaluateIndexDto, K2MemberAndElseInfo k2MemberAndElseInfo);

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
    SystemResult replyContent(Integer evaId, K2MemberAndElseInfo k2MemberAndElseInfo, String content);
}
