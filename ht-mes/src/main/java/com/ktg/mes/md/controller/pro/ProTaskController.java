package com.ktg.mes.md.controller.pro;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.domain.dv.DvRepairLine;
import com.ktg.mes.md.domain.pro.ProProcess;
import com.ktg.mes.md.domain.pro.ProTask;
import com.ktg.mes.md.service.IProProcessService;
import com.ktg.mes.md.service.IProTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/9 19:53
 * @description mes
 */
@RestController
@RequestMapping("/mes/pro/protask")
public class ProTaskController {

    @Autowired
    private IProTaskService proTaskService;

    @PreAuthorize("@ss.hasPermi('mes:dv:protask:list')")
    @GetMapping("/list")
    public AjaxResult list(ProTask proTask, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Page<ProTask> proTaskPage = proTaskService.selectList(proTask, pageNum, pageSize);
        return AjaxResult.success(proTaskPage);
    }
}
