package com.ruoyi.performance.dailyScoreChange.controller;

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
import com.ruoyi.performance.dailyScoreChange.domain.DorDailyScoreChange;
import com.ruoyi.performance.dailyScoreChange.service.IDorDailyScoreChangeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 宿舍每日分数浮动Controller
 * 
 * @author ruoyi
 * @date 2023-03-20
 */
@Controller
@RequestMapping("/dormitoryPerformance/dailyScoreChange")
public class DorDailyScoreChangeController extends BaseController
{
    private String prefix = "dormitoryPerformance/dailyScoreChange";

    @Autowired
    private IDorDailyScoreChangeService dorDailyScoreChangeService;

    @RequiresPermissions("dormitoryPerformance:dailyScoreChange:view")
    @GetMapping()
    public String dailyScoreChange()
    {
        return prefix + "/dailyScoreChange";
    }

    /**
     * 查询宿舍每日分数浮动列表
     */
    @RequiresPermissions("dormitoryPerformance:dailyScoreChange:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DorDailyScoreChange dorDailyScoreChange)
    {
        startPage();
        List<DorDailyScoreChange> list = dorDailyScoreChangeService.selectDorDailyScoreChangeList(dorDailyScoreChange);
        return getDataTable(list);
    }

    /**
     * 导出宿舍每日分数浮动列表
     */
    @RequiresPermissions("dormitoryPerformance:dailyScoreChange:export")
    @Log(title = "宿舍每日分数浮动", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DorDailyScoreChange dorDailyScoreChange)
    {
        List<DorDailyScoreChange> list = dorDailyScoreChangeService.selectDorDailyScoreChangeList(dorDailyScoreChange);
        ExcelUtil<DorDailyScoreChange> util = new ExcelUtil<DorDailyScoreChange>(DorDailyScoreChange.class);
        return util.exportExcel(list, "宿舍每日分数浮动数据");
    }

    /**
     * 新增宿舍每日分数浮动
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存宿舍每日分数浮动
     */
    @RequiresPermissions("dormitoryPerformance:dailyScoreChange:add")
    @Log(title = "宿舍每日分数浮动", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DorDailyScoreChange dorDailyScoreChange)
    {
        return toAjax(dorDailyScoreChangeService.insertDorDailyScoreChange(dorDailyScoreChange));
    }

    /**
     * 修改宿舍每日分数浮动
     */
    @RequiresPermissions("dormitoryPerformance:dailyScoreChange:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        DorDailyScoreChange dorDailyScoreChange = dorDailyScoreChangeService.selectDorDailyScoreChangeById(id);
        mmap.put("dorDailyScoreChange", dorDailyScoreChange);
        return prefix + "/edit";
    }

    /**
     * 修改保存宿舍每日分数浮动
     */
    @RequiresPermissions("dormitoryPerformance:dailyScoreChange:edit")
    @Log(title = "宿舍每日分数浮动", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DorDailyScoreChange dorDailyScoreChange)
    {
        return toAjax(dorDailyScoreChangeService.updateDorDailyScoreChange(dorDailyScoreChange));
    }

    /**
     * 删除宿舍每日分数浮动
     */
    @RequiresPermissions("dormitoryPerformance:dailyScoreChange:remove")
    @Log(title = "宿舍每日分数浮动", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dorDailyScoreChangeService.deleteDorDailyScoreChangeByIds(ids));
    }
}
