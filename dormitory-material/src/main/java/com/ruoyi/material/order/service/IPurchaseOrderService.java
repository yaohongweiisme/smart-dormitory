package com.ruoyi.material.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.material.order.domain.PurchaseOrder;

import java.util.List;

/**
 * 物资采购单Service接口
 * 
 * @author ruoyi
 * @date 2023-03-28
 */
public interface IPurchaseOrderService extends IService<PurchaseOrder>
{
    /**
     * 查询物资采购单
     * 
     * @param purchaseOrderId 物资采购单主键
     * @return 物资采购单
     */
    public PurchaseOrder selectPurchaseOrderByPurchaseOrderId(Long purchaseOrderId);

    /**
     * 查询物资采购单列表
     * 
     * @param purchaseOrder 物资采购单
     * @return 物资采购单集合
     */
    public List<PurchaseOrder> selectPurchaseOrderList(PurchaseOrder purchaseOrder);

    /**
     * 新增物资采购单
     * 
     * @param purchaseOrder 物资采购单
     * @return 结果
     */
    public int insertPurchaseOrder(PurchaseOrder purchaseOrder);

    /**
     * 修改物资采购单
     * 
     * @param purchaseOrder 物资采购单
     * @return 结果
     */
    public int updatePurchaseOrder(PurchaseOrder purchaseOrder);

    /**
     * 批量删除物资采购单
     * 
     * @param purchaseOrderIds 需要删除的物资采购单主键集合
     * @return 结果
     */
    public int deletePurchaseOrderByPurchaseOrderIds(String purchaseOrderIds);

    /**
     * 删除物资采购单信息
     * 
     * @param purchaseOrderId 物资采购单主键
     * @return 结果
     */
    public int deletePurchaseOrderByPurchaseOrderId(Long purchaseOrderId);
}
