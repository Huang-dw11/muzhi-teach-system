package com.muzhi.teach.service.impl;

import java.util.List;

import com.muzhi.common.utils.DateUtils;
import com.muzhi.teach.domain.Category;
import com.muzhi.teach.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.muzhi.teach.service.ICategoryService;

/**
 * 门类Service业务层处理
 *
 * @author hhh
 * @date 2025-04-06
 */
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 查询门类
     *
     * @param id 门类主键
     * @return 门类
     */
    @Override
    public Category selectCategoryById(Long id) {
        return categoryMapper.selectCategoryById(id);
    }

    /**
     * 查询门类列表
     *
     * @param category 门类
     * @return 门类
     */
    @Override
    public List<Category> selectCategoryList(Category category) {
        return categoryMapper.selectCategoryList(category);
    }

    /**
     * 新增门类
     *
     * @param category 门类
     * @return 结果
     */
    @Override
    public int insertCategory(Category category) {


        // 根据学位授予id查询
//        categoryMapper.selectCategoryBygetDegreeTypeId(category.getDegreeType());
        category.setCreateTime(DateUtils.getNowDate());
        return categoryMapper.insertCategory(category);
    }

    /**
     * 修改门类
     *
     * @param category 门类
     * @return 结果
     */
    @Override
    public int updateCategory(Category category) {
        category.setUpdateTime(DateUtils.getNowDate());
        return categoryMapper.updateCategory(category);
    }

    /**
     * 批量删除门类
     *
     * @param ids 需要删除的门类主键
     * @return 结果
     */
    @Override
    public int deleteCategoryByIds(Long[] ids) {
        return categoryMapper.deleteCategoryByIds(ids);
    }

    /**
     * 删除门类信息
     *
     * @param id 门类主键
     * @return 结果
     */
    @Override
    public int deleteCategoryById(Long id) {
        return categoryMapper.deleteCategoryById(id);
    }
}
