package com.ktg.mes.md.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.domain.wm.WmRtIssue;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/14 10:30
 * @description mes
 */
public interface IWmRtIssueService extends IService<WmRtIssue> {
    Page<WmRtIssue> selectList(WmRtIssue wmRtIssue, int pageNum, int pageSize);

    void add(WmRtIssue wmRtIssue);


    void deleteById(Long id);

    WmRtIssue selectById(Long id);


    void edit(WmRtIssue wmRtIssue);

}
