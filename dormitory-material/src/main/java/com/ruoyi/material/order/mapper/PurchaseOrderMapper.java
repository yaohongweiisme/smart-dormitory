package com.ruoyi.material.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import com.ruoyi.material.order.domain.PurchaseOrder;

/**
 * 物资采购单Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-01
 */
public interface PurchaseOrderMapper extends BaseMapper<PurchaseOrder>
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
     * 删除物资采购单
     * 
     * @param purchaseOrderId 物资采购单主键
     * @return 结果
     */
    public int deletePurchaseOrderByPurchaseOrderId(Long purchaseOrderId);

    /**
     * 批量删除物资采购单
     * 
     * @param purchaseOrderIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePurchaseOrderByPurchaseOrderIds(String[] purchaseOrderIds);
}
