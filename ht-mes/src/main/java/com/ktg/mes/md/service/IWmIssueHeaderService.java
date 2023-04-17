package com.ktg.mes.md.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.service.impl.wm.WmIssueHeader;

public interface IWmIssueHeaderService extends IService<WmIssueHeader> {

    Page<WmIssueHeader> selectList(WmIssueHeader wmIssueHeader, int pageNum, int pageSize);

    void add(WmIssueHeader wmIssueHeader);

    void deleteById(Long id);


    WmIssueHeader selectById(Long id);

    void edit(WmIssueHeader wmIssueHeader);


}
