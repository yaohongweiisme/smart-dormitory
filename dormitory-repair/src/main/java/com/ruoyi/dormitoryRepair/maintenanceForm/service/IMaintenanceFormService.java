package com.ruoyi.dormitoryRepair.maintenanceForm.service;

import java.util.List;
import com.ruoyi.dormitoryRepair.maintenanceForm.domain.MaintenanceForm;

/**
 * 报修管理Service接口
 * 
 * @author ruoyi
 * @date 2023-01-07
 */
public interface IMaintenanceFormService 
{
    /**
     * 查询报修管理
     * 
     * @param id 报修管理主键
     * @return 报修管理
     */
    public MaintenanceForm selectMaintenanceFormById(Long id);

    /**
     * 查询报修管理列表
     * 
     * @param maintenanceForm 报修管理
     * @return 报修管理集合
     */
    public List<MaintenanceForm> selectMaintenanceFormList(MaintenanceForm maintenanceForm);

    /**
     * 新增报修管理
     * 
     * @param maintenanceForm 报修管理
     * @return 结果
     */
    public int insertMaintenanceForm(MaintenanceForm maintenanceForm);

    /**
     * 修改报修管理
     * 
     * @param maintenanceForm 报修管理
     * @return 结果
     */
    public int updateMaintenanceForm(MaintenanceForm maintenanceForm);

    /**
     * 批量删除报修管理
     * 
     * @param ids 需要删除的报修管理主键集合
     * @return 结果
     */
    public int deleteMaintenanceFormByIds(String ids);

    /**
     * 删除报修管理信息
     * 
     * @param id 报修管理主键
     * @return 结果
     */
    public int deleteMaintenanceFormById(Long id);
}
