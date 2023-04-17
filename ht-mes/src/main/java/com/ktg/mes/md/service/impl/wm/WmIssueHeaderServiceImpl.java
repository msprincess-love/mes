package com.ktg.mes.md.service.impl.wm;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.wm.WmItemRecpt;
import com.ktg.mes.md.exception.IdExistNotException;
import com.ktg.mes.md.mapper.wm.WmIssueHeaderMapper;
import com.ktg.mes.md.mapper.wm.WmItemRecptMapper;
import com.ktg.mes.md.service.IWmIssueHeaderService;
import com.ktg.mes.md.service.IWmItemRecptService;
import org.springframework.stereotype.Service;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/14 9:13
 * @description mes
 */
@Service
public class WmIssueHeaderServiceImpl extends ServiceImpl<WmIssueHeaderMapper, WmIssueHeader> implements IWmIssueHeaderService {

    @Override
    public Page<WmIssueHeader> selectList(WmIssueHeader wmIssueHeader, int pageNum, int pageSize) {
        Page<WmIssueHeader> pageInfo = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<WmIssueHeader> wrapper = new LambdaQueryWrapper<>();
        if (wmIssueHeader.getIssueCode() != null)
            wrapper.eq(WmIssueHeader::getIssueCode, wmIssueHeader.getIssueCode());
        if (wmIssueHeader.getIssueName() != null)
            wrapper.like(WmIssueHeader::getIssueName, wmIssueHeader.getIssueName());
        if (wmIssueHeader.getWarehouseName() != null)
            wrapper.like(WmIssueHeader::getWarehouseName, wmIssueHeader.getWarehouseName());
        if (wmIssueHeader.getIssueDate() != null)
            wrapper.eq(WmIssueHeader::getIssueDate, wmIssueHeader.getIssueDate());
        if (wmIssueHeader.getStatus() != null)
            wrapper.eq(WmIssueHeader::getStatus, wmIssueHeader.getStatus());
        return page(pageInfo, wrapper);
    }

    @Override
    public void add(WmIssueHeader wmIssueHeader) {
        LambdaQueryWrapper<WmIssueHeader> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(WmIssueHeader::getIssueCode, wmIssueHeader.getIssueCode());
        int count = count(wrapper);
        if (count > 0)
            throw new RuntimeException("新增失败");
        save(wmIssueHeader);
    }

    @Override
    public void deleteById(Long id) {
        WmIssueHeader wmIssueHeader = getById(id);
        if (wmIssueHeader == null)
            throw new IdExistNotException("查不存在");
        removeById(id);
    }

    @Override
    public WmIssueHeader selectById(Long id) {
        WmIssueHeader wmIssueHeader = getById(id);
        if (wmIssueHeader == null)
            throw new IdExistNotException("查不存在");
        return wmIssueHeader;
    }

    @Override
    public void edit(WmIssueHeader wmIssueHeader) {
        updateById(wmIssueHeader);
    }

}
