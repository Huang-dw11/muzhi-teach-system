package com.muzhi.teach.service;

import java.util.List;
import com.muzhi.teach.domain.ClassroomUsage;

/**
 * 教室使用情况管理Service接口
 * 
 * @author hhh
 * @date 2025-04-09
 */
public interface IClassroomUsageService 
{
    /**
     * 查询教室使用情况管理
     * 
     * @param id 教室使用情况管理主键
     * @return 教室使用情况管理
     */
    public ClassroomUsage selectClassroomUsageById(Long id);

    /**
     * 查询教室使用情况管理列表
     * 
     * @param classroomUsage 教室使用情况管理
     * @return 教室使用情况管理集合
     */
    public List<ClassroomUsage> selectClassroomUsageList(ClassroomUsage classroomUsage);

    /**
     * 新增教室使用情况管理
     * 
     * @param classroomUsage 教室使用情况管理
     * @return 结果
     */
    public int insertClassroomUsage(ClassroomUsage classroomUsage);

    /**
     * 修改教室使用情况管理
     * 
     * @param classroomUsage 教室使用情况管理
     * @return 结果
     */
    public int updateClassroomUsage(ClassroomUsage classroomUsage);

    /**
     * 批量删除教室使用情况管理
     * 
     * @param ids 需要删除的教室使用情况管理主键集合
     * @return 结果
     */
    public int deleteClassroomUsageByIds(Long[] ids);

    /**
     * 删除教室使用情况管理信息
     * 
     * @param id 教室使用情况管理主键
     * @return 结果
     */
    public int deleteClassroomUsageById(Long id);
}
