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
import com.muzhi.teach.domain.Classroom;
import com.muzhi.teach.service.IClassroomService;
import com.muzhi.common.utils.poi.ExcelUtil;
import com.muzhi.common.core.page.TableDataInfo;

/**
 * 教室管理Controller
 *
 * @author hhh
 * @date 2025-04-09
 */
@RestController
@RequestMapping("/teach/classroom")
public class ClassroomController extends BaseController {
    @Autowired
    private IClassroomService classroomService;

    /**
     * 查询教室管理列表
     */
    @PreAuthorize("@ss.hasPermi('teach:classroom:list')")
    @GetMapping("/list")
    public TableDataInfo list(Classroom classroom) {
        startPage();
        List<Classroom> list = classroomService.selectClassroomList(classroom);
        return getDataTable(list);
    }

    /**
     * 导出教室管理列表
     */
    @PreAuthorize("@ss.hasPermi('teach:classroom:export')")
    @Log(title = "教室管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Classroom classroom) {
        List<Classroom> list = classroomService.selectClassroomList(classroom);
        ExcelUtil<Classroom> util = new ExcelUtil<Classroom>(Classroom.class);
        util.exportExcel(response, list, "教室管理数据");
    }

    /**
     * 获取教室管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('teach:classroom:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(classroomService.selectClassroomAndUsageById(id));
    }

    /**
     * 新增教室管理
     */
    @PreAuthorize("@ss.hasPermi('teach:classroom:add')")
    @Log(title = "教室管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Classroom classroom) {
        return toAjax(classroomService.insertClassroom(classroom));
    }

    /**
     * 修改教室管理
     */
    @PreAuthorize("@ss.hasPermi('teach:classroom:edit')")
    @Log(title = "教室管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Classroom classroom) {
        return toAjax(classroomService.updateClassroom(classroom));
    }

    /**
     * 删除教室管理
     */
    @PreAuthorize("@ss.hasPermi('teach:classroom:remove')")
    @Log(title = "教室管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(classroomService.deleteClassroomByIds(ids));
    }
}
