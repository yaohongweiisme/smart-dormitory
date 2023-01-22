package com.ruoyi.dormitory.buildingInfo.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.dormitory.buildingInfo.mapper.BuildingInfoMapper;
import com.ruoyi.dormitory.buildingInfo.domain.BuildingInfo;
import com.ruoyi.dormitory.buildingInfo.service.IBuildingInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 宿舍楼信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-01-22
 */
@Service
public class BuildingInfoServiceImpl extends ServiceImpl<BuildingInfoMapper,BuildingInfo> implements IBuildingInfoService
{
    @Autowired
    private BuildingInfoMapper buildingInfoMapper;

    /**
     * 查询宿舍楼信息
     * 
     * @param buildingId 宿舍楼信息主键
     * @return 宿舍楼信息
     */
    @Override
    public BuildingInfo selectBuildingInfoByBuildingId(String buildingId)
    {
        return buildingInfoMapper.selectBuildingInfoByBuildingId(buildingId);
    }

    /**
     * 查询宿舍楼信息列表
     * 
     * @param buildingInfo 宿舍楼信息
     * @return 宿舍楼信息
     */
    @Override
    public List<BuildingInfo> selectBuildingInfoList(BuildingInfo buildingInfo)
    {
        return buildingInfoMapper.selectBuildingInfoList(buildingInfo);
    }

    /**
     * 新增宿舍楼信息
     * 
     * @param buildingInfo 宿舍楼信息
     * @return 结果
     */
    @Override
    public int insertBuildingInfo(BuildingInfo buildingInfo)
    {
        return buildingInfoMapper.insertBuildingInfo(buildingInfo);
    }

    /**
     * 修改宿舍楼信息
     * 
     * @param buildingInfo 宿舍楼信息
     * @return 结果
     */
    @Override
    public int updateBuildingInfo(BuildingInfo buildingInfo)
    {
        return buildingInfoMapper.updateBuildingInfo(buildingInfo);
    }

    /**
     * 批量删除宿舍楼信息
     * 
     * @param buildingIds 需要删除的宿舍楼信息主键
     * @return 结果
     */
    @Override
    public int deleteBuildingInfoByBuildingIds(String buildingIds)
    {
        return buildingInfoMapper.deleteBuildingInfoByBuildingIds(Convert.toStrArray(buildingIds));
    }

    /**
     * 删除宿舍楼信息信息
     * 
     * @param buildingId 宿舍楼信息主键
     * @return 结果
     */
    @Override
    public int deleteBuildingInfoByBuildingId(String buildingId)
    {
        return buildingInfoMapper.deleteBuildingInfoByBuildingId(buildingId);
    }
}
