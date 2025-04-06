package com.muzhi.teach.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.muzhi.teach.domain.vo.ExpertiseVO;
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
import com.muzhi.teach.domain.Expertise;
import com.muzhi.teach.service.IExpertiseService;
import com.muzhi.common.utils.poi.ExcelUtil;
import com.muzhi.common.core.page.TableDataInfo;

/**
 * 专业管理Controller
 * 
 * @author hhh
 * @date 2025-04-06
 */
@RestController
@RequestMapping("/teach/expertise")
public class ExpertiseController extends BaseController
{
    @Autowired
    private IExpertiseService expertiseService;

    /**
     * 查询专业管理列表
     */
    @PreAuthorize("@ss.hasPermi('teach:expertise:list')")
    @GetMapping("/list")
    public TableDataInfo list(Expertise expertise)
    {
        startPage();
//        List<Expertise> list = expertiseService.selectExpertiseList(expertise);
        List<ExpertiseVO> list = expertiseService.selectExpertiseVOList(expertise);
        return getDataTable(list);
    }

    /**
     * 导出专业管理列表
     */
    @PreAuthorize("@ss.hasPermi('teach:expertise:export')")
    @Log(title = "专业管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Expertise expertise)
    {
        List<Expertise> list = expertiseService.selectExpertiseList(expertise);
        ExcelUtil<Expertise> util = new ExcelUtil<Expertise>(Expertise.class);
        util.exportExcel(response, list, "专业管理数据");
    }

    /**
     * 获取专业管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('teach:expertise:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(expertiseService.selectExpertiseById(id));
    }

    /**
     * 新增专业管理
     */
    @PreAuthorize("@ss.hasPermi('teach:expertise:add')")
    @Log(title = "专业管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Expertise expertise)
    {
        return toAjax(expertiseService.insertExpertise(expertise));
    }

    /**
     * 修改专业管理
     */
    @PreAuthorize("@ss.hasPermi('teach:expertise:edit')")
    @Log(title = "专业管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Expertise expertise)
    {
        return toAjax(expertiseService.updateExpertise(expertise));
    }

    /**
     * 删除专业管理
     */
    @PreAuthorize("@ss.hasPermi('teach:expertise:remove')")
    @Log(title = "专业管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(expertiseService.deleteExpertiseByIds(ids));
    }
}
