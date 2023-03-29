package com.ruoyi.material.apply.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import com.ruoyi.material.apply.domain.MaterialApply;

/**
 * 物资申领Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-28
 */
public interface MaterialApplyMapper extends BaseMapper<MaterialApply>
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
     * 删除物资申领
     * 
     * @param applicationId 物资申领主键
     * @return 结果
     */
    public int deleteMaterialApplyByApplicationId(Long applicationId);

    /**
     * 批量删除物资申领
     * 
     * @param applicationIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMaterialApplyByApplicationIds(String[] applicationIds);
}
