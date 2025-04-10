package com.muzhi.teach.domain.dto;

import com.muzhi.teach.domain.Clazz;
import lombok.Data;

@Data
public class ClazzDTO extends Clazz {
    //新增班级的数量
    private Integer count;
}
