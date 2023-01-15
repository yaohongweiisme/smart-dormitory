package com.ruoyi.dormitoryRepair.maintenanceForm.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.dormitoryRepair.maintenanceForm.domain.MaintenanceForm;

/**
 * 报修管理Mapper接口
 * 
 * @author ruoyi
 * @date 2023-01-07
 */
public interface MaintenanceFormMapper extends BaseMapper<MaintenanceForm>
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
     * 删除报修管理
     * 
     * @param id 报修管理主键
     * @return 结果
     */
    public int deleteMaintenanceFormById(Long id);

    /**
     * 批量删除报修管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMaintenanceFormByIds(String[] ids);
}
