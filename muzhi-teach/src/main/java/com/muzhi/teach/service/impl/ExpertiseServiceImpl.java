package com.muzhi.teach.service.impl;

import java.util.List;

import com.muzhi.common.utils.DateUtils;
import com.muzhi.teach.domain.vo.ExpertiseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.muzhi.teach.mapper.ExpertiseMapper;
import com.muzhi.teach.domain.Expertise;
import com.muzhi.teach.service.IExpertiseService;

/**
 * 专业管理Service业务层处理
 *
 * @author hhh
 * @date 2025-04-04
 */
@Service
public class ExpertiseServiceImpl implements IExpertiseService {
    @Autowired
    private ExpertiseMapper expertiseMapper;

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
        expertise.setCreateTime(DateUtils.getNowDate());
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
     * 查询专业信息
     *
     * @param expertise
     * @return ExpertiseVO集合
     */
    @Override
    public List<ExpertiseVO> selectExpertiseVOList(Expertise expertise) {
        return expertiseMapper.selectExpertiseVOList(expertise);
    }
}
