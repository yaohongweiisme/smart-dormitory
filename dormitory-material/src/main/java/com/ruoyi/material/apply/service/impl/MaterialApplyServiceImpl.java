package com.ruoyi.material.apply.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.material.apply.domain.MaterialApply;
import com.ruoyi.material.apply.mapper.MaterialApplyMapper;
import com.ruoyi.material.apply.service.IMaterialApplyService;
import com.ruoyi.material.inventory.domain.MaterialInventory;
import com.ruoyi.material.inventory.service.IMaterialInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 物资申领Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-14
 */
@Service
public class MaterialApplyServiceImpl extends ServiceImpl<MaterialApplyMapper,MaterialApply> implements IMaterialApplyService
{
    @Autowired
    private MaterialApplyMapper materialApplyMapper;
    @Autowired
    private IMaterialInventoryService inventoryService;

    /**
     * 查询物资申领
     * 
     * @param applicationId 物资申领主键
     * @return 物资申领
     */
    @Override
    public MaterialApply selectMaterialApplyByApplicationId(Long applicationId)
    {
        return materialApplyMapper.selectMaterialApplyByApplicationId(applicationId);
    }

    /**
     * 查询物资申领列表
     * 
     * @param materialApply 物资申领
     * @return 物资申领
     */
    @Override
    public List<MaterialApply> selectMaterialApplyList(MaterialApply materialApply)
    {
        return materialApplyMapper.selectMaterialApplyList(materialApply);
    }

    /**
     * 新增物资申领
     * 
     * @param materialApply 物资申领
     * @return 结果
     */
    @Override
    public int insertMaterialApply(MaterialApply materialApply)
    {
        return materialApplyMapper.insertMaterialApply(materialApply);
    }

    /**
     * 修改物资申领
     * 
     * @param materialApply 物资申领
     * @return 结果
     */
    @Transactional
    @Override
    public int updateMaterialApply(MaterialApply materialApply)
    {
        if(materialApply.getStatus()==1){
            Long materialId = selectMaterialApplyByApplicationId(materialApply.getApplicationId()).getMaterialId();
            Long number = materialApply.getNumber();
            Long oldInventory = inventoryService.selectMaterialInventoryByMaterialId(materialId).getNumber();
            Long newInventory=oldInventory-number;
            MaterialInventory inventory = new MaterialInventory();
            inventory.setMaterialId(materialId);
            inventory.setNumber(newInventory);
            inventoryService.updateMaterialInventory(inventory);
        }
            return materialApplyMapper.updateMaterialApply(materialApply);

    }

    /**
     * 批量删除物资申领
     * 
     * @param applicationIds 需要删除的物资申领主键
     * @return 结果
     */
    @Override
    public int deleteMaterialApplyByApplicationIds(String applicationIds)
    {
        return materialApplyMapper.deleteMaterialApplyByApplicationIds(Convert.toStrArray(applicationIds));
    }

    /**
     * 删除物资申领信息
     * 
     * @param applicationId 物资申领主键
     * @return 结果
     */
    @Override
    public int deleteMaterialApplyByApplicationId(Long applicationId)
    {
        return materialApplyMapper.deleteMaterialApplyByApplicationId(applicationId);
    }
}
