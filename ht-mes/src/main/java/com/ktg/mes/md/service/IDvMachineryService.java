package com.ktg.mes.md.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.domain.dv.DvMachinery;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/10 21:09
 * @description mes
 */
public interface IDvMachineryService extends IService<DvMachinery> {
    Page<DvMachinery> selectClientList(DvMachinery dvMachinery, int pageNum, int pageSize);

    void add(DvMachinery dvMachinery);


    void deleteById(Long id);


    DvMachinery selectById(Long id);


    void edit(DvMachinery dvMachinery);


}
