package com.ktg.mes.md.service.impl.wm;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.wm.WmRtIssue;
import com.ktg.mes.md.domain.wm.WmRtVendor;
import com.ktg.mes.md.exception.IdExistNotException;
import com.ktg.mes.md.mapper.wm.WmRtIssueMapper;
import com.ktg.mes.md.service.IWmRtIssueService;
import org.springframework.stereotype.Service;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/14 10:30
 * @description mes
 */
@Service
public class WmRtIssueServiceImpl extends ServiceImpl<WmRtIssueMapper, WmRtIssue> implements IWmRtIssueService {

    @Override
    public Page<WmRtIssue> selectList(WmRtIssue wmRtIssue, int pageNum, int pageSize) {
        Page<WmRtIssue> wmStorageLocationPage = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<WmRtIssue> wrapper = new LambdaQueryWrapper<>();
        if (wmRtIssue.getRtCode() != null)
            wrapper.eq(WmRtIssue::getRtCode, wmRtIssue.getRtCode());
        if (wmRtIssue.getWorkorderCode() != null)
            wrapper.eq(WmRtIssue::getWorkorderCode, wmRtIssue.getWorkorderCode());
        if (wmRtIssue.getWarehouseName() != null)
            wrapper.like(WmRtIssue::getWarehouseName, wmRtIssue.getWarehouseName());
        return page(wmStorageLocationPage, wrapper);
    }

    @Override
    public void add(WmRtIssue wmRtIssue) {
        LambdaQueryWrapper<WmRtIssue> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(WmRtIssue::getRtCode, wmRtIssue.getRtCode());
        int count = count(wrapper);
        if (count > 0)
            throw new RuntimeException("新增失败");
        save(wmRtIssue);
    }

    @Override
    public void deleteById(Long id) {
        WmRtIssue wmRtIssue = getById(id);
        if (wmRtIssue == null)
            throw new IdExistNotException("查不存在");
        removeById(id);
    }

    @Override
    public WmRtIssue selectById(Long id) {
        WmRtIssue wmRtIssue = getById(id);
        if (wmRtIssue == null)
            throw new IdExistNotException("查不存在");
        return wmRtIssue;
    }

    @Override
    public void edit(WmRtIssue wmRtIssue) {
        updateById(wmRtIssue);
    }
}
