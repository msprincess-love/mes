package com.ktg.mes.md.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.domain.dv.DvRepair;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/11 15:08
 * @description mes
 */
public interface IDvRepairService extends IService<DvRepair> {
    Page<DvRepair> selectList(DvRepair dvRepair, int pageNum, int pageSize);

    void add(DvRepair dvRepair);


    DvRepair selectById(Long id);

    void edit(DvRepair dvRepair);

    void deleteById(Long id);


}
