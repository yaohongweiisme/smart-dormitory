package com.ruoyi.material.apply.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.material.apply.domain.MaterialApply;

import java.util.List;

/**
 * 物资申领Service接口
 * 
 * @author ruoyi
 * @date 2023-04-14
 */
public interface IMaterialApplyService extends IService<MaterialApply>
{
    /**
     * 查询物资申领
     * 
     * @param applicationId 物资申领主键
     * @return 物资申领
     */
    public MaterialApply selectMaterialApplyByApplicationId(Long applicationId);

    /**
     * 查询物资申领列表
     * 
     * @param materialApply 物资申领
     * @return 物资申领集合
     */
    public List<MaterialApply> selectMaterialApplyList(MaterialApply materialApply);

    /**
     * 新增物资申领
     * 
     * @param materialApply 物资申领
     * @return 结果
     */
    public int insertMaterialApply(MaterialApply materialApply);

    /**
     * 修改物资申领
     * 
     * @param materialApply 物资申领
     * @return 结果
     */
    public int updateMaterialApply(MaterialApply materialApply);

    /**
     * 批量删除物资申领
     * 
     * @param applicationIds 需要删除的物资申领主键集合
     * @return 结果
     */
    public int deleteMaterialApplyByApplicationIds(String applicationIds);

    /**
     * 删除物资申领信息
     * 
     * @param applicationId 物资申领主键
     * @return 结果
     */
    public int deleteMaterialApplyByApplicationId(Long applicationId);
}
