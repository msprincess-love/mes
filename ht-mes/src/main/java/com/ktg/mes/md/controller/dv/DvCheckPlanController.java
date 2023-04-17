package com.ktg.mes.md.controller.dv;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.domain.dv.DvCheckPlan;
import com.ktg.mes.md.domain.dv.DvSubject;
import com.ktg.mes.md.service.IDvCheckPlanService;
import com.ktg.mes.md.service.IDvSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/11 11:31
 * @description mes
 */
@RestController
@RequestMapping("/mes/dv/checkplan")
public class DvCheckPlanController {

    @Autowired
    private IDvCheckPlanService dvCheckPlanService;

    @PreAuthorize("@ss.hasPermi('mes:dv:checkplan:list')")
    @GetMapping("/list")
    public AjaxResult list(DvCheckPlan dvCheckPlan, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Page<DvCheckPlan> dvCheckPlanPage = dvCheckPlanService.selectList(dvCheckPlan, pageNum, pageSize);
        return AjaxResult.success(dvCheckPlanPage);
    }

    @PreAuthorize("@ss.hasPermi('mes:dv:checkplan:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody DvCheckPlan dvCheckPlan) {
        dvCheckPlanService.add(dvCheckPlan);
        return AjaxResult.success("新增成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:dv:checkplan:query')")
    @GetMapping("/{id}")
    public AjaxResult getById(@PathVariable Long id) {
        DvCheckPlan dvCheckPlan = dvCheckPlanService.selectById(id);
        return AjaxResult.success(dvCheckPlan);
    }

    @PreAuthorize("@ss.hasPermi('mes:dv:checkplan:edit')")
    @PutMapping
    public AjaxResult update(@Validated @RequestBody DvCheckPlan dvCheckPlan) {
        dvCheckPlanService.edit(dvCheckPlan);
        return AjaxResult.success("修改成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:dv:checkplan:remove')")
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable Long id) {
        dvCheckPlanService.deleteById(id);
        return AjaxResult.success("删除成功");
    }
}
