package com.ktg.mes.md.controller.md;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktg.common.core.controller.BaseController;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.domain.md.MdItem;
import com.ktg.mes.md.service.IMdItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/8 13:25
 * @description mes
 */
@RequestMapping("/mes/md/mditem")
@RestController
public class MdItemController extends BaseController {

    @Autowired
    private IMdItemService mdItemService;

    @PreAuthorize("@ss.hasPermi('mes:md:mditem:list')")
    @GetMapping("/list")
    public AjaxResult list(@RequestParam(value = "pageNum", defaultValue = "1") int pageNUm,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                           @RequestParam(value = "itemTypeId", required = false) Long itemTypeId,
                           MdItem mdItem) {
        Page<MdItem> itemPage = mdItemService.listPage(mdItem, pageNUm, pageSize, itemTypeId);
        return AjaxResult.success(itemPage);
    }

    @PreAuthorize("@ss.hasPermi('mes:md:mditem:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody MdItem mdItem) {
        mdItemService.add(mdItem);
        return AjaxResult.success("新增成功");
    }
}
