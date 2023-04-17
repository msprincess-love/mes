package com.ktg.mes.md.controller.pro;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.domain.pro.ProProcess;
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
@RequestMapping("/mes/pro/process")
public class ProProcessController {

    @Autowired
    private IProProcessService proProcessService;

    @GetMapping("/list")
    @PreAuthorize("@ss.hasPermi('mes:pro:process:list')")
    public AjaxResult list(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                           @RequestParam(value = "processCode", required = false) String processCode,
                           @RequestParam(value = "processName", required = false) String processName,
                           @RequestParam(value = "enableFlag", required = false) String enableFlag) {
        Page<ProProcess> processPage = proProcessService.selectList(processCode, processName, enableFlag, pageNum, pageSize);
        return AjaxResult.success(processPage);
    }

    @PreAuthorize("@ss.hasPermi('mes:pro:process:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody ProProcess process) {
        proProcessService.add(process);
        return AjaxResult.success("新增成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:pro:process:remove')")
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable Long id) {
        proProcessService.deleteById(id);
        return AjaxResult.success("删除成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:pro:process:query')")
    @GetMapping("/{id}")
    public AjaxResult getById(@PathVariable Long id) {
        ProProcess process = proProcessService.selectById(id);
        return AjaxResult.success(process);
    }

    @PreAuthorize("@ss.hasPermi('mes:pro:process:edit')")
    @PutMapping
    public AjaxResult update(@Validated @RequestBody ProProcess process) {
        proProcessService.edit(process);
        return AjaxResult.success("修改成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:pro:process:list')")
    @GetMapping("/listAll")
    public AjaxResult listAll() {
        List<ProProcess> processes = proProcessService.listAll();
        return AjaxResult.success(processes);
    }

}
