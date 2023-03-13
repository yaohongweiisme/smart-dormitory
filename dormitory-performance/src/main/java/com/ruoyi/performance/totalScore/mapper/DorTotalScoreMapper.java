package com.ruoyi.performance.totalScore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.performance.totalScore.domain.DorTotalScore;

import java.util.List;

/**
 * 宿舍总分数Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-11
 */
public interface DorTotalScoreMapper extends BaseMapper<DorTotalScore>
{
    /**
     * 查询宿舍总分数
     * 
     * @param id 宿舍总分数主键
     * @return 宿舍总分数
     */
    public DorTotalScore selectDorTotalScoreById(Long id);

    /**
     * 查询宿舍总分数列表
     * 
     * @param dorTotalScore 宿舍总分数
     * @return 宿舍总分数集合
     */
    public List<DorTotalScore> selectDorTotalScoreList(DorTotalScore dorTotalScore);

    /**
     * 新增宿舍总分数
     * 
     * @param dorTotalScore 宿舍总分数
     * @return 结果
     */
    public int insertDorTotalScore(DorTotalScore dorTotalScore);

    /**
     * 修改宿舍总分数
     * 
     * @param dorTotalScore 宿舍总分数
     * @return 结果
     */
    public int updateDorTotalScore(DorTotalScore dorTotalScore);

    /**
     * 删除宿舍总分数
     * 
     * @param id 宿舍总分数主键
     * @return 结果
     */
    public int deleteDorTotalScoreById(Long id);

    /**
     * 批量删除宿舍总分数
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDorTotalScoreByIds(String[] ids);
}
