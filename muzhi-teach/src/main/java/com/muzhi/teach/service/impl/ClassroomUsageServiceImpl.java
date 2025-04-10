package com.muzhi.teach.service.impl;

import java.util.List;
import com.muzhi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.muzhi.teach.mapper.ClassroomUsageMapper;
import com.muzhi.teach.domain.ClassroomUsage;
import com.muzhi.teach.service.IClassroomUsageService;

/**
 * 教室使用情况管理Service业务层处理
 * 
 * @author hhh
 * @date 2025-04-09
 */
@Service
public class ClassroomUsageServiceImpl implements IClassroomUsageService 
{
    @Autowired
    private ClassroomUsageMapper classroomUsageMapper;

    /**
     * 查询教室使用情况管理
     * 
     * @param id 教室使用情况管理主键
     * @return 教室使用情况管理
     */
    @Override
    public ClassroomUsage selectClassroomUsageById(Long id)
    {
        return classroomUsageMapper.selectClassroomUsageById(id);
    }

    /**
     * 查询教室使用情况管理列表
     * 
     * @param classroomUsage 教室使用情况管理
     * @return 教室使用情况管理
     */
    @Override
    public List<ClassroomUsage> selectClassroomUsageList(ClassroomUsage classroomUsage)
    {
        return classroomUsageMapper.selectClassroomUsageList(classroomUsage);
    }

    /**
     * 新增教室使用情况管理
     * 
     * @param classroomUsage 教室使用情况管理
     * @return 结果
     */
    @Override
    public int insertClassroomUsage(ClassroomUsage classroomUsage)
    {
        classroomUsage.setCreateTime(DateUtils.getNowDate());
        return classroomUsageMapper.insertClassroomUsage(classroomUsage);
    }

    /**
     * 修改教室使用情况管理
     * 
     * @param classroomUsage 教室使用情况管理
     * @return 结果
     */
    @Override
    public int updateClassroomUsage(ClassroomUsage classroomUsage)
    {
        classroomUsage.setUpdateTime(DateUtils.getNowDate());
        return classroomUsageMapper.updateClassroomUsage(classroomUsage);
    }

    /**
     * 批量删除教室使用情况管理
     * 
     * @param ids 需要删除的教室使用情况管理主键
     * @return 结果
     */
    @Override
    public int deleteClassroomUsageByIds(Long[] ids)
    {
        return classroomUsageMapper.deleteClassroomUsageByIds(ids);
    }

    /**
     * 删除教室使用情况管理信息
     * 
     * @param id 教室使用情况管理主键
     * @return 结果
     */
    @Override
    public int deleteClassroomUsageById(Long id)
    {
        return classroomUsageMapper.deleteClassroomUsageById(id);
    }
}
