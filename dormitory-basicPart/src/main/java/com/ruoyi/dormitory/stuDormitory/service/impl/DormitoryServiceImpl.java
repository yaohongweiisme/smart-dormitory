package com.ruoyi.dormitory.stuDormitory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.dormitory.buildingInfo.mapper.BuildingInfoMapper;
import com.ruoyi.dormitory.ocpRelationship.domain.OccupancyRelationship;
import com.ruoyi.dormitory.ocpRelationship.mapper.OccupancyRelationshipMapper;
import com.ruoyi.dormitory.stuDormitory.domain.Dormitory;
import com.ruoyi.dormitory.stuDormitory.mapper.DormitoryMapper;
import com.ruoyi.dormitory.stuDormitory.service.IDormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 学生宿舍信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-01-08
 */
@Service
public class DormitoryServiceImpl extends ServiceImpl<DormitoryMapper,Dormitory> implements IDormitoryService
{
    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Autowired
    private OccupancyRelationshipMapper occupancyRelationshipMapper;

    @Autowired
    private BuildingInfoMapper buildingInfoMapper;

    /**
     * 查询学生宿舍信息
     * 
     * @param dorId 学生宿舍信息主键
     * @return 学生宿舍信息
     */
    @Override
    public Dormitory selectDormitoryByDorId(String dorId)
    {
        return dormitoryMapper.selectDormitoryByDorId(dorId);
    }

    /**
     * 查询学生宿舍信息列表
     * 
     * @param dormitory 学生宿舍信息
     * @return 学生宿舍信息
     */
    @Override
    public List<Dormitory> selectDormitoryList(Dormitory dormitory)
    {
        return dormitoryMapper.selectDormitoryList(dormitory);
    }

    /**
     * 新增学生宿舍信息
     * 
     * @param dormitory 学生宿舍信息
     * @return 结果
     */
    @Override
    public int insertDormitory(Dormitory dormitory)
    {
        return dormitoryMapper.insertDormitory(dormitory);
    }

    /**
     * 修改学生宿舍信息
     * 
     * @param dormitory 学生宿舍信息
     * @return 结果
     */
    @Override
    public int updateDormitory(Dormitory dormitory)
    {
        return dormitoryMapper.updateDormitory(dormitory);
    }

    /**
     * 批量删除学生宿舍信息
     * 
     * @param dorIds 需要删除的学生宿舍信息主键
     * @return 结果
     */
    @Override
    public int deleteDormitoryByDorIds(String dorIds)
    {
        return dormitoryMapper.deleteDormitoryByDorIds(Convert.toStrArray(dorIds));
    }

    /**
     * 删除学生宿舍信息信息
     * 
     * @param dorId 学生宿舍信息主键
     * @return 结果
     */
    @Override
    public int deleteDormitoryByDorId(String dorId)
    {
        return dormitoryMapper.deleteDormitoryByDorId(dorId);
    }


    @Override
    public void addPresentNumber(OccupancyRelationship occupancyRelationship) {
        String dormitoryId = occupancyRelationship.getDormitoryId();
        Dormitory dormitory = dormitoryMapper.selectOne(new LambdaQueryWrapper<Dormitory>().eq(Dormitory::getDorId, dormitoryId));
        dormitory.setPresentNumber(dormitory.getPresentNumber()+1);
        dormitoryMapper.updateDormitory(dormitory);
    }

    @Override
    public List<Long> selectAvailableBedNumbers(String dorId) {
        Dormitory dormitory = selectDormitoryByDorId(dorId);
        if(dormitory==null){
            throw new RuntimeException("宿舍号填写错误");
        }
        Long capacity = dormitory.getCapacity();
        List<Long> availableBedNumbers = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            availableBedNumbers.add((long) (i+1));
        }
        List<OccupancyRelationship> occupancyRelationships = occupancyRelationshipMapper.selectList(new LambdaQueryWrapper<OccupancyRelationship>()
                .eq(OccupancyRelationship::getDormitoryId, dorId));
        for (OccupancyRelationship occupancyRelationship : occupancyRelationships) {
            availableBedNumbers.remove(occupancyRelationship.getBedNumber());
        }
        return availableBedNumbers;
    }

    @Override
    public List<String> getDorByBuildId(String buildingId) {
        LambdaQueryWrapper<Dormitory> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Dormitory::getBuildingId,buildingId);
        List<Dormitory> dormitories = baseMapper.selectList(wrapper);
        return dormitories.stream().map(Dormitory::getDorId).collect(Collectors.toList());
    }
}
