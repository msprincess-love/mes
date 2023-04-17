package com.ktg.mes.md.controller.wm;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.domain.wm.WmItemRecpt;
import com.ktg.mes.md.domain.wm.WmItemRecptLine;
import com.ktg.mes.md.domain.wm.WmRtIssue;
import com.ktg.mes.md.service.IWmItemRecptLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/16 16:38
 * @description mes
 */
@RestController
@RequestMapping("/mes/wm/itemrecptline")
public class WmItemRecptLineController {

    @Autowired
    private IWmItemRecptLineService wmItemRecptLineService;

    @PreAuthorize("@ss.hasPermi('mes:wm:itemrecptline:list')")
    @GetMapping("/list")
    public AjaxResult list(@RequestParam(value = "recptId", required = false) Long recptId,
                           @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Page<WmItemRecptLine> wmItemRecptPage = wmItemRecptLineService.selectList(recptId, pageNum, pageSize);
        return AjaxResult.success(wmItemRecptPage);
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:itemrecptline:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody WmItemRecptLine wmItemRecpt) {
        wmItemRecptLineService.add(wmItemRecpt);
        return AjaxResult.success("新增成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:itemrecptline:remove')")
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable Long id) {
        wmItemRecptLineService.deleteById(id);
        return AjaxResult.success("删除成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:itemrecptline:query')")
    @GetMapping("/{id}")
    public AjaxResult get(@PathVariable("id") Long recptId) {
        WmItemRecptLine wmItemRecpt = wmItemRecptLineService.get(recptId);
        return AjaxResult.success(wmItemRecpt);
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:itemrecptline:edit')")
    @PutMapping
    public AjaxResult update(@Validated @RequestBody WmItemRecptLine wmItemRecptLine) {
        wmItemRecptLineService.edit(wmItemRecptLine);
        return AjaxResult.success("修改成功");
    }
}
