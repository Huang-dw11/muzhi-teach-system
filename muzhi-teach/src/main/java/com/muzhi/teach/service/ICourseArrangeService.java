package com.muzhi.teach.service;

import java.util.List;
import com.muzhi.teach.domain.CourseArrange;

/**
 * 课程安排Service接口
 * 
 * @author hhh
 * @date 2025-04-10
 */
public interface ICourseArrangeService 
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
    public int insertCourseArrange(CourseArrange courseArrange);

    /**
     * 修改课程安排
     * 
     * @param courseArrange 课程安排
     * @return 结果
     */
    public int updateCourseArrange(CourseArrange courseArrange);

    /**
     * 批量删除课程安排
     * 
     * @param ids 需要删除的课程安排主键集合
     * @return 结果
     */
    public int deleteCourseArrangeByIds(Long[] ids);

    /**
     * 删除课程安排信息
     * 
     * @param id 课程安排主键
     * @return 结果
     */
    public int deleteCourseArrangeById(Long id);
}
