package com.ruoyi.material.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.material.order.mapper.PurchaseOrderMapper;
import com.ruoyi.material.order.domain.PurchaseOrder;
import com.ruoyi.material.order.service.IPurchaseOrderService;
import com.ruoyi.common.core.text.Convert;

/**
 * 物资采购单Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-28
 */
@Service
public class PurchaseOrderServiceImpl extends ServiceImpl<PurchaseOrderMapper,PurchaseOrder> implements IPurchaseOrderService
{
    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;

    /**
     * 查询物资采购单
     * 
     * @param purchaseOrderId 物资采购单主键
     * @return 物资采购单
     */
    @Override
    public PurchaseOrder selectPurchaseOrderByPurchaseOrderId(Long purchaseOrderId)
    {
        return purchaseOrderMapper.selectPurchaseOrderByPurchaseOrderId(purchaseOrderId);
    }

    /**
     * 查询物资采购单列表
     * 
     * @param purchaseOrder 物资采购单
     * @return 物资采购单
     */
    @Override
    public List<PurchaseOrder> selectPurchaseOrderList(PurchaseOrder purchaseOrder)
    {
        return purchaseOrderMapper.selectPurchaseOrderList(purchaseOrder);
    }

    /**
     * 新增物资采购单
     * 
     * @param purchaseOrder 物资采购单
     * @return 结果
     */
    @Override
    public int insertPurchaseOrder(PurchaseOrder purchaseOrder)
    {
        return purchaseOrderMapper.insertPurchaseOrder(purchaseOrder);
    }

    /**
     * 修改物资采购单
     * 
     * @param purchaseOrder 物资采购单
     * @return 结果
     */
    @Override
    public int updatePurchaseOrder(PurchaseOrder purchaseOrder)
    {
        return purchaseOrderMapper.updatePurchaseOrder(purchaseOrder);
    }

    /**
     * 批量删除物资采购单
     * 
     * @param purchaseOrderIds 需要删除的物资采购单主键
     * @return 结果
     */
    @Override
    public int deletePurchaseOrderByPurchaseOrderIds(String purchaseOrderIds)
    {
        return purchaseOrderMapper.deletePurchaseOrderByPurchaseOrderIds(Convert.toStrArray(purchaseOrderIds));
    }

    /**
     * 删除物资采购单信息
     * 
     * @param purchaseOrderId 物资采购单主键
     * @return 结果
     */
    @Override
    public int deletePurchaseOrderByPurchaseOrderId(Long purchaseOrderId)
    {
        return purchaseOrderMapper.deletePurchaseOrderByPurchaseOrderId(purchaseOrderId);
    }
}
