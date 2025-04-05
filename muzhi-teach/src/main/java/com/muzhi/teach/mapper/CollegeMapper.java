package com.muzhi.teach.mapper;

import java.util.List;
import com.muzhi.teach.domain.College;
import org.apache.ibatis.annotations.Mapper;

/**
 * 学院管理Mapper接口
 * 
 * @author hhh
 * @date 2025-04-04
 */
@Mapper
public interface CollegeMapper 
{
    /**
     * 查询学院管理
     * 
     * @param id 学院管理主键
     * @return 学院管理
     */
    public College selectCollegeById(Long id);

    /**
     * 查询学院管理列表
     * 
     * @param college 学院管理
     * @return 学院管理集合
     */
    public List<College> selectCollegeList(College college);

    /**
     * 新增学院管理
     * 
     * @param college 学院管理
     * @return 结果
     */
    public int insertCollege(College college);

    /**
     * 修改学院管理
     * 
     * @param college 学院管理
     * @return 结果
     */
    public int updateCollege(College college);

    /**
     * 删除学院管理
     * 
     * @param id 学院管理主键
     * @return 结果
     */
    public int deleteCollegeById(Long id);

    /**
     * 批量删除学院管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCollegeByIds(Long[] ids);
}
