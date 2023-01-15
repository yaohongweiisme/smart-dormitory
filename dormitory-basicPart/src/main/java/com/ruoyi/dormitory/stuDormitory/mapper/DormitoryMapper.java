package com.ruoyi.dormitory.stuDormitory.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.dormitory.stuDormitory.domain.Dormitory;
import org.apache.ibatis.annotations.Mapper;

/**
 * 学生宿舍信息Mapper接口
 * 
 * @author ruoyi
 * @date 2023-01-08
 */
@Mapper
public interface DormitoryMapper extends BaseMapper<Dormitory>
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
     * 删除学生宿舍信息
     * 
     * @param dorId 学生宿舍信息主键
     * @return 结果
     */
    public int deleteDormitoryByDorId(String dorId);

    /**
     * 批量删除学生宿舍信息
     * 
     * @param dorIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDormitoryByDorIds(String[] dorIds);
}
