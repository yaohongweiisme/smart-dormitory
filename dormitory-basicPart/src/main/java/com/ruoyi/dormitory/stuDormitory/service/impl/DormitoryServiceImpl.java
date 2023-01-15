package com.ruoyi.dormitory.stuDormitory.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.ruoyi.dormitory.ocpRelationship.domain.OccupancyRelationship;
import com.ruoyi.dormitory.ocpRelationship.mapper.OccupancyRelationshipMapper;
import com.ruoyi.dormitory.ocpRelationship.service.IOccupancyRelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.dormitory.stuDormitory.mapper.DormitoryMapper;
import com.ruoyi.dormitory.stuDormitory.domain.Dormitory;
import com.ruoyi.dormitory.stuDormitory.service.IDormitoryService;
import com.ruoyi.common.core.text.Convert;

/**
 * 学生宿舍信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-01-08
 */
@Service
public class DormitoryServiceImpl implements IDormitoryService 
{
    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Autowired
    private OccupancyRelationshipMapper occupancyRelationshipMapper;

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
    public List<String> getDormitoryBuilding(List<Dormitory> dormitoryList) {
        List<String> list = dormitoryList.stream().map(item -> {
            String[] split = item.getLocation().split("栋" );
            return split[0] + "栋";
        }).collect(Collectors.toList());
        return list;
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
}
