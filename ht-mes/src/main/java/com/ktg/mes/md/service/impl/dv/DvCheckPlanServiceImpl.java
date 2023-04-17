package com.ktg.mes.md.service.impl.dv;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.dv.DvCheckPlan;
import com.ktg.mes.md.exception.IdExistNotException;
import com.ktg.mes.md.mapper.dv.DvCheckPlanMapper;
import com.ktg.mes.md.service.IDvCheckPlanService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/11 11:40
 * @description mes
 */
@Service
public class DvCheckPlanServiceImpl extends ServiceImpl<DvCheckPlanMapper, DvCheckPlan> implements IDvCheckPlanService {

    @Override
    public Page<DvCheckPlan> selectList(DvCheckPlan dvCheckPlan, int pageNum, int pageSize) {

        Page<DvCheckPlan> pageInfo = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<DvCheckPlan> wrapper = new LambdaQueryWrapper<>();
        if (dvCheckPlan.getPlanCode() != null)
            wrapper.eq(DvCheckPlan::getPlanCode, dvCheckPlan.getPlanCode());
        if (dvCheckPlan.getPlanName() != null)
            wrapper.like(DvCheckPlan::getPlanName, dvCheckPlan.getPlanName());
        if (dvCheckPlan.getPlanType() != null)
            wrapper.eq(DvCheckPlan::getPlanType, dvCheckPlan.getPlanType());
        if (dvCheckPlan.getStatus() != null)
            wrapper.eq(DvCheckPlan::getStatus, dvCheckPlan.getStatus());
        return page(pageInfo, wrapper);
    }

    @Override
    public void add(DvCheckPlan dvCheckPlan) {
        LambdaQueryWrapper<DvCheckPlan> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(DvCheckPlan::getPlanCode, dvCheckPlan.getPlanCode());
        int count = count(wrapper);
        if (count > 0)
            throw new RuntimeException("新增失败");

        if (dvCheckPlan.getStartDate().isAfter(dvCheckPlan.getEndDate()))
            throw new RuntimeException("结束日期不能早于开始日期");
        save(dvCheckPlan);
    }

    @Override
    public DvCheckPlan selectById(Long id) {
        DvCheckPlan dvCheckPlan = getById(id);
        if (dvCheckPlan == null)
            throw new IdExistNotException("不存在");
        return dvCheckPlan;
    }

    @Override
    public void edit(DvCheckPlan dvCheckPlan) {
        updateById(dvCheckPlan);
    }

    @Override
    public void deleteById(Long id) {
        DvCheckPlan dvCheckPlan = getById(id);
        if (dvCheckPlan == null)
            throw new IdExistNotException("查不存在");
        removeById(id);
    }
}
