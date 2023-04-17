package com.ktg.mes.md.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.domain.wm.WmRtVendorLine;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/16 17:00
 * @description mes
 */
public interface IWmRtVendorLineService extends IService<WmRtVendorLine> {
    void add(WmRtVendorLine wmRtVendorLine);

    Page<WmRtVendorLine> selectList(Long rtId, int pageNum, int pageSize);

    void deleteById(Long id);


    WmRtVendorLine get(Long recptId);

    void edit(WmRtVendorLine wmRtVendorLine);


}
