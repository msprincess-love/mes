package com.ktg.mes.md.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.domain.pro.ProProcess;
import com.ktg.mes.md.domain.pro.ProRouteProduct;

import java.util.List;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/9 19:51
 * @description mes
 */
public interface IProRouteProductService extends IService<ProRouteProduct> {
    Page<ProRouteProduct> selectList(ProRouteProduct proRouteProduct, int pageNum, int pageSize);

    void add(ProRouteProduct process);

    ProRouteProduct selectById(Long id);


    void deleteById(Long id);

    void edit(ProRouteProduct process);


}
