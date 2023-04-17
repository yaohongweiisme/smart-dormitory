package com.ruoyi.dormitory.buildingInfo.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.dormitory.buildingInfo.domain.BuildingInfo;
import com.ruoyi.dormitory.buildingInfo.service.IBuildingInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 宿舍楼信息Controller
 * 
 * @author ruoyi
 * @date 2023-01-22
 */
@Controller
@RequestMapping("/dormitoryManager/buildingInfo")
public class BuildingInfoController extends BaseController
{
    private String prefix = "dormitoryManager/buildingInfo";

    @Autowired
    private IBuildingInfoService buildingInfoService;

    @RequiresPermissions("dormitoryManager:buildingInfo:view")
    @GetMapping()
    public String buildingInfo()
    {
        return prefix + "/buildingInfo";
    }

    /**
     * 查询宿舍楼信息列表
     */
    @RequiresPermissions("dormitoryManager:buildingInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BuildingInfo buildingInfo)
    {
        startPage();
        List<BuildingInfo> list = buildingInfoService.selectBuildingInfoList(buildingInfo);
        return getDataTable(list);
    }

    /**
     * 导出宿舍楼信息列表
     */
    @RequiresPermissions("dormitoryManager:buildingInfo:export")
    @Log(title = "宿舍楼信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BuildingInfo buildingInfo)
    {
        List<BuildingInfo> list = buildingInfoService.selectBuildingInfoList(buildingInfo);
        ExcelUtil<BuildingInfo> util = new ExcelUtil<BuildingInfo>(BuildingInfo.class);
        return util.exportExcel(list, "宿舍楼信息数据");
    }

    /**
     * 新增宿舍楼信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存宿舍楼信息
     */
    @RequiresPermissions("dormitoryManager:buildingInfo:add")
    @Log(title = "宿舍楼信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BuildingInfo buildingInfo)
    {
        return toAjax(buildingInfoService.insertBuildingInfo(buildingInfo));
    }

    /**
     * 修改宿舍楼信息
     */
    @RequiresPermissions("dormitoryManager:buildingInfo:edit")
    @GetMapping("/edit/{buildingId}")
    public String edit(@PathVariable("buildingId") String buildingId, ModelMap mmap)
    {
        BuildingInfo buildingInfo = buildingInfoService.selectBuildingInfoByBuildingId(buildingId);
        mmap.put("buildingInfo", buildingInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存宿舍楼信息
     */
    @RequiresPermissions("dormitoryManager:buildingInfo:edit")
    @Log(title = "宿舍楼信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BuildingInfo buildingInfo)
    {
        return toAjax(buildingInfoService.updateBuildingInfo(buildingInfo));
    }

    /**
     * 删除宿舍楼信息
     */
    @RequiresPermissions("dormitoryManager:buildingInfo:remove")
    @Log(title = "宿舍楼信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(buildingInfoService.deleteBuildingInfoByBuildingIds(ids));
    }
}
