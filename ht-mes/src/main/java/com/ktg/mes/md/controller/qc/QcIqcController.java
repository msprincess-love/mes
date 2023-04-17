package com.ktg.mes.md.controller.qc;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.domain.pro.ProFeedback;
import com.ktg.mes.md.domain.qc.QcIqc;
import com.ktg.mes.md.service.IQcIqcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/14 13:44
 * @description mes
 */
@RestController
@RequestMapping("/mes/qc/iqc")
public class QcIqcController {

    @Autowired
    private IQcIqcService qcIqcService;

    @GetMapping("/list")
    @PreAuthorize("@ss.hasPermi('mes:qc:iqc:list')")
    public AjaxResult list(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                           QcIqc qcIqc) {
        Page<QcIqc> qcIqcPage = qcIqcService.getList(pageNum, pageSize, qcIqc);
        return AjaxResult.success(qcIqcPage);
    }


    @PreAuthorize("@ss.hasPermi('mes:qc:iqc:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody QcIqc qcIqc) {
        qcIqcService.add(qcIqc);
        return AjaxResult.success("新增成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:qc:iqc:remove')")
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable Long id) {
        qcIqcService.deleteById(id);
        return AjaxResult.success("删除成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:qc:iqc:query')")
    @GetMapping("/{id}")
    public AjaxResult getById(@PathVariable Long id) {
        QcIqc qcIqc = qcIqcService.selectById(id);
        return AjaxResult.success(qcIqc);
    }

    @PreAuthorize("@ss.hasPermi('mes:qc:iqc:edit')")
    @PutMapping
    public AjaxResult update(@Validated @RequestBody QcIqc qcIqc) {
        qcIqcService.edit(qcIqc);
        return AjaxResult.success("修改成功");
    }
}
