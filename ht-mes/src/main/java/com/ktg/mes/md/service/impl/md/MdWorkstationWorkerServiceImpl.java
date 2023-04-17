package com.ktg.mes.md.service.impl.md;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.md.MdWorkstationMachine;
import com.ktg.mes.md.domain.md.MdWorkstationWorker;
import com.ktg.mes.md.mapper.md.MdWorkstationWorkerMapper;
import com.ktg.mes.md.service.IMdWorkstationWorkerService;
import org.springframework.stereotype.Service;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/15 13:36
 * @description mes
 */
@Service
public class MdWorkstationWorkerServiceImpl extends ServiceImpl<MdWorkstationWorkerMapper, MdWorkstationWorker> implements IMdWorkstationWorkerService {
    @Override
    public Page<MdWorkstationWorker> listPage(int pageNUm, int pageSize, Long workstationId) {
        Page<MdWorkstationWorker> pageInfo = new Page<>(pageNUm, pageSize);
        LambdaQueryWrapper<MdWorkstationWorker> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(MdWorkstationWorker::getWorkstationId, workstationId);
        return page(pageInfo, wrapper);
    }

    @Override
    public void add(MdWorkstationWorker workstationWorker) {
        save(workstationWorker);
    }

    @Override
    public void deleteById(Long id) {
        removeById(id);
    }
}
