package com.ruoyi.material.inventory.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.material.inventory.domain.MaterialInventory;
import com.ruoyi.material.inventory.service.IMaterialInventoryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 物资库存Controller
 * 
 * @author ruoyi
 * @date 2023-03-28
 */
@Controller
@RequestMapping("/inventory/inventory")
public class MaterialInventoryController extends BaseController
{
    private String prefix = "inventory/inventory";

    @Autowired
    private IMaterialInventoryService materialInventoryService;

    @RequiresPermissions("inventory:inventory:view")
    @GetMapping()
    public String inventory()
    {
        return prefix + "/inventory";
    }

    /**
     * 查询物资库存列表
     */
    @RequiresPermissions("inventory:inventory:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MaterialInventory materialInventory)
    {
        startPage();
        List<MaterialInventory> list = materialInventoryService.selectMaterialInventoryList(materialInventory);
        return getDataTable(list);
    }

    /**
     * 导出物资库存列表
     */
    @RequiresPermissions("inventory:inventory:export")
    @Log(title = "物资库存", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MaterialInventory materialInventory)
    {
        List<MaterialInventory> list = materialInventoryService.selectMaterialInventoryList(materialInventory);
        ExcelUtil<MaterialInventory> util = new ExcelUtil<MaterialInventory>(MaterialInventory.class);
        return util.exportExcel(list, "物资库存数据");
    }

    /**
     * 新增物资库存
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存物资库存
     */
    @RequiresPermissions("inventory:inventory:add")
    @Log(title = "物资库存", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MaterialInventory materialInventory)
    {
        return toAjax(materialInventoryService.insertMaterialInventory(materialInventory));
    }

    /**
     * 修改物资库存
     */
    @RequiresPermissions("inventory:inventory:edit")
    @GetMapping("/edit/{materialId}")
    public String edit(@PathVariable("materialId") Long materialId, ModelMap mmap)
    {
        MaterialInventory materialInventory = materialInventoryService.selectMaterialInventoryByMaterialId(materialId);
        mmap.put("materialInventory", materialInventory);
        return prefix + "/edit";
    }

    /**
     * 修改保存物资库存
     */
    @RequiresPermissions("inventory:inventory:edit")
    @Log(title = "物资库存", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MaterialInventory materialInventory)
    {
        return toAjax(materialInventoryService.updateMaterialInventory(materialInventory));
    }

    /**
     * 删除物资库存
     */
    @RequiresPermissions("inventory:inventory:remove")
    @Log(title = "物资库存", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(materialInventoryService.deleteMaterialInventoryByMaterialIds(ids));
    }
}
