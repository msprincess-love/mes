package com.ktg.mes.md.controller.wm;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.service.IWmIssueHeaderService;
import com.ktg.mes.md.service.impl.wm.WmIssueHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/14 10:15
 * @description mes
 */
@RestController
@RequestMapping("/mes/wm/issueheader")
public class WmIssueHeaderController {

    @Autowired
    private IWmIssueHeaderService wmIssueHeaderService;

    @PreAuthorize("@ss.hasPermi('mes:wm:issueheader:list')")
    @GetMapping("/list")
    public AjaxResult list(WmIssueHeader wmIssueHeader,
                           @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Page<WmIssueHeader> wmIssueHeaderPage = wmIssueHeaderService.selectList(wmIssueHeader, pageNum, pageSize);
        return AjaxResult.success(wmIssueHeaderPage);
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:issueheader:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody WmIssueHeader wmIssueHeader) {
        wmIssueHeaderService.add(wmIssueHeader);
        return AjaxResult.success("新增成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:issueheader:remove')")
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable Long id) {
        wmIssueHeaderService.deleteById(id);
        return AjaxResult.success("删除成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:issueheader:query')")
    @GetMapping("/{id}")
    public AjaxResult getById(@PathVariable Long id) {
        WmIssueHeader wmIssueHeader = wmIssueHeaderService.selectById(id);
        return AjaxResult.success(wmIssueHeader);
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:issueheader:edit')")
    @PutMapping
    public AjaxResult update(@Validated @RequestBody WmIssueHeader wmIssueHeader) {
        wmIssueHeaderService.edit(wmIssueHeader);
        return AjaxResult.success("修改成功");
    }
}
