package com.ruoyi.dormitory.stuDormitory.service;

import java.util.List;

import com.ruoyi.dormitory.ocpRelationship.domain.OccupancyRelationship;
import com.ruoyi.dormitory.stuDormitory.domain.Dormitory;

/**
 * 学生宿舍信息Service接口
 * 
 * @author ruoyi
 * @date 2023-01-08
 */
public interface IDormitoryService 
{
    /**
     * 查询学生宿舍信息
     * 
     * @param dorId 学生宿舍信息主键
     * @return 学生宿舍信息
     */
    public Dormitory selectDormitoryByDorId(String dorId);

    /**
     * 查询学生宿舍信息列表
     * 
     * @param dormitory 学生宿舍信息
     * @return 学生宿舍信息集合
     */
    public List<Dormitory> selectDormitoryList(Dormitory dormitory);

    /**
     * 新增学生宿舍信息
     * 
     * @param dormitory 学生宿舍信息
     * @return 结果
     */
    public int insertDormitory(Dormitory dormitory);

    /**
     * 修改学生宿舍信息
     * 
     * @param dormitory 学生宿舍信息
     * @return 结果
     */
    public int updateDormitory(Dormitory dormitory);

    /**
     * 批量删除学生宿舍信息
     * 
     * @param dorIds 需要删除的学生宿舍信息主键集合
     * @return 结果
     */
    public int deleteDormitoryByDorIds(String dorIds);

    /**
     * 删除学生宿舍信息信息
     * 
     * @param dorId 学生宿舍信息主键
     * @return 结果
     */
    public int deleteDormitoryByDorId(String dorId);

    List<String> getDormitoryBuilding(List<Dormitory> dormitoryList);

    void addPresentNumber(OccupancyRelationship occupancyRelationship);

    List<Long> selectAvailableBedNumbers(String dorId);
}
