package com.muzhi.teach.service.impl;

import java.util.List;

import com.muzhi.common.utils.DateUtils;
import com.muzhi.teach.domain.ClassroomUsage;
import com.muzhi.teach.domain.dto.ClassroomDTO;
import com.muzhi.teach.mapper.ClassroomUsageMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.muzhi.teach.mapper.ClassroomMapper;
import com.muzhi.teach.domain.Classroom;
import com.muzhi.teach.service.IClassroomService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 教室管理Service业务层处理
 *
 * @author hhh
 * @date 2025-04-09
 */
@Service
public class ClassroomServiceImpl implements IClassroomService {
    @Autowired
    private ClassroomMapper classroomMapper;
    @Autowired
    private ClassroomUsageMapper classroomUsageMapper;

    /**
     * 查询教室管理
     *
     * @param id 教室管理主键
     * @return 教室管理
     */
    @Override
    public Classroom selectClassroomById(Long id) {
        return classroomMapper.selectClassroomById(id);
    }

    /**
     * 查询教室管理列表
     *
     * @param classroom 教室管理
     * @return 教室管理
     */
    @Override
    public List<Classroom> selectClassroomList(Classroom classroom) {
        return classroomMapper.selectClassroomList(classroom);
    }

    /**
     * 新增教室管理
     *
     * @param classroom 教室管理
     * @return 结果
     */
    @Override
    public int insertClassroom(Classroom classroom) {

        ClassroomUsage classroomUsage = new ClassroomUsage();
        classroomUsage.setClassroomCode(classroom.getClassroomCode());
        for (int i = 0; i < 4; i++) {
            classroomUsage.setClassTime(i+1);
            classroomUsageMapper.insertClassroomUsage(classroomUsage);
        }

        classroom.setCreateTime(DateUtils.getNowDate());
        return classroomMapper.insertClassroom(classroom);
    }

    /**
     * 修改教室管理
     *
     * @param classroom 教室管理
     * @return 结果
     */
    @Override
    public int updateClassroom(Classroom classroom) {
        classroom.setUpdateTime(DateUtils.getNowDate());
        return classroomMapper.updateClassroom(classroom);
    }

    /**
     * 批量删除教室管理
     *
     * @param ids 需要删除的教室管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteClassroomByIds(Long[] ids) {
        for (Long id : ids) {
            Classroom classroom = selectClassroomById(id);
            classroomUsageMapper.deleteClassroomUsageByCRCode(classroom.getClassroomCode());
        }

        return classroomMapper.deleteClassroomByIds(ids);
    }

    /**
     * 删除教室管理信息
     *
     * @param id 教室管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteClassroomById(Long id) {
        Classroom classroom = selectClassroomById(id);
        classroomUsageMapper.deleteClassroomUsageByCRCode(classroom.getClassroomCode());

        return classroomMapper.deleteClassroomById(id);
    }

    /**
     * 查询教室管理和使用情况
     *
     * @param id 教室管理主键
     * @return 教室管理
     */
    @Override
    public ClassroomDTO selectClassroomAndUsageById(Long id) {
        Classroom classroom = classroomMapper.selectClassroomById(id);

        ClassroomDTO classroomDTO = new ClassroomDTO();
        BeanUtils.copyProperties(classroom,classroomDTO);

        List<ClassroomUsage> classroomUsages = classroomUsageMapper.selectClassroomById(classroom.getClassroomCode());
        classroomDTO.setClassroomUsageList(classroomUsages);

        return classroomDTO;
    }
}
