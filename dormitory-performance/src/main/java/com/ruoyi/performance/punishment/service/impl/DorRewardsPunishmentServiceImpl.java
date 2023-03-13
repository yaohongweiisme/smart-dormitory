package com.ruoyi.performance.punishment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.performance.punishment.domain.DorRewardsPunishment;
import com.ruoyi.performance.punishment.mapper.DorRewardsPunishmentMapper;
import com.ruoyi.performance.punishment.service.IDorRewardsPunishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 宿舍奖惩活动Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-11
 */
@Service
public class DorRewardsPunishmentServiceImpl extends ServiceImpl<DorRewardsPunishmentMapper,DorRewardsPunishment> implements IDorRewardsPunishmentService
{
    @Autowired
    private DorRewardsPunishmentMapper dorRewardsPunishmentMapper;

    /**
     * 查询宿舍奖惩活动
     * 
     * @param id 宿舍奖惩活动主键
     * @return 宿舍奖惩活动
     */
    @Override
    public DorRewardsPunishment selectDorRewardsPunishmentById(Long id)
    {
        return dorRewardsPunishmentMapper.selectDorRewardsPunishmentById(id);
    }

    /**
     * 查询宿舍奖惩活动列表
     * 
     * @param dorRewardsPunishment 宿舍奖惩活动
     * @return 宿舍奖惩活动
     */
    @Override
    public List<DorRewardsPunishment> selectDorRewardsPunishmentList(DorRewardsPunishment dorRewardsPunishment)
    {
        return dorRewardsPunishmentMapper.selectDorRewardsPunishmentList(dorRewardsPunishment);
    }

    /**
     * 新增宿舍奖惩活动
     * 
     * @param dorRewardsPunishment 宿舍奖惩活动
     * @return 结果
     */
    @Override
    public int insertDorRewardsPunishment(DorRewardsPunishment dorRewardsPunishment)
    {
        return dorRewardsPunishmentMapper.insertDorRewardsPunishment(dorRewardsPunishment);
    }

    /**
     * 修改宿舍奖惩活动
     * 
     * @param dorRewardsPunishment 宿舍奖惩活动
     * @return 结果
     */
    @Override
    public int updateDorRewardsPunishment(DorRewardsPunishment dorRewardsPunishment)
    {
        return dorRewardsPunishmentMapper.updateDorRewardsPunishment(dorRewardsPunishment);
    }

    /**
     * 批量删除宿舍奖惩活动
     * 
     * @param ids 需要删除的宿舍奖惩活动主键
     * @return 结果
     */
    @Override
    public int deleteDorRewardsPunishmentByIds(String ids)
    {
        return dorRewardsPunishmentMapper.deleteDorRewardsPunishmentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除宿舍奖惩活动信息
     * 
     * @param id 宿舍奖惩活动主键
     * @return 结果
     */
    @Override
    public int deleteDorRewardsPunishmentById(Long id)
    {
        return dorRewardsPunishmentMapper.deleteDorRewardsPunishmentById(id);
    }
}
