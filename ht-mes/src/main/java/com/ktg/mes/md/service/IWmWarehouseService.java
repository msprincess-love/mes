package com.ktg.mes.md.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.domain.md.MdWorkshop;
import com.ktg.mes.md.domain.wm.WmWarehouse;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/9 21:08
 * @description mes
 */
public interface IWmWarehouseService extends IService<WmWarehouse> {
    Page<WmWarehouse> selectList(WmWarehouse warehouse, int pageNum, int pageSize);

    WmWarehouse selectById(Long id);

    void edit(WmWarehouse warehouse);

    void add(WmWarehouse warehouse);

    void deleteById(Long id);

    void getTreeList();




}
