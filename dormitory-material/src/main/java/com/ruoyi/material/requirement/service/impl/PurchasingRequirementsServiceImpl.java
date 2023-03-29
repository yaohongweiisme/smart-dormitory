package com.ruoyi.material.requirement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.material.requirement.mapper.PurchasingRequirementsMapper;
import com.ruoyi.material.requirement.domain.PurchasingRequirements;
import com.ruoyi.material.requirement.service.IPurchasingRequirementsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 物资采购需求Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-28
 */
@Service
public class PurchasingRequirementsServiceImpl extends ServiceImpl<PurchasingRequirementsMapper,PurchasingRequirements> implements IPurchasingRequirementsService
{
    @Autowired
    private PurchasingRequirementsMapper purchasingRequirementsMapper;

    /**
     * 查询物资采购需求
     * 
     * @param purchasingRequirementsId 物资采购需求主键
     * @return 物资采购需求
     */
    @Override
    public PurchasingRequirements selectPurchasingRequirementsByPurchasingRequirementsId(Long purchasingRequirementsId)
    {
        return purchasingRequirementsMapper.selectPurchasingRequirementsByPurchasingRequirementsId(purchasingRequirementsId);
    }

    /**
     * 查询物资采购需求列表
     * 
     * @param purchasingRequirements 物资采购需求
     * @return 物资采购需求
     */
    @Override
    public List<PurchasingRequirements> selectPurchasingRequirementsList(PurchasingRequirements purchasingRequirements)
    {
        return purchasingRequirementsMapper.selectPurchasingRequirementsList(purchasingRequirements);
    }

    /**
     * 新增物资采购需求
     * 
     * @param purchasingRequirements 物资采购需求
     * @return 结果
     */
    @Override
    public int insertPurchasingRequirements(PurchasingRequirements purchasingRequirements)
    {
        return purchasingRequirementsMapper.insertPurchasingRequirements(purchasingRequirements);
    }

    /**
     * 修改物资采购需求
     * 
     * @param purchasingRequirements 物资采购需求
     * @return 结果
     */
    @Override
    public int updatePurchasingRequirements(PurchasingRequirements purchasingRequirements)
    {
        return purchasingRequirementsMapper.updatePurchasingRequirements(purchasingRequirements);
    }

    /**
     * 批量删除物资采购需求
     * 
     * @param purchasingRequirementsIds 需要删除的物资采购需求主键
     * @return 结果
     */
    @Override
    public int deletePurchasingRequirementsByPurchasingRequirementsIds(String purchasingRequirementsIds)
    {
        return purchasingRequirementsMapper.deletePurchasingRequirementsByPurchasingRequirementsIds(Convert.toStrArray(purchasingRequirementsIds));
    }

    /**
     * 删除物资采购需求信息
     * 
     * @param purchasingRequirementsId 物资采购需求主键
     * @return 结果
     */
    @Override
    public int deletePurchasingRequirementsByPurchasingRequirementsId(Long purchasingRequirementsId)
    {
        return purchasingRequirementsMapper.deletePurchasingRequirementsByPurchasingRequirementsId(purchasingRequirementsId);
    }
}
