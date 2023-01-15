package com.ruoyi.dormitory.keeper.service;

import java.util.List;
import com.ruoyi.dormitory.keeper.domain.DormKeeper;

/**
 * 宿管信息Service接口
 * 
 * @author ruoyi
 * @date 2023-01-06
 */
public interface IDormKeeperService 
{
    /**
     * 查询宿管信息
     * 
     * @param dkId 宿管信息主键
     * @return 宿管信息
     */
    public DormKeeper selectDormKeeperByDkId(Long dkId);

    /**
     * 查询宿管信息列表
     * 
     * @param dormKeeper 宿管信息
     * @return 宿管信息集合
     */
    public List<DormKeeper> selectDormKeeperList(DormKeeper dormKeeper);

    /**
     * 新增宿管信息
     * 
     * @param dormKeeper 宿管信息
     * @return 结果
     */
    public int insertDormKeeper(DormKeeper dormKeeper);

    /**
     * 修改宿管信息
     * 
     * @param dormKeeper 宿管信息
     * @return 结果
     */
    public int updateDormKeeper(DormKeeper dormKeeper);

    /**
     * 批量删除宿管信息
     * 
     * @param dkIds 需要删除的宿管信息主键集合
     * @return 结果
     */
    public int deleteDormKeeperByDkIds(String dkIds);

    /**
     * 删除宿管信息信息
     * 
     * @param dkId 宿管信息主键
     * @return 结果
     */
    public int deleteDormKeeperByDkId(Long dkId);
}
