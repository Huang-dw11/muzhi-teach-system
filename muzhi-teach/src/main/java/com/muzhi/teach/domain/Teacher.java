package com.muzhi.teach.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.muzhi.common.annotation.Excel;
import com.muzhi.common.core.domain.BaseEntity;

/**
 * 教师信息对象 tb_teacher
 * 
 * @author hhh
 * @date 2025-04-04
 */
public class Teacher extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 工号 */
    @Excel(name = "工号")
    private String teacherNo;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 照片 */
    @Excel(name = "照片")
    private String image;

    /** 所属院系 */
    @Excel(name = "所属院系")
    private Long collegeId;

    /** 职位类型 */
    @Excel(name = "职位类型")
    private Long positionType;

    /** 职称 */
    @Excel(name = "职称")
    private Long title;

    /** 最高学历 */
    @Excel(name = "最高学历")
    private Long education;

    /** 性别 */
    @Excel(name = "性别")
    private Long gender;

    /** 国籍 */
    private String nationality;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phone;

    /** 身份证号 */
    private String idCard;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
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

    public void setImage(String image) 
    {
        this.image = image;
    }

    public String getImage() 
    {
        return image;
    }

    public void setCollegeId(Long collegeId) 
    {
        this.collegeId = collegeId;
    }

    public Long getCollegeId() 
    {
        return collegeId;
    }

    public void setPositionType(Long positionType) 
    {
        this.positionType = positionType;
    }

    public Long getPositionType() 
    {
        return positionType;
    }

    public void setTitle(Long title) 
    {
        this.title = title;
    }

    public Long getTitle() 
    {
        return title;
    }

    public void setEducation(Long education) 
    {
        this.education = education;
    }

    public Long getEducation() 
    {
        return education;
    }

    public void setGender(Long gender) 
    {
        this.gender = gender;
    }

    public Long getGender() 
    {
        return gender;
    }

    public void setNationality(String nationality) 
    {
        this.nationality = nationality;
    }

    public String getNationality() 
    {
        return nationality;
    }

    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }

    public void setIdCard(String idCard) 
    {
        this.idCard = idCard;
    }

    public String getIdCard() 
    {
        return idCard;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("teacherNo", getTeacherNo())
            .append("name", getName())
            .append("image", getImage())
            .append("collegeId", getCollegeId())
            .append("positionType", getPositionType())
            .append("title", getTitle())
            .append("education", getEducation())
            .append("gender", getGender())
            .append("nationality", getNationality())
            .append("phone", getPhone())
            .append("idCard", getIdCard())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .toString();
    }
}
