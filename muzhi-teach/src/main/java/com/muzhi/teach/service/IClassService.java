package com.muzhi.teach.service;

import java.util.List;

import com.muzhi.common.enums.BusinessType;
import com.muzhi.teach.annotation.AutoFill;
import com.muzhi.teach.domain.Clazz;
import com.muzhi.teach.domain.dto.ClazzDTO;
import com.muzhi.teach.domain.vo.ClazzVO;

/**
 * 班级管理Service接口
 * 
 * @author hhh
 * @date 2025-04-05
 */
public interface IClassService 
{
    /**
     * 查询班级管理
     * 
     * @param id 班级管理主键
     * @return 班级管理
     */
    public Clazz selectClassById(Long id);

    /**
     * 查询班级管理列表
     * 
     * @param clazz 班级管理
     * @return 班级管理集合
     */
    public List<Clazz> selectClassList(Clazz clazz);

    /**
     * 新增班级管理
     * 
     * @param clazz 班级管理
     * @return 结果
     */
    public int insertClass(Clazz clazz);

    /**
     * 修改班级管理
     * 
     * @param clazz 班级管理
     * @return 结果
     */
    public int updateClass(Clazz clazz);

    /**
     * 批量删除班级管理
     * 
     * @param ids 需要删除的班级管理主键集合
     * @return 结果
     */
    public int deleteClassByIds(Long[] ids);

    /**
     * 删除班级管理信息
     * 
     * @param id 班级管理主键
     * @return 结果
     */
    public int deleteClassById(Long id);

    /**
     * 查询专业名称和所属院系
     *
     * @param clazz
     * @return ClazzVO集合
     */
    public List<ClazzVO> selectClassVOList(Clazz clazz);

    /**
     * 批量新增班级管理
     *
     * @param clazzDTO 班级管理
     * @return 结果
     */
    public int insertClazzDTO(ClazzDTO clazzDTO);
}
