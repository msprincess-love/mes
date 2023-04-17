package com.ktg.mes.md.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.domain.md.MdItem;


/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/7 8:28
 * @description mes
 */
public interface IMdItemService extends IService<MdItem> {


    Page<MdItem> listPage(MdItem mdItem, int pageNUm, int pageSize, Long itemTypeId);

    void add(MdItem mdItem);


}
