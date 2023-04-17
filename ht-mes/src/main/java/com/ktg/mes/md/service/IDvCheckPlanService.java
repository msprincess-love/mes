package com.ktg.mes.md.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.domain.dv.DvCheckPlan;
import com.ktg.mes.md.domain.dv.DvSubject;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/11 11:39
 * @description mes
 */
public interface IDvCheckPlanService extends IService<DvCheckPlan> {
    Page<DvCheckPlan> selectList(DvCheckPlan dvCheckPlan, int pageNum, int pageSize);

    void add(DvCheckPlan dvCheckPlan);


    DvCheckPlan selectById(Long id);


    void edit(DvCheckPlan dvCheckPlan);


    void deleteById(Long id);

}
