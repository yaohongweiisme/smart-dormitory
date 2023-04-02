package com.ruoyi.performance.dailyScoreChange.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import com.ruoyi.performance.dailyScoreChange.domain.DorDailyScoreChange;

/**
 * 宿舍每日分数浮动Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-31
 */
public interface DorDailyScoreChangeMapper extends BaseMapper<DorDailyScoreChange>
{
    /**
     * 查询宿舍每日分数浮动
     * 
     * @param id 宿舍每日分数浮动主键
     * @return 宿舍每日分数浮动
     */
    public DorDailyScoreChange selectDorDailyScoreChangeById(Long id);

    /**
     * 查询宿舍每日分数浮动列表
     * 
     * @param dorDailyScoreChange 宿舍每日分数浮动
     * @return 宿舍每日分数浮动集合
     */
    public List<DorDailyScoreChange> selectDorDailyScoreChangeList(DorDailyScoreChange dorDailyScoreChange);

    /**
     * 新增宿舍每日分数浮动
     * 
     * @param dorDailyScoreChange 宿舍每日分数浮动
     * @return 结果
     */
    public int insertDorDailyScoreChange(DorDailyScoreChange dorDailyScoreChange);

    /**
     * 修改宿舍每日分数浮动
     * 
     * @param dorDailyScoreChange 宿舍每日分数浮动
     * @return 结果
     */
    public int updateDorDailyScoreChange(DorDailyScoreChange dorDailyScoreChange);

    /**
     * 删除宿舍每日分数浮动
     * 
     * @param id 宿舍每日分数浮动主键
     * @return 结果
     */
    public int deleteDorDailyScoreChangeById(Long id);

    /**
     * 批量删除宿舍每日分数浮动
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDorDailyScoreChangeByIds(String[] ids);
}
