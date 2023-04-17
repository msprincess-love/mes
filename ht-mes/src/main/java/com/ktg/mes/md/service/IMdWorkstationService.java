package com.ktg.mes.md.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.domain.md.MdWorkstation;
import com.ktg.mes.md.domain.pro.ProProcess;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/9 19:01
 * @description mes
 */
public interface IMdWorkstationService extends IService<MdWorkstation> {
    Page<MdWorkstation> selectList(MdWorkstation workstation, int pageNum, int pageSize);


    void add(MdWorkstation workstation);

    MdWorkstation selectById(Long id);

    void deleteById(Long id);


    void edit(MdWorkstation client);

}
