package com.ktg.mes.md.controller.md;

import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.domain.md.MdItemType;
import com.ktg.mes.md.service.IMdItemTypeService;
import com.ktg.mes.md.vo.MdItemTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/mes/md/itemtype")
public class MdItemTypeController {
    @Autowired
    private IMdItemTypeService mdItemTypeService;

    @PreAuthorize("@ss.hasPermi('mes:md:itemtype:list')")
    @GetMapping("/list")
    public AjaxResult list(MdItemType mdItemType) {
        List<MdItemType> mdItemTypes = mdItemTypeService.selectItemTypeList(mdItemType);
        return AjaxResult.success(mdItemTypes);
    }

    @PreAuthorize("@ss.hasPermi('mes:md:itemtype:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody MdItemType mdItemType) {
        mdItemTypeService.add(mdItemType);
        return AjaxResult.success("新增成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:md:itemtype:remove')")
    @DeleteMapping("/{typeId}")
    public AjaxResult delete(@PathVariable Long typeId) {
        mdItemTypeService.deleteById(typeId);
        return AjaxResult.success("删除成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:md:itemtype:query')")
    @GetMapping("/{typeId}")
    public AjaxResult getById(@PathVariable Long typeId) {
        MdItemType mdItemType = mdItemTypeService.selectItemTypeById(typeId);
        return AjaxResult.success(mdItemType);
    }

    @PreAuthorize("@ss.hasPermi('mes:md:itemtype:edit')")
    @PutMapping
    public AjaxResult update(@Validated @RequestBody MdItemType mdItemType) {
        mdItemTypeService.edit(mdItemType);
        return AjaxResult.success("修改成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:md:itemtype:list')")
    @GetMapping("/treeselect")
    public AjaxResult treeSelect() {
        List<MdItemTypeVo> mdItemTypeVos = mdItemTypeService.treeSelect();
        return AjaxResult.success(mdItemTypeVos);
    }
}
