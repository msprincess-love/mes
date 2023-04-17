package com.ktg.mes.md.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.domain.tm.TmTool;

import java.util.List;


/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/11 15:36
 * @description mes
 */
public interface ITmToolService extends IService<TmTool> {
    Page<TmTool> selectList(TmTool tmTool, int pageNum, int pageSize);

    void add(TmTool tmTool);


    void deleteById(Long id);


    TmTool selectById(Long id);


    void edit(TmTool tmTool);

    List<TmTool> listAll();
}
