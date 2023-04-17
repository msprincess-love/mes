package com.ktg.mes.md.service.impl.tm;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.pro.ProProcess;
import com.ktg.mes.md.domain.tm.TmTool;
import com.ktg.mes.md.domain.tm.TmToolType;
import com.ktg.mes.md.exception.IdExistNotException;
import com.ktg.mes.md.mapper.tm.TmToolMapper;
import com.ktg.mes.md.mapper.tm.TmToolTypeMapper;
import com.ktg.mes.md.service.ITmToolService;
import com.ktg.mes.md.service.ITmToolTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/11 15:36
 * @description mes
 */
@Service
public class TmToolServiceImpl extends ServiceImpl<TmToolMapper, TmTool> implements ITmToolService {


    @Override
    public Page<TmTool> selectList(TmTool tmTool, int pageNum, int pageSize) {
        Page<TmTool> pageInfo = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<TmTool> wrapper = new LambdaQueryWrapper<>();
        if (tmTool.getToolCode() != null)
            wrapper.eq(TmTool::getToolCode, tmTool.getToolCode());
        if (tmTool.getToolName() != null)
            wrapper.like(TmTool::getToolName, tmTool.getToolName());
        if (tmTool.getToolTypeId() != null)
            wrapper.eq(TmTool::getToolTypeId, tmTool.getToolTypeId());
        if (tmTool.getBrand() != null)
            wrapper.like(TmTool::getBrand, tmTool.getBrand());
        if (tmTool.getSpec() != null)
            wrapper.like(TmTool::getSpec, tmTool.getSpec());
        if (tmTool.getStatus() != null)
            wrapper.eq(TmTool::getStatus, tmTool.getStatus());
        return page(pageInfo, wrapper);
    }

    @Override
    public void add(TmTool tmTool) {
        LambdaQueryWrapper<TmTool> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TmTool::getToolCode, tmTool.getToolCode());
        int count = count(wrapper);
        if (count > 0)
            throw new RuntimeException("新增失败");
        save(tmTool);
    }

    @Override
    public void deleteById(Long id) {
        TmTool tmTool = getById(id);
        if (tmTool == null)
            throw new IdExistNotException("查不存在");
        removeById(id);
    }

    @Override
    public TmTool selectById(Long id) {
        TmTool tmTool = getById(id);
        if (tmTool == null)
            throw new IdExistNotException("查不存在");
        return tmTool;
    }

    @Override
    public void edit(TmTool tmTool) {
        updateById(tmTool);
    }

    @Override
    public List<TmTool> listAll() {
        List<TmTool> list = list();
        if (list.size() > 0)
            return list;
        throw new RuntimeException("无数据");
    }

}
