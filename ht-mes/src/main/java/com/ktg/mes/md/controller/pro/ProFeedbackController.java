package com.ktg.mes.md.controller.pro;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.domain.pro.ProFeedback;
import com.ktg.mes.md.domain.pro.ProProcessContent;
import com.ktg.mes.md.service.IProFeedbackService;
import com.ktg.mes.md.service.IProProcessContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/14 8:18
 * @description mes
 */
@RestController
@RequestMapping("mes/pro/feedback")
public class ProFeedbackController {

    @Autowired
    private IProFeedbackService proFeedbackService;

    @GetMapping("/list")
    @PreAuthorize("@ss.hasPermi('mes:pro:feedback:list')")
    public AjaxResult list(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                           ProFeedback proFeedback) {
        Page<ProFeedback> proFeedbackPage = proFeedbackService.getList(pageNum, pageSize, proFeedback);
        return AjaxResult.success(proFeedbackPage);
    }


    @PreAuthorize("@ss.hasPermi('mes:pro:feedback:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody ProFeedback proFeedback) {
        proFeedbackService.add(proFeedback);
        return AjaxResult.success("新增成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:pro:feedback:remove')")
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable Long id) {
        proFeedbackService.deleteById(id);
        return AjaxResult.success("删除成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:pro:feedback:query')")
    @GetMapping("/{id}")
    public AjaxResult getById(@PathVariable Long id) {
        ProFeedback proFeedback = proFeedbackService.selectById(id);
        return AjaxResult.success(proFeedback);
    }

    @PreAuthorize("@ss.hasPermi('mes:pro:feedback:edit')")
    @PutMapping
    public AjaxResult update(@Validated @RequestBody ProFeedback proFeedback) {
        proFeedbackService.edit(proFeedback);
        return AjaxResult.success("修改成功");
    }

}
