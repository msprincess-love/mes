package com.ktg.mes.md.controller.pro;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.domain.pro.ProProcess;
import com.ktg.mes.md.domain.pro.ProWorkorder;
import com.ktg.mes.md.service.IProProcessService;
import com.ktg.mes.md.service.IProWorkorderService;
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
@RequestMapping("/mes/pro/workorder")
public class ProWorkorderController {

    @Autowired
    private IProWorkorderService proWorkorderService;

    @GetMapping("/list")
    @PreAuthorize("@ss.hasPermi('mes:pro:workorder:list')")
    public AjaxResult list(ProWorkorder proWorkorder) {
        List<ProWorkorder> proWorkorders = proWorkorderService.selectList(proWorkorder);
        return AjaxResult.success(proWorkorders);
    }

    @PreAuthorize("@ss.hasPermi('mes:pro:workorder:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody ProWorkorder proWorkorder) {
        proWorkorderService.add(proWorkorder);
        return AjaxResult.success("新增成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:pro:workorder:remove')")
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable Long id) {
        proWorkorderService.deleteById(id);
        return AjaxResult.success("删除成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:pro:workorder:query')")
    @GetMapping("/{id}")
    public AjaxResult getById(@PathVariable Long id) {
        ProWorkorder proWorkorder = proWorkorderService.selectById(id);
        return AjaxResult.success(proWorkorder);
    }

    @PreAuthorize("@ss.hasPermi('mes:pro:workorder:edit')")
    @PutMapping
    public AjaxResult update(@Validated @RequestBody ProWorkorder proWorkorder) {
        proWorkorderService.edit(proWorkorder);
        return AjaxResult.success("修改成功");
    }


}
