package com.ktg.mes.md.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.domain.tm.TmToolType;

import java.util.List;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/11 15:36
 * @description mes
 */
public interface ITmToolTypeService extends IService<TmToolType> {
    Page<TmToolType> selectList(TmToolType tmToolType, int pageNum, int pageSize);

    void add(TmToolType tmToolType);


    void deleteById(Long id);


    TmToolType selectById(Long id);

    void edit(TmToolType tmToolType);


    List<TmToolType> listAll();
}
