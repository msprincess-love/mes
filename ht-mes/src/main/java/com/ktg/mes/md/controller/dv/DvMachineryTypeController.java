package com.ktg.mes.md.controller.dv;

import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.domain.dv.DvMachineryType;
import com.ktg.mes.md.service.IDvMachineryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/10 20:27
 * @description mes
 */
@RestController
@RequestMapping("/mes/dv/machinerytype")
public class DvMachineryTypeController {

    @Autowired
    private IDvMachineryTypeService dvMachineryTypeService;

    @PreAuthorize("@ss.hasPermi('mes:dv:machinerytype:list')")
    @GetMapping("/list")
    public AjaxResult list(DvMachineryType dvMachineryType) {
        List<DvMachineryType> dvMachineryTypes = dvMachineryTypeService.selectList(dvMachineryType);
        return AjaxResult.success(dvMachineryTypes);
    }

    @PreAuthorize("@ss.hasPermi('mes:dv:machinerytype:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody DvMachineryType dvMachineryType) {
        dvMachineryTypeService.add(dvMachineryType);
        return AjaxResult.success("新增成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:dv:machinerytype:query')")
    @GetMapping("/{id}")
    public AjaxResult getById(@PathVariable Long id) {
        DvMachineryType dvMachineryType = dvMachineryTypeService.selectById(id);
        return AjaxResult.success(dvMachineryType);
    }

    @PreAuthorize("@ss.hasPermi('mes:dv:machinerytype:edit')")
    @PutMapping
    public AjaxResult update(@Validated @RequestBody DvMachineryType dvMachineryType) {
        dvMachineryTypeService.edit(dvMachineryType);
        return AjaxResult.success("修改成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:dv:machinerytype:remove')")
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable Long id) {
        dvMachineryTypeService.deleteById(id);
        return AjaxResult.success("删除成功");
    }
}
