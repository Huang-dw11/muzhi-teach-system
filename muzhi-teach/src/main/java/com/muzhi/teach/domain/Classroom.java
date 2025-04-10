package com.muzhi.teach.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.muzhi.common.annotation.Excel;
import com.muzhi.common.core.domain.BaseEntity;

/**
 * 教室管理对象 tb_classroom
 * 
 * @author hhh
 * @date 2025-04-09
 */
public class Classroom extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 教室编码 */
    @Excel(name = "教室编码")
    private String classroomCode;

    /** 教室类型 */
    @Excel(name = "教室类型")
    private String classroomType;

    /** 教室容量 */
    @Excel(name = "教室容量")
    private Long capacity;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setClassroomCode(String classroomCode) 
    {
        this.classroomCode = classroomCode;
    }

    public String getClassroomCode() 
    {
        return classroomCode;
    }

    public void setClassroomType(String classroomType) 
    {
        this.classroomType = classroomType;
    }

    public String getClassroomType() 
    {
        return classroomType;
    }

    public void setCapacity(Long capacity) 
    {
        this.capacity = capacity;
    }

    public Long getCapacity() 
    {
        return capacity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("classroomCode", getClassroomCode())
            .append("classroomType", getClassroomType())
            .append("capacity", getCapacity())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
