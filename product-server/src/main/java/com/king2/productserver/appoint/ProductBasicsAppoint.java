package com.king2.productserver.appoint;

import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.JsonUtils;
import org.apache.commons.lang.StringUtils;

/*=======================================================
	说明:    商品基础管理委派类

	作者		时间					注释
  	俞烨		2019.08.06   			创建
=======================================================*/
public class ProductBasicsAppoint {

    /**
     * -----------------------------------------------------
     * 功能:  校验传输过来的json数据是否可以转换成对应的class对象
     * <p>
     * 参数:
     * jsonInfo         String          JSON数据
     * clazz            Class           需要转换的类型
     * <p>
     * 返回: UserManageUtil              返回调用者的数据
     * -----------------------------------------------------
     */
    public static SystemResult checkJsonWhetherGotoClass(String jsonInfo, Class clazz, String errorMsg) {

        // 判断Json数据是否为空
        if (StringUtils.isEmpty(jsonInfo) || clazz == null) {
            return new SystemResult(100, "转换失败：参数有空值", null);
        }

        // 转换数据
        try {
            Object o = JsonUtils.jsonToPojo(jsonInfo, clazz);
            return new SystemResult(o);
        } catch (Exception e) {
            return new SystemResult(100, errorMsg + "转换失败：类型与预期的不匹配", null);
        }
    }

    /**
     * -----------------------------------------------------
     * 功能:  根据传过去的Json数据获取商品的信息
     * <p>
     * 参数:
     * productJson         String          商品的JSON数据
     * <p>
     * 返回: UserManageUtil              返回调用者的数据
     * -----------------------------------------------------
     */
    public static SystemResult getProductInfoByPJson(String productJson) {

        // 获取商品的唯一编号

        return null;
    }
}
