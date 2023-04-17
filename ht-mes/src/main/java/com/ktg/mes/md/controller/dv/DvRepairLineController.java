package com.ktg.mes.md.controller.dv;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.domain.dv.DvRepairLine;
import com.ktg.mes.md.domain.dv.DvSubject;
import com.ktg.mes.md.service.IDvRepairLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/16 13:55
 * @description mes
 */
@RestController
@RequestMapping("/mes/dv/repairline")
public class DvRepairLineController {

    @Autowired
    private IDvRepairLineService dvRepairLineService;

    @PreAuthorize("@ss.hasPermi('mes:dv:repairline:list')")
    @GetMapping("/list")
    public AjaxResult list( @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Page<DvRepairLine> dvRepairLinePage = dvRepairLineService.selectList( pageNum, pageSize);
        return AjaxResult.success(dvRepairLinePage);
    }

    @PreAuthorize("@ss.hasPermi('mes:dv:repairline:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody DvRepairLine dvRepairLine) {
        dvRepairLineService.add(dvRepairLine);
        return AjaxResult.success("新增成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:dv:repairline:query')")
    @GetMapping("/{id}")
    public AjaxResult getById(@PathVariable Long id) {
        DvRepairLine dvRepairLine = dvRepairLineService.selectById(id);
        return AjaxResult.success(dvRepairLine);
    }

    @PreAuthorize("@ss.hasPermi('mes:dv:repairline:edit')")
    @PutMapping
    public AjaxResult update(@Validated @RequestBody DvRepairLine dvRepairLine) {
        dvRepairLineService.edit(dvRepairLine);
        return AjaxResult.success("修改成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:dv:repairline:remove')")
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable Long id) {
        dvRepairLineService.deleteById(id);
        return AjaxResult.success("删除成功");
    }
}
