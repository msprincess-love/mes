package com.ktg.mes.md.controller.md;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.domain.md.MdWorkshop;
import com.ktg.mes.md.service.IMdWorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/9 17:11
 * @description mes
 */
@RestController
@RequestMapping("/mes/md/workshop")
public class MdWorkshopController {

    @Autowired
    private IMdWorkshopService mdWorkshopService;

    @PreAuthorize("@ss.hasPermi('mes:md:workshop:list')")
    @GetMapping("/list")
    public AjaxResult list(MdWorkshop workshop, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Page<MdWorkshop> workshopPage = mdWorkshopService.selectList(workshop, pageNum, pageSize);
        return AjaxResult.success(workshopPage);
    }

    @PreAuthorize("@ss.hasPermi('mes:md:workshop:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody MdWorkshop workshop) {
        mdWorkshopService.add(workshop);
        return AjaxResult.success("新增成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:md:workshop:remove')")
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable Long id) {
        mdWorkshopService.deleteById(id);
        return AjaxResult.success("删除成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:md:workshop:query')")
    @GetMapping("/{id}")
    public AjaxResult getById(@PathVariable Long id) {
        MdWorkshop workshop = mdWorkshopService.selectById(id);
        return AjaxResult.success(workshop);
    }

    @PreAuthorize("@ss.hasPermi('mes:md:workshop:edit')")
    @PutMapping
    public AjaxResult update(@Validated @RequestBody MdWorkshop workshop) {
        mdWorkshopService.edit(workshop);
        return AjaxResult.success("修改成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:md:workshop:list')")
    @GetMapping("/listAll")
    public AjaxResult listAll() {
        List<MdWorkshop> workshops = mdWorkshopService.listAll();
        return AjaxResult.success(workshops);
    }

}
