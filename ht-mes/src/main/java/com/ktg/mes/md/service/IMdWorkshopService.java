package com.ktg.mes.md.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.domain.md.MdWorkshop;

import java.util.List;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/9 17:10
 * @description mes
 */
public interface IMdWorkshopService extends IService<MdWorkshop> {
    Page<MdWorkshop> selectList(MdWorkshop workshop, int pageNum, int pageSize);

    void add(MdWorkshop workshop);


    void deleteById(Long id);


    MdWorkshop selectById(Long id);

    void edit(MdWorkshop workshop);

    List<MdWorkshop> listAll();
}
