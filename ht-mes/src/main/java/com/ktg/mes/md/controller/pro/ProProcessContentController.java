package com.ktg.mes.md.controller.pro;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.domain.pro.ProProcess;
import com.ktg.mes.md.domain.pro.ProProcessContent;
import com.ktg.mes.md.service.IProProcessContentService;
import com.ktg.mes.md.service.IProProcessService;
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
@RequestMapping("/mes/pro/processcontent")
public class ProProcessContentController {

    @Autowired
    private IProProcessContentService proProcessContentService;

    @GetMapping("/list")
    @PreAuthorize("@ss.hasPermi('mes:pro:process:list')")
    public AjaxResult list(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                           ProProcessContent proProcessContent) {
        Page<ProProcessContent> proProcessContentPage = proProcessContentService.getList(pageNum, pageSize, proProcessContent);
        return AjaxResult.success(proProcessContentPage);
    }


    @PreAuthorize("@ss.hasPermi('mes:pro:process:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody ProProcessContent process) {
        proProcessContentService.add(process);
        return AjaxResult.success("新增成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:pro:process:remove')")
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable Long id) {
        proProcessContentService.deleteById(id);
        return AjaxResult.success("删除成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:pro:process:query')")
    @GetMapping("/{id}")
    public AjaxResult getById(@PathVariable Long id) {
        ProProcessContent process = proProcessContentService.selectById(id);
        return AjaxResult.success(process);
    }

    @PreAuthorize("@ss.hasPermi('mes:pro:process:edit')")
    @PutMapping
    public AjaxResult update(@Validated @RequestBody ProProcessContent process) {
        proProcessContentService.edit(process);
        return AjaxResult.success("修改成功");
    }


}
