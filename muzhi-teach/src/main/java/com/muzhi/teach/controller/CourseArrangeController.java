package com.muzhi.teach.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.muzhi.teach.domain.CourseArrange;
import com.muzhi.teach.service.ICourseArrangeService;
import com.muzhi.common.utils.poi.ExcelUtil;
import com.muzhi.common.core.page.TableDataInfo;

/**
 * 课程安排Controller
 * 
 * @author hhh
 * @date 2025-04-10
 */
@RestController
@RequestMapping("/teach/arrange")
public class CourseArrangeController extends BaseController
{
    @Autowired
    private ICourseArrangeService courseArrangeService;

    /**
     * 查询课程安排列表
     */
    @PreAuthorize("@ss.hasPermi('teach:arrange:list')")
    @GetMapping("/list")
    public TableDataInfo list(CourseArrange courseArrange)
    {
        startPage();
        List<CourseArrange> list = courseArrangeService.selectCourseArrangeList(courseArrange);
        return getDataTable(list);
    }

    /**
     * 导出课程安排列表
     */
    @PreAuthorize("@ss.hasPermi('teach:arrange:export')")
    @Log(title = "课程安排", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CourseArrange courseArrange)
    {
        List<CourseArrange> list = courseArrangeService.selectCourseArrangeList(courseArrange);
        ExcelUtil<CourseArrange> util = new ExcelUtil<CourseArrange>(CourseArrange.class);
        util.exportExcel(response, list, "课程安排数据");
    }

    /**
     * 获取课程安排详细信息
     */
    @PreAuthorize("@ss.hasPermi('teach:arrange:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(courseArrangeService.selectCourseArrangeById(id));
    }

    /**
     * 新增课程安排
     */
    @PreAuthorize("@ss.hasPermi('teach:arrange:add')")
    @Log(title = "课程安排", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CourseArrange courseArrange)
    {
        return toAjax(courseArrangeService.insertCourseArrange(courseArrange));
    }

    /**
     * 修改课程安排
     */
    @PreAuthorize("@ss.hasPermi('teach:arrange:edit')")
    @Log(title = "课程安排", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CourseArrange courseArrange)
    {
        return toAjax(courseArrangeService.updateCourseArrange(courseArrange));
    }

    /**
     * 删除课程安排
     */
    @PreAuthorize("@ss.hasPermi('teach:arrange:remove')")
    @Log(title = "课程安排", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(courseArrangeService.deleteCourseArrangeByIds(ids));
    }
}
