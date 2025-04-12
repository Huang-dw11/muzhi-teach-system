package com.muzhi.teach.service.impl;

import java.util.List;

import com.muzhi.common.exception.ServiceException;
import com.muzhi.common.utils.DateUtils;
import com.muzhi.teach.config.ClassNumberGenerator;
import com.muzhi.teach.domain.ClassroomUsage;
import com.muzhi.teach.domain.Course;
import com.muzhi.teach.mapper.ClassroomUsageMapper;
import com.muzhi.teach.mapper.CourseMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.muzhi.teach.mapper.CourseArrangeMapper;
import com.muzhi.teach.domain.CourseArrange;
import com.muzhi.teach.service.ICourseArrangeService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 课程安排Service业务层处理
 *
 * @author hhh
 * @date 2025-04-10
 */
@Slf4j
@Service
public class CourseArrangeServiceImpl implements ICourseArrangeService {
    @Autowired
    private CourseArrangeMapper courseArrangeMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private ClassNumberGenerator classNumberGenerator;
    @Autowired
    private ClassroomUsageMapper classroomUsageMapper;

    /**
     * 查询课程安排
     *
     * @param id 课程安排主键
     * @return 课程安排
     */
    @Override
    public CourseArrange selectCourseArrangeById(Long id) {
        return courseArrangeMapper.selectCourseArrangeById(id);
    }

    /**
     * 查询课程安排列表
     *
     * @param courseArrange 课程安排
     * @return 课程安排
     */
    @Override
    public List<CourseArrange> selectCourseArrangeList(CourseArrange courseArrange) {
        return courseArrangeMapper.selectCourseArrangeList(courseArrange);
    }

    /**
     * 新增课程安排
     *
     * @param courseArrange 课程安排
     * @return 结果
     */
    @Transactional
    @Override
    public int insertCourseArrange(CourseArrange courseArrange) {

        // 处理课程编号和课程名
        Course course = new Course();
        String courseCode = courseArrange.getCourseCode();
        course.setCourseCode(courseCode);

        Course courses = courseMapper.selectCourse(course);
        BeanUtils.copyProperties(courses, courseArrange);

        // 处理教编号与教师名
        String[] teacherNoAndName = courseArrange.getTeacherNo().split(",");

        courseArrange.setTeacherNo(teacherNoAndName[0]);
        courseArrange.setName(teacherNoAndName[1]);

        // 处理教室占用情况
        ClassroomUsage classroomUsage = new ClassroomUsage();
        BeanUtils.copyProperties(courseArrange, classroomUsage);

        // 查看占课情况
        getClassroomUsage(classroomUsage);

        // 未占用
        classroomUsageMapper.updateClassroomUsageByCRId(classroomUsage);

        // 生成开课编号
        String openCoursesCode = classNumberGenerator.generateClassNumber(courseCode, "courseArrange");
        courseArrange.setOpenCourseCode(openCoursesCode);

        courseArrange.setCreateTime(DateUtils.getNowDate());
        return courseArrangeMapper.insertCourseArrange(courseArrange);
    }

    /**
     * 修改课程安排
     *
     * @param courseArrange 课程安排
     * @return 结果
     */
    @Transactional
    @Override
    public int updateCourseArrange(CourseArrange courseArrange) {

        // 1.处理原先被占用的课程，将其设为null
        // 通过查询开课id获取原先的教室信息
        CourseArrange oldCourseArrange = selectCourseArrangeById(courseArrange.getId());
        ClassroomUsage classroomUsage = new ClassroomUsage();
        BeanUtils.copyProperties(oldCourseArrange, classroomUsage);
        classroomUsageMapper.updateClassroomUsageToBeNull(classroomUsage);

        // 2.在修改为新的教室
        BeanUtils.copyProperties(courseArrange, classroomUsage);

        // 3.查看占课情况
        getClassroomUsage(classroomUsage);

        classroomUsageMapper.updateClassroomUsageByCRId(classroomUsage);

        courseArrange.setUpdateTime(DateUtils.getNowDate());
        return courseArrangeMapper.updateCourseArrange(courseArrange);
    }

    /**
     * 批量删除课程安排
     *
     * @param ids 需要删除的课程安排主键
     * @return 结果
     */
    @Override
    public int deleteCourseArrangeByIds(Long[] ids) {

        for (Long id : ids) {
            CourseArrange oldCourseArrange = selectCourseArrangeById(id);
            ClassroomUsage classroomUsage = new ClassroomUsage();
            BeanUtils.copyProperties(oldCourseArrange, classroomUsage);
            classroomUsageMapper.updateClassroomUsageToBeNull(classroomUsage);
        }

        return courseArrangeMapper.deleteCourseArrangeByIds(ids);
    }

    /**
     * 删除课程安排信息
     *
     * @param id 课程安排主键
     * @return 结果
     */
    @Override
    public int deleteCourseArrangeById(Long id) {
        CourseArrange oldCourseArrange = selectCourseArrangeById(id);
        ClassroomUsage classroomUsage = new ClassroomUsage();
        BeanUtils.copyProperties(oldCourseArrange, classroomUsage);
        classroomUsageMapper.updateClassroomUsageToBeNull(classroomUsage);
        return courseArrangeMapper.deleteCourseArrangeById(id);
    }

    /**
     * 查看当前教室时间段是否已经被占用
     *
     * @param classroomUsage 教室信息
     */
    private void getClassroomUsage(ClassroomUsage classroomUsage) {
        // 1.查看当前教室时间段是否已经被占用
        List<ClassroomUsage> classroomUsages = classroomUsageMapper.selectClassroomById(classroomUsage.getClassroomCode());

        // 校验数据有效性
        if (CollectionUtils.isEmpty(classroomUsages) || classroomUsages.size() < classroomUsage.getClassTime()) {
            throw new ServiceException("教室使用数据异常，无法获取指定时间段");
        }
        // 2.获取节次的所有星期占课情况
        ClassroomUsage ClassroomUsageTime = classroomUsages.get(classroomUsage.getClassTime() - 1);

        // 3.获取节次的所有星期占课情况
        String[] weekAndClassTime = ClassroomUsageTime.toString().split(",");

        // 前三位为：id，教室编号，节次
        String[] week = weekAndClassTime[2 + classroomUsage.getWeekday()].split("=");

        String classTime = week[1];
        if (!classTime.equals("null")) {
            throw new RuntimeException("该时间段已被占用");
        }
    }
}
