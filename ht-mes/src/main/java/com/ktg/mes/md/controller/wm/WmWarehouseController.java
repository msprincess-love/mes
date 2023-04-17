package com.ktg.mes.md.controller.wm;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.domain.wm.WmWarehouse;
import com.ktg.mes.md.service.IWmWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/9 21:07
 * @description mes
 */
@RestController
@RequestMapping("/mes/wm/warehouse")
public class WmWarehouseController {

    @Autowired
    private IWmWarehouseService wmWarehouseService;

    @PreAuthorize("@ss.hasPermi('mes:wm:warehouse:list')")
    @GetMapping("/list")
    public AjaxResult list(WmWarehouse warehouse, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Page<WmWarehouse> warehousePage = wmWarehouseService.selectList(warehouse, pageNum, pageSize);
        return AjaxResult.success(warehousePage);
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:warehouse:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody WmWarehouse warehouse) {
        wmWarehouseService.add(warehouse);
        return AjaxResult.success("新增成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:warehouse:remove')")
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable Long id) {
        wmWarehouseService.deleteById(id);
        return AjaxResult.success("删除成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:warehouse:query')")
    @GetMapping("/{id}")
    public AjaxResult getById(@PathVariable Long id) {
        WmWarehouse warehouse = wmWarehouseService.selectById(id);
        return AjaxResult.success(warehouse);
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:warehouse:edit')")
    @PutMapping
    public AjaxResult update(@Validated @RequestBody WmWarehouse warehouse) {
        wmWarehouseService.edit(warehouse);
        return AjaxResult.success("修改成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:warehouse:list')")
    @GetMapping("/getTreeList")
    public AjaxResult getTreeList() {
        wmWarehouseService.getTreeList();
        return null;
    }

}
