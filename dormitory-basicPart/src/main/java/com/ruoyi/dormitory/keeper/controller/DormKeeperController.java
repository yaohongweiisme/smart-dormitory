package com.ruoyi.dormitory.keeper.controller;

import java.util.List;

import com.ruoyi.dormitory.buildingInfo.domain.BuildingInfo;
import com.ruoyi.dormitory.buildingInfo.service.IBuildingInfoService;
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
import com.ruoyi.dormitory.keeper.domain.DormKeeper;
import com.ruoyi.dormitory.keeper.service.IDormKeeperService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 宿管信息Controller
 * 
 * @author ruoyi
 * @date 2023-01-06
 */
@Controller
@RequestMapping("/dormitoryManager/keeper")
public class DormKeeperController extends BaseController
{
    private String prefix = "dormitoryManager/keeper";

    @Autowired
    private IDormKeeperService dormKeeperService;

    @Autowired
    private IBuildingInfoService buildingInfoService;

    @RequiresPermissions("dormitoryManager:keeper:view")
    @GetMapping()
    public String keeper()
    {
        return prefix + "/keeper";
    }

    /**
     * 查询宿管信息列表
     */
    @RequiresPermissions("dormitoryManager:keeper:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DormKeeper dormKeeper)
    {
        startPage();
        List<DormKeeper> list = dormKeeperService.selectDormKeeperList(dormKeeper);
        for (DormKeeper keeper : list) {
            System.out.println("宿管信息:"+keeper.toString());
        }
        return getDataTable(list);
    }

    /**
     * 导出宿管信息列表
     */
    @RequiresPermissions("dormitoryManager:keeper:export")
    @Log(title = "宿管信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DormKeeper dormKeeper)
    {
        List<DormKeeper> list = dormKeeperService.selectDormKeeperList(dormKeeper);
        ExcelUtil<DormKeeper> util = new ExcelUtil<DormKeeper>(DormKeeper.class);
        return util.exportExcel(list, "宿管信息数据");
    }

    /**
     * 新增宿管信息
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        List<BuildingInfo> dorBuilding;
        dorBuilding =buildingInfoService.selectBuildingInfoList(null);
        mmap.put("DorBuilding",dorBuilding);
        return prefix + "/add";
    }

    /**
     * 新增保存宿管信息
     */
    @RequiresPermissions("dormitoryManager:keeper:add")
    @Log(title = "宿管信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DormKeeper dormKeeper)
    {
        return toAjax(dormKeeperService.insertDormKeeper(dormKeeper));
    }

    /**
     * 修改宿管信息
     */
    @RequiresPermissions("dormitoryManager:keeper:edit")
    @GetMapping("/edit/{dkId}")
    public String edit(@PathVariable("dkId") Long dkId, ModelMap mmap)
    {
        DormKeeper dormKeeper = dormKeeperService.selectDormKeeperByDkId(dkId);
        mmap.put("dormKeeper", dormKeeper);
        return prefix + "/edit";
    }

    /**
     * 修改保存宿管信息
     */
    @RequiresPermissions("dormitoryManager:keeper:edit")
    @Log(title = "宿管信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DormKeeper dormKeeper)
    {
        return toAjax(dormKeeperService.updateDormKeeper(dormKeeper));
    }

    /**
     * 删除宿管信息
     */
    @RequiresPermissions("dormitoryManager:keeper:remove")
    @Log(title = "宿管信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dormKeeperService.deleteDormKeeperByDkIds(ids));
    }
}
