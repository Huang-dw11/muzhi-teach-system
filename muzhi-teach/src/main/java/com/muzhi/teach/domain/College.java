package com.muzhi.teach.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.muzhi.common.annotation.Excel;
import com.muzhi.common.core.domain.BaseEntity;

/**
 * 学院管理对象 tb_college
 *
 * @author hhh
 * @date 2025-04-04
 */
public class College extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 学院主键ID
     */
    private Long id;

    /**
     * 学院代码
     */
    @Excel(name = "学院代码")
    private String collegeCode;

    /**
     * 学院名称
     */
    @Excel(name = "学院名称")
    private String collegeName;

    /**
     * 隶属关系
     */
    @Excel(name = "隶属关系")
    private String affiliation;

    /**
     * 学院性质
     */
    @Excel(name = "学院性质")
    private String collegeType;

    /**
     * 学院介绍
     */
    @Excel(name = "学院介绍")
    private String introduction;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setCollegeCode(String collegeCode) {
        this.collegeCode = collegeCode;
    }

    public String getCollegeCode() {
        return collegeCode;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setCollegeType(String collegeType) {
        this.collegeType = collegeType;
    }

    public String getCollegeType() {
        return collegeType;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getIntroduction() {
        return introduction;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("collegeCode", getCollegeCode())
                .append("collegeName", getCollegeName())
                .append("affiliation", getAffiliation())
                .append("collegeType", getCollegeType())
                .append("introduction", getIntroduction())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("createBy", getCreateBy())
                .append("updateBy", getUpdateBy())
                .append("remark", getRemark())
                .toString();
    }
}
