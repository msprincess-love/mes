package com.ktg.mes.md.service.impl.wm;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.md.MdItem;
import com.ktg.mes.md.domain.wm.WmItemRecpt;
import com.ktg.mes.md.domain.wm.WmItemRecptLine;
import com.ktg.mes.md.domain.wm.WmMaterialStock;
import com.ktg.mes.md.domain.wm.WmStorageArea;
import com.ktg.mes.md.exception.IdExistNotException;
import com.ktg.mes.md.mapper.wm.WmItemRecptMapper;
import com.ktg.mes.md.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/14 9:13
 * @description mes
 */
@Service
public class WmItemRecptServiceImpl extends ServiceImpl<WmItemRecptMapper, WmItemRecpt> implements IWmItemRecptService {

    @Autowired
    private IMdItemService mdItemService;

    @Autowired
    private IWmStorageAreaService wmStorageAreaService;

    @Autowired
    private IWmItemRecptLineService wmItemRecptLineService;

    @Autowired
    private IWmMaterialStockService wmMaterialStockService;

    @Override
    public Page<WmItemRecpt> selectList(WmItemRecpt wmItemRecpt, int pageNum, int pageSize) {
        Page<WmItemRecpt> pageInfo = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<WmItemRecpt> wrapper = new LambdaQueryWrapper<>();
        if (wmItemRecpt.getRecptCode() != null)
            wrapper.eq(WmItemRecpt::getRecptCode, wmItemRecpt.getRecptCode());
        if (wmItemRecpt.getRecptName() != null)
            wrapper.like(WmItemRecpt::getRecptName, wmItemRecpt.getRecptName());
        if (wmItemRecpt.getVendorName() != null)
            wrapper.like(WmItemRecpt::getVendorName, wmItemRecpt.getVendorName());
        if (wmItemRecpt.getPoCode() != null)
            wrapper.eq(WmItemRecpt::getPoCode, wmItemRecpt.getPoCode());
        if (wmItemRecpt.getRecptDate() != null)
            wrapper.eq(WmItemRecpt::getRecptDate, wmItemRecpt.getRecptDate());
        return page(pageInfo, wrapper);
    }

    @Override
    public void add(WmItemRecpt wmItemRecpt) {
        LambdaQueryWrapper<WmItemRecpt> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(WmItemRecpt::getRecptCode, wmItemRecpt.getRecptCode());
        int count = count(wrapper);
        if (count > 0)
            throw new RuntimeException("新增失败");
        save(wmItemRecpt);
    }

    @Override
    public void deleteById(Long id) {
        WmItemRecpt wmItemRecpt = getById(id);
        if (wmItemRecpt == null)
            throw new IdExistNotException("查不存在");
        removeById(id);
    }

    @Override
    public WmItemRecpt selectById(Long id) {
        WmItemRecpt wmItemRecpt = getById(id);
        if (wmItemRecpt == null)
            throw new IdExistNotException("查不存在");
        return wmItemRecpt;
    }

    @Override
    public void edit(WmItemRecpt wmItemRecpt) {
        updateById(wmItemRecpt);
    }

    @Override
    @Transactional
    public void pushWarehouse(Long recptId) {
        WmItemRecpt wmItemRecpt = getById(recptId);
        wmItemRecpt.setStatus("在库状态");

        LambdaQueryWrapper<WmItemRecptLine> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(WmItemRecptLine::getRecptId, recptId);
        List<WmItemRecptLine> wmItemRecptLines = wmItemRecptLineService.list();

        for (WmItemRecptLine wmItemRecptLine : wmItemRecptLines) {
            LambdaQueryWrapper<WmMaterialStock> wrapperStock = new LambdaQueryWrapper<>();
            wrapperStock.eq(WmMaterialStock::getItemId, wmItemRecptLine.getItemId());
            wrapperStock.eq(WmMaterialStock::getAreaId, wmItemRecptLine.getAreaId());
            WmMaterialStock stock = wmMaterialStockService.getOne(wrapperStock);
            BigDecimal quantityRecived = wmItemRecptLine.getQuantityRecived();

            String itemId = wmItemRecptLine.getItemId();
            LambdaQueryWrapper<MdItem> wrapperItem = new LambdaQueryWrapper<>();
            wrapperItem.eq(MdItem::getItemId, itemId);
            MdItem mdItem = mdItemService.getOne(wrapperItem);

            LambdaQueryWrapper<WmStorageArea> wrapperArea = new LambdaQueryWrapper<>();
            wrapperArea.eq(WmStorageArea::getAreaId, wmItemRecptLine.getAreaId());
            WmStorageArea wmStorageArea = wmStorageAreaService.getOne(wrapperArea);

            // 以前没有该库存，此时应当创建一个库区 areaId 的物料 itemId 的库存
            if (stock == null) {
                WmMaterialStock wmMaterialStock = new WmMaterialStock();
                BeanUtils.copyProperties(wmMaterialStock, wmItemRecptLine);

                if (quantityRecived.max(mdItem.getMaxStock()).equals(quantityRecived)) {
                    throw new RuntimeException("此时已经达到该大库存，不能添加");
                }

                wmMaterialStock.setItemCode(mdItem.getItemCode());
                wmMaterialStock.setItemName(mdItem.getItemName());

                wmMaterialStock.setAreaCode(wmStorageArea.getAreaCode());
                wmMaterialStock.setAreaName(wmStorageArea.getAreaName());

                wmMaterialStock.setQuantityOnhand(wmItemRecptLine.getQuantityRecived());

                wmMaterialStockService.save(wmMaterialStock);
            } // 以前存在该库存，直接在该库存的基础上进行添加库存
            else {
                BigDecimal tryMax = quantityRecived.add(stock.getQuantityOnhand());
                if (tryMax.max(mdItem.getMaxStock()).equals(tryMax)) {
                    throw new RuntimeException("此时已经达到该大库存，不能添加");
                }
                stock.setQuantityOnhand(stock.getQuantityOnhand().add(wmItemRecptLine.getQuantityRecived()));
            }
        }
    }
}