package com.king2.product.server.service;


import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.dto.AddCategoryDto;
import com.king2.product.server.dto.CategoryIndexManageDto;

/*=======================================================
	说明:   商品类目管理Service

	作者		时间					注释
  	俞烨		2019.08.27   			创建
=======================================================*/
public interface ProductCategoryManageService {

    /**
     * -----------------------------------------------------
     * 功能:  显示商品类目的首页
     * <p>
     * 参数:
     * k2MemberAndElseInfo         K2MemberAndElseInfo        操作的用户信息
     * dto              CategoryIndexManageDto              分页数据
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult index(K2MemberAndElseInfo k2MemberAndElseInfo, CategoryIndexManageDto dto);

    /**
     * -----------------------------------------------------
     * 功能:  根据父类id查询子类信息
     * <p>
     * 参数:
     * parentId         Integer         父类的id
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult loadCategoryById(Integer parentId);

    /**
     * -----------------------------------------------------
     * 功能:   添加商品类目信息
     * <p>
     * 参数:
     * k2MemberAndElseInfo         K2MemberAndElseInfo         操作的用户信息
     * dto                       AddCategoryDto              新添加的类目信息
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult addCategory(K2MemberAndElseInfo k2MemberAndElseInfo, AddCategoryDto dto);

    /**
     * -----------------------------------------------------
     * 功能:   修改商品类目信息
     * <p>
     * 参数:
     * k2MemberAndElseInfo         K2MemberAndElseInfo         操作的用户信息
     * dto                       AddCategoryDto              修改添加的类目信息
     * categoryId               Integer                 修改的类目id
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult editCategory(K2MemberAndElseInfo k2MemberAndElseInfo, AddCategoryDto dto, Integer categoryId);


}
