package com.ruoyi.dormitory.ocpRelationship.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.ruoyi.dormitory.ocpRelationship.domain.OccupancyRelationship;
import com.ruoyi.dormitory.ocpRelationship.service.IOccupancyRelationshipService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 宿舍入住关系Controller
 *
 * @author ruoyi
 * @date 2023-01-01
 */
@Controller
@RequestMapping("/dormitoryManager/occupancyRelationship" )
public class OccupancyRelationshipController extends BaseController {
    private String prefix = "dormitoryManager/occupancyRelationship";

    @Autowired
    private IOccupancyRelationshipService occupancyRelationshipService;

    @Autowired
    private IDormitoryService dormitoryService;

    //输入宿舍id得到可选床号
    @ResponseBody
    @GetMapping("/selectAvailableBedNumbers" )
    public List<Long> getBedNumberThatNotSelected(String dorId) {

        List<Long> bedNumbers = dormitoryService.selectAvailableBedNumbers(dorId);

        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        return bedNumbers;
    }

    @RequiresPermissions("dormitoryManager:occupancyRelationship:view" )
    @GetMapping()
    public String occupancyRelationship() {
        return prefix + "/occupancyRelationship";
    }

    /**
     * 查询宿舍入住关系列表
     */
    @RequiresPermissions("dormitoryManager:occupancyRelationship:list" )
    @PostMapping("/list" )
    @ResponseBody
    public TableDataInfo list(OccupancyRelationship occupancyRelationship) {
        startPage();
        List<OccupancyRelationship> list = occupancyRelationshipService.selectOccupancyRelationshipList(occupancyRelationship);
        return getDataTable(list);
    }

    /**
     * 导出宿舍入住关系列表
     */
    @RequiresPermissions("dormitoryManager:occupancyRelationship:export" )
    @Log(title = "宿舍入住关系" , businessType = BusinessType.EXPORT)
    @PostMapping("/export" )
    @ResponseBody
    public AjaxResult export(OccupancyRelationship occupancyRelationship) {
        List<OccupancyRelationship> list = occupancyRelationshipService.selectOccupancyRelationshipList(occupancyRelationship);
        ExcelUtil<OccupancyRelationship> util = new ExcelUtil<OccupancyRelationship>(OccupancyRelationship.class);
        return util.exportExcel(list, "宿舍入住关系数据" );
    }

    /**
     * 新增宿舍入住关系
     */
    @GetMapping("/add" )
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存宿舍入住关系
     */
    @RequiresPermissions("dormitoryManager:occupancyRelationship:add" )
    @Log(title = "宿舍入住关系" , businessType = BusinessType.INSERT)
    @PostMapping("/add" )
    @ResponseBody
    public AjaxResult addSave(OccupancyRelationship occupancyRelationship) {
//        System.out.println("表单提交的入住信息数据:"+occupancyRelationship.toString());
        boolean b = occupancyRelationshipService.checkIfLegalWhenAddOrUpdate(occupancyRelationship);
        if (b) {
            dormitoryService.addPresentNumber(occupancyRelationship);
        }
        return toAjax(occupancyRelationshipService.insertOccupancyRelationship(occupancyRelationship));
    }

    /**
     * 修改宿舍入住关系
     */
    @RequiresPermissions("dormitoryManager:occupancyRelationship:edit" )
    @GetMapping("/edit/{ocpId}" )
    public String edit(@PathVariable("ocpId" ) String ocpId, ModelMap mmap) {
        OccupancyRelationship occupancyRelationship = occupancyRelationshipService.selectOccupancyRelationshipByOcpId(ocpId);
        mmap.put("occupancyRelationship" , occupancyRelationship);
        return prefix + "/edit";
    }

    /**
     * 修改保存宿舍入住关系
     */
    @RequiresPermissions("dormitoryManager:occupancyRelationship:edit" )
    @Log(title = "宿舍入住关系" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit" )
    @ResponseBody
    public AjaxResult editSave(OccupancyRelationship occupancyRelationship) {
        occupancyRelationshipService.checkIfLegalWhenAddOrUpdate(occupancyRelationship);
        return toAjax(occupancyRelationshipService.updateOccupancyRelationship(occupancyRelationship));
    }

    /**
     * 删除宿舍入住关系
     */
    @RequiresPermissions("dormitoryManager:occupancyRelationship:remove" )
    @Log(title = "宿舍入住关系" , businessType = BusinessType.DELETE)
    @PostMapping("/remove" )
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(occupancyRelationshipService.deleteOccupancyRelationshipByOcpIds(ids));
    }
}
