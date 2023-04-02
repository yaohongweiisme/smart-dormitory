package com.ruoyi.material.requirements.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.material.inventory.domain.MaterialInventory;
import com.ruoyi.material.inventory.mapper.MaterialInventoryMapper;
import com.ruoyi.material.order.domain.PurchaseOrder;
import com.ruoyi.material.order.mapper.PurchaseOrderMapper;
import com.ruoyi.material.requirements.domain.PurchasingRequirements;
import com.ruoyi.material.requirements.mapper.PurchasingRequirementsMapper;
import com.ruoyi.material.requirements.service.IPurchasingRequirementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 物资采购需求Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-01
 */
@Service
public class PurchasingRequirementsServiceImpl extends ServiceImpl<PurchasingRequirementsMapper,PurchasingRequirements> implements IPurchasingRequirementsService
{
    @Autowired
    private PurchasingRequirementsMapper purchasingRequirementsMapper;
    @Autowired
    private MaterialInventoryMapper materialInventoryMapper;
    @Autowired
    private PurchaseOrderMapper orderMapper;

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

    @Override
    public int mergeRequirements(String ids) {
        Long[] needToMerge = Convert.toLongArray(ids);
        System.out.println("需要合并的需求id："+ Arrays.toString(needToMerge));
        List<PurchasingRequirements> list = baseMapper.selectList(new LambdaQueryWrapper<PurchasingRequirements>()
                .in(PurchasingRequirements::getPurchasingRequirementsId,needToMerge));
        String objectList="";
        for (PurchasingRequirements requirements : list) {
            Long materialId = requirements.getMaterialId();
            MaterialInventory material = materialInventoryMapper.selectMaterialInventoryByMaterialId(materialId);
            objectList+=material.getName()+":"+requirements.getReplenishment()+";";
        }
        objectList=objectList.substring(0,objectList.length()-1);
        System.out.println(objectList);
        PurchaseOrder order = new PurchaseOrder();
        order.setObjectList(objectList);
        order.setBuildTime(DateUtils.getNowDate());
        orderMapper.insert(order);
        return deletePurchasingRequirementsByPurchasingRequirementsIds(ids);
    }
}
