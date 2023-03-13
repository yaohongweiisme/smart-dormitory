package com.ruoyi.performance.dailyScoreChange.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.performance.dailyScoreChange.domain.DorDailyScoreChange;

import java.util.List;

/**
 * 宿舍每日分数浮动Service接口
 * 
 * @author ruoyi
 * @date 2023-03-11
 */
public interface IDorDailyScoreChangeService extends IService<DorDailyScoreChange>
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
     * 批量删除宿舍每日分数浮动
     * 
     * @param ids 需要删除的宿舍每日分数浮动主键集合
     * @return 结果
     */
    public int deleteDorDailyScoreChangeByIds(String ids);

    /**
     * 删除宿舍每日分数浮动信息
     * 
     * @param id 宿舍每日分数浮动主键
     * @return 结果
     */
    public int deleteDorDailyScoreChangeById(Long id);
}
