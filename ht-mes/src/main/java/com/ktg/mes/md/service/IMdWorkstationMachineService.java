package com.ktg.mes.md.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.domain.md.MdWorkstationMachine;
import com.ktg.mes.md.domain.md.MdWorkstationWorker;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/9 17:10
 * @description mes
 */
public interface IMdWorkstationMachineService extends IService<MdWorkstationMachine> {

    Page<MdWorkstationMachine> listPage(int pageNUm, int pageSize, Long workstationId);

    void add(MdWorkstationMachine mdWorkstationMachine);

    void deleteById(Long id);

}
