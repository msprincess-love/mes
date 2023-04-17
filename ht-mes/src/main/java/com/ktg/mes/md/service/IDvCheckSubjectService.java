package com.ktg.mes.md.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.domain.dv.DvCheckPlan;
import com.ktg.mes.md.domain.dv.DvCheckSubject;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/11 11:39
 * @description mes
 */
public interface IDvCheckSubjectService extends IService<DvCheckSubject> {
    Page<DvCheckSubject> selectList(Long planId, int pageNum, int pageSize);

    void add(DvCheckSubject dvCheckSubject);


    void deleteById(Long id);

}
