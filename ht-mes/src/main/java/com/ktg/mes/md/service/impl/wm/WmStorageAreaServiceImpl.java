package com.ktg.mes.md.service.impl.wm;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.wm.WmStorageArea;
import com.ktg.mes.md.domain.wm.WmStorageLocation;
import com.ktg.mes.md.exception.IdExistNotException;
import com.ktg.mes.md.mapper.wm.WmStorageAreaMapper;
import com.ktg.mes.md.service.IWmStorageAreaService;
import com.ktg.mes.md.service.IWmStorageLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/10 16:40
 * @description mes
 */
@Service
public class WmStorageAreaServiceImpl extends ServiceImpl<WmStorageAreaMapper, WmStorageArea> implements IWmStorageAreaService {

    @Autowired
    private IWmStorageLocationService wmStorageLocationService;

    @Override
    public Page<WmStorageArea> selectList(WmStorageArea wmStorageArea, int pageNum, int pageSize) {

        Page<WmStorageArea> wmStorageLocationPage = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<WmStorageArea> wrapper = new LambdaQueryWrapper<>();
        if (wmStorageArea.getLocationId() == null)
            throw new RuntimeException("库位id不能为空");

        wrapper.eq(WmStorageArea::getLocationId, wmStorageArea.getLocationId());
        if (wmStorageArea.getAreaCode() != null)
            wrapper.eq(WmStorageArea::getAreaCode, wmStorageArea.getAreaCode());
        if (wmStorageArea.getAreaName() != null)
            wrapper.like(WmStorageArea::getAreaName, wmStorageArea.getAreaName());
        return page(wmStorageLocationPage, wrapper);
    }

    @Override
    public void add(WmStorageArea wmStorageArea) {
        LambdaQueryWrapper<WmStorageArea> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(WmStorageArea::getAreaCode, wmStorageArea.getAreaCode());
        int count = count(wrapper);
        if (count > 0)
            throw new RuntimeException("新增失败");

        WmStorageLocation wmStorageLocation = wmStorageLocationService.getById(Long.valueOf(wmStorageArea.getLocationId()));
        LambdaQueryWrapper<WmStorageArea> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(WmStorageArea::getLocationId, wmStorageArea.getLocationId());
        List<WmStorageArea> wmStorageAreas = list(queryWrapper);

        BigDecimal total = new BigDecimal(0);
        for (WmStorageArea storageArea : wmStorageAreas) {
            total = total.add(storageArea.getArea());
        }

        BigDecimal now = wmStorageArea.getArea().add(total);
        if (now.max(wmStorageLocation.getArea()).equals(now))
            throw new RuntimeException("库位总面积不能大于库区面积");
        save(wmStorageArea);
    }

    @Override
    public void deleteById(Long id) {
        WmStorageArea wmStorageArea = getById(id);
        if (wmStorageArea == null)
            throw new IdExistNotException("wmStorageArea不存在");
        removeById(id);
    }

    @Override
    public WmStorageArea selectById(Long id) {
        WmStorageArea wmStorageArea = getById(id);
        if (wmStorageArea == null)
            throw new IdExistNotException("wmStorageArea不存在");
        return wmStorageArea;
    }

    @Override
    public void edit(WmStorageArea wmStorageArea) {
        updateById(wmStorageArea);
    }

}
