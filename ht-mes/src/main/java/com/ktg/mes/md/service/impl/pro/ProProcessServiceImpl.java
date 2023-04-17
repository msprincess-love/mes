package com.ktg.mes.md.service.impl.pro;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.pro.ProProcess;
import com.ktg.mes.md.exception.IdExistNotException;
import com.ktg.mes.md.mapper.pro.ProProcessMapper;
import com.ktg.mes.md.service.IProProcessService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/9 19:52
 * @description mes
 */
@Service
public class ProProcessServiceImpl extends ServiceImpl<ProProcessMapper, ProProcess> implements IProProcessService {

    @Override
    public Page<ProProcess> selectList(String processCode, String processName, String enableFlag, int pageNum, int pageSize) {
        Page<ProProcess> pageInfo = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<ProProcess> wrapper = new LambdaQueryWrapper<>();
        if (processCode != null)
            wrapper.eq(ProProcess::getProcessCode, processName);
        if (processName != null)
            wrapper.like(ProProcess::getProcessName, processName);
        if (enableFlag != null)
            wrapper.eq(ProProcess::getEnableFlag, enableFlag);
        return page(pageInfo, wrapper);
    }

    @Override
    public void add(ProProcess process) {
        LambdaQueryWrapper<ProProcess> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ProProcess::getProcessCode, process.getProcessCode());
        int count = count(wrapper);
        if (count > 0)
            throw new RuntimeException("新增失败，此工序已存在");
        save(process);
    }

    @Override
    public ProProcess selectById(Long id) {
        ProProcess process = getById(id);
        if (process == null)
            throw new IdExistNotException("工序不存在");
        return process;
    }

    @Override
    public void deleteById(Long id) {
        ProProcess process = getById(id);
        if (process == null)
            throw new IdExistNotException("工序不存在");
        removeById(id);
    }

    @Override
    public void edit(ProProcess process) {
        updateById(process);
    }

    @Override
    public List<ProProcess> listAll() {
        List<ProProcess> list = list();
        if (list.size() > 0)
            return list;
        throw new RuntimeException("暂没有工序流程");
    }


}
