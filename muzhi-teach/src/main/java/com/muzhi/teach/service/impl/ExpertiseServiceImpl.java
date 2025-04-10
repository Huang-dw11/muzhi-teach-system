package com.muzhi.teach.service.impl;

import java.util.List;

import com.muzhi.common.utils.DateUtils;
import com.muzhi.teach.domain.College;
import com.muzhi.teach.domain.vo.ExpertiseVO;
import com.muzhi.teach.mapper.CategoryMapper;
import com.muzhi.teach.mapper.CollegeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.muzhi.teach.mapper.ExpertiseMapper;
import com.muzhi.teach.domain.Expertise;
import com.muzhi.teach.service.IExpertiseService;

/**
 * 专业管理Service业务层处理
 *
 * @author hhh
 * @date 2025-04-06
 */
@Service
public class ExpertiseServiceImpl implements IExpertiseService {
    @Autowired
    private ExpertiseMapper expertiseMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private CollegeMapper collegeMapper;

    /**
     * 查询专业管理
     *
     * @param id 专业管理主键
     * @return 专业管理
     */
    @Override
    public Expertise selectExpertiseById(Long id) {
        return expertiseMapper.selectExpertiseById(id);
    }

    /**
     * 查询专业管理列表
     *
     * @param expertise 专业管理
     * @return 专业管理
     */
    @Override
    public List<Expertise> selectExpertiseList(Expertise expertise) {
        return expertiseMapper.selectExpertiseList(expertise);
    }

    /**
     * 新增专业管理
     *
     * @param expertise 专业管理
     * @return 结果
     */
    @Override
    public int insertExpertise(Expertise expertise) {
        // 080901 - 08学类，工学，理学 - 09门类，如计算机类  - 01第几个专业
        String code = expertise.getExpertiseCode();

        // 去除前导零（但如果整个字符串是 "00"，则返回 ""）
        String degreeType = code.substring(0, 2).replaceFirst("^0+", "");

        String categoryId;
        if (code != null && code.matches("^0.*")) {
            // 第一位是 0
            categoryId = code.substring(1, 4);
            System.out.println("第一位是 0");
        } else {
            //第一位不是 0
            categoryId = code.substring(0, 4);
        }

        expertise.setDegreeType(Long.parseLong(degreeType));
        expertise.setCategoryId(Long.parseLong(categoryId));

        expertise.setCreateTime(DateUtils.getNowDate());

        // 设置专业所属院系
        College college = collegeMapper.selectCollegeById(expertise.getCollegeId());
        expertise.setCollegeName(college.getCollegeName());

        return expertiseMapper.insertExpertise(expertise);
    }

    /**
     * 修改专业管理
     *
     * @param expertise 专业管理
     * @return 结果
     */
    @Override
    public int updateExpertise(Expertise expertise) {

        String code = expertise.getExpertiseCode();

        // 去除前导零（但如果整个字符串是 "00"，则返回 ""）
        String degreeType = code.substring(0, 2).replaceFirst("^0+", "");

        String categoryId;
        if (code != null && code.matches("^0.*")) {
            // 第一位是 0
            categoryId = code.substring(1, 4);
            System.out.println("第一位是 0");
        } else {
            //第一位不是 0
            categoryId = code.substring(0, 4);
        }

        expertise.setDegreeType(Long.parseLong(degreeType));
        expertise.setCategoryId(Long.parseLong(categoryId));

        expertise.setCreateTime(DateUtils.getNowDate());

        // 设置专业所属院系
        College college = collegeMapper.selectCollegeById(expertise.getCollegeId());
        expertise.setCollegeName(college.getCollegeName());

        expertise.setUpdateTime(DateUtils.getNowDate());
        return expertiseMapper.updateExpertise(expertise);
    }

    /**
     * 批量删除专业管理
     *
     * @param ids 需要删除的专业管理主键
     * @return 结果
     */
    @Override
    public int deleteExpertiseByIds(Long[] ids) {
        return expertiseMapper.deleteExpertiseByIds(ids);
    }

    /**
     * 删除专业管理信息
     *
     * @param id 专业管理主键
     * @return 结果
     */
    @Override
    public int deleteExpertiseById(Long id) {
        return expertiseMapper.deleteExpertiseById(id);
    }

    /**
     * 查询专业信息和对应的门类
     *
     * @param expertise
     * @return 专业管理集合
     */
    @Override
    public List<ExpertiseVO> selectExpertiseVOList(Expertise expertise) {
        return expertiseMapper.selectExpertiseVOList(expertise);
    }
}
