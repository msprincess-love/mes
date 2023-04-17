package com.ktg.mes.md.service.impl.md;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktg.mes.md.domain.md.MdItem;
import com.ktg.mes.md.mapper.md.MdItemMapper;
import com.ktg.mes.md.service.IMdItemService;
import org.springframework.stereotype.Service;


/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/8 13:28
 * @description mes
 */
@Service
public class MdItemServiceImpl extends ServiceImpl<MdItemMapper, MdItem> implements IMdItemService {

    @Override
    public Page<MdItem> listPage(MdItem mdItem, int pageNUm, int pageSize, Long itemTypeId) {
        Page<MdItem> pageInfo = new Page<>(pageNUm, pageSize);
        LambdaQueryWrapper<MdItem> wrapper = new LambdaQueryWrapper<>();
        if (itemTypeId != null)
        if (mdItem.getItemCode() != null)
            wrapper.eq(MdItem::getItemCode, mdItem.getItemCode());
        if (mdItem.getItemName() != null)
            wrapper.like(MdItem::getItemName, mdItem.getItemName());
        wrapper.eq(MdItem::getItemTypeId, itemTypeId);
        return page(pageInfo, wrapper);
    }

    @Override
    public void add(MdItem mdItem) {
        LambdaQueryWrapper<MdItem> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(MdItem::getItemCode, mdItem.getItemCode());
        int count = count(wrapper);
        if (count > 0)
            throw new RuntimeException("新增失败");
        save(mdItem);
    }
}
