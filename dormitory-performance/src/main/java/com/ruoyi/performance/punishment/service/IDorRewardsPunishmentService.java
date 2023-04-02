package com.ruoyi.performance.punishment.service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.performance.punishment.domain.DorRewardsPunishment;

/**
 * 宿舍奖惩活动Service接口
 * 
 * @author ruoyi
 * @date 2023-03-31
 */
public interface IDorRewardsPunishmentService extends IService<DorRewardsPunishment>
{
    /**
     * 查询宿舍奖惩活动
     * 
     * @param id 宿舍奖惩活动主键
     * @return 宿舍奖惩活动
     */
    public DorRewardsPunishment selectDorRewardsPunishmentById(Long id);

    /**
     * 查询宿舍奖惩活动列表
     * 
     * @param dorRewardsPunishment 宿舍奖惩活动
     * @return 宿舍奖惩活动集合
     */
    public List<DorRewardsPunishment> selectDorRewardsPunishmentList(DorRewardsPunishment dorRewardsPunishment);

    /**
     * 新增宿舍奖惩活动
     * 
     * @param dorRewardsPunishment 宿舍奖惩活动
     * @return 结果
     */
    public int insertDorRewardsPunishment(DorRewardsPunishment dorRewardsPunishment);

    /**
     * 修改宿舍奖惩活动
     * 
     * @param dorRewardsPunishment 宿舍奖惩活动
     * @return 结果
     */
    public int updateDorRewardsPunishment(DorRewardsPunishment dorRewardsPunishment);

    /**
     * 批量删除宿舍奖惩活动
     * 
     * @param ids 需要删除的宿舍奖惩活动主键集合
     * @return 结果
     */
    public int deleteDorRewardsPunishmentByIds(String ids);

    /**
     * 删除宿舍奖惩活动信息
     * 
     * @param id 宿舍奖惩活动主键
     * @return 结果
     */
    public int deleteDorRewardsPunishmentById(Long id);
}
