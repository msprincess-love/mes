package com.ktg.mes.md.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ktg.mes.md.domain.wm.WmItemRecptLine;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/16 16:34
 * @description mes
 */
public interface IWmItemRecptLineService extends IService<WmItemRecptLine> {
    Page<WmItemRecptLine> selectList(Long recptId, int pageNum, int pageSize);

    void add(WmItemRecptLine wmItemRecpt);


    void deleteById(Long id);

    WmItemRecptLine get(Long recptId);

    void edit(WmItemRecptLine wmItemRecptLine);
}
