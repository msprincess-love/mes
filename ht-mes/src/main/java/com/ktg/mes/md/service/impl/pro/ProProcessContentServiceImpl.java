package com.ktg.mes.md.service.impl.pro;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.pro.ProProcessContent;
import com.ktg.mes.md.exception.IdExistNotException;
import com.ktg.mes.md.mapper.pro.ProProcessContentMapper;
import com.ktg.mes.md.service.IProProcessContentService;
import org.springframework.stereotype.Service;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/9 19:52
 * @description mes
 */
@Service
public class ProProcessContentServiceImpl extends ServiceImpl<ProProcessContentMapper, ProProcessContent> implements IProProcessContentService {

    @Override
    public Page<ProProcessContent> getList(int pageNum, int pageSize, ProProcessContent proProcessContent) {
        Page<ProProcessContent> pageInfo = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<ProProcessContent> wrapper = new LambdaQueryWrapper<>();
        if (proProcessContent.getProcessId() != null)
            wrapper.eq(ProProcessContent::getProcessId, proProcessContent.getProcessId());
        return page(pageInfo, wrapper);
    }

    @Override
    public void add(ProProcessContent process) {
        save(process);
    }

    @Override
    public void deleteById(Long id) {
        ProProcessContent process = getById(id);
        if (process == null)
            throw new IdExistNotException("查不存在");
        removeById(id);
    }

    @Override
    public void edit(ProProcessContent process) {
        updateById(process);
    }

    @Override
    public ProProcessContent selectById(Long id) {
        ProProcessContent process = getById(id);
        if (process == null)
            throw new IdExistNotException("查不存在");
        return process;
    }
}
