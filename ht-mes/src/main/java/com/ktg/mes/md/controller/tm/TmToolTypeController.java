package com.ktg.mes.md.controller.tm;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.domain.md.MdWorkshop;
import com.ktg.mes.md.domain.tm.TmToolType;
import com.ktg.mes.md.service.ITmToolTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/11 15:37
 * @description mes
 */
@RestController
@RequestMapping("/mes/tm/tooltype")
public class TmToolTypeController {

    @Autowired
    private ITmToolTypeService tmToolTypeService;

    @PreAuthorize("@ss.hasPermi('mes:tm:tooltype:list')")
    @GetMapping("/list")
    public AjaxResult list(TmToolType tmToolType, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Page<TmToolType> tmToolTypePage = tmToolTypeService.selectList(tmToolType, pageNum, pageSize);
        return AjaxResult.success(tmToolTypePage);
    }

    @PreAuthorize("@ss.hasPermi('mes:tm:tooltype:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody TmToolType tmToolType) {
        tmToolTypeService.add(tmToolType);
        return AjaxResult.success("新增成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:tm:tooltype:remove')")
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable Long id) {
        tmToolTypeService.deleteById(id);
        return AjaxResult.success("删除成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:tm:tooltype:query')")
    @GetMapping("/{id}")
    public AjaxResult getBId(@PathVariable Long id) {
        TmToolType tmToolType = tmToolTypeService.selectById(id);
        return AjaxResult.success(tmToolType);
    }

    @PreAuthorize("@ss.hasPermi('mes:tm:tooltype:edit')")
    @PutMapping
    public AjaxResult update(@Validated @RequestBody TmToolType tmToolType) {
        tmToolTypeService.edit(tmToolType);
        return AjaxResult.success("修改成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:tm:tooltype:list')")
    @GetMapping("/listAll")
    public AjaxResult listAll() {
        return AjaxResult.success(tmToolTypeService.listAll());
    }


}
