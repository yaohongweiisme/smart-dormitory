package com.ruoyi.dormitoryRepair.buildingStaff.controller;

import java.util.List;
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
import com.ruoyi.dormitoryRepair.buildingStaff.domain.BuildingStaff;
import com.ruoyi.dormitoryRepair.buildingStaff.service.IBuildingStaffService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 物业人员信息Controller
 * 
 * @author ruoyi
 * @date 2023-01-07
 */
@Controller
@RequestMapping("/DormitoryRepairManager/buildingStaff")
public class BuildingStaffController extends BaseController
{
    private String prefix = "DormitoryRepairManager/buildingStaff";

    @Autowired
    private IBuildingStaffService buildingStaffService;


    @RequiresPermissions("DormitoryRepairManager:buildingStaff:view")
    @GetMapping()
    public String buildingStaff()
    {
        return prefix + "/buildingStaff";
    }

    /**
     * 查询物业人员信息列表
     */
    @RequiresPermissions("DormitoryRepairManager:buildingStaff:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BuildingStaff buildingStaff)
    {
        startPage();
        List<BuildingStaff> list = buildingStaffService.selectBuildingStaffList(buildingStaff);
        return getDataTable(list);
    }

    /**
     * 导出物业人员信息列表
     */
    @RequiresPermissions("DormitoryRepairManager:buildingStaff:export")
    @Log(title = "物业人员信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BuildingStaff buildingStaff)
    {
        List<BuildingStaff> list = buildingStaffService.selectBuildingStaffList(buildingStaff);
        ExcelUtil<BuildingStaff> util = new ExcelUtil<BuildingStaff>(BuildingStaff.class);
        return util.exportExcel(list, "物业人员信息数据");
    }

    /**
     * 新增物业人员信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存物业人员信息
     */
    @RequiresPermissions("DormitoryRepairManager:buildingStaff:add")
    @Log(title = "物业人员信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BuildingStaff buildingStaff)
    {
        return toAjax(buildingStaffService.insertBuildingStaff(buildingStaff));
    }

    /**
     * 修改物业人员信息
     */
    @RequiresPermissions("DormitoryRepairManager:buildingStaff:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        BuildingStaff buildingStaff = buildingStaffService.selectBuildingStaffById(id);
        mmap.put("buildingStaff", buildingStaff);

        return prefix + "/edit";
    }

    /**
     * 修改保存物业人员信息
     */
    @RequiresPermissions("DormitoryRepairManager:buildingStaff:edit")
    @Log(title = "物业人员信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BuildingStaff buildingStaff)
    {
        return toAjax(buildingStaffService.updateBuildingStaff(buildingStaff));
    }

    /**
     * 删除物业人员信息
     */
    @RequiresPermissions("DormitoryRepairManager:buildingStaff:remove")
    @Log(title = "物业人员信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(buildingStaffService.deleteBuildingStaffByIds(ids));
    }
}
