package com.ruoyi.material.inventory.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 物资库存对象 material_inventory
 * 
 * @author ruoyi
 * @date 2023-04-01
 */
@TableName("material_inventory")
public class MaterialInventory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 物资物品id */
    private Long materialId;

    /** 物品名字 */
    @TableField("name")
    @Excel(name = "物品名字")
    private String name;

    /** 物品数量 */
    @TableField("number")
    @Excel(name = "物品数量")
    private Long number;

    /** 物品单价 */
    @TableField("price")
    @Excel(name = "物品单价")
    private BigDecimal price;

    public void setMaterialId(Long materialId) 
    {
        this.materialId = materialId;
    }

    public Long getMaterialId() 
    {
        return materialId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setNumber(Long number) 
    {
        this.number = number;
    }

    public Long getNumber() 
    {
        return number;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("materialId", getMaterialId())
            .append("name", getName())
            .append("number", getNumber())
            .append("price", getPrice())
            .toString();
    }
}
