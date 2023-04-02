package com.ruoyi.material.order.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 物资采购单对象 purchase_order
 * 
 * @author ruoyi
 * @date 2023-04-01
 */
@TableName("purchase_order")
public class PurchaseOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 采购单id */
    private Long purchaseOrderId;

    /** 采购物品清单 */
    @TableField("object_list")
    @Excel(name = "采购物品清单")
    private String objectList;

    /** 采购人 */
    @TableField("purchase_person")
    @Excel(name = "采购人")
    private String purchasePerson;

    /** 采购单建立时间 */
    @TableField("build_time")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "采购单建立时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date buildTime;

    /** 状态（0进行中，1已采购） */
    @TableField("status")
    @Excel(name = "状态", readConverterExp = "0=进行中，1已采购")
    private Long status;

    public void setPurchaseOrderId(Long purchaseOrderId) 
    {
        this.purchaseOrderId = purchaseOrderId;
    }

    public Long getPurchaseOrderId() 
    {
        return purchaseOrderId;
    }
    public void setObjectList(String objectList) 
    {
        this.objectList = objectList;
    }

    public String getObjectList() 
    {
        return objectList;
    }
    public void setPurchasePerson(String purchasePerson) 
    {
        this.purchasePerson = purchasePerson;
    }

    public String getPurchasePerson() 
    {
        return purchasePerson;
    }
    public void setBuildTime(Date buildTime) 
    {
        this.buildTime = buildTime;
    }

    public Date getBuildTime() 
    {
        return buildTime;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("purchaseOrderId", getPurchaseOrderId())
            .append("objectList", getObjectList())
            .append("purchasePerson", getPurchasePerson())
            .append("buildTime", getBuildTime())
            .append("status", getStatus())
            .toString();
    }
}
