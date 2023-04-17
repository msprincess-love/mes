package com.ktg.mes.md.controller.dv;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.domain.dv.DvCheckPlan;
import com.ktg.mes.md.domain.dv.DvCheckSubject;
import com.ktg.mes.md.service.IDvCheckSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/11 11:31
 * @description mes
 */
@RestController
@RequestMapping("/mes/dv/checksubject")
public class DvCheckSubjectController {

    @Autowired
    private IDvCheckSubjectService dvCheckSubjectService;

    @PreAuthorize("@ss.hasPermi('mes:dv:checksubject:list')")
    @GetMapping("/list")
    public AjaxResult list( @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                            @RequestParam(value = "planId") Long planId) {
        Page<DvCheckSubject> dvCheckSubjectPage = dvCheckSubjectService.selectList(planId, pageNum, pageSize);
        return AjaxResult.success(dvCheckSubjectPage);
    }

    @PreAuthorize("@ss.hasPermi('mes:dv:checksubject:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody DvCheckSubject dvCheckSubject) {
        dvCheckSubjectService.add(dvCheckSubject);
        return AjaxResult.success("新增成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:dv:checksubject:remove')")
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable Long id) {
        dvCheckSubjectService.deleteById(id);
        return AjaxResult.success("删除成功");
    }


}
