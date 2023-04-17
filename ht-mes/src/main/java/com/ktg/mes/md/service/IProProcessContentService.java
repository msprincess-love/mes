package com.ktg.mes.md.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.domain.pro.ProProcess;
import com.ktg.mes.md.domain.pro.ProProcessContent;

import java.util.List;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/9 19:51
 * @description mes
 */
public interface IProProcessContentService extends IService<ProProcessContent> {

    Page<ProProcessContent> getList(int pageNum, int pageSize, ProProcessContent proProcessContent);


    void add(ProProcessContent process);

    void deleteById(Long id);

    void edit(ProProcessContent process);

    ProProcessContent selectById(Long id);

}
