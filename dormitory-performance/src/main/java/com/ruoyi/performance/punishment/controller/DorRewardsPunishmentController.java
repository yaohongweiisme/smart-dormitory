package com.ruoyi.performance.punishment.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.performance.punishment.domain.DorRewardsPunishment;
import com.ruoyi.performance.punishment.service.IDorRewardsPunishmentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 宿舍奖惩活动Controller
 * 
 * @author ruoyi
 * @date 2023-03-31
 */
@Controller
@RequestMapping("/dormitoryPerformance/punishment")
public class DorRewardsPunishmentController extends BaseController
{
    private String prefix = "dormitoryPerformance/punishment";

    @Autowired
    private IDorRewardsPunishmentService dorRewardsPunishmentService;

    @RequiresPermissions("dormitoryPerformance:punishment:view")
    @GetMapping()
    public String punishment(ModelMap map)
    {
        map.put("buildings",dorRewardsPunishmentService.getAllBuilding());
        return prefix + "/punishment";
    }

    /**
     * 查询宿舍奖惩活动列表
     */
    @RequiresPermissions("dormitoryPerformance:punishment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DorRewardsPunishment dorRewardsPunishment)
    {
        startPage();
        List<DorRewardsPunishment> list = dorRewardsPunishmentService.selectDorRewardsPunishmentList(dorRewardsPunishment);
        return getDataTable(list);
    }

    /**
     * 导出宿舍奖惩活动列表
     */
    @RequiresPermissions("dormitoryPerformance:punishment:export")
    @Log(title = "宿舍奖惩活动", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DorRewardsPunishment dorRewardsPunishment)
    {
        List<DorRewardsPunishment> list = dorRewardsPunishmentService.selectDorRewardsPunishmentList(dorRewardsPunishment);
        ExcelUtil<DorRewardsPunishment> util = new ExcelUtil<DorRewardsPunishment>(DorRewardsPunishment.class);
        return util.exportExcel(list, "宿舍奖惩活动数据");
    }

    /**
     * 新增宿舍奖惩活动
     */
    @GetMapping("/add")
    public String add(ModelMap map)
    {
        map.put("buildings",dorRewardsPunishmentService.getAllBuilding());
        return prefix + "/add";
    }

    /**
     * 新增保存宿舍奖惩活动
     */
    @RequiresPermissions("dormitoryPerformance:punishment:add")
    @Log(title = "宿舍奖惩活动", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DorRewardsPunishment dorRewardsPunishment)
    {
        return toAjax(dorRewardsPunishmentService.insertDorRewardsPunishment(dorRewardsPunishment));
    }

    /**
     * 修改宿舍奖惩活动
     */
    @RequiresPermissions("dormitoryPerformance:punishment:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap map)
    {
        DorRewardsPunishment dorRewardsPunishment = dorRewardsPunishmentService.selectDorRewardsPunishmentById(id);
        map.put("dorRewardsPunishment", dorRewardsPunishment);
        map.put("buildings",dorRewardsPunishmentService.getAllBuilding());
        return prefix + "/edit";
    }

    /**
     * 修改保存宿舍奖惩活动
     */
    @RequiresPermissions("dormitoryPerformance:punishment:edit")
    @Log(title = "宿舍奖惩活动", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DorRewardsPunishment dorRewardsPunishment)
    {
        return toAjax(dorRewardsPunishmentService.updateDorRewardsPunishment(dorRewardsPunishment));
    }

    /**
     * 删除宿舍奖惩活动
     */
    @RequiresPermissions("dormitoryPerformance:punishment:remove")
    @Log(title = "宿舍奖惩活动", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dorRewardsPunishmentService.deleteDorRewardsPunishmentByIds(ids));
    }
}
