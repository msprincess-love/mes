package com.ktg.mes.md.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.domain.wm.WmStorageLocation;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/10 10:39
 * @description mes
 */
public interface IWmStorageLocationService extends IService<WmStorageLocation> {
    Page<WmStorageLocation> selectList(WmStorageLocation wmStorageLocation, int pageNum, int pageSize);

    void edit(WmStorageLocation wmStorageLocation);


    void deleteById(Long id);


    void add(WmStorageLocation wmStorageLocation);


    WmStorageLocation selectById(Long id);

}
