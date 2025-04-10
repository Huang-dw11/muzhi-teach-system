package com.muzhi.teach.service.impl;

import java.util.List;

import com.muzhi.common.utils.DateUtils;
import com.muzhi.teach.config.ClassNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.muzhi.teach.mapper.CourseMapper;
import com.muzhi.teach.domain.Course;
import com.muzhi.teach.service.ICourseService;

/**
 * 课程管理Service业务层处理
 *
 * @author hhh
 * @date 2025-04-05
 */
@Service
public class CourseServiceImpl implements ICourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private ClassNumberGenerator classNumberGenerator;

    /**
     * 查询课程管理
     *
     * @param id 课程管理主键
     * @return 课程管理
     */
    @Override
    public Course selectCourseById(Long id) {
        return courseMapper.selectCourseById(id);
    }

    /**
     * 查询课程管理列表
     *
     * @param course 课程管理
     * @return 课程管理
     */
    @Override
    public List<Course> selectCourseList(Course course) {
        return courseMapper.selectCourseList(course);
    }

    /**
     * 新增课程管理
     *
     * @param course 课程管理
     * @return 结果
     */
    @Override
    public int insertCourse(Course course) {
        // 课程编码规范301-4-1-001 ，301：学院号后三位 - 4：课程类型 - 001：流水号
        String courseCodeTemp = String.valueOf(course.getCollegeId()).substring(3) + course.getCourseType();

        String courseCode = classNumberGenerator.generateClassNumber(courseCodeTemp, "course");

        course.setCourseCode(courseCode);

        course.setCreateTime(DateUtils.getNowDate());
        return courseMapper.insertCourse(course);
    }

    /**
     * 修改课程管理
     *
     * @param course 课程管理
     * @return 结果
     */
    @Override
    public int updateCourse(Course course) {
        String courseCodeTemp = String.valueOf(course.getCollegeId()).substring(3) + course.getCourseType();

        String courseCode = courseCodeTemp+course.getCourseCode().substring(4);

        course.setCourseCode(courseCode);
        course.setUpdateTime(DateUtils.getNowDate());
        return courseMapper.updateCourse(course);
    }

    /**
     * 批量删除课程管理
     *
     * @param ids 需要删除的课程管理主键
     * @return 结果
     */
    @Override
    public int deleteCourseByIds(Long[] ids) {
        return courseMapper.deleteCourseByIds(ids);
    }

    /**
     * 删除课程管理信息
     *
     * @param id 课程管理主键
     * @return 结果
     */
    @Override
    public int deleteCourseById(Long id) {
        return courseMapper.deleteCourseById(id);
    }

//    /**
//     * 根据course属性查询课程
//     *
//     * @param course
//     * @return 课程管理
//     */
//    @Override
//    public Course selectCourse(Course course) {
//        return courseMapper.selectCourse(course);
//    }
}
