package com.ruoyi.dormitory.ocpRelationship.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.dormitory.stuDormitory.domain.Dormitory;
import com.ruoyi.dormitory.stuDormitory.service.IDormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.dormitory.ocpRelationship.mapper.OccupancyRelationshipMapper;
import com.ruoyi.dormitory.ocpRelationship.domain.OccupancyRelationship;
import com.ruoyi.dormitory.ocpRelationship.service.IOccupancyRelationshipService;
import com.ruoyi.common.core.text.Convert;

/**
 * 宿舍入住关系Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-01-01
 */
@Service
public class OccupancyRelationshipServiceImpl  implements IOccupancyRelationshipService
{
    @Autowired
    private OccupancyRelationshipMapper occupancyRelationshipMapper;

    @Autowired
    private IDormitoryService dormitoryService;

    /**
     * 查询宿舍入住关系
     * 
     * @param ocpId 宿舍入住关系主键
     * @return 宿舍入住关系
     */
    @Override
    public OccupancyRelationship selectOccupancyRelationshipByOcpId(String ocpId)
    {
        return occupancyRelationshipMapper.selectOccupancyRelationshipByOcpId(ocpId);
    }

    /**
     * 查询宿舍入住关系列表
     * 
     * @param occupancyRelationship 宿舍入住关系
     * @return 宿舍入住关系
     */
    @Override
    public List<OccupancyRelationship> selectOccupancyRelationshipList(OccupancyRelationship occupancyRelationship)
    {
        return occupancyRelationshipMapper.selectOccupancyRelationshipList(occupancyRelationship);
    }

    /**
     * 新增宿舍入住关系
     * 
     * @param occupancyRelationship 宿舍入住关系
     * @return 结果
     */
    @Override
    public int insertOccupancyRelationship(OccupancyRelationship occupancyRelationship)
    {
        return occupancyRelationshipMapper.insertOccupancyRelationship(occupancyRelationship);
    }

    /**
     * 修改宿舍入住关系
     * 
     * @param occupancyRelationship 宿舍入住关系
     * @return 结果
     */
    @Override
    public int updateOccupancyRelationship(OccupancyRelationship occupancyRelationship)
    {
        return occupancyRelationshipMapper.updateOccupancyRelationship(occupancyRelationship);
    }

    /**
     * 批量删除宿舍入住关系
     * 
     * @param ocpIds 需要删除的宿舍入住关系主键
     * @return 结果
     */
    @Override
    public int deleteOccupancyRelationshipByOcpIds(String ocpIds)
    {
        return occupancyRelationshipMapper.deleteOccupancyRelationshipByOcpIds(Convert.toStrArray(ocpIds));
    }

    /**
     * 删除宿舍入住关系信息
     * 
     * @param ocpId 宿舍入住关系主键
     * @return 结果
     */
    @Override
    public int deleteOccupancyRelationshipByOcpId(String ocpId)
    {
        return occupancyRelationshipMapper.deleteOccupancyRelationshipByOcpId(ocpId);
    }

    @Override
    public boolean checkIfLegalWhenAddOrUpdate(OccupancyRelationship occupancyRelationship) {
        String dormitoryId = occupancyRelationship.getDormitoryId();
        Long bedNumber = occupancyRelationship.getBedNumber();
        Dormitory dormitory = dormitoryService.selectDormitoryByDorId(dormitoryId);
        if(dormitory==null){
            throw new RuntimeException("宿舍ID填写错误，不存在该宿舍！！！");
        }else {
            //先去查床号是否重复
            LambdaQueryWrapper<OccupancyRelationship> wrapper = new LambdaQueryWrapper<>();
            wrapper.and(i -> i.eq(OccupancyRelationship::getBedNumber,bedNumber).eq(OccupancyRelationship::getDormitoryId,dormitoryId));
            OccupancyRelationship ors = occupancyRelationshipMapper.selectOne(wrapper);
            if (ors!=null){
                throw new RuntimeException("该宿舍此床号已被入住！！！");
            }
            //验证床号是否存在
            Long capacity = dormitory.getCapacity();
            if(bedNumber>capacity){
                throw new RuntimeException("该宿舍此床号不存在！！！");
            }
        }

        return true;
    }
}
