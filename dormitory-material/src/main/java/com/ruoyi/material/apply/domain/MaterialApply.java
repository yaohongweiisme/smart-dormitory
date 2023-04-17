package com.ruoyi.material.apply.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 物资申领对象 material_apply
 * 
 * @author ruoyi
 * @date 2023-04-14
 */
@TableName("material_apply")
public class MaterialApply extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 申领表id */
    private Long applicationId;

    /** 申领物品id */
    @TableField("material_id")
    @Excel(name = "申领物品id")
    private Long materialId;

    /** 申领宿舍号 */
    @TableField("apply_dor_id")
    @Excel(name = "申领宿舍号")
    private String applyDorId;

    /** 申领数量 */
    @TableField("number")
    @Excel(name = "申领数量")
    private Long number;

    /** 申领时间 */
    @TableField("apply_time")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申领时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date applyTime;

    /** 申领状态(0申领中，1已处理) */
    @TableField("status")
    @Excel(name = "申领状态(0申领中，1已处理)")
    private Long status;

    /** 处理人id（物业人员） */
    @TableField("handle_people")
    @Excel(name = "处理人id", readConverterExp = "物=业人员")
    private Long handlePeople;

    public void setApplicationId(Long applicationId) 
    {
        this.applicationId = applicationId;
    }

    public Long getApplicationId() 
    {
        return applicationId;
    }
    public void setMaterialId(Long materialId) 
    {
        this.materialId = materialId;
    }

    public Long getMaterialId() 
    {
        return materialId;
    }
    public void setApplyDorId(String applyDorId) 
    {
        this.applyDorId = applyDorId;
    }

    public String getApplyDorId() 
    {
        return applyDorId;
    }
    public void setNumber(Long number) 
    {
        this.number = number;
    }

    public Long getNumber() 
    {
        return number;
    }
    public void setApplyTime(Date applyTime) 
    {
        this.applyTime = applyTime;
    }

    public Date getApplyTime() 
    {
        return applyTime;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setHandlePeople(Long handlePeople) 
    {
        this.handlePeople = handlePeople;
    }

    public Long getHandlePeople() 
    {
        return handlePeople;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("applicationId", getApplicationId())
            .append("materialId", getMaterialId())
            .append("applyDorId", getApplyDorId())
            .append("number", getNumber())
            .append("applyTime", getApplyTime())
            .append("status", getStatus())
            .append("handlePeople", getHandlePeople())
            .toString();
    }
}
