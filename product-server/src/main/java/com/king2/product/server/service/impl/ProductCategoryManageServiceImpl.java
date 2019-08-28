package com.king2.product.server.service.impl;

import com.king2.commons.mapper.K2CategorySeasonMapper;
import com.king2.commons.mapper.K2ProductCategoryMapper;
import com.king2.commons.mapper.K2ProductSkuKeyMapper;
import com.king2.commons.pojo.*;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.appoint.ProductCategoryAppoint;
import com.king2.product.server.appoint.UserMessageAppoint;
import com.king2.product.server.dto.*;
import com.king2.product.server.enmu.K2ProductCategoryEnum;
import com.king2.product.server.mapper.CategoryManageMapper;
import com.king2.product.server.mapper.ProductSkuMapper;
import com.king2.product.server.service.ProductCategoryManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
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

    // 注入商品sku-key的mapper
    @Autowired
    private ProductSkuMapper productSkuMapper;

    // 注入商品类目委派类
    @Autowired
    private ProductCategoryAppoint productCategoryAppoint;

    // 注入系统提供给用户的注册最大数量
    @Value("${SYSTEM_MAX_ADD_SKU_SIZE}")
    private Integer SYSTEM_MAX_ADD_SKU_SIZE;

    // 注入远程的SKU-keyMApper
    @Autowired
    private K2ProductSkuKeyMapper k2ProductSkuKeyMapper;

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

    /**
     * -----------------------------------------------------
     * 功能:    修改商品类目的状态
     * <p>
     * 参数:
     * k2MemberAndElseInfo          K2MemberAndElseInfo         操作的用户信息
     * state                        String                      类目状态
     * categoryId                   Integer                     修改的类目id
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult editCategoryState(K2MemberAndElseInfo k2MemberAndElseInfo, Integer categoryId, String state) {

        SystemResult result = editCheckCategoryInfo(k2MemberAndElseInfo, categoryId, state);
        if (result.getStatus() != 200) return result;

        // 说明校验通过 获取类目的信息
        K2ProductCategory k2ProductCategory = (K2ProductCategory) result.getData();

        // 发送SQL修改类目信息
        k2ProductCategoryMapper.updateByPrimaryKeySelective(k2ProductCategory);
        return new SystemResult("ok");
    }

    /**
     * 修改类目时，查看类目信息是否符合
     *
     * @param k2MemberAndElseInfo
     * @param categoryId
     * @param state
     * @return
     */
    public SystemResult editCheckCategoryInfo(K2MemberAndElseInfo k2MemberAndElseInfo, Integer categoryId, String state) {

        // 校验该角色是否可以进行修改类目的状态
        boolean flag = false;
        for (K2Role k2Role : k2MemberAndElseInfo.getK2Roles()) {
            if (SYSTEM_ROLE_PROVE.equals(k2Role.getRetain1())) {
                flag = true;
            }
        }
        if (!flag) return new SystemResult(100, "你暂时没有权限");

        // 校验该类目是否存在
        K2ProductCategory k2ProductCategory = k2ProductCategoryMapper.selectByPrimaryKey(categoryId);
        if (k2ProductCategory == null) return new SystemResult(100, "类目信息不存在");

        // 判断本次的状态是否正常
        if (!state.equals(K2ProductCategoryEnum.ZC.getValue() + "") && !state.equals(K2ProductCategoryEnum.TY.getValue() + "")) {
            return new SystemResult(100, "本次状态码错误");
        }


        // 通过就设置值
        k2ProductCategory.setCategoryState(Integer.parseInt(state));
        k2ProductCategory.setCategoryUpdateUserid(k2MemberAndElseInfo.getK2Member().getMemberId());

        return new SystemResult(k2ProductCategory);
    }

    /**
     * -----------------------------------------------------
     * 功能:    显示类目的SKU信息
     * <p>
     * 参数:
     * k2MemberAndElseInfo          K2MemberAndElseInfo         操作的用户信息
     * categoryId                   Integer                     修改的类目id
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult showCategorySKUInfo(K2MemberAndElseInfo k2MemberAndElseInfo, Integer categoryId) {

        // 创建返回的数据
        ShowCategoryOfSkuInfo skuInfo = new ShowCategoryOfSkuInfo();

        // 根据用户的角色判断是否需要查询店铺的SKU信息
        boolean flag = false;
        for (K2Role k2Role : k2MemberAndElseInfo.getK2Roles()) {
            if (SYSTEM_ROLE_PROVE.equals(k2Role.getRetain1())) {
                flag = true;
            }
        }

        // 查询系统定义好的SKU信息
        List<K2ProductSkuKey> skuInfoByCid = productSkuMapper.getSkuInfoByCid(categoryId);
        skuInfo.setSystemSkuInfo(skuInfoByCid);

        if (flag) {
            // 需要查询店铺+系统定义好的
            skuInfo.setEditSystemFlag(true);
            skuInfo.setShowUserInfoFlag(false);
        } else {
            // 这里说明 登入的用户不是超级管理员 需要对外暴露系统+他们自己定义的SKU信息 不过系统定义好的SKU信息是不能删除的
            skuInfo.setEditSystemFlag(false);
            skuInfo.setShowUserInfoFlag(true);
            // 查询用户定义好的SKU信息
            List<K2ProductSkuKey> skuInfoByStoreId = productSkuMapper.getSkuInfoByStoreId(categoryId, Integer.parseInt(k2MemberAndElseInfo.getK2Member().getRetain1()));
            skuInfo.setUserSkuInfo(skuInfoByStoreId);
        }
        // 首先查询系统定义好的
        return new SystemResult(skuInfo);
    }

    /**
     * -----------------------------------------------------
     * 功能:    管理并添加类目的SKU信息
     * <p>
     * 参数:
     * k2MemberAndElseInfo          K2MemberAndElseInfo         操作的用户信息
     * categoryId                   Integer                     修改的类目id
     * skuInfoJson                  String                      新添加的SKU串
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult manageAndAddCategoryOfSkuInfo(K2MemberAndElseInfo k2MemberAndElseInfo, Integer categoryId, String skuInfoJson) {

        // 校验用户的角色是否为超级管理员
        boolean flag = false;
        for (K2Role k2Role : k2MemberAndElseInfo.getK2Roles()) {
            if (SYSTEM_ROLE_PROVE.equals(k2Role.getRetain1())) {
                flag = true;
            }
        }

        // 查看SKU最大的排序
        Integer maxOrder = productSkuMapper.skuMaxOrder(categoryId);

        // 定义返回的Result
        SystemResult result = null;
        if (flag) {
            // 管理员
            // 校验SKUJSON信息是否正确,并返回SKU模板的信息的集合
            result = productCategoryAppoint.checkCategorySkuInfoAndReturnSkuLists
                    (skuInfoJson, flag, 0, categoryId, k2MemberAndElseInfo.getK2Member(), maxOrder + 1);
            if (result.getStatus() != 200) return result;
        } else {
            // 不是管理员

            // 查看该店铺自己添加了多少个SKU信息
            K2ProductSkuKeyExample example = new K2ProductSkuKeyExample();
            example.createCriteria().andIsSystemCreateNotEqualTo(2)
                    .andBelongStoreIdEqualTo(Integer.parseInt(k2MemberAndElseInfo.getK2Member().getRetain1()))
                    .andRetain1EqualTo("1")
                    .andSkuKeyStateEqualTo(1);
            List<K2ProductSkuKey> skuKeys = k2ProductSkuKeyMapper.selectByExample(example);
            // 查询该店铺还有多少次添加商品SKU的机会
            if (CollectionUtils.isEmpty(skuKeys)) {
                // 校验SKUJSON信息是否正确,并返回SKU模板的信息的集合
                result = productCategoryAppoint.checkCategorySkuInfoAndReturnSkuLists
                        (skuInfoJson, flag, SYSTEM_MAX_ADD_SKU_SIZE, categoryId, k2MemberAndElseInfo.getK2Member(), maxOrder + 1);
            } else {
                if (SYSTEM_MAX_ADD_SKU_SIZE - skuKeys.size() <= 0) {
                    return new SystemResult(100, "剩余自己定义的次数为:0次，若不能满足您的要求，请联系管理员");
                }
                // 校验SKUJSON信息是否正确,并返回SKU模板的信息的集合
                result = productCategoryAppoint.checkCategorySkuInfoAndReturnSkuLists
                        (skuInfoJson, flag, SYSTEM_MAX_ADD_SKU_SIZE - skuKeys.size(), categoryId, k2MemberAndElseInfo.getK2Member(), (maxOrder + skuKeys.size() + 1));
            }

            if (result.getStatus() != 200) return result;
        }

        // 校验成功 取出SKU的数据
        List<ProductSkuDto> skuSplit = (List<ProductSkuDto>) result.getData();

        // 批量插入数据
        if (!CollectionUtils.isEmpty(skuSplit)) productSkuMapper.batchInsertSkuKey(skuSplit);

        return new SystemResult(skuSplit);
    }
}
