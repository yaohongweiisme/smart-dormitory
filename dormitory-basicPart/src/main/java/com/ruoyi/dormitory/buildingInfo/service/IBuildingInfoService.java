package com.ruoyi.dormitory.buildingInfo.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.dormitory.buildingInfo.domain.BuildingInfo;

/**
 * 宿舍楼信息Service接口
 * 
 * @author ruoyi
 * @date 2023-01-22
 */
public interface IBuildingInfoService extends IService<BuildingInfo>
{
    /**
     * 查询宿舍楼信息
     * 
     * @param buildingId 宿舍楼信息主键
     * @return 宿舍楼信息
     */
    public BuildingInfo selectBuildingInfoByBuildingId(String buildingId);

    /**
     * 查询宿舍楼信息列表
     * 
     * @param buildingInfo 宿舍楼信息
     * @return 宿舍楼信息集合
     */
    public List<BuildingInfo> selectBuildingInfoList(BuildingInfo buildingInfo);

    /**
     * 新增宿舍楼信息
     * 
     * @param buildingInfo 宿舍楼信息
     * @return 结果
     */
    public int insertBuildingInfo(BuildingInfo buildingInfo);

    /**
     * 修改宿舍楼信息
     * 
     * @param buildingInfo 宿舍楼信息
     * @return 结果
     */
    public int updateBuildingInfo(BuildingInfo buildingInfo);

    /**
     * 批量删除宿舍楼信息
     * 
     * @param buildingIds 需要删除的宿舍楼信息主键集合
     * @return 结果
     */
    public int deleteBuildingInfoByBuildingIds(String buildingIds);

    /**
     * 删除宿舍楼信息信息
     * 
     * @param buildingId 宿舍楼信息主键
     * @return 结果
     */
    public int deleteBuildingInfoByBuildingId(String buildingId);
}
