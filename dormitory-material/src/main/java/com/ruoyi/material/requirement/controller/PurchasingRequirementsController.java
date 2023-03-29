package com.ruoyi.material.requirement.controller;

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
import com.ruoyi.material.requirement.domain.PurchasingRequirements;
import com.ruoyi.material.requirement.service.IPurchasingRequirementsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 物资采购需求Controller
 * 
 * @author ruoyi
 * @date 2023-03-28
 */
@Controller
@RequestMapping("/material-requirement/requirements")
public class PurchasingRequirementsController extends BaseController
{
    private String prefix = "material-requirement/requirements";

    @Autowired
    private IPurchasingRequirementsService purchasingRequirementsService;

    @RequiresPermissions("material-requirement:requirements:view")
    @GetMapping()
    public String requirements()
    {
        return prefix + "/requirements";
    }

    /**
     * 查询物资采购需求列表
     */
    @RequiresPermissions("material-requirement:requirements:list")
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
    @RequiresPermissions("material-requirement:requirements:export")
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
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存物资采购需求
     */
    @RequiresPermissions("material-requirement:requirements:add")
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
    @RequiresPermissions("material-requirement:requirements:edit")
    @GetMapping("/edit/{purchasingRequirementsId}")
    public String edit(@PathVariable("purchasingRequirementsId") Long purchasingRequirementsId, ModelMap mmap)
    {
        PurchasingRequirements purchasingRequirements = purchasingRequirementsService.selectPurchasingRequirementsByPurchasingRequirementsId(purchasingRequirementsId);
        mmap.put("purchasingRequirements", purchasingRequirements);
        return prefix + "/edit";
    }

    /**
     * 修改保存物资采购需求
     */
    @RequiresPermissions("material-requirement:requirements:edit")
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
    @RequiresPermissions("material-requirement:requirements:remove")
    @Log(title = "物资采购需求", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(purchasingRequirementsService.deletePurchasingRequirementsByPurchasingRequirementsIds(ids));
    }
}
