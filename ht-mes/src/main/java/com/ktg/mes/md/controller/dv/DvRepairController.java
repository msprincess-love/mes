package com.ktg.mes.md.controller.dv;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.domain.dv.DvCheckPlan;
import com.ktg.mes.md.domain.dv.DvRepair;
import com.ktg.mes.md.service.IDvCheckPlanService;
import com.ktg.mes.md.service.IDvRepairService;
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
@RequestMapping("/mes/dv/repair")
public class DvRepairController {

    @Autowired
    private IDvRepairService dvRepairService;

    @PreAuthorize("@ss.hasPermi('mes:dv:repair:list')")
    @GetMapping("/list")
    public AjaxResult list(DvRepair dvRepair, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Page<DvRepair> dvRepairPage = dvRepairService.selectList(dvRepair, pageNum, pageSize);
        return AjaxResult.success(dvRepairPage);
    }

    @PreAuthorize("@ss.hasPermi('mes:dv:repair:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody DvRepair dvRepair) {
        dvRepairService.add(dvRepair);
        return AjaxResult.success("新增成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:dv:repair:query')")
    @GetMapping("/{id}")
    public AjaxResult getById(@PathVariable Long id) {
        DvRepair dvRepair = dvRepairService.selectById(id);
        return AjaxResult.success(dvRepair);
    }

    @PreAuthorize("@ss.hasPermi('mes:dv:repair:edit')")
    @PutMapping
    public AjaxResult update(@Validated @RequestBody DvRepair dvRepair) {
        dvRepairService.edit(dvRepair);
        return AjaxResult.success("修改成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:dv:repair:remove')")
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable Long id) {
        dvRepairService.deleteById(id);
        return AjaxResult.success("删除成功");
    }
}
