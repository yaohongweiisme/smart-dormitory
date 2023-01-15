package com.ruoyi.dormitoryRepair.maintenanceForm.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.dormitoryRepair.buildingStaff.domain.BuildingStaff;
import com.ruoyi.dormitoryRepair.buildingStaff.service.IBuildingStaffService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.dormitoryRepair.maintenanceForm.domain.MaintenanceForm;
import com.ruoyi.dormitoryRepair.maintenanceForm.service.IMaintenanceFormService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 报修管理Controller
 * 
 * @author ruoyi
 * @date 2023-01-07
 */
@Controller
@RequestMapping("/DormitoryRepairManager/maintenanceForm")
public class MaintenanceFormController extends BaseController
{
    private String prefix = "DormitoryRepairManager/maintenanceForm";

    @Autowired
    private IMaintenanceFormService maintenanceFormService;

    @Autowired
    private IBuildingStaffService buildingStaffService;

    @RequiresPermissions("DormitoryRepairManager:maintenanceForm:view")
    @GetMapping()
    public String maintenanceForm()
    {
        return prefix + "/maintenanceForm";
    }

    /**
     * 查询报修管理列表
     */
    @RequiresPermissions("DormitoryRepairManager:maintenanceForm:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MaintenanceForm maintenanceForm)
    {
        startPage();
        List<MaintenanceForm> list = maintenanceFormService.selectMaintenanceFormList(maintenanceForm);
        return getDataTable(list);
    }

    /**
     * 导出报修管理列表
     */
    @RequiresPermissions("DormitoryRepairManager:maintenanceForm:export")
    @Log(title = "报修管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MaintenanceForm maintenanceForm)
    {
        List<MaintenanceForm> list = maintenanceFormService.selectMaintenanceFormList(maintenanceForm);
        ExcelUtil<MaintenanceForm> util = new ExcelUtil<MaintenanceForm>(MaintenanceForm.class);
        return util.exportExcel(list, "报修管理数据");
    }

    /**
     * 新增报修管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存报修管理
     */
    @RequiresPermissions("DormitoryRepairManager:maintenanceForm:add")
    @Log(title = "报修管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MaintenanceForm maintenanceForm)
    {
        return toAjax(maintenanceFormService.insertMaintenanceForm(maintenanceForm));
    }

    /**
     * 修改报修管理
     */
    @RequiresPermissions("DormitoryRepairManager:maintenanceForm:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        MaintenanceForm maintenanceForm = maintenanceFormService.selectMaintenanceFormById(id);
        mmap.put("maintenanceForm", maintenanceForm);
        List<BuildingStaff> buildingStaffs = buildingStaffService.selectBuildingStaffList(null);
        List<String> strings = buildingStaffs.stream().map(item -> {
            return item.getName();
        }).collect(Collectors.toList());
        mmap.put("buildingStaffs",strings);
        return prefix + "/edit";
    }

    /**
     * 修改保存报修管理
     */
    @RequiresPermissions("DormitoryRepairManager:maintenanceForm:edit")
    @Log(title = "报修管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MaintenanceForm maintenanceForm)
    {
        return toAjax(maintenanceFormService.updateMaintenanceForm(maintenanceForm));
    }

    /**
     * 删除报修管理
     */
    @RequiresPermissions("DormitoryRepairManager:maintenanceForm:remove")
    @Log(title = "报修管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(maintenanceFormService.deleteMaintenanceFormByIds(ids));
    }
}
