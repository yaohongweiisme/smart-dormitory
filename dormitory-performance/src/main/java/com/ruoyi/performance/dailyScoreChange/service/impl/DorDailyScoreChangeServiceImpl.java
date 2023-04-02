package com.ruoyi.performance.dailyScoreChange.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.performance.dailyScoreChange.mapper.DorDailyScoreChangeMapper;
import com.ruoyi.performance.dailyScoreChange.domain.DorDailyScoreChange;
import com.ruoyi.performance.dailyScoreChange.service.IDorDailyScoreChangeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 宿舍每日分数浮动Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-31
 */
@Service
public class DorDailyScoreChangeServiceImpl extends ServiceImpl<DorDailyScoreChangeMapper,DorDailyScoreChange> implements IDorDailyScoreChangeService
{
    @Autowired
    private DorDailyScoreChangeMapper dorDailyScoreChangeMapper;

    /**
     * 查询宿舍每日分数浮动
     * 
     * @param id 宿舍每日分数浮动主键
     * @return 宿舍每日分数浮动
     */
    @Override
    public DorDailyScoreChange selectDorDailyScoreChangeById(Long id)
    {
        return dorDailyScoreChangeMapper.selectDorDailyScoreChangeById(id);
    }

    /**
     * 查询宿舍每日分数浮动列表
     * 
     * @param dorDailyScoreChange 宿舍每日分数浮动
     * @return 宿舍每日分数浮动
     */
    @Override
    public List<DorDailyScoreChange> selectDorDailyScoreChangeList(DorDailyScoreChange dorDailyScoreChange)
    {
        return dorDailyScoreChangeMapper.selectDorDailyScoreChangeList(dorDailyScoreChange);
    }

    /**
     * 新增宿舍每日分数浮动
     * 
     * @param dorDailyScoreChange 宿舍每日分数浮动
     * @return 结果
     */
    @Override
    public int insertDorDailyScoreChange(DorDailyScoreChange dorDailyScoreChange)
    {
        return dorDailyScoreChangeMapper.insertDorDailyScoreChange(dorDailyScoreChange);
    }

    /**
     * 修改宿舍每日分数浮动
     * 
     * @param dorDailyScoreChange 宿舍每日分数浮动
     * @return 结果
     */
    @Override
    public int updateDorDailyScoreChange(DorDailyScoreChange dorDailyScoreChange)
    {
        return dorDailyScoreChangeMapper.updateDorDailyScoreChange(dorDailyScoreChange);
    }

    /**
     * 批量删除宿舍每日分数浮动
     * 
     * @param ids 需要删除的宿舍每日分数浮动主键
     * @return 结果
     */
    @Override
    public int deleteDorDailyScoreChangeByIds(String ids)
    {
        return dorDailyScoreChangeMapper.deleteDorDailyScoreChangeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除宿舍每日分数浮动信息
     * 
     * @param id 宿舍每日分数浮动主键
     * @return 结果
     */
    @Override
    public int deleteDorDailyScoreChangeById(Long id)
    {
        return dorDailyScoreChangeMapper.deleteDorDailyScoreChangeById(id);
    }
}
