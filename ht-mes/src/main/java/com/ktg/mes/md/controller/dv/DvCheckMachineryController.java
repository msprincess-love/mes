package com.ktg.mes.md.controller.dv;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.domain.dv.DvCheckMachinery;
import com.ktg.mes.md.domain.dv.DvCheckSubject;
import com.ktg.mes.md.service.IDvCheckMachineryService;
import com.ktg.mes.md.service.IDvCheckSubjectService;
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
@RequestMapping("/mes/dv/checkmachinery")
public class DvCheckMachineryController {

    @Autowired
    private IDvCheckMachineryService dvCheckMachineryService;

    @PreAuthorize("@ss.hasPermi('mes:dv:checkmachinery:list')")
    @GetMapping("/list")
    public AjaxResult list( @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                            @RequestParam(value = "planId") Long planId) {
        Page<DvCheckMachinery> dvCheckMachineryPage = dvCheckMachineryService.selectList(planId, pageNum, pageSize);
        return AjaxResult.success(dvCheckMachineryPage);
    }

    @PreAuthorize("@ss.hasPermi('mes:dv:checkmachinery:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody DvCheckMachinery dvCheckMachinery) {
        dvCheckMachineryService.add(dvCheckMachinery);
        return AjaxResult.success("新增成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:dv:checkmachinery:remove')")
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable Long id) {
        dvCheckMachineryService.deleteById(id);
        return AjaxResult.success("删除成功");
    }


}
