package com.ruoyi.material.requirements.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.material.requirements.domain.PurchasingRequirements;

import java.util.List;

/**
 * 物资采购需求Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-01
 */
public interface PurchasingRequirementsMapper extends BaseMapper<PurchasingRequirements>
{
    /**
     * 查询物资采购需求
     * 
     * @param purchasingRequirementsId 物资采购需求主键
     * @return 物资采购需求
     */
    public PurchasingRequirements selectPurchasingRequirementsByPurchasingRequirementsId(Long purchasingRequirementsId);

    /**
     * 查询物资采购需求列表
     * 
     * @param purchasingRequirements 物资采购需求
     * @return 物资采购需求集合
     */
    public List<PurchasingRequirements> selectPurchasingRequirementsList(PurchasingRequirements purchasingRequirements);

    /**
     * 新增物资采购需求
     * 
     * @param purchasingRequirements 物资采购需求
     * @return 结果
     */
    public int insertPurchasingRequirements(PurchasingRequirements purchasingRequirements);

    /**
     * 修改物资采购需求
     * 
     * @param purchasingRequirements 物资采购需求
     * @return 结果
     */
    public int updatePurchasingRequirements(PurchasingRequirements purchasingRequirements);

    /**
     * 删除物资采购需求
     * 
     * @param purchasingRequirementsId 物资采购需求主键
     * @return 结果
     */
    public int deletePurchasingRequirementsByPurchasingRequirementsId(Long purchasingRequirementsId);

    /**
     * 批量删除物资采购需求
     * 
     * @param purchasingRequirementsIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePurchasingRequirementsByPurchasingRequirementsIds(String[] purchasingRequirementsIds);
}
