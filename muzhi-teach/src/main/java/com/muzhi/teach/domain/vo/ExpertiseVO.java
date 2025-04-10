package com.muzhi.teach.domain.vo;


import com.muzhi.common.annotation.Excel;
import com.muzhi.teach.domain.Expertise;
import lombok.Data;

@Data
public class ExpertiseVO extends Expertise {
    /** 门类、专业类 */
    @Excel(name = "门类、专业类")
    private String categoryName;
}
