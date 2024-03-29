package com.ruoyi.dormitory.stuDormitory.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.dormitory.buildingInfo.service.IBuildingInfoService;
import com.ruoyi.dormitory.stuDormitory.domain.Dormitory;
import com.ruoyi.dormitory.stuDormitory.service.IDormitoryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 学生宿舍信息Controller
 * 
 * @author ruoyi
 * @date 2023-01-08
 */
@Controller
@RequestMapping("/dormitoryManager/stuDormitory")
public class DormitoryController extends BaseController
{
    private String prefix = "dormitoryManager/stuDormitory";

    @Autowired
    private IDormitoryService dormitoryService;
    @Autowired
    private IBuildingInfoService buildingInfoService;

    @RequiresPermissions("dormitoryManager:stuDormitory:view")
    @GetMapping()
    public String stuDormitory(ModelMap map)
    {
        map.put("buildings",buildingInfoService.selectBuildingInfoList(null));
        return prefix + "/stuDormitory";
    }

    //通过宿舍楼号寻找旗下宿舍号
    @GetMapping("/getDorIdByBuildId")
    @ResponseBody
    public Map<String, Object> getDorByBuildId(String buildingId) {

        List<String> dorIds=dormitoryService.getDorByBuildId(buildingId);
        Map<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("dorIds",dorIds);
        stringObjectHashMap.put("code",dorIds==null?500:200);
        return stringObjectHashMap;
    }

    /**
     * 查询学生宿舍信息列表
     */
    @RequiresPermissions("dormitoryManager:stuDormitory:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Dormitory dormitory)
    {
        startPage();
        List<Dormitory> list = dormitoryService.selectDormitoryList(dormitory);
        System.out.println("list是多少:"+list.toString());
        return getDataTable(list);
    }

    /**
     * 导出学生宿舍信息列表
     */
    @RequiresPermissions("dormitoryManager:stuDormitory:export")
    @Log(title = "学生宿舍信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Dormitory dormitory)
    {
        List<Dormitory> list = dormitoryService.selectDormitoryList(dormitory);
        ExcelUtil<Dormitory> util = new ExcelUtil<Dormitory>(Dormitory.class);
        return util.exportExcel(list, "学生宿舍信息数据");
    }

    /**
     * 新增学生宿舍信息
     */
    @GetMapping("/add")
    public String add(ModelMap map)
    {
        map.put("buildings",buildingInfoService.selectBuildingInfoList(null));
        return prefix + "/add";
    }

    /**
     * 新增保存学生宿舍信息
     */
    @RequiresPermissions("dormitoryManager:stuDormitory:add")
    @Log(title = "学生宿舍信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Dormitory dormitory)
    {
        return toAjax(dormitoryService.insertDormitory(dormitory));
    }

    /**
     * 修改学生宿舍信息
     */
    @RequiresPermissions("dormitoryManager:stuDormitory:edit")
    @GetMapping("/edit/{dorId}")
    public String edit(@PathVariable("dorId") String dorId, ModelMap mmap)
    {
        Dormitory dormitory = dormitoryService.selectDormitoryByDorId(dorId);
        mmap.put("dormitory", dormitory);
        mmap.put("buildings",buildingInfoService.selectBuildingInfoList(null));
        return prefix + "/edit";
    }

    /**
     * 修改保存学生宿舍信息
     */
    @RequiresPermissions("dormitoryManager:stuDormitory:edit")
    @Log(title = "学生宿舍信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Dormitory dormitory)
    {
        return toAjax(dormitoryService.updateDormitory(dormitory));
    }

    /**
     * 删除学生宿舍信息
     */
    @RequiresPermissions("dormitoryManager:stuDormitory:remove")
    @Log(title = "学生宿舍信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dormitoryService.deleteDormitoryByDorIds(ids));
    }
}
