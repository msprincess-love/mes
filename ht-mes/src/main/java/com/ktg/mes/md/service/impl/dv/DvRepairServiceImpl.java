package com.ktg.mes.md.service.impl.dv;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.dv.DvCheckMachinery;
import com.ktg.mes.md.domain.dv.DvCheckPlan;
import com.ktg.mes.md.domain.dv.DvRepair;
import com.ktg.mes.md.exception.IdExistNotException;
import com.ktg.mes.md.mapper.dv.DvCheckMachineryMapper;
import com.ktg.mes.md.mapper.dv.DvRepairMapper;
import com.ktg.mes.md.service.IDvCheckMachineryService;
import com.ktg.mes.md.service.IDvRepairService;
import org.springframework.stereotype.Service;


/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/11 11:40
 * @description mes
 */
@Service
public class DvRepairServiceImpl extends ServiceImpl<DvRepairMapper, DvRepair> implements IDvRepairService {


    @Override
    public Page<DvRepair> selectList(DvRepair dvRepair, int pageNum, int pageSize) {
        Page<DvRepair> pageInfo = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<DvRepair> wrapper = new LambdaQueryWrapper<>();
        if (dvRepair.getRepairCode() != null)
            wrapper.eq(DvRepair::getRepairCode, dvRepair.getRepairCode());
        if (dvRepair.getRepairName() != null)
            wrapper.like(DvRepair::getRepairName, dvRepair.getRepairName());
        if (dvRepair.getMachineryCode() != null)
            wrapper.eq(DvRepair::getMachineryCode, dvRepair.getMachineryCode());
        if (dvRepair.getMachineryName() != null)
            wrapper.like(DvRepair::getMachineryName, dvRepair.getMachineryName());
        if (dvRepair.getRepairResult() != null)
            wrapper.eq(DvRepair::getRepairResult, dvRepair.getRepairResult());
        if (dvRepair.getStatus() != null)
            wrapper.eq(DvRepair::getStatus, dvRepair.getStatus());
        return page(pageInfo, wrapper);
    }

    @Override
    public void add(DvRepair dvRepair) {

        LambdaQueryWrapper<DvRepair> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(DvRepair::getRepairCode, dvRepair.getRepairCode());
        int count = count(wrapper);
        if (count > 0)
            throw new RuntimeException("新增失败");

        if (dvRepair.getRequireDate() != null && dvRepair.getFinishDate() != null) {
            if (dvRepair.getRequireDate().isAfter(dvRepair.getFinishDate()))
                throw new RuntimeException("完成日期不能早于保修日期");
        }
        if (dvRepair.getFinishDate() != null && dvRepair.getConfirmDate() != null) {
            if (dvRepair.getFinishDate().isAfter(dvRepair.getConfirmDate()))
                throw new RuntimeException("当前还未报修完成，请勿确定保修");
        }
        save(dvRepair);
    }

    @Override
    public DvRepair selectById(Long id) {
        DvRepair dv = getById(id);
        if (dv == null)
            throw new IdExistNotException("查不存在");
        return dv;
    }

    @Override
    public void edit(DvRepair dvRepair) {
        updateById(dvRepair);
    }

    @Override
    public void deleteById(Long id) {
        DvRepair dvRepair = getById(id);
        if (dvRepair == null)
            throw new IdExistNotException("查不存在");
        removeById(id);
    }
}
