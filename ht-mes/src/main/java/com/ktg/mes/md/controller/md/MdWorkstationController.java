package com.ktg.mes.md.controller.md;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.domain.md.MdClient;
import com.ktg.mes.md.domain.md.MdWorkstation;
import com.ktg.mes.md.service.IMdWorkstationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/9 19:31
 * @description mes
 */
@RequestMapping("/mes/md/workstation")
@RestController
public class MdWorkstationController {

    @Autowired
    private IMdWorkstationService mdWorkstationService;

    @PreAuthorize("@ss.hasPermi('mes:md:workstation:list')")
    @GetMapping("/list")
    public AjaxResult list(MdWorkstation workstation, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Page<MdWorkstation> workstationPage = mdWorkstationService.selectList(workstation, pageNum, pageSize);
        return AjaxResult.success(workstationPage);
    }

    @PreAuthorize("@ss.hasPermi('mes:md:workstation:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody MdWorkstation workstation) {
        mdWorkstationService.add(workstation);
        return AjaxResult.success("新增成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:md:workstation:remove')")
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable Long id) {
        mdWorkstationService.deleteById(id);
        return AjaxResult.success("删除成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:md:workstation:query')")
    @GetMapping("/{id}")
    public AjaxResult getById(@PathVariable Long id) {
        MdWorkstation mdClient = mdWorkstationService.selectById(id);
        return AjaxResult.success(mdClient);
    }

    @PreAuthorize("@ss.hasPermi('mes:md:workstation:edit')")
    @PutMapping
    public AjaxResult update(@Validated @RequestBody MdWorkstation client) {
        mdWorkstationService.edit(client);
        return AjaxResult.success("修改成功");
    }
}
