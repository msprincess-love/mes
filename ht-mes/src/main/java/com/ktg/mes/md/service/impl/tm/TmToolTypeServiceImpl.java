package com.ktg.mes.md.service.impl.tm;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.tm.TmToolType;
import com.ktg.mes.md.exception.IdExistNotException;
import com.ktg.mes.md.mapper.tm.TmToolTypeMapper;
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
public class TmToolTypeServiceImpl extends ServiceImpl<TmToolTypeMapper, TmToolType> implements ITmToolTypeService {


    @Override
    public Page<TmToolType> selectList(TmToolType tmToolType, int pageNum, int pageSize) {
        Page<TmToolType> pageInfo = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<TmToolType> wrapper = new LambdaQueryWrapper<>();
        if (tmToolType.getToolTypeCode() != null)
            wrapper.eq(TmToolType::getToolTypeCode, tmToolType.getToolTypeCode());
        if (tmToolType.getToolTypeName() != null)
            wrapper.like(TmToolType::getToolTypeName, tmToolType.getToolTypeName());
        if (tmToolType.getMaintenType() != null)
            wrapper.like(TmToolType::getMaintenType, tmToolType.getMaintenType());
        return page(pageInfo, wrapper);
    }

    @Override
    public void add(TmToolType tmToolType) {
        LambdaQueryWrapper<TmToolType> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TmToolType::getToolTypeCode, tmToolType.getToolTypeCode());
        int count = count(wrapper);
        if (count > 0)
            throw new RuntimeException("新增失败");
        save(tmToolType);
    }

    @Override
    public void deleteById(Long id) {
        TmToolType tmToolType = getById(id);
        if (tmToolType == null)
            throw new IdExistNotException("查不存在");
        removeById(id);
    }

    @Override
    public TmToolType selectById(Long id) {
        TmToolType tmToolType = getById(id);
        if (tmToolType == null)
            throw new IdExistNotException("查不存在");
        return tmToolType;
    }

    @Override
    public void edit(TmToolType tmToolType) {
        updateById(tmToolType);
    }

    @Override
    public List<TmToolType> listAll() {
        List<TmToolType> list = list();
        if (list.size() > 0)
            return list;
        throw new RuntimeException("暂没有工装类型");
    }
}
