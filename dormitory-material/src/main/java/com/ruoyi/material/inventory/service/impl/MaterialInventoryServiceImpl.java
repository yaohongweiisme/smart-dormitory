package com.ruoyi.material.inventory.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.material.inventory.mapper.MaterialInventoryMapper;
import com.ruoyi.material.inventory.domain.MaterialInventory;
import com.ruoyi.material.inventory.service.IMaterialInventoryService;
import com.ruoyi.common.core.text.Convert;

/**
 * 物资库存Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-01
 */
@Service
public class MaterialInventoryServiceImpl extends ServiceImpl<MaterialInventoryMapper,MaterialInventory> implements IMaterialInventoryService
{
    @Autowired
    private MaterialInventoryMapper materialInventoryMapper;

    /**
     * 查询物资库存
     * 
     * @param materialId 物资库存主键
     * @return 物资库存
     */
    @Override
    public MaterialInventory selectMaterialInventoryByMaterialId(Long materialId)
    {
        return materialInventoryMapper.selectMaterialInventoryByMaterialId(materialId);
    }

    /**
     * 查询物资库存列表
     * 
     * @param materialInventory 物资库存
     * @return 物资库存
     */
    @Override
    public List<MaterialInventory> selectMaterialInventoryList(MaterialInventory materialInventory)
    {
        return materialInventoryMapper.selectMaterialInventoryList(materialInventory);
    }

    /**
     * 新增物资库存
     * 
     * @param materialInventory 物资库存
     * @return 结果
     */
    @Override
    public int insertMaterialInventory(MaterialInventory materialInventory)
    {
        return materialInventoryMapper.insertMaterialInventory(materialInventory);
    }

    /**
     * 修改物资库存
     * 
     * @param materialInventory 物资库存
     * @return 结果
     */
    @Override
    public int updateMaterialInventory(MaterialInventory materialInventory)
    {
        return materialInventoryMapper.updateMaterialInventory(materialInventory);
    }

    /**
     * 批量删除物资库存
     * 
     * @param materialIds 需要删除的物资库存主键
     * @return 结果
     */
    @Override
    public int deleteMaterialInventoryByMaterialIds(String materialIds)
    {
        return materialInventoryMapper.deleteMaterialInventoryByMaterialIds(Convert.toStrArray(materialIds));
    }

    /**
     * 删除物资库存信息
     * 
     * @param materialId 物资库存主键
     * @return 结果
     */
    @Override
    public int deleteMaterialInventoryByMaterialId(Long materialId)
    {
        return materialInventoryMapper.deleteMaterialInventoryByMaterialId(materialId);
    }
}
