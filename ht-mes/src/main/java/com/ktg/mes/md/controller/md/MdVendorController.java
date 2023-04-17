package com.ktg.mes.md.controller.md;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.domain.md.MdVendor;
import com.ktg.mes.md.service.IMdVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mes/md/vendor")
public class MdVendorController {
    @Autowired
    private IMdVendorService mdVendorService;

    @PreAuthorize("@ss.hasPermi('mes:md:vendor:list')")
    @GetMapping("/list")
    public AjaxResult list(MdVendor vendor, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Page<MdVendor> vendorPage = mdVendorService.selectVendorList(vendor, pageNum, pageSize);
        return AjaxResult.success(vendorPage);
    }

    @PreAuthorize("@ss.hasPermi('mes:md:vendor:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody MdVendor vendor) {
        mdVendorService.add(vendor);
        return AjaxResult.success("新增成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:md:vendor:remove')")
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable Long id) {
        mdVendorService.deleteById(id);
        return AjaxResult.success("删除成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:md:vendor:query')")
    @GetMapping("/{id}")
    public AjaxResult getById(@PathVariable Long id) {
        MdVendor vendor = mdVendorService.selectById(id);
        return AjaxResult.success(vendor);
    }

    @PreAuthorize("@ss.hasPermi('mes:md:vendor:edit')")
    @PutMapping
    public AjaxResult update(@Validated @RequestBody MdVendor vendor) {
        mdVendorService.edit(vendor);
        return AjaxResult.success("修改成功");
    }


}
