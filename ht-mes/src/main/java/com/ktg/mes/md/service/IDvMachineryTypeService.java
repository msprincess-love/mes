package com.ktg.mes.md.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.domain.dv.DvMachineryType;

import java.util.List;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/10 20:26
 * @description mes
 */
public interface IDvMachineryTypeService extends IService<DvMachineryType> {
    List<DvMachineryType> selectList(DvMachineryType dvMachineryType);


    void add(DvMachineryType dvMachineryType);


    DvMachineryType selectById(Long id);


    void edit(DvMachineryType dvMachineryType);


    void deleteById(Long id);


}
