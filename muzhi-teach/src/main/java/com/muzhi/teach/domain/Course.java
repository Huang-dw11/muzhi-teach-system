package com.muzhi.teach.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.muzhi.common.annotation.Excel;
import com.muzhi.common.core.domain.BaseEntity;

/**
 * 课程管理对象 tb_course
 * 
 * @author hhh
 * @date 2025-04-05
 */
public class Course extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 课程编码 */
    @Excel(name = "课程编码")
    private String courseCode;

    /** 开课学院 */
    @Excel(name = "开课学院")
    private Long collegeId;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String courseName;

    /** 课程类型 */
    @Excel(name = "课程类型")
    private Integer courseType;

    /** 学分 */
    @Excel(name = "学分")
    private BigDecimal credit;

    /** 学时 */
    @Excel(name = "学时")
    private Integer classHours;

    /** 授课对象 */
    @Excel(name = "授课对象")
    private String targetStudents;

    /** 考核方式 */
    @Excel(name = "考核方式")
    private String assessmentMethods;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setCourseCode(String courseCode) 
    {
        this.courseCode = courseCode;
    }

    public String getCourseCode() 
    {
        return courseCode;
    }

    public void setCollegeId(Long collegeId) 
    {
        this.collegeId = collegeId;
    }

    public Long getCollegeId() 
    {
        return collegeId;
    }

    public void setCourseName(String courseName) 
    {
        this.courseName = courseName;
    }

    public String getCourseName() 
    {
        return courseName;
    }

    public void setCourseType(Integer courseType) 
    {
        this.courseType = courseType;
    }

    public Integer getCourseType() 
    {
        return courseType;
    }

    public void setCredit(BigDecimal credit) 
    {
        this.credit = credit;
    }

    public BigDecimal getCredit() 
    {
        return credit;
    }

    public void setClassHours(Integer classHours) 
    {
        this.classHours = classHours;
    }

    public Integer getClassHours() 
    {
        return classHours;
    }

    public void setTargetStudents(String targetStudents) 
    {
        this.targetStudents = targetStudents;
    }

    public String getTargetStudents() 
    {
        return targetStudents;
    }

    public void setAssessmentMethods(String assessmentMethods) 
    {
        this.assessmentMethods = assessmentMethods;
    }

    public String getAssessmentMethods() 
    {
        return assessmentMethods;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("courseCode", getCourseCode())
            .append("collegeId", getCollegeId())
            .append("courseName", getCourseName())
            .append("courseType", getCourseType())
            .append("credit", getCredit())
            .append("classHours", getClassHours())
            .append("targetStudents", getTargetStudents())
            .append("assessmentMethods", getAssessmentMethods())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .toString();
    }
}
