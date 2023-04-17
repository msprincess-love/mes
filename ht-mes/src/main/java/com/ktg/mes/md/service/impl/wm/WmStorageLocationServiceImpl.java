package com.ktg.mes.md.service.impl.wm;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.wm.WmStorageLocation;
import com.ktg.mes.md.domain.wm.WmWarehouse;
import com.ktg.mes.md.exception.IdExistNotException;
import com.ktg.mes.md.mapper.wm.WmStorageLocationMapper;
import com.ktg.mes.md.service.IWmStorageLocationService;
import com.ktg.mes.md.service.IWmWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/10 10:39
 * @description mes
 */
@Service
public class WmStorageLocationServiceImpl extends ServiceImpl<WmStorageLocationMapper, WmStorageLocation> implements IWmStorageLocationService {

    @Autowired
    private IWmWarehouseService wmWarehouseService;

    @Override
    public Page<WmStorageLocation> selectList(WmStorageLocation wmStorageLocation, int pageNum, int pageSize) {
        Page<WmStorageLocation> wmStorageLocationPage = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<WmStorageLocation> wrapper = new LambdaQueryWrapper<>();
        if (wmStorageLocation.getWarehouseId() == null)
            throw new RuntimeException("仓库id不能为空");
        wrapper.eq(WmStorageLocation::getWarehouseId, wmStorageLocation.getWarehouseId());
        if (wmStorageLocation.getLocationName() != null)
            wrapper.like(WmStorageLocation::getLocationName, wmStorageLocation.getLocationName());
        return page(wmStorageLocationPage, wrapper);
    }

    @Override
    public void edit(WmStorageLocation wmStorageLocation) {
        updateById(wmStorageLocation);
    }


    @Override
    public WmStorageLocation selectById(Long id) {
        WmStorageLocation wmStorageLocation = getById(id);
        if (wmStorageLocation == null)
            throw new IdExistNotException("wmStorageLocation不存在");
        return wmStorageLocation;
    }


    @Override
    public void deleteById(Long id) {
        WmStorageLocation wmStorageLocation = getById(id);
        if (wmStorageLocation == null)
            throw new IdExistNotException("wmStorageLocation不存在");
        removeById(id);
    }

    @Override
    public void add(WmStorageLocation wmStorageLocation) {
        LambdaQueryWrapper<WmStorageLocation> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(WmStorageLocation::getLocationCode, wmStorageLocation.getLocationCode());
        int count = count(wrapper);
        if (count > 0)
            throw new RuntimeException("新增失败");

        WmWarehouse wmWarehouse = wmWarehouseService.getById(Long.valueOf(wmStorageLocation.getWarehouseId()));
        LambdaQueryWrapper<WmStorageLocation> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(WmStorageLocation::getWarehouseId, wmStorageLocation.getWarehouseId());
        List<WmStorageLocation> wmStorageLocations = list(queryWrapper);

        BigDecimal total = new BigDecimal(0);
        for (WmStorageLocation storageLocation : wmStorageLocations) {
            total = total.add(storageLocation.getArea());
        }

        BigDecimal now = wmStorageLocation.getArea().add(total);
        if (now.max(wmWarehouse.getArea()).equals(now))
            throw new RuntimeException("库区总面积不能大于仓库面积");
        save(wmStorageLocation);
    }
}
