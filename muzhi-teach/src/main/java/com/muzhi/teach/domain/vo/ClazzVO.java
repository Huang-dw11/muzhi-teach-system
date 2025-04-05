package com.muzhi.teach.domain.vo;

import com.muzhi.common.annotation.Excel;
import com.muzhi.teach.domain.Clazz;
import lombok.Data;

@Data
public class ClazzVO extends Clazz {

    /** 所属院系名称 */
    @Excel(name = "所属院系ID")
    private String collegeName;

    /** 所属专业名称 */
    @Excel(name = "所属专业ID")
    private String expertiseName;
}
