package com.ruoyi.material.order.controller;

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
import com.ruoyi.material.order.domain.PurchaseOrder;
import com.ruoyi.material.order.service.IPurchaseOrderService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 物资采购单Controller
 * 
 * @author ruoyi
 * @date 2023-04-01
 */
@Controller
@RequestMapping("/material/order")
public class PurchaseOrderController extends BaseController
{
    private String prefix = "material/order";

    @Autowired
    private IPurchaseOrderService purchaseOrderService;

    @RequiresPermissions("material:order:view")
    @GetMapping()
    public String order()
    {
        return prefix + "/order";
    }

    /**
     * 查询物资采购单列表
     */
    @RequiresPermissions("material:order:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PurchaseOrder purchaseOrder)
    {
        startPage();
        List<PurchaseOrder> list = purchaseOrderService.selectPurchaseOrderList(purchaseOrder);
        return getDataTable(list);
    }

    /**
     * 导出物资采购单列表
     */
    @RequiresPermissions("material:order:export")
    @Log(title = "物资采购单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PurchaseOrder purchaseOrder)
    {
        List<PurchaseOrder> list = purchaseOrderService.selectPurchaseOrderList(purchaseOrder);
        ExcelUtil<PurchaseOrder> util = new ExcelUtil<PurchaseOrder>(PurchaseOrder.class);
        return util.exportExcel(list, "物资采购单数据");
    }

    /**
     * 新增物资采购单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存物资采购单
     */
    @RequiresPermissions("material:order:add")
    @Log(title = "物资采购单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PurchaseOrder purchaseOrder)
    {
        return toAjax(purchaseOrderService.insertPurchaseOrder(purchaseOrder));
    }

    /**
     * 修改物资采购单
     */
    @RequiresPermissions("material:order:edit")
    @GetMapping("/edit/{purchaseOrderId}")
    public String edit(@PathVariable("purchaseOrderId") Long purchaseOrderId, ModelMap mmap)
    {
        PurchaseOrder purchaseOrder = purchaseOrderService.selectPurchaseOrderByPurchaseOrderId(purchaseOrderId);
        mmap.put("purchaseOrder", purchaseOrder);
        return prefix + "/edit";
    }

    /**
     * 修改保存物资采购单
     */
    @RequiresPermissions("material:order:edit")
    @Log(title = "物资采购单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PurchaseOrder purchaseOrder)
    {
        return toAjax(purchaseOrderService.updatePurchaseOrder(purchaseOrder));
    }

    /**
     * 删除物资采购单
     */
    @RequiresPermissions("material:order:remove")
    @Log(title = "物资采购单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(purchaseOrderService.deletePurchaseOrderByPurchaseOrderIds(ids));
    }
}
