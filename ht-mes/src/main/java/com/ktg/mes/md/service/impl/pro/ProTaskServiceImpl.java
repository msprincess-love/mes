package com.ktg.mes.md.service.impl.pro;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.pro.ProProcess;
import com.ktg.mes.md.domain.pro.ProTask;
import com.ktg.mes.md.exception.IdExistNotException;
import com.ktg.mes.md.mapper.pro.ProProcessMapper;
import com.ktg.mes.md.mapper.pro.ProTaskMapper;
import com.ktg.mes.md.service.IProProcessService;
import com.ktg.mes.md.service.IProTaskService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/9 19:52
 * @description mes
 */
@Service
public class ProTaskServiceImpl extends ServiceImpl<ProTaskMapper, ProTask> implements IProTaskService {

    @Override
    public Page<ProTask> selectList(ProTask proTask, int pageNum, int pageSize) {
        Page<ProTask> pageInfo = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<ProTask> wrapper = new LambdaQueryWrapper<>();
        if (proTask.getProcessId() != null)
            wrapper.eq(ProTask::getProcessId, proTask.getProcessId());
        if (proTask.getWorkstationId() != null)
            wrapper.eq(ProTask::getWorkstationId, proTask.getWorkstationId());
        if (proTask.getTaskCode() != null)
            wrapper.eq(ProTask::getTaskCode, proTask.getTaskCode());
        return page(pageInfo, wrapper);
    }
}
