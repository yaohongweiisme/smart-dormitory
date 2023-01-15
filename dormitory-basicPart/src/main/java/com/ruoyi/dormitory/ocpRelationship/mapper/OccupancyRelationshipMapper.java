package com.ruoyi.dormitory.ocpRelationship.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.dormitory.ocpRelationship.domain.OccupancyRelationship;
import org.apache.ibatis.annotations.Mapper;

/**
 * 宿舍入住关系Mapper接口
 * 
 * @author ruoyi
 * @date 2023-01-01
 */
@Mapper
public interface OccupancyRelationshipMapper extends BaseMapper<OccupancyRelationship>
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
     * 删除宿舍入住关系
     * 
     * @param ocpId 宿舍入住关系主键
     * @return 结果
     */
    public int deleteOccupancyRelationshipByOcpId(String ocpId);

    /**
     * 批量删除宿舍入住关系
     * 
     * @param ocpIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOccupancyRelationshipByOcpIds(String[] ocpIds);
}
