package com.ktg.mes.md.controller.wm;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.domain.wm.WmItemRecpt;
import com.ktg.mes.md.service.IWmItemRecptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/14 9:14
 * @description mes
 */
@RestController
@RequestMapping("/mes/wm/itemrecpt")
public class WmItemRecptController {

    @Autowired
    private IWmItemRecptService wmItemRecptService;

    @PreAuthorize("@ss.hasPermi('mes:wm:itemrecpt:list')")
    @GetMapping("/list")
    public AjaxResult list(WmItemRecpt wmItemRecpt,
                           @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Page<WmItemRecpt> wmItemRecptPage = wmItemRecptService.selectList(wmItemRecpt, pageNum, pageSize);
        return AjaxResult.success(wmItemRecptPage);
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:itemrecpt:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody WmItemRecpt wmItemRecpt) {
        wmItemRecptService.add(wmItemRecpt);
        return AjaxResult.success("新增成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:itemrecpt:remove')")
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable Long id) {
        wmItemRecptService.deleteById(id);
        return AjaxResult.success("删除成功");
    }


    @PreAuthorize("@ss.hasPermi('mes:wm:itemrecpt:edit')")
    @PutMapping
    public AjaxResult update(WmItemRecpt wmItemRecpt) {
        wmItemRecptService.edit(wmItemRecpt);
        return AjaxResult.success("修改成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:itemrecpt:query')")
    @GetMapping("/{id}")
    public AjaxResult getById(@PathVariable("id") Long recptId) {
        WmItemRecpt wmItemRecpt = wmItemRecptService.selectById(recptId);
        return AjaxResult.success(wmItemRecpt);
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:itemrecpt:edit')")
    @PutMapping("/{id}")
    public AjaxResult pushWarehouse(@PathVariable("id") Long recptId) {
        wmItemRecptService.pushWarehouse(recptId);
        return AjaxResult.success("入库成功");
    }
}
