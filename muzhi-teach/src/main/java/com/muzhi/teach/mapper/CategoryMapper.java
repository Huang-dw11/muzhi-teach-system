package com.muzhi.teach.mapper;

import com.muzhi.common.enums.BusinessType;
import com.muzhi.teach.annotation.AutoFill;
import com.muzhi.teach.domain.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 门类Mapper接口
 * 
 * @author hhh
 * @date 2025-04-06
 */
@Mapper
public interface CategoryMapper 
{
    /**
     * 查询门类
     * 
     * @param id 门类主键
     * @return 门类
     */
    public Category selectCategoryById(Long id);

    /**
     * 查询门类列表
     * 
     * @param category 门类
     * @return 门类集合
     */
    public List<Category> selectCategoryList(Category category);

    /**
     * 新增门类
     * 
     * @param category 门类
     * @return 结果
     */
    @AutoFill(value = BusinessType.INSERT)
    public int insertCategory(Category category);

    /**
     * 修改门类
     * 
     * @param category 门类
     * @return 结果
     */
    @AutoFill(value = BusinessType.UPDATE)
    public int updateCategory(Category category);

    /**
     * 删除门类
     * 
     * @param id 门类主键
     * @return 结果
     */
    public int deleteCategoryById(Long id);

    /**
     * 批量删除门类
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCategoryByIds(Long[] ids);

}
