package com.ruoyi.material.apply.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 物资申领对象 material_apply
 * 
 * @author ruoyi
 * @date 2023-03-28
 */
@TableName("material_apply")
public class MaterialApply extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 申领表id */
    private Long applicationId;

    /** 申领物品名字 */
    @TableField("material_name")
    @Excel(name = "申领物品名字")
    private String materialName;

    /** 申领人id（学生） */
    @TableField("apply_person")
    @Excel(name = "申领人id", readConverterExp = "学=生")
    private String applyPerson;

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
    public void setMaterialName(String materialName) 
    {
        this.materialName = materialName;
    }

    public String getMaterialName() 
    {
        return materialName;
    }
    public void setApplyPerson(String applyPerson) 
    {
        this.applyPerson = applyPerson;
    }

    public String getApplyPerson() 
    {
        return applyPerson;
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
            .append("materialName", getMaterialName())
            .append("applyPerson", getApplyPerson())
            .append("number", getNumber())
            .append("applyTime", getApplyTime())
            .append("status", getStatus())
            .append("handlePeople", getHandlePeople())
            .toString();
    }
}
