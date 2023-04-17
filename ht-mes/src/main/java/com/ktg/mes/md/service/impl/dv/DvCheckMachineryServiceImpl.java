package com.ktg.mes.md.service.impl.dv;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.dv.DvCheckMachinery;
import com.ktg.mes.md.exception.IdExistNotException;
import com.ktg.mes.md.mapper.dv.DvCheckMachineryMapper;
import com.ktg.mes.md.service.IDvCheckMachineryService;
import org.springframework.stereotype.Service;


/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/11 11:40
 * @description mes
 */
@Service
public class DvCheckMachineryServiceImpl extends ServiceImpl<DvCheckMachineryMapper, DvCheckMachinery> implements IDvCheckMachineryService {

    @Override
    public Page<DvCheckMachinery> selectList(Long planId, int pageNum, int pageSize) {

        Page<DvCheckMachinery> pageInfo = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<DvCheckMachinery> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(DvCheckMachinery::getPlanId, planId);
        return page(pageInfo, wrapper);
    }

    @Override
    public void add(DvCheckMachinery dvCheckMachinery) {
        save(dvCheckMachinery);
    }


    @Override
    public void deleteById(Long id) {
        DvCheckMachinery dvCheckMachinery = getById(id);
        if (dvCheckMachinery == null)
            throw new IdExistNotException("查不存在");
        removeById(id);
    }
}
