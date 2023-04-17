package com.ktg.mes.md.controller.wm;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.domain.wm.WmMaterialStock;
import com.ktg.mes.md.service.IWmMaterialStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/10 17:54
 * @description mes
 */
@RestController
@RequestMapping("/mes/wm/wmstock")
public class WmMaterialStockController {

    @Autowired
    private IWmMaterialStockService wmMaterialStockService;

    @PreAuthorize("@ss.hasPermi('mes:wm:wmstock:list')")
    @GetMapping("/list")
    public AjaxResult list(WmMaterialStock wmMaterialStock,
                           @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Page<WmMaterialStock> wmMaterialStockPage = wmMaterialStockService.selectList(wmMaterialStock, pageNum, pageSize);
        return AjaxResult.success(wmMaterialStockPage);
    }

}
