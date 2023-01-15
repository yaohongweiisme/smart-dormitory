package com.ruoyi.payment.statusManager.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 缴费状态对象 payment_status
 * 
 * @author ruoyi
 * @date 2023-01-03
 */
@TableName("payment_status")
public class PaymentStatus extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 缴费情况id */
    private Long statusId;

    /** 缴费项目id */
    @TableField("project_id")
    @Excel(name = "缴费项目id")
    private Long projectId;

    /** 缴费宿舍id */
    @TableField("dormitory_id")
    @Excel(name = "缴费宿舍id")
    private String dormitoryId;

    /** 缴费状态（0=未缴费，1=缴费完成） */
    @TableField("status")
    @Excel(name = "缴费状态", readConverterExp = "0==未缴费，1=缴费完成")
    private Long status;

    /** 完成缴费时间 */
    @TableField("finish_time")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "完成缴费时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date finishTime;

    public void setStatusId(Long statusId) 
    {
        this.statusId = statusId;
    }

    public Long getStatusId() 
    {
        return statusId;
    }
    public void setProjectId(Long projectId) 
    {
        this.projectId = projectId;
    }

    public Long getProjectId() 
    {
        return projectId;
    }
    public void setDormitoryId(String dormitoryId) 
    {
        this.dormitoryId = dormitoryId;
    }

    public String getDormitoryId() 
    {
        return dormitoryId;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setFinishTime(Date finishTime) 
    {
        this.finishTime = finishTime;
    }

    public Date getFinishTime() 
    {
        return finishTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("statusId", getStatusId())
            .append("projectId", getProjectId())
            .append("dormitoryId", getDormitoryId())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("finishTime", getFinishTime())
            .toString();
    }
}
