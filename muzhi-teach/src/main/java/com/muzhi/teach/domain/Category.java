package com.muzhi.teach.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.muzhi.common.annotation.Excel;
import com.muzhi.common.core.domain.BaseEntity;

/**
 * 门类对象 tb_category
 * 
 * @author hhh
 * @date 2025-04-06
 */
public class Category extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID，自增 */
    private Long id;

    /** 学位授予类型值，整型 */
    @Excel(name = "学位授予类型值，整型")
    private Long degreeType;

    /** 专业门类 */
    private Long categoryValue;

    /** 专业门类 */
    @Excel(name = "专业门类")
    private String categoryName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setDegreeType(Long degreeType) 
    {
        this.degreeType = degreeType;
    }

    public Long getDegreeType() 
    {
        return degreeType;
    }

    public void setCategoryValue(Long categoryValue) 
    {
        this.categoryValue = categoryValue;
    }

    public Long getCategoryValue() 
    {
        return categoryValue;
    }

    public void setCategoryName(String categoryName) 
    {
        this.categoryName = categoryName;
    }

    public String getCategoryName() 
    {
        return categoryName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("degreeType", getDegreeType())
            .append("categoryValue", getCategoryValue())
            .append("categoryName", getCategoryName())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
