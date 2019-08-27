package com.king2.product.server.service.impl;

import com.king2.commons.mapper.K2CategorySeasonMapper;
import com.king2.commons.mapper.K2ProductCategoryMapper;
import com.king2.commons.pojo.*;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.appoint.UserMessageAppoint;
import com.king2.product.server.dto.AddCategoryDto;
import com.king2.product.server.dto.CategoryIndexManageDto;
import com.king2.product.server.dto.ProductCatrgorySiJieDto;
import com.king2.product.server.enmu.K2ProductCategoryEnum;
import com.king2.product.server.mapper.CategoryManageMapper;
import com.king2.product.server.service.ProductCategoryManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/*=======================================================
	说明:   商品类目管理Service实现类

	作者		时间					注释
  	俞烨		2019.08.27   			创建
=======================================================*/
@Service
@SuppressWarnings("all")
public class ProductCategoryManageServiceImpl implements ProductCategoryManageService {

    // 注入本地商品类目的Mapper
    @Autowired
    private CategoryManageMapper categoryManageMapper;

    // 注入系统管理员的标识符
    @Value("${SYSTEM_ROLE_PROVE}")
    private String SYSTEM_ROLE_PROVE;

    // 注入季节Mapper
    @Autowired
    private K2CategorySeasonMapper k2CategorySeasonMapper;

    // 注入远程的商品类目Mapper
    @Autowired
    private K2ProductCategoryMapper k2ProductCategoryMapper;

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
    @Override
    public SystemResult index(K2MemberAndElseInfo k2MemberAndElseInfo, CategoryIndexManageDto dto) {

        // 查看该用户是否可以添加和编辑商品类目
        for (K2Role k2Role : k2MemberAndElseInfo.getK2Roles()) {
            if (k2Role.getRetain1().equals(SYSTEM_ROLE_PROVE)) {
                dto.setAddOrEdit(true);
                break;
            }
        }

        // 查询商品类目的数量
        Integer totalSize = categoryManageMapper.selectCount(StringUtils.isEmpty(dto.getCategoryName()) ? null : "%" + dto.getCategoryName().trim().replaceAll(" ", "") + "%");
        dto.setTotalSize(totalSize);

        // 查询一级类目的信息
        K2ProductCategoryExample example = new K2ProductCategoryExample();
        example.createCriteria().andCategoryIsParentEqualTo(1);
        List<K2ProductCategory> k2ProductCategories = k2ProductCategoryMapper.selectByExample(example);
        dto.setOneCategorDatas(k2ProductCategories);

        // 查询适合季节的信息
        List<K2CategorySeason> k2CategorySeasons = k2CategorySeasonMapper.selectByExample(null);
        List<ProductCatrgorySiJieDto> siJieDtos = new ArrayList<>();
        for (K2CategorySeason k2CategorySeason : k2CategorySeasons) {
            ProductCatrgorySiJieDto dto1 = new ProductCatrgorySiJieDto();
            dto1.setLabel(k2CategorySeason.getCategorySeasonValue());
            dto1.setValue(k2CategorySeason.getCategorySeasonId() + "");
            siJieDtos.add(dto1);
        }
        dto.setSiJieDatas(siJieDtos);

        // 设置值
        dto.setTotalSize(totalSize);

        // 求出总页数
        int totalPage = (totalSize + dto.getCurrentSize() - 1) / dto.getCurrentSize();
        dto.setTotlaPage(totalPage);

        // 查看当前页数是否大于总页数
        if (dto.getCurrentPage() > totalPage) dto.setCurrentPage(totalPage);

        // 计算出索引值
        int index = (dto.getCurrentPage() - 1) * dto.getCurrentSize();

        // 获取商品类目的信息
        List<K2ProductCategory> category = categoryManageMapper.getCategory(
                StringUtils.isEmpty(dto.getCategoryName()) ? null : "%" + dto.getCategoryName().trim().replaceAll(" ", "") + "%",
                index, dto.getCurrentSize()
        );

        if (!CollectionUtils.isEmpty(category)) {
            category.forEach((n) -> {
                n.setCreateTimeStr(UserMessageAppoint.sdf.format(n.getCategoryCreateTime()));
                n.setCategoryIsName(n.getCategoryIsParent() == 1 ? "一级类目" : "二级类目");
            });
        }

        dto.setCategoryDatas(category);

        return new SystemResult(dto);
    }

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
    @Override
    public SystemResult loadCategoryById(Integer parentId) {

        // 查询数据
        List<K2ProductCategory> categoryById = categoryManageMapper.getCategoryById(parentId);
        if (!CollectionUtils.isEmpty(categoryById)) {
            categoryById.forEach((n) -> {
                n.setCreateTimeStr(UserMessageAppoint.sdf.format(n.getCategoryCreateTime()));
                n.setCategoryIsName(n.getCategoryIsParent() == 1 ? "一级类目" : "二级类目");
                n.setHasChildren(false);
            });
        }
        return new SystemResult(categoryById);
    }

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
    @Override
    public SystemResult addCategory(K2MemberAndElseInfo k2MemberAndElseInfo, AddCategoryDto dto) {

        SystemResult result = checkCategory(k2MemberAndElseInfo, dto);
        if (result.getStatus() != 200) return result;
        // 创建类目对象
        K2ProductCategory category = new K2ProductCategory();
        // 补全信息
        category.setCategoryName(dto.getCategoryName());
        category.setCategorySeasonId(dto.getSiJie());
        category.setCategoryIsParent(Integer.parseInt(dto.getOneCateId()) == 0 ? K2ProductCategoryEnum.YES.getValue() :
                K2ProductCategoryEnum.NO.getValue());
        category.setCategoryParentId(Integer.parseInt(dto.getOneCateId()));
        category.setCategoryState(K2ProductCategoryEnum.ZC.getValue());
        category.setCategoryUserid(k2MemberAndElseInfo.getK2Member().getMemberId());
        category.setCategoryUpdateUserid(k2MemberAndElseInfo.getK2Member().getMemberId());
        category.setCategoryCreateTime(new Date());

        // 添加数据
        k2ProductCategoryMapper.insert(category);
        return new SystemResult(category);
    }

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
    @Override
    public SystemResult editCategory(K2MemberAndElseInfo k2MemberAndElseInfo, AddCategoryDto dto, Integer categoryId) {

        SystemResult result = checkCategory(k2MemberAndElseInfo, dto);
        if (result.getStatus() != 200) return result;

        // 创建类目对象
        K2ProductCategory category = new K2ProductCategory();
        // 补全信息
        category.setCategoryName(dto.getCategoryName());
        category.setCategorySeasonId(dto.getSiJie());
        category.setCategoryUpdateUserid(k2MemberAndElseInfo.getK2Member().getMemberId());
        category.setCategoryId(categoryId);

        // 修改信息
        k2ProductCategoryMapper.updateByPrimaryKeySelective(category);

        return new SystemResult("ok");
    }

