package com.ktg.mes.md.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.domain.wm.WmMaterialStock;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/10 17:49
 * @description mes
 */
public interface IWmMaterialStockService extends IService<WmMaterialStock> {
    Page<WmMaterialStock> selectList(WmMaterialStock wmMaterialStock, int pageNum, int pageSize);
}
