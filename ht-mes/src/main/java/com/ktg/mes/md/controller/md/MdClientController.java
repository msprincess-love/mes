package com.ktg.mes.md.controller.md;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.domain.md.MdClient;
import com.ktg.mes.md.service.IMdClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mes/md/client")
public class MdClientController {
    @Autowired
    private IMdClientService mdClientService;

    @PreAuthorize("@ss.hasPermi('mes:md:client:list')")
    @GetMapping("/list")
    public AjaxResult list(MdClient client, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Page<MdClient> mdClientPage = mdClientService.selectClientList(client, pageNum, pageSize);
        return AjaxResult.success(mdClientPage);
    }

    @PreAuthorize("@ss.hasPermi('mes:md:client:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody MdClient client) {
        mdClientService.add(client);
        return AjaxResult.success("新增成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:md:client:remove')")
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable Long id) {
        mdClientService.deleteById(id);
        return AjaxResult.success("删除成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:md:client:query')")
    @GetMapping("/{id}")
    public AjaxResult getById(@PathVariable Long id) {
        MdClient mdClient = mdClientService.selectById(id);
        return AjaxResult.success(mdClient);
    }

    @PreAuthorize("@ss.hasPermi('mes:md:client:edit')")
    @PutMapping
    public AjaxResult update(@Validated @RequestBody MdClient client) {
        mdClientService.edit(client);
        return AjaxResult.success("修改成功");
    }


}
