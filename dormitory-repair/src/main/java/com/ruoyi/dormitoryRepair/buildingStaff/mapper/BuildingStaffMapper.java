package com.ruoyi.dormitoryRepair.buildingStaff.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.dormitoryRepair.buildingStaff.domain.BuildingStaff;

/**
 * 物业人员信息Mapper接口
 * 
 * @author ruoyi
 * @date 2023-01-07
 */
public interface BuildingStaffMapper extends BaseMapper<BuildingStaff>
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
     * 删除物业人员信息
     * 
     * @param id 物业人员信息主键
     * @return 结果
     */
    public int deleteBuildingStaffById(Long id);

    /**
     * 批量删除物业人员信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBuildingStaffByIds(String[] ids);
}
