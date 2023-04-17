package com.ktg.mes.md.controller.pro;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.domain.pro.ProProcess;
import com.ktg.mes.md.domain.pro.ProRouteProcess;
import com.ktg.mes.md.domain.pro.ProRouteProduct;
import com.ktg.mes.md.service.IProProcessService;
import com.ktg.mes.md.service.IProRouteProcessService;
import com.ktg.mes.md.service.IProRouteProductService;
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
@RequestMapping("/mes/pro/routeprocess")
public class ProRouteProcessController {

    @Autowired
    private IProRouteProcessService proRouteProcessService;

    @GetMapping("/list")
    @PreAuthorize("@ss.hasPermi('mes:pro:proroute:list')")
    public AjaxResult list(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                           ProRouteProcess proRouteProcess) {
        Page<ProRouteProcess> processPage = proRouteProcessService.selectList(proRouteProcess, pageNum, pageSize);
        return AjaxResult.success(processPage);
    }

    @PreAuthorize("@ss.hasPermi('mes:pro:proroute:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody ProRouteProcess process) {
        proRouteProcessService.add(process);
        return AjaxResult.success("新增成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:pro:proroute:remove')")
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable Long id) {
        proRouteProcessService.deleteById(id);
        return AjaxResult.success("删除成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:pro:proroute:query')")
    @GetMapping("/{id}")
    public AjaxResult getById(@PathVariable Long id) {
        ProRouteProcess process = proRouteProcessService.selectById(id);
        return AjaxResult.success(process);
    }

    @PreAuthorize("@ss.hasPermi('mes:pro:proroute:edit')")
    @PutMapping
    public AjaxResult update(@Validated @RequestBody ProRouteProcess process) {
        proRouteProcessService.edit(process);
        return AjaxResult.success("修改成功");
    }

}
