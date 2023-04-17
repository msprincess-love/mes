package com.ktg.mes.md.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.domain.wm.WmRtVendor;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/14 9:43
 * @description mes
 */
public interface IWmRtVendorService extends IService<WmRtVendor> {
    Page<WmRtVendor> selectList(WmRtVendor wmRtVendor, int pageNum, int pageSize);

    void add(WmRtVendor wmRtVendor);


    void deleteById(Long id);

    WmRtVendor selectById(Long id);

    void edit(WmRtVendor wmRtVendor);

    void outItem(Long id);
}
