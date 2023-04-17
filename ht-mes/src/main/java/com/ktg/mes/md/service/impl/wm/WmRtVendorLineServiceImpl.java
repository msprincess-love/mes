package com.ktg.mes.md.service.impl.wm;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.wm.WmRtVendorLine;
import com.ktg.mes.md.mapper.WmRtVendorLineMapper;
import com.ktg.mes.md.service.IWmRtVendorLineService;
import org.springframework.stereotype.Service;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/16 17:00
 * @description mes
 */
@Service
public class WmRtVendorLineServiceImpl extends ServiceImpl<WmRtVendorLineMapper, WmRtVendorLine> implements IWmRtVendorLineService {

    @Override
    public void add(WmRtVendorLine wmRtVendorLine) {

    }

    @Override
    public Page<WmRtVendorLine> selectList(Long rtId, int pageNum, int pageSize) {
        Page<WmRtVendorLine> pageInfo = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<WmRtVendorLine> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(WmRtVendorLine::getRtId, rtId);
        return page(pageInfo, wrapper);
    }

    @Override
    public void deleteById(Long id) {
        removeById(id);
    }

    @Override
    public WmRtVendorLine get(Long recptId) {
        if (getById(recptId) == null)
            throw new RuntimeException("查不存在");
        return getById(recptId);
    }

    @Override
    public void edit(WmRtVendorLine wmRtVendorLine) {
        updateById(wmRtVendorLine);
    }
}
