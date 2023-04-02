package com.ruoyi.material.requirements.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.material.inventory.domain.MaterialInventory;
import com.ruoyi.material.inventory.service.IMaterialInventoryService;
import com.ruoyi.material.requirements.domain.PurchasingRequirements;
import com.ruoyi.material.requirements.service.IPurchasingRequirementsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 物资采购需求Controller
 * 
 * @author ruoyi
 * @date 2023-04-01
 */
@Controller
@RequestMapping("/material/requirements")
public class PurchasingRequirementsController extends BaseController
{
    private String prefix = "material/requirements";

    @Autowired
    private IPurchasingRequirementsService purchasingRequirementsService;
    @Autowired
    private IMaterialInventoryService materialInventoryService;

    @RequiresPermissions("material:requirements:view")
    @GetMapping()
    public String requirements(ModelMap map)
    {
        List<MaterialInventory> inventoryList = materialInventoryService.selectMaterialInventoryList(null);
        map.put("materials",inventoryList);
        return prefix + "/requirements";
    }

    /**
     * 查询物资采购需求列表
     */
    @RequiresPermissions("material:requirements:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PurchasingRequirements purchasingRequirements)
    {
        startPage();
        List<PurchasingRequirements> list = purchasingRequirementsService.selectPurchasingRequirementsList(purchasingRequirements);
        return getDataTable(list);
    }

    /**
     * 导出物资采购需求列表
     */
    @RequiresPermissions("material:requirements:export")
    @Log(title = "物资采购需求", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PurchasingRequirements purchasingRequirements)
    {
        List<PurchasingRequirements> list = purchasingRequirementsService.selectPurchasingRequirementsList(purchasingRequirements);
        ExcelUtil<PurchasingRequirements> util = new ExcelUtil<PurchasingRequirements>(PurchasingRequirements.class);
        return util.exportExcel(list, "物资采购需求数据");
    }

    /**
     * 新增物资采购需求
     */
    @GetMapping("/add")
    public String add(ModelMap map)
    {
        List<MaterialInventory> inventoryList = materialInventoryService.selectMaterialInventoryList(null);
        map.put("inventoryList",inventoryList);
        return prefix + "/add";
    }

    /**
     * 新增保存物资采购需求
     */
    @RequiresPermissions("material:requirements:add")
    @Log(title = "物资采购需求", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PurchasingRequirements purchasingRequirements)
    {
        return toAjax(purchasingRequirementsService.insertPurchasingRequirements(purchasingRequirements));
    }

    /**
     * 修改物资采购需求
     */
    @RequiresPermissions("material:requirements:edit")
    @GetMapping("/edit/{purchasingRequirementsId}")
    public String edit(@PathVariable("purchasingRequirementsId") Long purchasingRequirementsId, ModelMap mmap)
    {   List<MaterialInventory> inventoryList = materialInventoryService.selectMaterialInventoryList(null);
        mmap.put("materials",inventoryList);
        PurchasingRequirements purchasingRequirements = purchasingRequirementsService.selectPurchasingRequirementsByPurchasingRequirementsId(purchasingRequirementsId);
        mmap.put("purchasingRequirements", purchasingRequirements);
        return prefix + "/edit";
    }

    /**
     * 修改保存物资采购需求
     */
    @RequiresPermissions("material:requirements:edit")
    @Log(title = "物资采购需求", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PurchasingRequirements purchasingRequirements)
    {
        return toAjax(purchasingRequirementsService.updatePurchasingRequirements(purchasingRequirements));
    }

    /**
     * 删除物资采购需求
     */
    @RequiresPermissions("material:requirements:remove")
    @Log(title = "物资采购需求", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(purchasingRequirementsService.deletePurchasingRequirementsByPurchasingRequirementsIds(ids));
    }

    @RequiresPermissions("material:requirements:merge")
    @Log(title = "合并采购需求为采购单")
    @PostMapping( "/merge")
    @ResponseBody
    public AjaxResult mergeRequirements(String ids)
    {
        return toAjax(purchasingRequirementsService.mergeRequirements(ids));
    }
}
