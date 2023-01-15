package com.ruoyi.dormitoryRepair.maintenanceForm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.dormitoryRepair.maintenanceForm.mapper.MaintenanceFormMapper;
import com.ruoyi.dormitoryRepair.maintenanceForm.domain.MaintenanceForm;
import com.ruoyi.dormitoryRepair.maintenanceForm.service.IMaintenanceFormService;
import com.ruoyi.common.core.text.Convert;

/**
 * 报修管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-01-07
 */
@Service
public class MaintenanceFormServiceImpl implements IMaintenanceFormService 
{
    @Autowired
    private MaintenanceFormMapper maintenanceFormMapper;

    /**
     * 查询报修管理
     * 
     * @param id 报修管理主键
     * @return 报修管理
     */
    @Override
    public MaintenanceForm selectMaintenanceFormById(Long id)
    {
        return maintenanceFormMapper.selectMaintenanceFormById(id);
    }

    /**
     * 查询报修管理列表
     * 
     * @param maintenanceForm 报修管理
     * @return 报修管理
     */
    @Override
    public List<MaintenanceForm> selectMaintenanceFormList(MaintenanceForm maintenanceForm)
    {
        return maintenanceFormMapper.selectMaintenanceFormList(maintenanceForm);
    }

    /**
     * 新增报修管理
     * 
     * @param maintenanceForm 报修管理
     * @return 结果
     */
    @Override
    public int insertMaintenanceForm(MaintenanceForm maintenanceForm)
    {
        return maintenanceFormMapper.insertMaintenanceForm(maintenanceForm);
    }

    /**
     * 修改报修管理
     * 
     * @param maintenanceForm 报修管理
     * @return 结果
     */
    @Override
    public int updateMaintenanceForm(MaintenanceForm maintenanceForm)
    {
        return maintenanceFormMapper.updateMaintenanceForm(maintenanceForm);
    }

    /**
     * 批量删除报修管理
     * 
     * @param ids 需要删除的报修管理主键
     * @return 结果
     */
    @Override
    public int deleteMaintenanceFormByIds(String ids)
    {
        return maintenanceFormMapper.deleteMaintenanceFormByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除报修管理信息
     * 
     * @param id 报修管理主键
     * @return 结果
     */
    @Override
    public int deleteMaintenanceFormById(Long id)
    {
        return maintenanceFormMapper.deleteMaintenanceFormById(id);
    }
}
