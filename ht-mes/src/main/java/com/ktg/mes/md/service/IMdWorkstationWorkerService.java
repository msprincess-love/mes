package com.ktg.mes.md.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.domain.md.MdWorkshop;
import com.ktg.mes.md.domain.md.MdWorkstationWorker;

import java.util.List;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/9 17:10
 * @description mes
 */
public interface IMdWorkstationWorkerService extends IService<MdWorkstationWorker> {

    Page<MdWorkstationWorker> listPage(int pageNUm, int pageSize, Long workstationId);

    void add(MdWorkstationWorker workstationWorker);

    void deleteById(Long id);

}
