package com.ruoyi.dormitoryRepair.buildingStaff.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.dormitoryRepair.buildingStaff.mapper.BuildingStaffMapper;
import com.ruoyi.dormitoryRepair.buildingStaff.domain.BuildingStaff;
import com.ruoyi.dormitoryRepair.buildingStaff.service.IBuildingStaffService;
import com.ruoyi.common.core.text.Convert;

/**
 * 物业人员信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-01-07
 */
@Service
public class BuildingStaffServiceImpl implements IBuildingStaffService 
{
    @Autowired
    private BuildingStaffMapper buildingStaffMapper;

    /**
     * 查询物业人员信息
     * 
     * @param id 物业人员信息主键
     * @return 物业人员信息
     */
    @Override
    public BuildingStaff selectBuildingStaffById(Long id)
    {
        return buildingStaffMapper.selectBuildingStaffById(id);
    }

    /**
     * 查询物业人员信息列表
     * 
     * @param buildingStaff 物业人员信息
     * @return 物业人员信息
     */
    @Override
    public List<BuildingStaff> selectBuildingStaffList(BuildingStaff buildingStaff)
    {
        return buildingStaffMapper.selectBuildingStaffList(buildingStaff);
    }

    /**
     * 新增物业人员信息
     * 
     * @param buildingStaff 物业人员信息
     * @return 结果
     */
    @Override
    public int insertBuildingStaff(BuildingStaff buildingStaff)
    {
        return buildingStaffMapper.insertBuildingStaff(buildingStaff);
    }

    /**
     * 修改物业人员信息
     * 
     * @param buildingStaff 物业人员信息
     * @return 结果
     */
    @Override
    public int updateBuildingStaff(BuildingStaff buildingStaff)
    {
        return buildingStaffMapper.updateBuildingStaff(buildingStaff);
    }

    /**
     * 批量删除物业人员信息
     * 
     * @param ids 需要删除的物业人员信息主键
     * @return 结果
     */
    @Override
    public int deleteBuildingStaffByIds(String ids)
    {
        return buildingStaffMapper.deleteBuildingStaffByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除物业人员信息信息
     * 
     * @param id 物业人员信息主键
     * @return 结果
     */
    @Override
    public int deleteBuildingStaffById(Long id)
    {
        return buildingStaffMapper.deleteBuildingStaffById(id);
    }
}
