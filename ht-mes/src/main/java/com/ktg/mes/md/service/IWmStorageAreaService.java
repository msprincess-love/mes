package com.ktg.mes.md.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.domain.wm.WmStorageArea;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/10 16:39
 * @description mes
 */
public interface IWmStorageAreaService extends IService<WmStorageArea> {
    Page<WmStorageArea> selectList(WmStorageArea wmStorageArea, int pageNum, int pageSize);

    void add(WmStorageArea wmStorageArea);


    void deleteById(Long id);


    WmStorageArea selectById(Long id);

    void edit(WmStorageArea wmStorageArea);

}
