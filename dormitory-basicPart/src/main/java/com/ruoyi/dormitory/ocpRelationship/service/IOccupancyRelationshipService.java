package com.ruoyi.dormitory.ocpRelationship.service;

import java.util.List;
import com.ruoyi.dormitory.ocpRelationship.domain.OccupancyRelationship;

/**
 * 宿舍入住关系Service接口
 * 
 * @author ruoyi
 * @date 2023-01-01
 */
public interface IOccupancyRelationshipService 
{
    /**
     * 查询宿舍入住关系
     * 
     * @param ocpId 宿舍入住关系主键
     * @return 宿舍入住关系
     */
    public OccupancyRelationship selectOccupancyRelationshipByOcpId(String ocpId);

    /**
     * 查询宿舍入住关系列表
     * 
     * @param occupancyRelationship 宿舍入住关系
     * @return 宿舍入住关系集合
     */
    public List<OccupancyRelationship> selectOccupancyRelationshipList(OccupancyRelationship occupancyRelationship);

    /**
     * 新增宿舍入住关系
     * 
     * @param occupancyRelationship 宿舍入住关系
     * @return 结果
     */
    public int insertOccupancyRelationship(OccupancyRelationship occupancyRelationship);

    /**
     * 修改宿舍入住关系
     * 
     * @param occupancyRelationship 宿舍入住关系
     * @return 结果
     */
    public int updateOccupancyRelationship(OccupancyRelationship occupancyRelationship);

    /**
     * 批量删除宿舍入住关系
     * 
     * @param ocpIds 需要删除的宿舍入住关系主键集合
     * @return 结果
     */
    public int deleteOccupancyRelationshipByOcpIds(String ocpIds);

    /**
     * 删除宿舍入住关系信息
     * 
     * @param ocpId 宿舍入住关系主键
     * @return 结果
     */
    public int deleteOccupancyRelationshipByOcpId(String ocpId);

    boolean checkIfLegalWhenAddOrUpdate(OccupancyRelationship occupancyRelationship);
}
