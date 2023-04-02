package com.ruoyi.performance.punishment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import com.ruoyi.performance.punishment.domain.DorRewardsPunishment;

/**
 * 宿舍奖惩活动Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-31
 */
public interface DorRewardsPunishmentMapper extends BaseMapper<DorRewardsPunishment>
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
     * 删除宿舍奖惩活动
     * 
     * @param id 宿舍奖惩活动主键
     * @return 结果
     */
    public int deleteDorRewardsPunishmentById(Long id);

    /**
     * 批量删除宿舍奖惩活动
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDorRewardsPunishmentByIds(String[] ids);
}
