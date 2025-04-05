package com.muzhi.teach.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.muzhi.common.annotation.Log;
import com.muzhi.common.core.controller.BaseController;
import com.muzhi.common.core.domain.AjaxResult;
import com.muzhi.common.enums.BusinessType;
import com.muzhi.teach.domain.College;
import com.muzhi.teach.service.ICollegeService;
import com.muzhi.common.utils.poi.ExcelUtil;
import com.muzhi.common.core.page.TableDataInfo;

/**
 * 学院管理Controller
 * 
 * @author hhh
 * @date 2025-04-04
 */
@RestController
@RequestMapping("/teach/college")
public class CollegeController extends BaseController
{
    @Autowired
    private ICollegeService collegeService;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 查询学院管理列表
     */
    @PreAuthorize("@ss.hasPermi('teach:college:list')")
    @GetMapping("/list")
    public TableDataInfo list(College college)
    {
        startPage();
        List<College> list = collegeService.selectCollegeList(college);
        return getDataTable(list);
    }

    /**
     * 导出学院管理列表
     */
    @PreAuthorize("@ss.hasPermi('teach:college:export')")
    @Log(title = "学院管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, College college)
    {
        List<College> list = collegeService.selectCollegeList(college);
        ExcelUtil<College> util = new ExcelUtil<College>(College.class);
        util.exportExcel(response, list, "学院管理数据");
    }

    /**
     * 获取学院管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('teach:college:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(collegeService.selectCollegeById(id));
    }

    /**
     * 新增学院管理
     */
    @PreAuthorize("@ss.hasPermi('teach:college:add')")
    @Log(title = "学院管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody College college)
    {
        return toAjax(collegeService.insertCollege(college));
    }

    /**
     * 修改学院管理
     */
    @PreAuthorize("@ss.hasPermi('teach:college:edit')")
    @Log(title = "学院管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody College college)
    {
        return toAjax(collegeService.updateCollege(college));
    }

    /**
     * 删除学院管理
     */
    @PreAuthorize("@ss.hasPermi('teach:college:remove')")
    @Log(title = "学院管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(collegeService.deleteCollegeByIds(ids));
    }
}
