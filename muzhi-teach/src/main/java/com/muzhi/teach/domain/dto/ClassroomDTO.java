package com.muzhi.teach.domain.dto;

import com.muzhi.teach.domain.Classroom;
import com.muzhi.teach.domain.ClassroomUsage;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ClassroomDTO extends Classroom {
    List<ClassroomUsage> classroomUsageList;
}
