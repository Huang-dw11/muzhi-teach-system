package com.muzhi.teach.domain.vo;

import com.muzhi.common.annotation.Excel;
import com.muzhi.teach.domain.Expertise;
import lombok.Data;

@Data
public class ExpertiseVO extends Expertise {
    /** 所属院系 */
    @Excel(name = "所属院系")
    private String collegeName;
}
