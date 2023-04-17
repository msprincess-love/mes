package com.ktg.mes.md.controller.tm;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.domain.tm.TmTool;
import com.ktg.mes.md.domain.tm.TmToolType;
import com.ktg.mes.md.service.ITmToolService;
import com.ktg.mes.md.service.ITmToolTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/11 15:37
 * @description mes
 */
@RestController
@RequestMapping("/mes/tm/tool")
public class TmToolController {

    @Autowired
    private ITmToolService tmToolService;

    @PreAuthorize("@ss.hasPermi('mes:tm:tool:list')")
    @GetMapping("/list")
    public AjaxResult list(TmTool tmTool, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Page<TmTool> tmToolPage = tmToolService.selectList(tmTool, pageNum, pageSize);
        return AjaxResult.success(tmToolPage);
    }

    @PreAuthorize("@ss.hasPermi('mes:tm:tool:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody TmTool tmTool) {
        tmToolService.add(tmTool);
        return AjaxResult.success("新增成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:tm:tooltype:remove')")
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable Long id) {
        tmToolService.deleteById(id);
        return AjaxResult.success("删除成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:tm:tool:query')")
    @GetMapping("/{id}")
    public AjaxResult getBId(@PathVariable Long id) {
        TmTool tmTool = tmToolService.selectById(id);
        return AjaxResult.success(tmTool);
    }

    @PreAuthorize("@ss.hasPermi('mes:tm:tool:edit')")
    @PutMapping
    public AjaxResult update(@Validated @RequestBody TmTool tmTool) {
        tmToolService.edit(tmTool);
        return AjaxResult.success("修改成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:tm:tool:list')")
    @GetMapping("/listAll")
    public AjaxResult listAll() {
        return AjaxResult.success(tmToolService.listAll());
    }


}
