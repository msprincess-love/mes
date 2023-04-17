package com.ktg.mes.md.controller.pro;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.domain.pro.ProProcess;
import com.ktg.mes.md.domain.pro.ProRoute;
import com.ktg.mes.md.service.IProProcessService;
import com.ktg.mes.md.service.IProRouteService;
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
@RequestMapping("/mes/pro/proroute")
public class ProRouteController {

    @Autowired
    private IProRouteService proRouteService;

    @GetMapping("/list")
    @PreAuthorize("@ss.hasPermi('mes:pro:proroute:list')")
    public AjaxResult list(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                           ProRoute proRoute) {
        Page<ProRoute> proRoutePage = proRouteService.selectList(proRoute, pageNum, pageSize);
        return AjaxResult.success(proRoutePage);
    }

    @PreAuthorize("@ss.hasPermi('mes:pro:proroute:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody ProRoute proRoute) {
        proRouteService.add(proRoute);
        return AjaxResult.success("新增成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:pro:proroute:remove')")
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable Long id) {
        proRouteService.deleteById(id);
        return AjaxResult.success("删除成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:pro:proroute:query')")
    @GetMapping("/{id}")
    public AjaxResult getById(@PathVariable Long id) {
        ProRoute proRoute = proRouteService.selectById(id);
        return AjaxResult.success(proRoute);
    }

    @PreAuthorize("@ss.hasPermi('mes:pro:proroute:edit')")
    @PutMapping
    public AjaxResult update(@Validated @RequestBody ProRoute proRoute) {
        proRouteService.edit(proRoute);
        return AjaxResult.success("修改成功");
    }

}