    /**
     * jiaoy类目的信息
     *
     * @param k2MemberAndElseInfo
     * @param dto
     * @return
     */
    public SystemResult checkCategory(K2MemberAndElseInfo k2MemberAndElseInfo, AddCategoryDto dto) {
        // 查询该用户是否有资格添加商品类目
        boolean flag = false;
        for (K2Role k2Role : k2MemberAndElseInfo.getK2Roles()) {
            if (SYSTEM_ROLE_PROVE.equals(k2Role.getRetain1())) {
                flag = true;
            }
        }

        if (!flag) return new SystemResult(100, "你暂时没有权限");

        // 校验四季是否正确
        if (StringUtils.isEmpty(dto.getSiJie())) {
            return new SystemResult(100, "请选择类目的适应时间");
        } else {
            String[] split = dto.getSiJie().split(",");
            if (split.length > 4 || split.length < 1) return new SystemResult(100, "加载失败,请刷新页面重试");
            for (int i = 0; i < split.length; i++) {
                if (!split[i].matches("[0-9]{1,}")) {
                    return new SystemResult(100, "加载失败,请刷新页面重试");
                } else if (Integer.parseInt(split[i]) != 1 && Integer.parseInt(split[i]) != 2
                        && Integer.parseInt(split[i]) != 3 && Integer.parseInt(split[i]) != 4) {
                    return new SystemResult(100, "加载失败,请刷新页面重试");

                }

            }
        }

        return new SystemResult("ok");
    }
}
