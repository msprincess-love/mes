package com.ktg.mes.md.service.impl.pro;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.pro.ProFeedback;
import com.ktg.mes.md.exception.IdExistNotException;
import com.ktg.mes.md.mapper.pro.ProFeedbackMapper;
import com.ktg.mes.md.service.IProFeedbackService;
import org.springframework.stereotype.Service;

@Service
public class ProFeedbackServiceImpl extends ServiceImpl<ProFeedbackMapper, ProFeedback> implements IProFeedbackService {

    @Override
    public Page<ProFeedback> getList(int pageNum, int pageSize, ProFeedback proFeedback) {
        Page<ProFeedback> pageInfo = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<ProFeedback> wrapper = new LambdaQueryWrapper<>();
        if (proFeedback.getFeedbackType() != null)
            wrapper.eq(ProFeedback::getFeedbackType, proFeedback.getFeedbackType());
        if (proFeedback.getWorkstationName() != null)
            wrapper.like(ProFeedback::getWorkstationName, proFeedback.getWorkorderName());
        if (proFeedback.getWorkorderCode() != null)
            wrapper.eq(ProFeedback::getWorkorderCode, proFeedback.getWorkorderCode());
        if (proFeedback.getItemCode() != null)
            wrapper.eq(ProFeedback::getItemCode, proFeedback.getItemCode());
        if (proFeedback.getItemName() != null)
            wrapper.like(ProFeedback::getItemName, proFeedback.getItemName());
        if (proFeedback.getUserName() != null)
            wrapper.like(ProFeedback::getUserName, proFeedback.getUserName());
        if (proFeedback.getRecordUser() != null)
            wrapper.like(ProFeedback::getRecordUser, proFeedback.getRecordUser());
        if (proFeedback.getStatus() != null)
            wrapper.eq(ProFeedback::getStatus, proFeedback.getStatus());
        return page(pageInfo, wrapper);
    }

    @Override
    public void add(ProFeedback proFeedback) {
        save(proFeedback);
    }

    @Override
    public void deleteById(Long id) {
        ProFeedback proFeedback = getById(id);
        if (proFeedback == null)
            throw new IdExistNotException("查不存在");
        removeById(id);
    }

    @Override
    public ProFeedback selectById(Long id) {
        ProFeedback proFeedback = getById(id);
        if (proFeedback == null)
            throw new IdExistNotException("查不存在");
        return proFeedback;
    }

    @Override
    public void edit(ProFeedback proFeedback) {
        updateById(proFeedback);
    }
}
