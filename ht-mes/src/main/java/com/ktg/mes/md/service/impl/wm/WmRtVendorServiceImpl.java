package com.ktg.mes.md.service.impl.wm;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.md.MdItem;
import com.ktg.mes.md.domain.wm.*;
import com.ktg.mes.md.exception.IdExistNotException;
import com.ktg.mes.md.mapper.wm.WmRtVendorMapper;
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
 * @date 2023/4/14 9:44
 * @description mes
 */
@Service
public class WmRtVendorServiceImpl extends ServiceImpl<WmRtVendorMapper, WmRtVendor> implements IWmRtVendorService {

    @Autowired
    private IWmRtVendorLineService wmRtVendorLineService;

    @Autowired
    private IWmMaterialStockService wmMaterialStockService;

    @Autowired
    private IMdItemService mdItemService;

    @Autowired
    private IWmStorageAreaService wmStorageAreaService;

    @Override
    public Page<WmRtVendor> selectList(WmRtVendor wmRtVendor, int pageNum, int pageSize) {

        Page<WmRtVendor> wmStorageLocationPage = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<WmRtVendor> wrapper = new LambdaQueryWrapper<>();
        if (wmRtVendor.getRtCode() != null)
            wrapper.eq(WmRtVendor::getRtCode, wmRtVendor.getRtCode());
        if (wmRtVendor.getRtName() != null)
            wrapper.like(WmRtVendor::getRtName, wmRtVendor.getRtName());
        if (wmRtVendor.getPoCode() != null)
            wrapper.eq(WmRtVendor::getPoCode, wmRtVendor.getPoCode());
        if (wmRtVendor.getVendorName() != null)
            wrapper.like(WmRtVendor::getVendorName, wmRtVendor.getVendorName());
        return page(wmStorageLocationPage, wrapper);
    }

    @Override
    public void add(WmRtVendor wmRtVendor) {
        LambdaQueryWrapper<WmRtVendor> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(WmRtVendor::getRtCode, wmRtVendor.getRtCode());
        int count = count(wrapper);
        if (count > 0)
            throw new RuntimeException("新增失败");
        save(wmRtVendor);
    }

    @Override
    public void deleteById(Long id) {
        WmRtVendor wmRtVendor = getById(id);
        if (wmRtVendor == null)
            throw new IdExistNotException("查不存在");
        removeById(id);
    }

    @Override
    public WmRtVendor selectById(Long id) {
        WmRtVendor wmRtVendor = getById(id);
        if (wmRtVendor == null)
            throw new IdExistNotException("查不存在");
        return wmRtVendor;
    }

    @Override
    public void edit(WmRtVendor wmRtVendor) {
        updateById(wmRtVendor);
    }

    @Override
    @Transactional
    public void outItem(Long id) {
        WmRtVendor wmRtVendor = getById(id);
        wmRtVendor.setStatus("退货状态");

        LambdaQueryWrapper<WmRtVendorLine> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(WmRtVendorLine::getRtId, id);
        List<WmRtVendorLine> wmRtVendorLines = wmRtVendorLineService.list();
        for (WmRtVendorLine wmRtVendorLine : wmRtVendorLines) {
            LambdaQueryWrapper<WmMaterialStock> wrapperStock = new LambdaQueryWrapper<>();
            wrapperStock.eq(WmMaterialStock::getItemId, wmRtVendorLine.getItemId());
            wrapperStock.eq(WmMaterialStock::getAreaId, wmRtVendorLine.getAreaId());
            WmMaterialStock stock = wmMaterialStockService.getOne(wrapperStock);
            BigDecimal quantityRted = wmRtVendorLine.getQuantityRted();

            String itemId = wmRtVendorLine.getItemId();
            LambdaQueryWrapper<MdItem> wrapperItem = new LambdaQueryWrapper<>();
            wrapperItem.eq(MdItem::getItemId, itemId);
            MdItem mdItem = mdItemService.getOne(wrapperItem);

            LambdaQueryWrapper<WmStorageArea> wrapperArea = new LambdaQueryWrapper<>();
            wrapperArea.eq(WmStorageArea::getAreaId, wmRtVendorLine.getAreaId());
            WmStorageArea wmStorageArea = wmStorageAreaService.getOne(wrapperArea);

            // 以前没有该库存，此时应当创建一个库区 areaId 的物料 itemId 的库存
            if (stock == null) {
                throw new RuntimeException("此库位并不存在商品的信息");
            }
            BigDecimal tryMin = quantityRted.add(mdItem.getMinStock());
            if (tryMin.max(stock.getQuantityOnhand()).equals(tryMin)) {
                throw new RuntimeException("已超出最小库存，不能继续");
            }
            stock.setQuantityOnhand(stock.getQuantityOnhand().subtract(wmRtVendorLine.getQuantityRted()));
        }
    }
}
