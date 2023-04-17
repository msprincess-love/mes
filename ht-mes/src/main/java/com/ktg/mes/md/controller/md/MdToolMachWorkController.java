package com.ktg.mes.md.controller.md;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.domain.dv.DvCheckSubject;
import com.ktg.mes.md.domain.md.MdItem;
import com.ktg.mes.md.domain.md.MdWorkstationMachine;
import com.ktg.mes.md.domain.md.MdWorkstationTool;
import com.ktg.mes.md.domain.md.MdWorkstationWorker;
import com.ktg.mes.md.service.IMdWorkstationMachineService;
import com.ktg.mes.md.service.IMdWorkstationToolService;
import com.ktg.mes.md.service.IMdWorkstationWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/15 13:38
 * @description mes
 */
@RestController
@RequestMapping("/mes/md")
public class MdToolMachWorkController {

    @Autowired
    private IMdWorkstationToolService workstationToolService;

    @Autowired
    private IMdWorkstationWorkerService workstationWorkerService;

    @Autowired
    private IMdWorkstationMachineService workstationMachineService;

    @PreAuthorize("@ss.hasPermi('mes:md:workstation:list')")
    @GetMapping("/workstationworker/list")
    public AjaxResult listWorkers(@RequestParam(value = "pageNum", defaultValue = "1") int pageNUm,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                           @RequestParam(value = "workstationId") Long workstationId) {
        Page<MdWorkstationWorker> itemPage = workstationWorkerService.listPage(pageNUm, pageSize, workstationId);
        return AjaxResult.success(itemPage);
    }

    @PreAuthorize("@ss.hasPermi('mes:md:workstation:list')")
    @GetMapping("/workstationmachine/list")
    public AjaxResult listMachines(@RequestParam(value = "pageNum", defaultValue = "1") int pageNUm,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                           @RequestParam(value = "workstationId") Long workstationId) {
        Page<MdWorkstationMachine> itemPage = workstationMachineService.listPage(pageNUm, pageSize, workstationId);
        return AjaxResult.success(itemPage);
    }

    @PreAuthorize("@ss.hasPermi('mes:md:workstation:list')")
    @GetMapping("/workstationtool/list")
    public AjaxResult lisTools(@RequestParam(value = "pageNum", defaultValue = "1") int pageNUm,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                           @RequestParam(value = "workstationId") Long workstationId) {
        Page<MdWorkstationTool> itemPage = workstationToolService.listPage( pageNUm, pageSize, workstationId);
        return AjaxResult.success(itemPage);
    }

    @PreAuthorize("@ss.hasPermi('mes:md:workstation:add')")
    @PostMapping("/workstationmachine")
    public AjaxResult addMachine(@Validated @RequestBody MdWorkstationMachine mdWorkstationMachine) {
        workstationMachineService.add(mdWorkstationMachine);
        return AjaxResult.success("新增成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:md:workstation:add')")
    @PostMapping("/workstationtool")
    public AjaxResult addTool(@Validated @RequestBody MdWorkstationTool mdWorkstationTool) {
        workstationToolService.add(mdWorkstationTool);
        return AjaxResult.success("新增成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:md:workstation:add')")
    @PostMapping("/workstationworker")
    public AjaxResult addWorker(@Validated @RequestBody MdWorkstationWorker workstationWorker) {
        workstationWorkerService.add(workstationWorker);
        return AjaxResult.success("新增成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:md:workstation:remove')")
    @DeleteMapping("//workstationmachine/{id}")
    public AjaxResult deleteMachine(@PathVariable Long id) {
        workstationMachineService.deleteById(id);
        return AjaxResult.success("删除成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:md:workstation:remove')")
    @DeleteMapping("//workstationtool/{id}")
    public AjaxResult deleteTool(@PathVariable Long id) {
        workstationToolService.deleteById(id);
        return AjaxResult.success("删除成功");
    }

    @PreAuthorize("@ss.hasPermi('mes:md:workstation:remove')")
    @DeleteMapping("//workstationworker/{id}")
    public AjaxResult deleteWorker(@PathVariable Long id) {
        workstationWorkerService.deleteById(id);
        return AjaxResult.success("删除成功");
    }

}
