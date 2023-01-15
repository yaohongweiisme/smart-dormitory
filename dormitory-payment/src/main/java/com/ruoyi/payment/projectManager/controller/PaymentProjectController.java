package com.ruoyi.payment.projectManager.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.dormitory.stuDormitory.domain.Dormitory;
import com.ruoyi.dormitory.stuDormitory.service.IDormitoryService;
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
import com.ruoyi.payment.projectManager.domain.PaymentProject;
import com.ruoyi.payment.projectManager.service.IPaymentProjectService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 缴费项目管理Controller
 * 
 * @author ruoyi
 * @date 2023-01-03
 */
@Controller
@RequestMapping("/dormitory-payment/projectManager")
public class PaymentProjectController extends BaseController
{
    private String prefix = "dormitory-payment/projectManager";

    @Autowired
    private IPaymentProjectService paymentProjectService;

    @Autowired
    private IDormitoryService dormitoryService;

    @RequiresPermissions("dormitory-payment:projectManager:view")
    @GetMapping()
    public String projectManager()
    {
        return prefix + "/projectManager";
    }

    /**
     * 查询缴费项目管理列表
     */
    @RequiresPermissions("dormitory-payment:projectManager:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PaymentProject paymentProject)
    {
        startPage();
        List<PaymentProject> list = paymentProjectService.selectPaymentProjectList(paymentProject);
        return getDataTable(list);
    }

    /**
     * 导出缴费项目管理列表
     */
    @RequiresPermissions("dormitory-payment:projectManager:export")
    @Log(title = "缴费项目管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PaymentProject paymentProject)
    {
        List<PaymentProject> list = paymentProjectService.selectPaymentProjectList(paymentProject);
        ExcelUtil<PaymentProject> util = new ExcelUtil<PaymentProject>(PaymentProject.class);
        return util.exportExcel(list, "缴费项目管理数据");
    }

    /**
     * 新增缴费项目管理
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        List<Dormitory> dormitoryList = dormitoryService.selectDormitoryList(null);
        List<String> projectObject;
        projectObject= dormitoryService.getDormitoryBuilding(dormitoryList);
        mmap.put("projectObject",projectObject);
        return prefix + "/add";
    }

    /**
     * 新增保存缴费项目管理
     */
    @RequiresPermissions("dormitory-payment:projectManager:add")
    @Log(title = "缴费项目管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PaymentProject paymentProject)
    {
        return toAjax(paymentProjectService.insertPaymentProject(paymentProject));
    }

    /**
     * 修改缴费项目管理
     */
    @RequiresPermissions("dormitory-payment:projectManager:edit")
    @GetMapping("/edit/{projectId}")
    public String edit(@PathVariable("projectId") Long projectId, ModelMap mmap)
    {
        PaymentProject paymentProject = paymentProjectService.selectPaymentProjectByProjectId(projectId);
        mmap.put("paymentProject", paymentProject);
        return prefix + "/edit";
    }

    /**
     * 修改保存缴费项目管理
     */
    @RequiresPermissions("dormitory-payment:projectManager:edit")
    @Log(title = "缴费项目管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PaymentProject paymentProject)
    {
        return toAjax(paymentProjectService.updatePaymentProject(paymentProject));
    }

    /**
     * 删除缴费项目管理
     */
    @RequiresPermissions("dormitory-payment:projectManager:remove")
    @Log(title = "缴费项目管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(paymentProjectService.deletePaymentProjectByProjectIds(ids));
    }
}
