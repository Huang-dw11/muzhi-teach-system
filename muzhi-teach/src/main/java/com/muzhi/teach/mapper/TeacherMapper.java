package com.muzhi.teach.mapper;

import java.util.List;

import com.muzhi.common.enums.BusinessType;
import com.muzhi.teach.annotation.AutoFill;
import com.muzhi.teach.domain.Teacher;
import org.apache.ibatis.annotations.Mapper;

/**
 * 教师信息Mapper接口
 * 
 * @author hhh
 * @date 2025-04-04
 */
@Mapper
public interface TeacherMapper 
{
    /**
     * 查询教师信息
     * 
     * @param id 教师信息主键
     * @return 教师信息
     */
    public Teacher selectTeacherById(Long id);

    /**
     * 查询教师信息列表
     * 
     * @param teacher 教师信息
     * @return 教师信息集合
     */
    public List<Teacher> selectTeacherList(Teacher teacher);

    /**
     * 新增教师信息
     * 
     * @param teacher 教师信息
     * @return 结果
     */
    @AutoFill(value = BusinessType.INSERT)
    public int insertTeacher(Teacher teacher);

    /**
     * 修改教师信息
     * 
     * @param teacher 教师信息
     * @return 结果
     */
    @AutoFill(value = BusinessType.UPDATE)
    public int updateTeacher(Teacher teacher);

    /**
     * 删除教师信息
     * 
     * @param id 教师信息主键
     * @return 结果
     */
    public int deleteTeacherById(Long id);

    /**
     * 批量删除教师信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTeacherByIds(Long[] ids);
}
