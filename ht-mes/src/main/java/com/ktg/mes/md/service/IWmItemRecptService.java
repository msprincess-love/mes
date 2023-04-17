package com.ktg.mes.md.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.domain.wm.WmItemRecpt;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/14 9:13
 * @description mes
 */
public interface IWmItemRecptService extends IService<WmItemRecpt> {
    Page<WmItemRecpt> selectList(WmItemRecpt wmItemRecpt, int pageNum, int pageSize);

    void add(WmItemRecpt wmItemRecpt);


    void deleteById(Long id);

    WmItemRecpt selectById(Long id);

    void edit(WmItemRecpt wmItemRecpt);

    void pushWarehouse(Long recptId);


}
