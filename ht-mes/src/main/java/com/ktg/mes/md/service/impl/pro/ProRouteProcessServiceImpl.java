package com.ktg.mes.md.service.impl.pro;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.pro.ProProcess;
import com.ktg.mes.md.domain.pro.ProRouteProcess;
import com.ktg.mes.md.exception.IdExistNotException;
import com.ktg.mes.md.mapper.pro.ProRouteProcessMapper;
import com.ktg.mes.md.service.IProProcessService;
import com.ktg.mes.md.service.IProRouteProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/9 19:52
 * @description mes
 */
@Service
public class ProRouteProcessServiceImpl extends ServiceImpl<ProRouteProcessMapper, ProRouteProcess> implements IProRouteProcessService {

    @Autowired
    private IProProcessService proProcessService;


    @Override
    public Page<ProRouteProcess> selectList(ProRouteProcess process, int pageNum, int pageSize) {
        Page<ProRouteProcess> pageInfo = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<ProRouteProcess> wrapper = new LambdaQueryWrapper<>();
        if (process.getRouteId() != null)
            wrapper.eq(ProRouteProcess::getRouteId, process.getRouteId());
        return page(pageInfo, wrapper);
    }

    @Override
    public void add(ProRouteProcess process) {
        LambdaQueryWrapper<ProRouteProcess> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ProRouteProcess::getProcessId, process.getProcessId());
        queryWrapper.eq(ProRouteProcess::getRouteId, process.getRouteId());
        int count = count(queryWrapper);
        if (count > 0)
            throw new RuntimeException("此工序已被添加进工序流程中，请勿重新添加");

        if (process.getNextProcessId() == null) {
            LambdaQueryWrapper<ProProcess> wrapper = new LambdaQueryWrapper<>();
            wrapper.gt(ProProcess::getProcessId, process.getProcessId());
            wrapper.orderByAsc(ProProcess::getProcessId);
            List<ProProcess> proProcesses = proProcessService.list(wrapper);
            if (proProcesses != null && proProcesses.size() > 0) {
                process.setNextProcessId(proProcesses.get(0).getProcessId());
            } else
                process.setNextProcessId("-1");
        }
        save(process);
    }

    @Override
    public ProRouteProcess selectById(Long id) {
        ProRouteProcess process = getById(id);
        if (process == null)
            throw new IdExistNotException("查不存在");
        return process;
    }

    @Override
    public void deleteById(Long id) {
        ProRouteProcess process = getById(id);
        if (process == null)
            throw new IdExistNotException("查不存在");
        removeById(id);
    }

    @Override
    public void edit(ProRouteProcess process) {
        updateById(process);
    }
}
