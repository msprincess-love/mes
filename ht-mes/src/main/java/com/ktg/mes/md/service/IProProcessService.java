package com.ktg.mes.md.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.domain.pro.ProProcess;

import java.util.List;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/9 19:51
 * @description mes
 */
public interface IProProcessService extends IService<ProProcess> {
    Page<ProProcess> selectList(String processCode, String processName, String enableFlag, int pageNum, int pageSize);

    void add(ProProcess process);

    ProProcess selectById(Long id);


    void deleteById(Long id);

    void edit(ProProcess process);


    List<ProProcess> listAll();



}
