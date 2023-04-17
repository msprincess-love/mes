package com.ktg.mes.md.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.domain.dv.DvCheckMachinery;
import com.ktg.mes.md.domain.dv.DvCheckPlan;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/11 11:39
 * @description mes
 */
public interface IDvCheckMachineryService extends IService<DvCheckMachinery> {
    Page<DvCheckMachinery> selectList(Long planId, int pageNum, int pageSize);

    void add(DvCheckMachinery dvCheckMachinery);


    void deleteById(Long id);

}
