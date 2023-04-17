package com.ktg.mes.md.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.domain.md.MdWorkstationTool;
import com.ktg.mes.md.domain.md.MdWorkstationWorker;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/9 17:10
 * @description mes
 */
public interface IMdWorkstationToolService extends IService<MdWorkstationTool> {

    Page<MdWorkstationTool> listPage(int pageNUm, int pageSize, Long workstationId);

    void add(MdWorkstationTool mdWorkstationTool);


    void deleteById(Long id);

}
