package com.ruoyi.material.requirements.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 物资采购需求对象 purchasing_requirements
 * 
 * @author ruoyi
 * @date 2023-04-01
 */
@TableName("purchasing_requirements")
public class PurchasingRequirements extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 采购需求id */
    private Long purchasingRequirementsId;

    /** 物品id */
    @TableField("material_id")
    @Excel(name = "物品id")
    private Long materialId;

    /** 需补充数量 */
    @TableField("replenishment")
    @Excel(name = "需补充数量")
    private Long replenishment;

    /** 需求产生时间 */
    @TableField("build_time")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "需求产生时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date buildTime;

    /** 需求建立人 */
    @TableField("buid_person")
    @Excel(name = "需求建立人")
    private String buidPerson;

    public void setPurchasingRequirementsId(Long purchasingRequirementsId) 
    {
        this.purchasingRequirementsId = purchasingRequirementsId;
    }

    public Long getPurchasingRequirementsId() 
    {
        return purchasingRequirementsId;
    }
    public void setMaterialId(Long materialId) 
    {
        this.materialId = materialId;
    }

    public Long getMaterialId() 
    {
        return materialId;
    }
    public void setReplenishment(Long replenishment) 
    {
        this.replenishment = replenishment;
    }

    public Long getReplenishment() 
    {
        return replenishment;
    }
    public void setBuildTime(Date buildTime) 
    {
        this.buildTime = buildTime;
    }

    public Date getBuildTime() 
    {
        return buildTime;
    }
    public void setBuidPerson(String buidPerson) 
    {
        this.buidPerson = buidPerson;
    }

    public String getBuidPerson() 
    {
        return buidPerson;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("purchasingRequirementsId", getPurchasingRequirementsId())
            .append("materialId", getMaterialId())
            .append("replenishment", getReplenishment())
            .append("buildTime", getBuildTime())
            .append("buidPerson", getBuidPerson())
            .toString();
    }
}
