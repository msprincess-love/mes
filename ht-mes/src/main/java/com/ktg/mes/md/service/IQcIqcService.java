package com.ktg.mes.md.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.domain.qc.QcIqc;

public interface IQcIqcService extends IService<QcIqc> {
    Page<QcIqc> getList(int pageNum, int pageSize, QcIqc qcIqc);

    void add(QcIqc qcIqc);


    void deleteById(Long id);

    QcIqc selectById(Long id);

    void edit(QcIqc qcIqc);
}
