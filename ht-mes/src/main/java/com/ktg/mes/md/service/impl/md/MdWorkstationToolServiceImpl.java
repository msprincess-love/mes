package com.ktg.mes.md.service.impl.md;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.md.MdWorkstationMachine;
import com.ktg.mes.md.domain.md.MdWorkstationTool;
import com.ktg.mes.md.mapper.md.MdWorkstationToolMapper;
import com.ktg.mes.md.service.IMdWorkstationToolService;
import org.springframework.stereotype.Service;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/15 13:36
 * @description mes
 */
@Service
public class MdWorkstationToolServiceImpl extends ServiceImpl<MdWorkstationToolMapper, MdWorkstationTool> implements IMdWorkstationToolService {
    @Override
    public Page<MdWorkstationTool> listPage(int pageNUm, int pageSize, Long workstationId) {
        Page<MdWorkstationTool> pageInfo = new Page<>(pageNUm, pageSize);
        LambdaQueryWrapper<MdWorkstationTool> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(MdWorkstationTool::getWorkstationId, workstationId);
        return page(pageInfo, wrapper);
    }

    @Override
    public void add(MdWorkstationTool mdWorkstationTool) {
        save(mdWorkstationTool);
    }

    @Override
    public void deleteById(Long id) {
        removeById(id);
    }
}
