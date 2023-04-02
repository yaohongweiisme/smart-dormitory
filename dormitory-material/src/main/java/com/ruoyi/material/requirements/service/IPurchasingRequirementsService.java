package com.ruoyi.material.requirements.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.material.requirements.domain.PurchasingRequirements;

import java.util.List;

/**
 * 物资采购需求Service接口
 * 
 * @author ruoyi
 * @date 2023-04-01
 */
public interface IPurchasingRequirementsService extends IService<PurchasingRequirements>
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
     * 批量删除物资采购需求
     * 
     * @param purchasingRequirementsIds 需要删除的物资采购需求主键集合
     * @return 结果
     */
    public int deletePurchasingRequirementsByPurchasingRequirementsIds(String purchasingRequirementsIds);

    /**
     * 删除物资采购需求信息
     * 
     * @param purchasingRequirementsId 物资采购需求主键
     * @return 结果
     */
    public int deletePurchasingRequirementsByPurchasingRequirementsId(Long purchasingRequirementsId);

    int mergeRequirements(String ids);
}
