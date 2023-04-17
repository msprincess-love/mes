package com.ktg.mes.md.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.domain.pro.ProProcess;
import com.ktg.mes.md.domain.pro.ProWorkorder;

import java.util.List;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/9 19:51
 * @description mes
 */
public interface IProWorkorderService extends IService<ProWorkorder> {


    List<ProWorkorder> selectList(ProWorkorder proWorkorder);


    ProWorkorder selectById(Long id);

    void deleteById(Long id);


    void edit(ProWorkorder proWorkorder);

    void add(ProWorkorder proWorkorder);
}
