package com.ktg.mes.md.controller.wm;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.domain.wm.WmRtVendor;
import com.ktg.mes.md.service.IWmRtVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/14 9:47
 * @description mes
 */
@RestController
@RequestMapping("/mes/wm/rtvendor")
public class WmRtVendorController {

    @Autowired
    private IWmRtVendorService rtVendorService;

    @PreAuthorize("@ss.hasPermi('mes:wm:rtvendor:list')")
    @GetMapping("/list")
    public AjaxResult list(WmRtVendor wmRtVendor,
                           @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Page<WmRtVendor> wmRtVendorPage = rtVendorService.selectList(wmRtVendor, pageNum, pageSize);
        return AjaxResult.success(wmRtVendorPage);
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:rtvendor:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody WmRtVendor wmRtVendor) {
        rtVendorService.add(wmRtVendor);
        return AjaxResult.success("新增成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:rtvendor:remove')")
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable Long id) {
        rtVendorService.deleteById(id);
        return AjaxResult.success("删除成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:rtvendor:query')")
    @GetMapping("/{id}")
    public AjaxResult getById(@PathVariable Long id) {
        WmRtVendor wmRtVendor = rtVendorService.selectById(id);
        return AjaxResult.success(wmRtVendor);
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:rtvendor:edit')")
    @PutMapping
    public AjaxResult update(@Validated @RequestBody WmRtVendor wmRtVendor) {
        rtVendorService.edit(wmRtVendor);
        return AjaxResult.success("修改成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:rtvendor:edit')")
    @PutMapping("/{id}")
    public AjaxResult outItem(@PathVariable("id") Long id) {
        rtVendorService.outItem(id);
        return AjaxResult.success("修改成功");
    }

}
