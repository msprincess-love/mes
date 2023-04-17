package com.ktg.mes.md.controller.wm;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.domain.wm.WmStorageArea;
import com.ktg.mes.md.service.IWmStorageAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/10 16:41
 * @description mes
 */
@RestController
@RequestMapping("/mes/wm/area")
public class WmStorageAreaController {

    @Autowired
    private IWmStorageAreaService wmStorageAreaService;

    @PreAuthorize("@ss.hasPermi('mes:wm:area:list')")
    @GetMapping("/list")
    public AjaxResult list(WmStorageArea wmStorageArea,
                           @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Page<WmStorageArea> wmStorageAreaPage = wmStorageAreaService.selectList(wmStorageArea, pageNum, pageSize);
        return AjaxResult.success(wmStorageAreaPage);
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:area:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody WmStorageArea wmStorageArea) {
        wmStorageAreaService.add(wmStorageArea);
        return AjaxResult.success("新增成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:area:remove')")
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable Long id) {
        wmStorageAreaService.deleteById(id);
        return AjaxResult.success("删除成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:area:query')")
    @GetMapping("/{id}")
    public AjaxResult getById(@PathVariable Long id) {
        WmStorageArea wmStorageArea = wmStorageAreaService.selectById(id);
        return AjaxResult.success(wmStorageArea);
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:area:edit')")
    @PutMapping
    public AjaxResult update(@Validated @RequestBody WmStorageArea wmStorageArea) {
        wmStorageAreaService.edit(wmStorageArea);
        return AjaxResult.success("修改成功");
    }
}
