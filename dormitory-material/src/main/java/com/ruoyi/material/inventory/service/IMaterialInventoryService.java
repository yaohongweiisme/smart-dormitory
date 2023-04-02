package com.ruoyi.material.inventory.service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.material.inventory.domain.MaterialInventory;

/**
 * 物资库存Service接口
 * 
 * @author ruoyi
 * @date 2023-04-01
 */
public interface IMaterialInventoryService extends IService<MaterialInventory>
{
    /**
     * 查询物资库存
     * 
     * @param materialId 物资库存主键
     * @return 物资库存
     */
    public MaterialInventory selectMaterialInventoryByMaterialId(Long materialId);

    /**
     * 查询物资库存列表
     * 
     * @param materialInventory 物资库存
     * @return 物资库存集合
     */
    public List<MaterialInventory> selectMaterialInventoryList(MaterialInventory materialInventory);

    /**
     * 新增物资库存
     * 
     * @param materialInventory 物资库存
     * @return 结果
     */
    public int insertMaterialInventory(MaterialInventory materialInventory);

    /**
     * 修改物资库存
     * 
     * @param materialInventory 物资库存
     * @return 结果
     */
    public int updateMaterialInventory(MaterialInventory materialInventory);

    /**
     * 批量删除物资库存
     * 
     * @param materialIds 需要删除的物资库存主键集合
     * @return 结果
     */
    public int deleteMaterialInventoryByMaterialIds(String materialIds);

    /**
     * 删除物资库存信息
     * 
     * @param materialId 物资库存主键
     * @return 结果
     */
    public int deleteMaterialInventoryByMaterialId(Long materialId);
}
