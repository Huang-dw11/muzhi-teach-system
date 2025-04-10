package com.muzhi.teach.mapper;

import java.util.List;

import com.muzhi.common.enums.BusinessType;
import com.muzhi.teach.annotation.AutoFill;
import com.muzhi.teach.domain.Classroom;
import org.apache.ibatis.annotations.Mapper;

/**
 * 教室管理Mapper接口
 * 
 * @author hhh
 * @date 2025-04-09
 */
@Mapper
public interface ClassroomMapper 
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
    @AutoFill(value = BusinessType.INSERT)
    public int insertClassroom(Classroom classroom);

    /**
     * 修改教室管理
     * 
     * @param classroom 教室管理
     * @return 结果
     */
    @AutoFill(value = BusinessType.UPDATE)
    public int updateClassroom(Classroom classroom);

    /**
     * 删除教室管理
     * 
     * @param id 教室管理主键
     * @return 结果
     */
    public int deleteClassroomById(Long id);

    /**
     * 批量删除教室管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteClassroomByIds(Long[] ids);
}
