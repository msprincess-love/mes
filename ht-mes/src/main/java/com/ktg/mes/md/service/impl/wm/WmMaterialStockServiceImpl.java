package com.ktg.mes.md.service.impl.wm;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.wm.WmMaterialStock;
import com.ktg.mes.md.mapper.wm.WmMaterialStockMapper;
import com.ktg.mes.md.service.IWmMaterialStockService;
import org.springframework.stereotype.Service;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/10 17:50
 * @description mes
 */
@Service
public class WmMaterialStockServiceImpl extends ServiceImpl<WmMaterialStockMapper, WmMaterialStock> implements IWmMaterialStockService {


    @Override
    public Page<WmMaterialStock> selectList(WmMaterialStock wmMaterialStock, int pageNum, int pageSize) {
        Page<WmMaterialStock> pageInfo = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<WmMaterialStock> wrapper = new LambdaQueryWrapper<>();
        if (wmMaterialStock.getItemCode() != null)
            wrapper.eq(WmMaterialStock::getItemCode, wmMaterialStock.getItemCode());
        if (wmMaterialStock.getItemName() != null)
            wrapper.like(WmMaterialStock::getItemName, wmMaterialStock.getItemName());
        if (wmMaterialStock.getBatchCode() != null)
            wrapper.like(WmMaterialStock::getBatchCode, wmMaterialStock.getBatchCode());
        if (wmMaterialStock.getWarehouseName() != null)
            wrapper.like(WmMaterialStock::getWarehouseName, wmMaterialStock.getWarehouseName());
        if (wmMaterialStock.getVendorCode() != null)
            wrapper.eq(WmMaterialStock::getVendorCode, wmMaterialStock.getVendorCode());
        if (wmMaterialStock.getVendorName() != null)
            wrapper.like(WmMaterialStock::getVendorName, wmMaterialStock.getVendorName());
        if (wmMaterialStock.getExpireDate() != null)
            wrapper.le(WmMaterialStock::getExpireDate, wmMaterialStock.getExpireDate());
        return page(pageInfo, wrapper);
    }
}
