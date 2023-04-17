package com.ruoyi.material.apply.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.dormitoryRepair.buildingStaff.domain.BuildingStaff;
import com.ruoyi.dormitoryRepair.buildingStaff.service.IBuildingStaffService;
import com.ruoyi.material.apply.domain.MaterialApply;
import com.ruoyi.material.apply.service.IMaterialApplyService;
import com.ruoyi.material.inventory.domain.MaterialInventory;
import com.ruoyi.material.inventory.service.IMaterialInventoryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 物资申领Controller
 * 
 * @author ruoyi
 * @date 2023-04-14
 */
@Controller
@RequestMapping("/material/apply")
public class MaterialApplyController extends BaseController
{
    private String prefix = "material/apply";

    @Autowired
    private IMaterialApplyService materialApplyService;
    @Autowired
    private IMaterialInventoryService inventoryService;
    @Autowired
    private IBuildingStaffService buildingStaffService;

    @RequiresPermissions("material:apply:view")
    @GetMapping()
    public String apply(ModelMap map)
    {
        List<BuildingStaff> buildingStaffs = buildingStaffService.selectBuildingStaffList(null);
        map.put("buildingStaffs",buildingStaffs);
        List<MaterialInventory> inventories = inventoryService.selectMaterialInventoryList(null);
        map.put("inventories",inventories);
        return prefix + "/apply";
    }

    /**
     * 查询物资申领列表
     */
    @RequiresPermissions("material:apply:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MaterialApply materialApply)
    {
        startPage();
        List<MaterialApply> list = materialApplyService.selectMaterialApplyList(materialApply);
        return getDataTable(list);
    }

    /**
     * 导出物资申领列表
     */
    @RequiresPermissions("material:apply:export")
    @Log(title = "物资申领", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MaterialApply materialApply)
    {
        List<MaterialApply> list = materialApplyService.selectMaterialApplyList(materialApply);
        ExcelUtil<MaterialApply> util = new ExcelUtil<MaterialApply>(MaterialApply.class);
        return util.exportExcel(list, "物资申领数据");
    }

    /**
     * 新增物资申领
     */
    @GetMapping("/add")
    public String add(ModelMap map)
    {
        List<MaterialInventory> inventories = inventoryService.selectMaterialInventoryList(null);
        map.put("inventories",inventories);
        return prefix + "/add";
    }

    /**
     * 新增保存物资申领
     */
    @RequiresPermissions("material:apply:add")
    @Log(title = "物资申领", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MaterialApply materialApply)
    {
        return toAjax(materialApplyService.insertMaterialApply(materialApply));
    }

    /**
     * 修改物资申领
     */
    @RequiresPermissions("material:apply:edit")
    @GetMapping("/edit/{applicationId}")
    public String edit(@PathVariable("applicationId") Long applicationId, ModelMap map)
    {
        MaterialApply materialApply = materialApplyService.selectMaterialApplyByApplicationId(applicationId);
        map.put("materialApply", materialApply);
        List<BuildingStaff> buildingStaffs = buildingStaffService.selectBuildingStaffList(null);
        map.put("buildingStaffs",buildingStaffs);
        MaterialInventory material = inventoryService.getOne(new LambdaQueryWrapper<MaterialInventory>().eq(MaterialInventory::getMaterialId, materialApply.getMaterialId()));
        map.put("materialName",material.getName());
        return prefix + "/edit";
    }

    /**
     * 修改保存物资申领
     */
    @RequiresPermissions("material:apply:edit")
    @Log(title = "物资申领", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MaterialApply materialApply)
    {
        return toAjax(materialApplyService.updateMaterialApply(materialApply));
    }

    /**
     * 删除物资申领
     */
    @RequiresPermissions("material:apply:remove")
    @Log(title = "物资申领", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(materialApplyService.deleteMaterialApplyByApplicationIds(ids));
    }
}
