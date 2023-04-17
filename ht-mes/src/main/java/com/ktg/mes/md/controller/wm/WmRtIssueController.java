package com.ktg.mes.md.controller.wm;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.domain.wm.WmRtIssue;
import com.ktg.mes.md.domain.wm.WmRtVendor;
import com.ktg.mes.md.service.IWmRtIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/14 10:31
 * @description mes
 */
@RestController
@RequestMapping("/mes/wm/rtissue")
public class WmRtIssueController {

    @Autowired
    private IWmRtIssueService wmRtIssueService;

    @PreAuthorize("@ss.hasPermi('mes:wm:rtissue:list')")
    @GetMapping("/list")
    public AjaxResult list(WmRtIssue wmRtIssue,
                           @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Page<WmRtIssue> wmRtIssuePage = wmRtIssueService.selectList(wmRtIssue, pageNum, pageSize);
        return AjaxResult.success(wmRtIssuePage);
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:rtissue:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody WmRtIssue wmRtIssue) {
        wmRtIssueService.add(wmRtIssue);
        return AjaxResult.success("新增成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:rtissue:remove')")
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable Long id) {
        wmRtIssueService.deleteById(id);
        return AjaxResult.success("删除成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:rtissue:query')")
    @GetMapping("/{id}")
    public AjaxResult getById(@PathVariable Long id) {
        WmRtIssue wmRtIssue = wmRtIssueService.selectById(id);
        return AjaxResult.success(wmRtIssue);
    }

    @PreAuthorize("@ss.hasPermi('mes:wm:rtissue:edit')")
    @PutMapping
    public AjaxResult update(@Validated @RequestBody WmRtIssue wmRtIssue) {
        wmRtIssueService.edit(wmRtIssue);
        return AjaxResult.success("修改成功");
    }
}
