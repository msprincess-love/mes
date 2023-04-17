package com.ktg.mes.md.controller.dv;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.domain.dv.DvMachineryType;
import com.ktg.mes.md.domain.dv.DvSubject;
import com.ktg.mes.md.domain.md.MdVendor;
import com.ktg.mes.md.service.IDvSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/11 11:31
 * @description mes
 */
@RestController
@RequestMapping("/mes/dv/dvsubject")
public class DvSubjectController {

    @Autowired
    private IDvSubjectService dvSubjectService;

    @PreAuthorize("@ss.hasPermi('mes:dv:dvsubject:list')")
    @GetMapping("/list")
    public AjaxResult list(DvSubject dvSubject, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Page<DvSubject> dvSubjectPage = dvSubjectService.selectList(dvSubject, pageNum, pageSize);
        return AjaxResult.success(dvSubjectPage);
    }

    @PreAuthorize("@ss.hasPermi('mes:dv:dvsubject:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody DvSubject dvSubject) {
        dvSubjectService.add(dvSubject);
        return AjaxResult.success("新增成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:dv:dvsubject:query')")
    @GetMapping("/{id}")
    public AjaxResult getById(@PathVariable Long id) {
        DvSubject dvSubject = dvSubjectService.selectById(id);
        return AjaxResult.success(dvSubject);
    }

    @PreAuthorize("@ss.hasPermi('mes:dv:dvsubject:edit')")
    @PutMapping
    public AjaxResult update(@Validated @RequestBody DvSubject dvSubject) {
        dvSubjectService.edit(dvSubject);
        return AjaxResult.success("修改成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:dv:dvsubject:remove')")
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable Long id) {
        dvSubjectService.deleteById(id);
        return AjaxResult.success("删除成功");
    }
}
