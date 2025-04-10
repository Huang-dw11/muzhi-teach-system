package com.muzhi.teach.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.muzhi.common.annotation.Excel;
import com.muzhi.common.core.domain.BaseEntity;

/**
 * 班级管理对象 tb_class
 * 
 * @author hhh
 * @date 2025-04-05
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Clazz extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 班级ID */
    private Long id;

    /** 所属院系ID */
    @Excel(name = "所属院系ID")
    private Long collegeId;

    /** 所属专业ID */
    @Excel(name = "所属专业ID")
    private Long expertiseId;

    /** 班级编号 */
    @Excel(name = "班级编号")
    private String classNumber;

    /** 所属年级 */
    @Excel(name = "所属年级")
    private String grade;

    /** 班级人数 */
    @Excel(name = "班级人数")
    private Long studentCount;

    /** 课程安排ID */
    private Long scheduleId;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public void setCollegeId(Long collegeId)
    {
        this.collegeId = collegeId;
    }

    public Long getCollegeId()
    {
        return collegeId;
    }

    public void setExpertiseId(Long expertiseId)
    {
        this.expertiseId = expertiseId;
    }

    public Long getExpertiseId()
    {
        return expertiseId;
    }

    public void setClassNumber(String classNumber)
    {
        this.classNumber = classNumber;
    }

    public String getClassNumber()
    {
        return classNumber;
    }

    public void setGrade(String grade)
    {
        this.grade = grade;
    }

    public String getGrade()
    {
        return grade;
    }

    public void setStudentCount(Long studentCount)
    {
        this.studentCount = studentCount;
    }

    public Long getStudentCount()
    {
        return studentCount;
    }

    public void setScheduleId(Long scheduleId)
    {
        this.scheduleId = scheduleId;
    }

    public Long getScheduleId()
    {
        return scheduleId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("collegeId", getCollegeId())
            .append("expertiseId", getExpertiseId())
            .append("classNumber", getClassNumber())
            .append("grade", getGrade())
            .append("studentCount", getStudentCount())
            .append("scheduleId", getScheduleId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
