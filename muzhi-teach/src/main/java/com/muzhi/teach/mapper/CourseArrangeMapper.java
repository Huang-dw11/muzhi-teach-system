package com.muzhi.teach.mapper;

import java.util.List;

import com.muzhi.common.enums.BusinessType;
import com.muzhi.teach.annotation.AutoFill;
import com.muzhi.teach.domain.CourseArrange;
import org.apache.ibatis.annotations.Mapper;

/**
 * 课程安排Mapper接口
 * 
 * @author hhh
 * @date 2025-04-10
 */
@Mapper
public interface CourseArrangeMapper 
{
    /**
     * 查询课程安排
     * 
     * @param id 课程安排主键
     * @return 课程安排
     */
    public CourseArrange selectCourseArrangeById(Long id);

    /**
     * 查询课程安排列表
     * 
     * @param courseArrange 课程安排
     * @return 课程安排集合
     */
    public List<CourseArrange> selectCourseArrangeList(CourseArrange courseArrange);

    /**
     * 新增课程安排
     * 
     * @param courseArrange 课程安排
     * @return 结果
     */
    @AutoFill(value = BusinessType.INSERT)
    public int insertCourseArrange(CourseArrange courseArrange);

    /**
     * 修改课程安排
     * 
     * @param courseArrange 课程安排
     * @return 结果
     */
    @AutoFill(value = BusinessType.UPDATE)
    public int updateCourseArrange(CourseArrange courseArrange);

    /**
     * 删除课程安排
     * 
     * @param id 课程安排主键
     * @return 结果
     */
    public int deleteCourseArrangeById(Long id);

    /**
     * 批量删除课程安排
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCourseArrangeByIds(Long[] ids);
}
