package com.muzhi.teach.service.impl;

import java.util.List;

import com.muzhi.common.exception.CollegeHasTeachersException;
import com.muzhi.common.utils.DateUtils;
import com.muzhi.teach.domain.Teacher;
import com.muzhi.teach.mapper.ExpertiseMapper;
import com.muzhi.teach.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.muzhi.teach.mapper.CollegeMapper;
import com.muzhi.teach.domain.College;
import com.muzhi.teach.service.ICollegeService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 学院管理Service业务层处理
 * 
 * @author hhh
 * @date 2025-04-04
 */
@Service
public class CollegeServiceImpl implements ICollegeService 
{
    @Autowired
    private CollegeMapper collegeMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private ExpertiseMapper expertiseMapper;


    /**
     * 查询学院管理
     * 
     * @param id 学院管理主键
     * @return 学院管理
     */
    @Override
    public College selectCollegeById(Long id)
    {
        return collegeMapper.selectCollegeById(id);
    }

    /**
     * 查询学院管理列表
     * 
     * @param college 学院管理
     * @return 学院管理
     */
    @Override
    public List<College> selectCollegeList(College college)
    {
        return collegeMapper.selectCollegeList(college);
    }

    /**
     * 新增学院管理
     * 
     * @param college 学院管理
     * @return 结果
     */
    @Override
    public int insertCollege(College college)
    {
        college.setCreateTime(DateUtils.getNowDate());
        return collegeMapper.insertCollege(college);
    }

    /**
     * 修改学院管理
     * 
     * @param college 学院管理
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateCollege(College college)
    {
        // 先更新学院信息
        college.setUpdateTime(DateUtils.getNowDate());
        int result = collegeMapper.updateCollege(college);

        if (college.getCollegeCode() != null){
            expertiseMapper.updateByCollegeId(college.getCollegeName(), college.getId());
        }
        return result;
    }

    /**
     * 批量删除学院管理
     * 
     * @param ids 需要删除的学院管理主键
     * @return 结果
     */
    @Override
    public int deleteCollegeByIds(Long[] ids)
    {
        return collegeMapper.deleteCollegeByIds(ids);
    }

    /**
     * 删除学院管理信息
     * 
     * @param id 学院管理主键
     * @return 结果
     */
    @Override
    public int deleteCollegeById(Long id)
    {
        Teacher teacher = new Teacher();
        teacher.setCollegeId(id);

        // 查询当前学院是否存在教师
        List<Teacher> teacherList = teacherMapper.selectTeacherList(teacher);
        if (teacherList != null && !teacherList.isEmpty()){
            throw new CollegeHasTeachersException("改学院存在教师");
        }

        return collegeMapper.deleteCollegeById(id);
    }
}
