package com.muzhi.teach.service;

import java.util.List;
import com.muzhi.teach.domain.Expertise;

/**
 * 专业管理Service接口
 * 
 * @author hhh
 * @date 2025-04-05
 */
public interface IExpertiseService 
{
    /**
     * 查询专业管理
     * 
     * @param id 专业管理主键
     * @return 专业管理
     */
    public Expertise selectExpertiseById(Long id);

    /**
     * 查询专业管理列表
     * 
     * @param expertise 专业管理
     * @return 专业管理集合
     */
    public List<Expertise> selectExpertiseList(Expertise expertise);

    /**
     * 新增专业管理
     * 
     * @param expertise 专业管理
     * @return 结果
     */
    public int insertExpertise(Expertise expertise);

    /**
     * 修改专业管理
     * 
     * @param expertise 专业管理
     * @return 结果
     */
    public int updateExpertise(Expertise expertise);

    /**
     * 批量删除专业管理
     * 
     * @param ids 需要删除的专业管理主键集合
     * @return 结果
     */
    public int deleteExpertiseByIds(Long[] ids);

    /**
     * 删除专业管理信息
     * 
     * @param id 专业管理主键
     * @return 结果
     */
    public int deleteExpertiseById(Long id);
}
