package com.ruoyi.payment.statusManager.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ruoyi.payment.projectManager.domain.PaymentProject;
import com.ruoyi.payment.projectManager.service.IPaymentProjectService;
import com.ruoyi.payment.statusManager.vo.PaymentStatusVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
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
import com.ruoyi.payment.statusManager.domain.PaymentStatus;
import com.ruoyi.payment.statusManager.service.IPaymentStatusService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 缴费状态Controller
 * 
 * @author ruoyi
 * @date 2023-01-03
 */
@Controller
@RequestMapping("/dormitory-payment/statusManager")
public class PaymentStatusController extends BaseController
{
    private String prefix = "dormitory-payment/statusManager";

    @Autowired
    private IPaymentStatusService paymentStatusService;


    @RequiresPermissions("dormitory-payment:statusManager:view")
    @GetMapping()
    public String statusManager()
    {
        return prefix + "/statusManager";
    }

    /**
     * 查询缴费状态列表
     */
    @RequiresPermissions("dormitory-payment:statusManager:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PaymentStatus paymentStatus)
    {
        startPage();
        List<PaymentStatus> list = paymentStatusService.selectPaymentStatusList(paymentStatus);
        List<PaymentStatusVo> voList;
        voList=paymentStatusService.getVoList(list);
        System.out.println("voList是"+voList.toString());
        return getDataTable(voList);
    }

    /**
     * 导出缴费状态列表
     */
    @RequiresPermissions("dormitory-payment:statusManager:export")
    @Log(title = "缴费状态", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PaymentStatus paymentStatus)
    {
        List<PaymentStatus> list = paymentStatusService.selectPaymentStatusList(paymentStatus);
        ExcelUtil<PaymentStatus> util = new ExcelUtil<PaymentStatus>(PaymentStatus.class);
        return util.exportExcel(list, "缴费状态数据");
    }

    /**
     * 新增缴费状态
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存缴费状态
     */
    @RequiresPermissions("dormitory-payment:statusManager:add")
    @Log(title = "缴费状态", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PaymentStatus paymentStatus)
    {
        return toAjax(paymentStatusService.insertPaymentStatus(paymentStatus));
    }

    /**
     * 修改缴费状态
     */
    @RequiresPermissions("dormitory-payment:statusManager:edit")
    @GetMapping("/edit/{statusId}")
    public String edit(@PathVariable("statusId") Long statusId, ModelMap mmap)
    {
        PaymentStatus paymentStatus = paymentStatusService.selectPaymentStatusByStatusId(statusId);
        mmap.put("paymentStatus", paymentStatus);
        return prefix + "/edit";
    }

    /**
     * 修改保存缴费状态
     */
    @RequiresPermissions("dormitory-payment:statusManager:edit")
    @Log(title = "缴费状态", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PaymentStatus paymentStatus)
    {
        return toAjax(paymentStatusService.updatePaymentStatus(paymentStatus));
    }

    /**
     * 删除缴费状态
     */
    @RequiresPermissions("dormitory-payment:statusManager:remove")
    @Log(title = "缴费状态", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(paymentStatusService.deletePaymentStatusByStatusIds(ids));
    }
}
