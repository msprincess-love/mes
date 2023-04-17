package com.ktg.mes.md.service.impl.pro;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.pro.ProProcess;
import com.ktg.mes.md.domain.pro.ProRoute;
import com.ktg.mes.md.exception.IdExistNotException;
import com.ktg.mes.md.mapper.pro.ProProcessMapper;
import com.ktg.mes.md.mapper.pro.ProRouteMapper;
import com.ktg.mes.md.service.IProProcessService;
import com.ktg.mes.md.service.IProRouteService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/9 19:52
 * @description mes
 */
@Service
public class ProRouteServiceImpl extends ServiceImpl<ProRouteMapper, ProRoute> implements IProRouteService {

    @Override
    public Page<ProRoute> selectList(ProRoute proRoute, int pageNum, int pageSize) {
        Page<ProRoute> pageInfo = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<ProRoute> wrapper = new LambdaQueryWrapper<>();
        if (proRoute.getRouteCode() != null)
            wrapper.eq(ProRoute::getRouteCode, proRoute.getRouteCode());
        if (proRoute.getRouteName() != null)
            wrapper.like(ProRoute::getRouteName, proRoute.getRouteName());
        if (proRoute.getEnableFlag() != null)
            wrapper.eq(ProRoute::getEnableFlag, proRoute.getEnableFlag());
        return page(pageInfo, wrapper);
    }

    @Override
    public void add(ProRoute proRoute) {
        LambdaQueryWrapper<ProRoute> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ProRoute::getRouteCode, proRoute.getRouteCode());
        int count = count(wrapper);
        if (count > 0)
            throw new RuntimeException("新增失败，已存在");
        save(proRoute);
    }

    @Override
    public ProRoute selectById(Long id) {
        ProRoute proRoute = getById(id);
        if (proRoute == null)
            throw new IdExistNotException("不存在");
        return proRoute;
    }

    @Override
    public void deleteById(Long id) {
        ProRoute proRoute = getById(id);
        if (proRoute == null)
            throw new IdExistNotException("不存在");
        removeById(id);
    }

    @Override
    public void edit(ProRoute proRoute) {
        updateById(proRoute);
    }

}
