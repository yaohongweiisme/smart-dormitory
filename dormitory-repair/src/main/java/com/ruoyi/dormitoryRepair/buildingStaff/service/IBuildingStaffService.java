package com.ruoyi.dormitoryRepair.buildingStaff.service;

import java.util.List;
import com.ruoyi.dormitoryRepair.buildingStaff.domain.BuildingStaff;

/**
 * 物业人员信息Service接口
 * 
 * @author ruoyi
 * @date 2023-01-07
 */
public interface IBuildingStaffService 
{
    /**
     * 查询物业人员信息
     * 
     * @param id 物业人员信息主键
     * @return 物业人员信息
     */
    public BuildingStaff selectBuildingStaffById(Long id);

    /**
     * 查询物业人员信息列表
     * 
     * @param buildingStaff 物业人员信息
     * @return 物业人员信息集合
     */
    public List<BuildingStaff> selectBuildingStaffList(BuildingStaff buildingStaff);

    /**
     * 新增物业人员信息
     * 
     * @param buildingStaff 物业人员信息
     * @return 结果
     */
    public int insertBuildingStaff(BuildingStaff buildingStaff);

    /**
     * 修改物业人员信息
     * 
     * @param buildingStaff 物业人员信息
     * @return 结果
     */
    public int updateBuildingStaff(BuildingStaff buildingStaff);

    /**
     * 批量删除物业人员信息
     * 
     * @param ids 需要删除的物业人员信息主键集合
     * @return 结果
     */
    public int deleteBuildingStaffByIds(String ids);

    /**
     * 删除物业人员信息信息
     * 
     * @param id 物业人员信息主键
     * @return 结果
     */
    public int deleteBuildingStaffById(Long id);
}
