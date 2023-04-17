package com.ktg.mes.md.service.impl.pro;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.pro.ProProcess;
import com.ktg.mes.md.domain.pro.ProRouteProcess;
import com.ktg.mes.md.domain.pro.ProRouteProduct;
import com.ktg.mes.md.exception.IdExistNotException;
import com.ktg.mes.md.mapper.pro.ProProcessMapper;
import com.ktg.mes.md.mapper.pro.ProRouteProductMapper;
import com.ktg.mes.md.service.IProProcessService;
import com.ktg.mes.md.service.IProRouteProductService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/9 19:52
 * @description mes
 */
@Service
public class ProRouteProductServiceImpl extends ServiceImpl<ProRouteProductMapper, ProRouteProduct> implements IProRouteProductService {


    @Override
    public Page<ProRouteProduct> selectList(ProRouteProduct proRouteProduct, int pageNum, int pageSize) {
        Page<ProRouteProduct> pageInfo = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<ProRouteProduct> wrapper = new LambdaQueryWrapper<>();
        if (proRouteProduct.getRouteId() != null)
            wrapper.eq(ProRouteProduct::getRouteId, proRouteProduct.getRouteId());
        return page(pageInfo, wrapper);
    }

    @Override
    public void add(ProRouteProduct process) {
        save(process);
    }

    @Override
    public ProRouteProduct selectById(Long id) {
        ProRouteProduct process = getById(id);
        if (process == null)
            throw new IdExistNotException("查不存在");
        return process;
    }

    @Override
    public void deleteById(Long id) {
        ProRouteProduct process = getById(id);
        if (process == null)
            throw new IdExistNotException("查不存在");
        removeById(id);
    }

    @Override
    public void edit(ProRouteProduct process) {
        updateById(process);
    }
}
