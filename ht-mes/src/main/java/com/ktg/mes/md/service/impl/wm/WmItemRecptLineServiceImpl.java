package com.ktg.mes.md.service.impl.wm;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.md.MdItem;
import com.ktg.mes.md.domain.wm.WmItemRecptLine;
import com.ktg.mes.md.domain.wm.WmStorageArea;
import com.ktg.mes.md.mapper.wm.WmItemRecptLineMapper;
import com.ktg.mes.md.service.IMdItemService;
import com.ktg.mes.md.service.IWmItemRecptLineService;
import com.ktg.mes.md.service.IWmStorageAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/16 16:35
 * @description mes
 */
@Service
public class WmItemRecptLineServiceImpl extends ServiceImpl<WmItemRecptLineMapper, WmItemRecptLine> implements IWmItemRecptLineService {

    @Override
    public Page<WmItemRecptLine> selectList(Long recptId, int pageNum, int pageSize) {
        Page<WmItemRecptLine> pageInfo = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<WmItemRecptLine> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(WmItemRecptLine::getRecptId, recptId);
        return page(pageInfo, wrapper);
    }

    @Override
    public void add(WmItemRecptLine wmItemRecpt) {
        save(wmItemRecpt);
    }

    @Override
    public void deleteById(Long id) {
        removeById(id);
    }

    @Override
    public WmItemRecptLine get(Long recptId) {
        if (getById(recptId) == null)
            throw new RuntimeException("查不存在");
        return getById(recptId);
    }

    @Override
    public void edit(WmItemRecptLine wmItemRecptLine) {
        updateById(wmItemRecptLine);
    }
}
