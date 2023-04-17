package com.ktg.mes.md.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.domain.dv.DvRepairLine;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/16 13:54
 * @description mes
 */
public interface IDvRepairLineService extends IService<DvRepairLine> {
    Page<DvRepairLine> selectList( int pageNum, int pageSize);

    void add(DvRepairLine dvRepairLine);


    DvRepairLine selectById(Long id);

    void edit(DvRepairLine dvRepairLine);

    void deleteById(Long id);


}
