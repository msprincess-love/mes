package com.ktg.mes.md.service.impl.pro;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.pro.ProProcess;
import com.ktg.mes.md.domain.pro.ProWorkorder;
import com.ktg.mes.md.exception.IdExistNotException;
import com.ktg.mes.md.mapper.pro.ProWorkorderMapper;
import com.ktg.mes.md.service.IProWorkorderService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/9 19:52
 * @description mes
 */
@Service
public class ProWorkorderServiceImpl extends ServiceImpl<ProWorkorderMapper, ProWorkorder> implements IProWorkorderService {

    @Override
    public List<ProWorkorder> selectList(ProWorkorder proWorkorder) {
        LambdaQueryWrapper<ProWorkorder> wrapper = new LambdaQueryWrapper<>();
        if (proWorkorder.getWorkorderCode() != null)
            wrapper.eq(ProWorkorder::getWorkorderCode, proWorkorder.getWorkorderCode());
        if (proWorkorder.getWorkorderName() != null)
            wrapper.like(ProWorkorder::getWorkorderName, proWorkorder.getWorkorderName());
        if (proWorkorder.getSourceCode() != null)
            wrapper.like(ProWorkorder::getSourceCode, proWorkorder.getSourceCode());
        if (proWorkorder.getProductCode() != null)
            wrapper.eq(ProWorkorder::getProductCode, proWorkorder.getProductCode());
        if (proWorkorder.getProductName() != null)
            wrapper.like(ProWorkorder::getProductName, proWorkorder.getProductName());
        if (proWorkorder.getClientCode() != null)
            wrapper.eq(ProWorkorder::getClientCode, proWorkorder.getClientCode());
        if (proWorkorder.getClientName() != null)
            wrapper.like(ProWorkorder::getClientName, proWorkorder.getClientName());
        if (proWorkorder.getRequestDate() != null)
            wrapper.eq(ProWorkorder::getRequestDate, proWorkorder.getRequestDate());
        return list(wrapper);
    }

    @Override
    public ProWorkorder selectById(Long id) {
        ProWorkorder proWorkorder = getById(id);
        if (proWorkorder == null)
            throw new IdExistNotException("查不存在");
        return proWorkorder;
    }

    @Override
    public void deleteById(Long id) {
        ProWorkorder proWorkorder = getById(id);
        if (proWorkorder == null)
            throw new IdExistNotException("查不存在");
        removeById(id);
    }

    @Override
    public void edit(ProWorkorder proWorkorder) {
        updateById(proWorkorder);
    }

    @Override
    public void add(ProWorkorder proWorkorder) {
        LambdaQueryWrapper<ProWorkorder> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ProWorkorder::getWorkorderCode, proWorkorder.getWorkorderCode());
        int count = count(wrapper);
        if (count > 0)
            throw new RuntimeException("新增失败，已存在");
        save(proWorkorder);
    }
}
