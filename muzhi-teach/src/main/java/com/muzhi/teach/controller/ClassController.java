package com.muzhi.teach.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.muzhi.teach.domain.vo.ClazzVO;
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
import com.muzhi.teach.domain.Clazz;
import com.muzhi.teach.service.IClassService;
import com.muzhi.common.utils.poi.ExcelUtil;
import com.muzhi.common.core.page.TableDataInfo;

/**
 * 班级管理Controller
 * 
 * @author hhh
 * @date 2025-04-05
 */
@RestController
@RequestMapping("/teach/class")
public class ClassController extends BaseController
{
    @Autowired
    private IClassService classService;

    /**
     * 查询班级管理列表
     */
    @PreAuthorize("@ss.hasPermi('teach:class:list')")
    @GetMapping("/list")
    public TableDataInfo list(Clazz clazz)
    {
        startPage();
//        List<Clazz> list = classService.selectClassList(clazz);
        List<ClazzVO> list = classService.selectClassVOList(clazz);
        return getDataTable(list);
    }

    /**
     * 导出班级管理列表
     */
    @PreAuthorize("@ss.hasPermi('teach:class:export')")
    @Log(title = "班级管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Clazz clazz)
    {
        List<Clazz> list = classService.selectClassList(clazz);
        ExcelUtil<Clazz> util = new ExcelUtil<Clazz>(Clazz.class);
        util.exportExcel(response, list, "班级管理数据");
    }

    /**
     * 获取班级管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('teach:class:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(classService.selectClassById(id));
    }

    /**
     * 新增班级管理
     */
    @PreAuthorize("@ss.hasPermi('teach:class:add')")
    @Log(title = "班级管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Clazz clazz)
    {
        return toAjax(classService.insertClass(clazz));
    }

    /**
     * 修改班级管理
     */
    @PreAuthorize("@ss.hasPermi('teach:class:edit')")
    @Log(title = "班级管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Clazz clazz)
    {
        return toAjax(classService.updateClass(clazz));
    }

    /**
     * 删除班级管理
     */
    @PreAuthorize("@ss.hasPermi('teach:class:remove')")
    @Log(title = "班级管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(classService.deleteClassByIds(ids));
    }
}
