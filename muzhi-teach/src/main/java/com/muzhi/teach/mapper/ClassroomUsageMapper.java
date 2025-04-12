package com.muzhi.teach.mapper;

import java.util.List;

import com.muzhi.teach.domain.ClassroomUsage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 教室使用情况管理Mapper接口
 *
 * @author hhh
 * @date 2025-04-09
 */
@Mapper
public interface ClassroomUsageMapper {
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
     * 删除教室使用情况管理
     *
     * @param id 教室使用情况管理主键
     * @return 结果
     */
    public int deleteClassroomUsageById(Long id);

    /**
     * 批量删除教室使用情况管理
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteClassroomUsageByIds(Long[] ids);

    /**
     * 根据教室编号id查询使用情况
     *
     * @param classroomCode
     * @return
     */
    @Select("select * from tb_classroom_usage where classroom_code = #{cclassroomCode}")
    public List<ClassroomUsage> selectClassroomById(String classroomCode);

    /**
     * 增加教室的使用情况
     *
     * @param classroomUsage
     * @return
     */
    public int updateClassroomUsageByCRId(ClassroomUsage classroomUsage);

    /**
     *  修改教室被占用的节次和某一星期的课
     * @param classroomUsage
     * @return
     */
    public int updateClassroomUsageToBeNull(ClassroomUsage classroomUsage);

    /**
     * 根据教室编码删除教室使用情况管理
     *
     * @param classroomCode 教室编号
     * @return 结果
     */
    public int deleteClassroomUsageByCRCode(String classroomCode);
}
