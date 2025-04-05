package com.muzhi.teach.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import com.muzhi.common.exception.CollegeHasTeachersException;
import com.muzhi.common.utils.DateUtils;
import com.muzhi.teach.domain.Expertise;
import com.muzhi.teach.domain.vo.ClazzVO;
import com.muzhi.teach.mapper.ExpertiseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.muzhi.teach.mapper.ClassMapper;
import com.muzhi.teach.domain.Clazz;
import com.muzhi.teach.service.IClassService;

/**
 * 班级管理Service业务层处理
 *
 * @author hhh
 * @date 2025-04-05
 */
@Service
public class ClassServiceImpl implements IClassService {
    @Autowired
    private ClassMapper classMapper;
    @Autowired
    private ExpertiseMapper expertiseMapper;

    /**
     * 查询班级管理
     *
     * @param id 班级管理主键
     * @return 班级管理
     */
    @Override
    public Clazz selectClassById(Long id) {
        return classMapper.selectClassById(id);
    }

    /**
     * 查询班级管理列表
     *
     * @param clazz 班级管理
     * @return 班级管理
     */
    @Override
    public List<Clazz> selectClassList(Clazz clazz) {
        return classMapper.selectClassList(clazz);
    }

    /**
     * 新增班级管理
     *
     * @param clazz 班级管理
     * @return 结果
     */
    @Override
    public int insertClass(Clazz clazz) {
        Expertise expertise = expertiseMapper.selectExpertiseById(clazz.getExpertiseId());
        if (expertise == null) {
            throw new CollegeHasTeachersException("该学院未开设专业");
        } else if (!Objects.equals(expertise.getCollegeId(), clazz.getExpertiseId())) {
            throw new CollegeHasTeachersException("该学院不存在此专业");
        }

        clazz.setCreateTime(DateUtils.getNowDate());
        return classMapper.insertClass(clazz);
    }

    /**
     * 修改班级管理
     *
     * @param clazz 班级管理
     * @return 结果
     */
    @Override
    public int updateClass(Clazz clazz) {
        clazz.setUpdateTime(DateUtils.getNowDate());
        return classMapper.updateClass(clazz);
    }

    /**
     * 批量删除班级管理
     *
     * @param ids 需要删除的班级管理主键
     * @return 结果
     */
    @Override
    public int deleteClassByIds(Long[] ids) {
        return classMapper.deleteClassByIds(ids);
    }

    /**
     * 删除班级管理信息
     *
     * @param id 班级管理主键
     * @return 结果
     */
    @Override
    public int deleteClassById(Long id) {
        return classMapper.deleteClassById(id);
    }

    /**
     * 查询专业名称和所属院系
     *
     * @param clazz
     * @return ClazzVO集合
     */
    @Override
    public List<ClazzVO> selectClassVOList(Clazz clazz) {
        return classMapper.selectClassVOList(clazz);
    }
}
