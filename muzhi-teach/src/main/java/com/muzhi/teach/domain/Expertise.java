package com.muzhi.teach.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.muzhi.common.annotation.Excel;
import com.muzhi.common.core.domain.BaseEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 专业管理对象 tb_expertise
 * 
 * @author hhh
 * @date 2025-04-06
 */
@Mapper
public class Expertise extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 专业主键ID */
    private Long id;

    /** 专业编码 */
    @Excel(name = "专业编码")
    private String expertiseCode;

    /** 专业名称 */
    @Excel(name = "专业名称")
    private String expertiseName;

    /** 所属院系 */
    private Long collegeId;

    /** 学院名称 */
    @Excel(name = "学院名称")
    private String collegeName;

    /** 培养层次 */
    @Excel(name = "培养层次")
    private Long educationLevel;

    /** 学位授予类型 */
    @Excel(name = "学位授予类型")
    private Long degreeType;

    /** 门类、专业类 */
    @Excel(name = "门类、专业类")
    private Long categoryId;

    /** 学制（年） */
    @Excel(name = "学制", readConverterExp = "年=")
    private Long duration;

    /** 专业介绍 */
    private String introduction;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setExpertiseCode(String expertiseCode) 
    {
        this.expertiseCode = expertiseCode;
    }

    public String getExpertiseCode() 
    {
        return expertiseCode;
    }

    public void setExpertiseName(String expertiseName) 
    {
        this.expertiseName = expertiseName;
    }

    public String getExpertiseName() 
    {
        return expertiseName;
    }

    public void setCollegeId(Long collegeId) 
    {
        this.collegeId = collegeId;
    }

    public Long getCollegeId() 
    {
        return collegeId;
    }

    public void setCollegeName(String collegeName) 
    {
        this.collegeName = collegeName;
    }

    public String getCollegeName() 
    {
        return collegeName;
    }

    public void setEducationLevel(Long educationLevel) 
    {
        this.educationLevel = educationLevel;
    }

    public Long getEducationLevel() 
    {
        return educationLevel;
    }

    public void setDegreeType(Long degreeType) 
    {
        this.degreeType = degreeType;
    }

    public Long getDegreeType() 
    {
        return degreeType;
    }

    public void setCategoryId(Long categoryId) 
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() 
    {
        return categoryId;
    }

    public void setDuration(Long duration) 
    {
        this.duration = duration;
    }

    public Long getDuration() 
    {
        return duration;
    }

    public void setIntroduction(String introduction) 
    {
        this.introduction = introduction;
    }

    public String getIntroduction() 
    {
        return introduction;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("expertiseCode", getExpertiseCode())
            .append("expertiseName", getExpertiseName())
            .append("collegeId", getCollegeId())
            .append("collegeName", getCollegeName())
            .append("educationLevel", getEducationLevel())
            .append("degreeType", getDegreeType())
            .append("categoryId", getCategoryId())
            .append("duration", getDuration())
            .append("introduction", getIntroduction())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
