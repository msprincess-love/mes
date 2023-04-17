package com.ktg.mes.md.service.impl.wm;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.wm.WmStorageArea;
import com.ktg.mes.md.domain.wm.WmStorageLocation;
import com.ktg.mes.md.domain.wm.WmWarehouse;
import com.ktg.mes.md.exception.IdExistNotException;
import com.ktg.mes.md.mapper.wm.WmWarehouseMapper;
import com.ktg.mes.md.service.IWmStorageAreaService;
import com.ktg.mes.md.service.IWmStorageLocationService;
import com.ktg.mes.md.service.IWmWarehouseService;
import com.ktg.mes.md.vo.WmStorageAreaVo;
import com.ktg.mes.md.vo.WmStorageLocationVo;
import com.ktg.mes.md.vo.WmWarehouseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/9 21:09
 * @description mes
 */
@Service
public class WmWarehouseServiceImpl extends ServiceImpl<WmWarehouseMapper, WmWarehouse> implements IWmWarehouseService {

    @Autowired
    private IWmStorageLocationService wmStorageLocationService;

    @Autowired
    private IWmStorageAreaService wmStorageAreaService;

    @Override
    public Page<WmWarehouse> selectList(WmWarehouse warehouse, int pageNum, int pageSize) {
        Page<WmWarehouse> pageInfo = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<WmWarehouse> wrapper = new LambdaQueryWrapper<>();
        if (warehouse.getWarehouseCode() != null)
            wrapper.eq(WmWarehouse::getWarehouseCode, warehouse.getWarehouseCode());
        if (warehouse.getWarehouseName() != null)
            wrapper.like(WmWarehouse::getWarehouseName, warehouse.getWarehouseName());
        return page(pageInfo, wrapper);
    }
    @Override
    public WmWarehouse selectById(Long id) {
        WmWarehouse warehouse = getById(id);
        if (warehouse == null)
            throw new IdExistNotException("warehouse不存在");
        return warehouse;
    }

    @Override
    public void edit(WmWarehouse warehouse) {
        updateById(warehouse);
    }

    @Override
    public void add(WmWarehouse warehouse) {
        LambdaQueryWrapper<WmWarehouse> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(WmWarehouse::getWarehouseCode, warehouse.getWarehouseCode());
        int count = count(wrapper);
        if (count > 0)
            throw new RuntimeException("新增失败");
        save(warehouse);
    }

    @Override
    public void deleteById(Long id) {
        WmWarehouse warehouse = getById(id);
        if (warehouse == null)
            throw new IdExistNotException("warehouse不存在");
        removeById(id);
    }

    @Override
    public void getTreeList() {
        List<WmWarehouse> wmWarehouses = list();
        for (WmWarehouse wmWarehouse : wmWarehouses) {
            List<WmStorageLocation> locations = getWmStorageLocationByWarehouseId(wmWarehouse.getWarehouseId());
            WmWarehouseVo wmWarehouseVo = new WmWarehouseVo();
            BeanUtils.copyProperties(wmWarehouseVo, wmWarehouse);
            ArrayList<WmStorageLocationVo> wmStorageLocationVos = new ArrayList<>();
            for (WmStorageLocation location : locations) {
                List<WmStorageArea> areas = getStorageAreaByLocationId(location.getLocationId());
                WmStorageLocationVo wmStorageLocationVo = new WmStorageLocationVo();
                BeanUtils.copyProperties(wmStorageLocationVo, location);
                List<WmStorageAreaVo> list = new ArrayList<>();
                for (WmStorageArea area : areas) {
                    WmStorageAreaVo wmStorageAreaVo = new WmStorageAreaVo();
                    wmStorageAreaVo.setAreaId(area.getAreaId());
                    wmStorageAreaVo.setAreaName(area.getAreaName());
                    list.add(wmStorageAreaVo);
                }
                wmStorageLocationVo.setWmStorageAreas(list);
                wmStorageLocationVos.add(wmStorageLocationVo);
            }
            wmWarehouseVo.setWmStorageLocations(wmStorageLocationVos);
        }

    }

    public List<WmStorageLocation> getWmStorageLocationByWarehouseId(String warehouseId) {
        LambdaQueryWrapper<WmStorageLocation> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(WmStorageLocation::getWarehouseId, warehouseId);
        return wmStorageLocationService.list(wrapper);
    }

    public List<WmStorageArea> getStorageAreaByLocationId(String locationId) {
        LambdaQueryWrapper<WmStorageArea> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(WmStorageArea::getLocationId, locationId);
        return wmStorageAreaService.list(wrapper);
    }
}
