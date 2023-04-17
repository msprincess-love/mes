package com.ktg.mes.md.service.impl.dv;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.dv.DvMachinery;
import com.ktg.mes.md.domain.md.MdClient;
import com.ktg.mes.md.exception.IdExistNotException;
import com.ktg.mes.md.mapper.dv.DvMachineryMapper;
import com.ktg.mes.md.service.IDvMachineryService;
import org.springframework.stereotype.Service;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/10 21:10
 * @description mes
 */
@Service
public class DvMachineryServiceImpl extends ServiceImpl<DvMachineryMapper, DvMachinery> implements IDvMachineryService {

    @Override
    public Page<DvMachinery> selectClientList(DvMachinery dvMachinery, int pageNum, int pageSize) {

        Page<DvMachinery> pageInfo = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<DvMachinery> wrapper = new LambdaQueryWrapper<>();
        if (dvMachinery.getMachineryCode() != null)
            wrapper.eq(DvMachinery::getMachineryCode, dvMachinery.getMachineryCode());
        if (dvMachinery.getMachineryName() != null)
            wrapper.like(DvMachinery::getMachineryName, dvMachinery.getMachineryName());
        if (dvMachinery.getMachineryTypeId() != null)
            wrapper.eq(DvMachinery::getMachineryTypeId, dvMachinery.getMachineryTypeId());
        return page(pageInfo, wrapper);
    }

    @Override
    public void add(DvMachinery dvMachinery) {
        LambdaQueryWrapper<DvMachinery> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(DvMachinery::getMachineryCode, dvMachinery.getMachineryCode());
        int count = count(wrapper);
        if (count > 0)
            throw new RuntimeException("新增失败");
        save(dvMachinery);
    }

    @Override
    public void deleteById(Long id) {
        DvMachinery dvMachinery = getById(id);
        if (dvMachinery == null)
            throw new IdExistNotException("查不存在");
        removeById(id);
    }

    @Override
    public DvMachinery selectById(Long id) {
        DvMachinery dvMachinery = getById(id);
        if (dvMachinery == null)
            throw new IdExistNotException("查不存在");
        return dvMachinery;
    }

    @Override
    public void edit(DvMachinery dvMachinery) {
        updateById(dvMachinery);
    }
}
