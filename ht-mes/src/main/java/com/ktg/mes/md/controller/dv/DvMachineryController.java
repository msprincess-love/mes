package com.ktg.mes.md.controller.dv;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.domain.dv.DvMachinery;
import com.ktg.mes.md.service.IDvMachineryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/10 21:10
 * @description mes
 */
@RestController
@RequestMapping("/mes/dv/machinery")
public class DvMachineryController {

    @Autowired
    private IDvMachineryService dvMachineryService;

    @PreAuthorize("@ss.hasPermi('mes:dv:machinery:list')")
    @GetMapping("/list")
    public AjaxResult list(DvMachinery dvMachinery, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Page<DvMachinery> dvMachineryPage = dvMachineryService.selectClientList(dvMachinery, pageNum, pageSize);
        return AjaxResult.success(dvMachineryPage);
    }

    @PreAuthorize("@ss.hasPermi('mes:dv:machinery:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody DvMachinery dvMachinery) {
        dvMachineryService.add(dvMachinery);
        return AjaxResult.success("新增成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:dv:machinery:remove')")
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable Long id) {
        dvMachineryService.deleteById(id);
        return AjaxResult.success("删除成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:dv:machinery:query')")
    @GetMapping("/{id}")
    public AjaxResult getById(@PathVariable Long id) {
        DvMachinery dvMachinery = dvMachineryService.selectById(id);
        return AjaxResult.success(dvMachinery);
    }

    @PreAuthorize("@ss.hasPermi('mes:dv:machinery:edit')")
    @PutMapping
    public AjaxResult update(@Validated @RequestBody DvMachinery dvMachinery) {
        dvMachineryService.edit(dvMachinery);
        return AjaxResult.success("修改成功");
    }

}
