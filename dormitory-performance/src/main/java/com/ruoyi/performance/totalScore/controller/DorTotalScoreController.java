package com.ruoyi.performance.totalScore.controller;

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
import com.ruoyi.performance.totalScore.domain.DorTotalScore;
import com.ruoyi.performance.totalScore.service.IDorTotalScoreService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 宿舍总分数Controller
 * 
 * @author ruoyi
 * @date 2023-03-11
 */
@Controller
@RequestMapping("/dormitoryPerformance/totalScore")
public class DorTotalScoreController extends BaseController
{
    private String prefix = "dormitoryPerformance/totalScore";

    @Autowired
    private IDorTotalScoreService dorTotalScoreService;

    @RequiresPermissions("dormitoryPerformance:totalScore:view")
    @GetMapping()
    public String totalScore()
    {
        return prefix + "/totalScore";
    }

    /**
     * 查询宿舍总分数列表
     */
    @RequiresPermissions("dormitoryPerformance:totalScore:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DorTotalScore dorTotalScore)
    {
        startPage();
        List<DorTotalScore> list = dorTotalScoreService.selectDorTotalScoreList(dorTotalScore);
        return getDataTable(list);
    }

    /**
     * 导出宿舍总分数列表
     */
    @RequiresPermissions("dormitoryPerformance:totalScore:export")
    @Log(title = "宿舍总分数", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DorTotalScore dorTotalScore)
    {
        List<DorTotalScore> list = dorTotalScoreService.selectDorTotalScoreList(dorTotalScore);
        ExcelUtil<DorTotalScore> util = new ExcelUtil<DorTotalScore>(DorTotalScore.class);
        return util.exportExcel(list, "宿舍总分数数据");
    }

    /**
     * 新增宿舍总分数
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存宿舍总分数
     */
    @RequiresPermissions("dormitoryPerformance:totalScore:add")
    @Log(title = "宿舍总分数", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DorTotalScore dorTotalScore)
    {
        return toAjax(dorTotalScoreService.insertDorTotalScore(dorTotalScore));
    }

    /**
     * 修改宿舍总分数
     */
    @RequiresPermissions("dormitoryPerformance:totalScore:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        DorTotalScore dorTotalScore = dorTotalScoreService.selectDorTotalScoreById(id);
        mmap.put("dorTotalScore", dorTotalScore);
        return prefix + "/edit";
    }

    /**
     * 修改保存宿舍总分数
     */
    @RequiresPermissions("dormitoryPerformance:totalScore:edit")
    @Log(title = "宿舍总分数", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DorTotalScore dorTotalScore)
    {
        return toAjax(dorTotalScoreService.updateDorTotalScore(dorTotalScore));
    }

    /**
     * 删除宿舍总分数
     */
    @RequiresPermissions("dormitoryPerformance:totalScore:remove")
    @Log(title = "宿舍总分数", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dorTotalScoreService.deleteDorTotalScoreByIds(ids));
    }
}
