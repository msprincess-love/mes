package com.ktg.mes.md.controller.wm;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.domain.wm.WmStorageLocation;
import com.ktg.mes.md.service.IWmStorageLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/10 10:33
 * @description mes
 */
@RestController
@RequestMapping("/mes/wm/location")
public class WmStorageLocationController {

    @Autowired
    private IWmStorageLocationService wmStorageLocationService;

    @PreAuthorize("@ss.hasPermi('mes:wm:location:list')")
    @GetMapping("/list")
    public AjaxResult list(WmStorageLocation wmStorageLocation,
                           @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Page<WmStorageLocation> wmStorageLocationPage = wmStorageLocationService.selectList(wmStorageLocation, pageNum, pageSize);
        return AjaxResult.success(wmStorageLocationPage);
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:location:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody WmStorageLocation wmStorageLocation) {
        wmStorageLocationService.add(wmStorageLocation);
        return AjaxResult.success("新增成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:location:remove')")
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable Long id) {
        wmStorageLocationService.deleteById(id);
        return AjaxResult.success("删除成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:location:query')")
    @GetMapping("/{id}")
    public AjaxResult getById(@PathVariable Long id) {
        WmStorageLocation wmStorageLocation = wmStorageLocationService.selectById(id);
        return AjaxResult.success(wmStorageLocation);
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:location:edit')")
    @PutMapping
    public AjaxResult update(@Validated @RequestBody WmStorageLocation wmStorageLocation) {
        wmStorageLocationService.edit(wmStorageLocation);
        return AjaxResult.success("修改成功");
    }
}
