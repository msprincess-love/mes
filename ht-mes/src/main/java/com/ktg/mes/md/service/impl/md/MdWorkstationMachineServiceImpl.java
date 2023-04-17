package com.ktg.mes.md.service.impl.md;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.md.MdWorkstationMachine;
import com.ktg.mes.md.mapper.md.MdWorkstationMachineMapper;
import com.ktg.mes.md.service.IMdWorkstationMachineService;
import org.springframework.stereotype.Service;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/15 13:36
 * @description mes
 */
@Service
public class MdWorkstationMachineServiceImpl extends ServiceImpl<MdWorkstationMachineMapper, MdWorkstationMachine> implements IMdWorkstationMachineService {

    @Override
    public Page<MdWorkstationMachine> listPage(int pageNUm, int pageSize, Long workstationId) {
        Page<MdWorkstationMachine> pageInfo = new Page<>(pageNUm, pageSize);
        LambdaQueryWrapper<MdWorkstationMachine> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(MdWorkstationMachine::getWorkstationId, workstationId);
        return page(pageInfo, wrapper);
    }

    @Override
    public void add(MdWorkstationMachine mdWorkstationMachine) {
        save(mdWorkstationMachine);
    }

    @Override
    public void deleteById(Long id) {
        removeById(id);
    }
}
