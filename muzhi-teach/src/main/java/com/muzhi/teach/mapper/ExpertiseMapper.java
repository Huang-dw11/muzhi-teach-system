package com.muzhi.teach.mapper;

import java.util.List;

import com.muzhi.teach.domain.Expertise;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * 专业管理Mapper接口
 *
 * @author hhh
 * @date 2025-04-05
 */
@Mapper
public interface ExpertiseMapper {
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
     * 删除专业管理
     *
     * @param id 专业管理主键
     * @return 结果
     */
    public int deleteExpertiseById(Long id);

    /**
     * 批量删除专业管理
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteExpertiseByIds(Long[] ids);

    /**
     * 同步修改collegeName
     *
     * @param collegeName
     * @param collegeId
     * @return 结果
     */
    @Update("update tb_expertise set college_name = #{collegeName} where college_id = #{collegeId}")
    public int updateByCollegeId(@Param("collegeName") String collegeName, @Param("collegeId") Long collegeId);
}
