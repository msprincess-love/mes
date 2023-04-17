package com.ktg.mes.md.service.impl.md;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.md.MdWorkshop;
import com.ktg.mes.md.domain.md.MdWorkstation;
import com.ktg.mes.md.domain.wm.WmStorageArea;
import com.ktg.mes.md.domain.wm.WmStorageLocation;
import com.ktg.mes.md.exception.IdExistNotException;
import com.ktg.mes.md.mapper.md.MdWorkstationMapper;
import com.ktg.mes.md.service.IMdWorkstationService;
import com.ktg.mes.md.service.IWmStorageAreaService;
import com.ktg.mes.md.service.IWmStorageLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/9 19:02
 * @description mes
 */
@Service
public class MdWorkstationServiceImpl extends ServiceImpl<MdWorkstationMapper, MdWorkstation> implements IMdWorkstationService {

    @Autowired
    private IWmStorageAreaService wmStorageAreaService;

    @Autowired
    private IWmStorageLocationService wmStorageLocationService;



    @Override
    public Page<MdWorkstation> selectList(MdWorkstation workstation, int pageNum, int pageSize) {
        Page<MdWorkstation> pageInfo = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<MdWorkstation> wrapper = new LambdaQueryWrapper<>();
        if (workstation.getWorkstationCode() != null)
            wrapper.eq(MdWorkstation::getWorkstationCode, workstation.getWorkstationCode());
        if (workstation.getWorkstationName() != null)
            wrapper.like(MdWorkstation::getWorkstationName, workstation.getWorkstationName());
        if (workstation.getWorkshopId() != null)
            wrapper.eq(MdWorkstation::getWorkshopId, workstation.getWorkshopId());
        if (workstation.getProcessId() != null)
            wrapper.eq(MdWorkstation::getProcessId, workstation.getProcessId());
        return page(pageInfo, wrapper);
    }

    @Override
    public void add(MdWorkstation workstation) {
        LambdaQueryWrapper<MdWorkstation> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(MdWorkstation::getWorkstationCode, workstation.getWorkstationCode());
        int count = count(wrapper);
        if (count > 0)
            throw new RuntimeException("新增失败，此工作站已存在");

        WmStorageArea wmStorageArea = wmStorageAreaService.list().get(0);
        LambdaQueryWrapper<WmStorageLocation> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(WmStorageLocation::getLocationId, wmStorageArea.getLocationId());
        WmStorageLocation wmStorageLocation = wmStorageLocationService.getOne(queryWrapper);

        if (workstation.getWarehouseId() == null)
            workstation.setWarehouseId(wmStorageLocation.getWarehouseId());
        if (workstation.getLocationId() == null)
            workstation.setLocationId(wmStorageArea.getLocationId());
        if (workstation.getAreaId() == null)
            workstation.setAreaId(wmStorageArea.getAreaId());
        save(workstation);
    }

    @Override
    public MdWorkstation selectById(Long id) {
        MdWorkstation workshop = getById(id);
        if (workshop == null)
            throw new IdExistNotException("工作站不存在");
        return workshop;
    }

    @Override
    public void deleteById(Long id) {
        MdWorkstation workshop = getById(id);
        if (workshop == null)
            throw new IdExistNotException("工作站不存在");
        removeById(id);
    }

    @Override
    public void edit(MdWorkstation client) {
        updateById(client);
    }

}
