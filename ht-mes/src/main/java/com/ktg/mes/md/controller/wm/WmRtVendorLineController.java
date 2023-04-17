package com.ktg.mes.md.controller.wm;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.domain.wm.WmItemRecptLine;
import com.ktg.mes.md.domain.wm.WmRtVendorLine;
import com.ktg.mes.md.service.IWmRtVendorLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/16 17:02
 * @description mes
 */
@RestController
@RequestMapping("/mes/wm/rtvendorline")
public class WmRtVendorLineController {

    @Autowired
    private IWmRtVendorLineService wmRtVendorLineService;

    @PreAuthorize("@ss.hasPermi('mes:wm:rtvendorline:list')")
    @GetMapping("/list")
    public AjaxResult list(@RequestParam(value = "rtId", required = false) Long rtId,
                           @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Page<WmRtVendorLine> wmRtVendorLinePage = wmRtVendorLineService.selectList(rtId, pageNum, pageSize);
        return AjaxResult.success(wmRtVendorLinePage);
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:rtvendorline:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody WmRtVendorLine wmRtVendorLine) {
        wmRtVendorLineService.add(wmRtVendorLine);
        return AjaxResult.success("新增成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:rtvendorline:remove')")
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable Long id) {
        wmRtVendorLineService.deleteById(id);
        return AjaxResult.success("删除成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:rtvendorline:query')")
    @GetMapping("{id}")
    public AjaxResult get(@PathVariable("id") Long recptId) {
        WmRtVendorLine wmRtVendorLine = wmRtVendorLineService.get(recptId);
        return AjaxResult.success(wmRtVendorLine);
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:rtvendorline:edit')")
    @PutMapping
    public AjaxResult update(@Validated @RequestBody WmRtVendorLine wmRtVendorLine) {
        wmRtVendorLineService.edit(wmRtVendorLine);
        return AjaxResult.success("修改成功");
    }
}
