package com.ruoyi.performance.totalScore.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.performance.totalScore.domain.DorTotalScore;

import java.util.List;

/**
 * 宿舍总分数Service接口
 * 
 * @author ruoyi
 * @date 2023-03-31
 */
public interface IDorTotalScoreService extends IService<DorTotalScore>
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
     * 批量删除宿舍总分数
     * 
     * @param ids 需要删除的宿舍总分数主键集合
     * @return 结果
     */
    public int deleteDorTotalScoreByIds(String ids);

    /**
     * 删除宿舍总分数信息
     * 
     * @param id 宿舍总分数主键
     * @return 结果
     */
    public int deleteDorTotalScoreById(Long id);
}
