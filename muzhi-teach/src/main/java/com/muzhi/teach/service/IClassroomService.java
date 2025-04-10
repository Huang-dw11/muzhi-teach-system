package com.muzhi.teach.service;

import java.util.List;
import com.muzhi.teach.domain.Classroom;
import com.muzhi.teach.domain.dto.ClassroomDTO;

/**
 * 教室管理Service接口
 * 
 * @author hhh
 * @date 2025-04-09
 */
public interface IClassroomService 
{
    /**
     * 查询教室管理
     * 
     * @param id 教室管理主键
     * @return 教室管理
     */
    public Classroom selectClassroomById(Long id);

    /**
     * 查询教室管理列表
     * 
     * @param classroom 教室管理
     * @return 教室管理集合
     */
    public List<Classroom> selectClassroomList(Classroom classroom);

    /**
     * 新增教室管理
     * 
     * @param classroom 教室管理
     * @return 结果
     */
    public int insertClassroom(Classroom classroom);

    /**
     * 修改教室管理
     * 
     * @param classroom 教室管理
     * @return 结果
     */
    public int updateClassroom(Classroom classroom);

    /**
     * 批量删除教室管理
     * 
     * @param ids 需要删除的教室管理主键集合
     * @return 结果
     */
    public int deleteClassroomByIds(Long[] ids);

    /**
     * 删除教室管理信息
     * 
     * @param id 教室管理主键
     * @return 结果
     */
    public int deleteClassroomById(Long id);

    /**
     * 查询教室管理和使用情况
     *
     * @param id 教室管理主键
     * @return 教室管理
     */
    public ClassroomDTO selectClassroomAndUsageById(Long id);
}
