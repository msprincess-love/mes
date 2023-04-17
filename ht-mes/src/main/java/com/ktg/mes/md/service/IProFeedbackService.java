package com.ktg.mes.md.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.domain.pro.ProFeedback;

import java.util.List;

public interface IProFeedbackService extends IService<ProFeedback> {

    Page<ProFeedback> getList(int pageNum, int pageSize, ProFeedback proFeedback);

    void add(ProFeedback proFeedback);


    void deleteById(Long id);


    ProFeedback selectById(Long id);

    void edit(ProFeedback proFeedback);


}
