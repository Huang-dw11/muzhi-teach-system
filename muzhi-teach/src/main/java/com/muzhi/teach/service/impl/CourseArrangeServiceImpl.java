package com.muzhi.teach.service.impl;

import java.util.List;

import com.muzhi.common.utils.DateUtils;
import com.muzhi.teach.config.ClassNumberGenerator;
import com.muzhi.teach.domain.Course;
import com.muzhi.teach.mapper.CourseMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.muzhi.teach.mapper.CourseArrangeMapper;
import com.muzhi.teach.domain.CourseArrange;
import com.muzhi.teach.service.ICourseArrangeService;

/**
 * 课程安排Service业务层处理
 *
 * @author hhh
 * @date 2025-04-10
 */
@Service
public class CourseArrangeServiceImpl implements ICourseArrangeService {
    @Autowired
    private CourseArrangeMapper courseArrangeMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private ClassNumberGenerator classNumberGenerator;

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
    @Override
    public int insertCourseArrange(CourseArrange courseArrange) {

        // 处理课程编号和课程名
        Course course = new Course();
        String courseCode = courseArrange.getCourseCode();
        course.setCourseCode(courseCode);

        Course courses = courseMapper.selectCourse(course);
        BeanUtils.copyProperties(courses,courseArrange);

        // 处理教编号与教师名
        String[] teacherNoAndName = courseArrange.getTeacherNo().split(",");

        courseArrange.setTeacherNo(teacherNoAndName[0]);
        courseArrange.setName(teacherNoAndName[1]);

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
    @Override
    public int updateCourseArrange(CourseArrange courseArrange) {
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
        return courseArrangeMapper.deleteCourseArrangeById(id);
    }
}
