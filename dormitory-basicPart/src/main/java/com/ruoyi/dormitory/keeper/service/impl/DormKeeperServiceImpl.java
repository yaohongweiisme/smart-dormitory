package com.ruoyi.dormitory.keeper.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.dormitory.keeper.mapper.DormKeeperMapper;
import com.ruoyi.dormitory.keeper.domain.DormKeeper;
import com.ruoyi.dormitory.keeper.service.IDormKeeperService;
import com.ruoyi.common.core.text.Convert;

/**
 * 宿管信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-01-06
 */
@Service
public class DormKeeperServiceImpl implements IDormKeeperService 
{
    @Autowired
    private DormKeeperMapper dormKeeperMapper;

    /**
     * 查询宿管信息
     * 
     * @param dkId 宿管信息主键
     * @return 宿管信息
     */
    @Override
    public DormKeeper selectDormKeeperByDkId(Long dkId)
    {
        return dormKeeperMapper.selectDormKeeperByDkId(dkId);
    }

    /**
     * 查询宿管信息列表
     * 
     * @param dormKeeper 宿管信息
     * @return 宿管信息
     */
    @Override
    public List<DormKeeper> selectDormKeeperList(DormKeeper dormKeeper)
    {
        return dormKeeperMapper.selectDormKeeperList(dormKeeper);
    }

    /**
     * 新增宿管信息
     * 
     * @param dormKeeper 宿管信息
     * @return 结果
     */
    @Override
    public int insertDormKeeper(DormKeeper dormKeeper)
    {
        return dormKeeperMapper.insertDormKeeper(dormKeeper);
    }

    /**
     * 修改宿管信息
     * 
     * @param dormKeeper 宿管信息
     * @return 结果
     */
    @Override
    public int updateDormKeeper(DormKeeper dormKeeper)
    {
        return dormKeeperMapper.updateDormKeeper(dormKeeper);
    }

    /**
     * 批量删除宿管信息
     * 
     * @param dkIds 需要删除的宿管信息主键
     * @return 结果
     */
    @Override
    public int deleteDormKeeperByDkIds(String dkIds)
    {
        return dormKeeperMapper.deleteDormKeeperByDkIds(Convert.toStrArray(dkIds));
    }

    /**
     * 删除宿管信息信息
     * 
     * @param dkId 宿管信息主键
     * @return 结果
     */
    @Override
    public int deleteDormKeeperByDkId(Long dkId)
    {
        return dormKeeperMapper.deleteDormKeeperByDkId(dkId);
    }
}
