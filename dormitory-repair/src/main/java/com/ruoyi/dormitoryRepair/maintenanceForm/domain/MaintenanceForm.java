package com.ruoyi.dormitoryRepair.maintenanceForm.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 报修管理对象 maintenanceForm
 * 
 * @author ruoyi
 * @date 2023-01-07
 */
@TableName("maintenanceForm")
public class MaintenanceForm extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 报修信息id */
    private Long id;

    /** 报修宿舍id */
    @TableField("dorId")
    @Excel(name = "报修宿舍id")
    private String dorId;

    /** 报修问题详情 */
    @TableField("repairIssueDescription")
    @Excel(name = "报修问题详情")
    private String repairIssueDescription;

    /** 报修人姓名 */
    @TableField("linkmanName")
    @Excel(name = "报修人姓名")
    private String linkmanName;

    /** 报修人联系电话 */
    @TableField("phoneNumber")
    @Excel(name = "报修人联系电话")
    private String phoneNumber;

    /** 报修单状态(0=新建，1=跟进中，2=处理完毕) */
    @TableField("status")
    @Excel(name = "报修单状态(0=新建，1=跟进中，2=处理完毕)")
    private Long status;

    /** 物业处理人 */
    @TableField("handleMan")
    @Excel(name = "物业处理人")
    private String handleMan;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDorId(String dorId) 
    {
        this.dorId = dorId;
    }

    public String getDorId() 
    {
        return dorId;
    }
    public void setRepairIssueDescription(String repairIssueDescription) 
    {
        this.repairIssueDescription = repairIssueDescription;
    }

    public String getRepairIssueDescription() 
    {
        return repairIssueDescription;
    }
    public void setLinkmanName(String linkmanName) 
    {
        this.linkmanName = linkmanName;
    }

    public String getLinkmanName() 
    {
        return linkmanName;
    }
    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setHandleMan(String handleMan) 
    {
        this.handleMan = handleMan;
    }

    public String getHandleMan() 
    {
        return handleMan;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("dorId", getDorId())
            .append("repairIssueDescription", getRepairIssueDescription())
            .append("linkmanName", getLinkmanName())
            .append("phoneNumber", getPhoneNumber())
            .append("status", getStatus())
            .append("handleMan", getHandleMan())
            .toString();
    }
}
