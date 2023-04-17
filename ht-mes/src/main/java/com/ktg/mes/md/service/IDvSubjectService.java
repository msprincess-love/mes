package com.ktg.mes.md.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.domain.dv.DvSubject;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/11 11:39
 * @description mes
 */
public interface IDvSubjectService extends IService<DvSubject> {
    Page<DvSubject> selectList(DvSubject dvSubject, int pageNum, int pageSize);

    void add(DvSubject dvSubject);


    DvSubject selectById(Long id);


    void edit(DvSubject dvSubject);


    void deleteById(Long id);

}
