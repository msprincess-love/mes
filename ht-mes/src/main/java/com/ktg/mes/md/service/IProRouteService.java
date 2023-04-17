package com.ktg.mes.md.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.domain.pro.ProProcess;
import com.ktg.mes.md.domain.pro.ProRoute;

import java.util.List;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/9 19:51
 * @description mes
 */
public interface IProRouteService extends IService<ProRoute> {
    Page<ProRoute> selectList(ProRoute proRoute, int pageNum, int pageSize);

    void add(ProRoute proRoute);

    ProRoute selectById(Long id);


    void deleteById(Long id);

    void edit(ProRoute proRoute);




}
