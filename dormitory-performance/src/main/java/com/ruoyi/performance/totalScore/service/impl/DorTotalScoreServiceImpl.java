package com.ruoyi.performance.totalScore.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.performance.totalScore.domain.DorTotalScore;
import com.ruoyi.performance.totalScore.mapper.DorTotalScoreMapper;
import com.ruoyi.performance.totalScore.service.IDorTotalScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 宿舍总分数Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-31
 */
@Service
public class DorTotalScoreServiceImpl extends ServiceImpl<DorTotalScoreMapper,DorTotalScore> implements IDorTotalScoreService
{
    @Autowired
    private DorTotalScoreMapper dorTotalScoreMapper;

    /**
     * 查询宿舍总分数
     * 
     * @param id 宿舍总分数主键
     * @return 宿舍总分数
     */
    @Override
    public DorTotalScore selectDorTotalScoreById(Long id)
    {
        return dorTotalScoreMapper.selectDorTotalScoreById(id);
    }

    /**
     * 查询宿舍总分数列表
     * 
     * @param dorTotalScore 宿舍总分数
     * @return 宿舍总分数
     */
    @Override
    public List<DorTotalScore> selectDorTotalScoreList(DorTotalScore dorTotalScore)
    {
        return dorTotalScoreMapper.selectDorTotalScoreList(dorTotalScore);
    }

    /**
     * 新增宿舍总分数
     * 
     * @param dorTotalScore 宿舍总分数
     * @return 结果
     */
    @Override
    public int insertDorTotalScore(DorTotalScore dorTotalScore)
    {
        return dorTotalScoreMapper.insertDorTotalScore(dorTotalScore);
    }

    /**
     * 修改宿舍总分数
     * 
     * @param dorTotalScore 宿舍总分数
     * @return 结果
     */
    @Override
    public int updateDorTotalScore(DorTotalScore dorTotalScore)
    {
        return dorTotalScoreMapper.updateDorTotalScore(dorTotalScore);
    }

    /**
     * 批量删除宿舍总分数
     * 
     * @param ids 需要删除的宿舍总分数主键
     * @return 结果
     */
    @Override
    public int deleteDorTotalScoreByIds(String ids)
    {
        return dorTotalScoreMapper.deleteDorTotalScoreByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除宿舍总分数信息
     * 
     * @param id 宿舍总分数主键
     * @return 结果
     */
    @Override
    public int deleteDorTotalScoreById(Long id)
    {
        return dorTotalScoreMapper.deleteDorTotalScoreById(id);
    }

    @Override
    public List<DorTotalScore> getTotalScoreByDorId(String dorId) {
        LambdaQueryWrapper<DorTotalScore> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(DorTotalScore::getDorId,dorId);
        return list(wrapper);
    }
}
