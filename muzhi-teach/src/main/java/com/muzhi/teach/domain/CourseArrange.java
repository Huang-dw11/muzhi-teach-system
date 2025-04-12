package com.muzhi.teach.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.muzhi.common.annotation.Excel;
import com.muzhi.common.core.domain.BaseEntity;

/**
 * 课程安排对象 tb_course_arrange
 * 
 * @author hdw
 * @date 2025-04-12
 */
public class CourseArrange extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 课程编码 */
    private String courseCode;

    /** 开课编码 */
    @Excel(name = "开课编码")
    private String openCourseCode;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String courseName;

    /** 教师编码 */
    @Excel(name = "教师编码")
    private String teacherNo;

    /** 教师名 */
    @Excel(name = "教师名")
    private String name;

    /** 课程类型 */
    @Excel(name = "课程类型")
    private Integer courseType;

    /** 教室编号 */
    @Excel(name = "教室编号")
    private String classroomCode;

    /** 星期 */
    @Excel(name = "星期")
    private Integer weekday;

    /** 上课时间 */
    @Excel(name = "上课时间")
    private Integer classTime;

    /** 学分 */
    @Excel(name = "学分")
    private BigDecimal credit;

    /** 学时 */
    @Excel(name = "学时")
    private Integer classHours;

    /** 课程周数 */
    @Excel(name = "课程周数")
    private String courseWeeks;

    /** 班级人数 */
    @Excel(name = "班级人数")
    private Integer classSize;

    /** 考核方式 */
    @Excel(name = "考核方式")
    private String assessmentMethod;

    /** 开课学期 */
    @Excel(name = "开课学期")
    private String semester;

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

    public void setOpenCourseCode(String openCourseCode) 
    {
        this.openCourseCode = openCourseCode;
    }

    public String getOpenCourseCode() 
    {
        return openCourseCode;
    }

    public void setCourseName(String courseName) 
    {
        this.courseName = courseName;
    }

    public String getCourseName() 
    {
        return courseName;
    }

    public void setTeacherNo(String teacherNo) 
    {
        this.teacherNo = teacherNo;
    }

    public String getTeacherNo() 
    {
        return teacherNo;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public void setCourseType(Integer courseType)
    {
        this.courseType = courseType;
    }

    public Integer getCourseType()
    {
        return courseType;
    }

    public void setClassroomCode(String classroomCode) 
    {
        this.classroomCode = classroomCode;
    }

    public String getClassroomCode() 
    {
        return classroomCode;
    }

    public void setWeekday(Integer weekday) 
    {
        this.weekday = weekday;
    }

    public Integer getWeekday() 
    {
        return weekday;
    }

    public void setClassTime(Integer classTime) 
    {
        this.classTime = classTime;
    }

    public Integer getClassTime() 
    {
        return classTime;
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

    public void setCourseWeeks(String courseWeeks) 
    {
        this.courseWeeks = courseWeeks;
    }

    public String getCourseWeeks() 
    {
        return courseWeeks;
    }

    public void setClassSize(Integer classSize) 
    {
        this.classSize = classSize;
    }

    public Integer getClassSize() 
    {
        return classSize;
    }

    public void setAssessmentMethod(String assessmentMethod) 
    {
        this.assessmentMethod = assessmentMethod;
    }

    public String getAssessmentMethod() 
    {
        return assessmentMethod;
    }

    public void setSemester(String semester) 
    {
        this.semester = semester;
    }

    public String getSemester() 
    {
        return semester;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("courseCode", getCourseCode())
            .append("openCourseCode", getOpenCourseCode())
            .append("courseName", getCourseName())
            .append("teacherNo", getTeacherNo())
            .append("name", getName())
            .append("courseType", getCourseType())
            .append("classroomCode", getClassroomCode())
            .append("weekday", getWeekday())
            .append("classTime", getClassTime())
            .append("credit", getCredit())
            .append("classHours", getClassHours())
            .append("courseWeeks", getCourseWeeks())
            .append("classSize", getClassSize())
            .append("assessmentMethod", getAssessmentMethod())
            .append("semester", getSemester())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
