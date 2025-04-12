package com.muzhi.teach.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.muzhi.common.annotation.Excel;
import com.muzhi.common.core.domain.BaseEntity;

/**
 * 教室使用情况管理对象 tb_classroom_usage
 * 
 * @author hhh
 * @date 2025-04-12
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ClassroomUsage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 教室编码 */
    @Excel(name = "教室编码")
    private String classroomCode;

    /** 上课时间 */
    @Excel(name = "上课时间")
    private Integer classTime;

    /** 星期一使用情况(0:未使用,1:已使用) */
    @Excel(name = "星期一使用情况(0:未使用,1:已使用)")
    private Integer monday;

    /** 星期二使用情况(0:未使用,1:已使用) */
    @Excel(name = "星期二使用情况(0:未使用,1:已使用)")
    private Integer tuesday;

    /** 星期三使用情况(0:未使用,1:已使用) */
    @Excel(name = "星期三使用情况(0:未使用,1:已使用)")
    private Integer wednesday;

    /** 星期四使用情况(0:未使用,1:已使用) */
    @Excel(name = "星期四使用情况(0:未使用,1:已使用)")
    private Integer thursday;

    /** 星期五使用情况(0:未使用,1:已使用) */
    @Excel(name = "星期五使用情况(0:未使用,1:已使用)")
    private Integer friday;

    /** 星期六使用情况(0:未使用,1:已使用) */
    @Excel(name = "星期六使用情况(0:未使用,1:已使用)")
    private Integer saturday;

    /** 星期日使用情况(0:未使用,1:已使用) */
    @Excel(name = "星期日使用情况(0:未使用,1:已使用)")
    private Integer sunday;

    /** 星期 */
    @Excel(name = "星期")
    private Integer weekday;

//    public void setId(Long id)
//    {
//        this.id = id;
//    }
//
//    public Long getId()
//    {
//        return id;
//    }
//
//    public void setClassroomCode(String classroomCode)
//    {
//        this.classroomCode = classroomCode;
//    }
//
//    public String getClassroomCode()
//    {
//        return classroomCode;
//    }
//
//    public void setClassTime(Integer classTime)
//    {
//        this.classTime = classTime;
//    }
//
//    public Integer getClassTime()
//    {
//        return classTime;
//    }
//
//    public void setMonday(Integer monday)
//    {
//        this.monday = monday;
//    }
//
//    public Integer getMonday()
//    {
//        return monday;
//    }
//
//    public void setTuesday(Integer tuesday)
//    {
//        this.tuesday = tuesday;
//    }
//
//    public Integer getTuesday()
//    {
//        return tuesday;
//    }
//
//    public void setWednesday(Integer wednesday)
//    {
//        this.wednesday = wednesday;
//    }
//
//    public Integer getWednesday()
//    {
//        return wednesday;
//    }
//
//    public void setThursday(Integer thursday)
//    {
//        this.thursday = thursday;
//    }
//
//    public Integer getThursday()
//    {
//        return thursday;
//    }
//
//    public void setFriday(Integer friday)
//    {
//        this.friday = friday;
//    }
//
//    public Integer getFriday()
//    {
//        return friday;
//    }
//
//    public void setSaturday(Integer saturday)
//    {
//        this.saturday = saturday;
//    }
//
//    public Integer getSaturday()
//    {
//        return saturday;
//    }
//
//    public void setSunday(Integer sunday)
//    {
//        this.sunday = sunday;
//    }
//
//    public Integer getSunday()
//    {
//        return sunday;
//    }
//
//    @Override
//    public String toString() {
//        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
//            .append("id", getId())
//            .append("classroomCode", getClassroomCode())
//            .append("classTime", getClassTime())
//            .append("monday", getMonday())
//            .append("tuesday", getTuesday())
//            .append("wednesday", getWednesday())
//            .append("thursday", getThursday())
//            .append("friday", getFriday())
//            .append("saturday", getSaturday())
//            .append("sunday", getSunday())
//            .append("createTime", getCreateTime())
//            .append("updateTime", getUpdateTime())
//            .append("createBy", getCreateBy())
//            .append("updateBy", getUpdateBy())
//            .toString();
//    }
}
