package com.muzhi.teach.service.impl;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;
import java.util.Objects;

import com.muzhi.common.exception.CollegeHasTeachersException;
import com.muzhi.common.utils.DateUtils;
import com.muzhi.teach.config.ClassNumberGenerator;
import com.muzhi.teach.domain.College;
import com.muzhi.teach.domain.Expertise;
import com.muzhi.teach.domain.dto.ClazzDTO;
import com.muzhi.teach.domain.vo.ClazzVO;
import com.muzhi.teach.mapper.CollegeMapper;
import com.muzhi.teach.mapper.ExpertiseMapper;
import org.springframework.beans.BeanUtils;
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
    @Autowired
    private CollegeMapper collegeMapper;
    @Autowired
    private ClassNumberGenerator classNumberGenerator;

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

    /**
     * 批量新增班级管理
     *
     * @param clazzDTO 班级管理
     * @return 结果
     */
    @Override
    public int insertClazzDTO(ClazzDTO clazzDTO) {
        Clazz clazz = new Clazz();
        StringBuilder builder = new StringBuilder();
        BeanUtils.copyProperties(clazzDTO,clazz);

        Expertise expertise = expertiseMapper.selectExpertiseById(clazz.getExpertiseId());
        if (expertise == null) {
            throw new CollegeHasTeachersException("该学院未开设专业");
        } else if (!Objects.equals(expertise.getCollegeId(), clazz.getCollegeId())) {
            throw new CollegeHasTeachersException("该学院不存在此专业");
        }

        // 23-5-01-08 入学年份后两位-学生类型：5为本科 6为研究生-所属学院后两位-专业编码5-6位
        // 获取当前年份
        String year = LocalDate.now().toString().substring(2, 4);

        // 获取学院编码
        String collegeById = collegeMapper.selectCollegeById(clazz.getCollegeId()).getCollegeCode().substring(4);

        //获取专业编码
        String expertiseCodeId = expertise.getExpertiseCode().substring(4,6);

        String clazzNumberTemp = builder.append(year).append(clazz.getGrade()).append(collegeById).append(expertiseCodeId).toString();

        String clazzNumber = classNumberGenerator.generateClassNumber(clazzNumberTemp,"clazz");

        clazz.setClassNumber(clazzNumber);
        clazz.setCreateTime(DateUtils.getNowDate());
        return classMapper.insertClass(clazz);
    }
}
