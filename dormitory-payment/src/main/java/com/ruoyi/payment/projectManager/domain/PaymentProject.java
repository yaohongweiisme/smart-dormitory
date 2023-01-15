package com.ruoyi.payment.projectManager.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 缴费项目管理对象 payment_project
 * 
 * @author ruoyi
 * @date 2023-01-03
 */
@TableName("payment_project")
public class PaymentProject extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 缴费项目id */
    private Long projectId;

    /** 缴费项目标题 */
    @TableField("project_tittle")
    @Excel(name = "缴费项目标题")
    private String projectTittle;

    /** 缴费对象 */
    @TableField("project_object")
    @Excel(name = "缴费对象")
    private String projectObject;

    /** 负责人（某个宿管） */
    @TableField("principal")
    @Excel(name = "负责人", readConverterExp = "某个宿管")
    private String principal;

    /** 缴费进度(0=新建，1=进行中，2=已完成) */
    @TableField("project_progress")
    @Excel(name = "缴费进度(0=新建，1=进行中，2=已完成)")
    private Long projectProgress;

    /** 创建时间 */
    @Excel(name = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public void setProjectId(Long projectId) 
    {
        this.projectId = projectId;
    }

    public Long getProjectId() 
    {
        return projectId;
    }
    public void setProjectTittle(String projectTittle) 
    {
        this.projectTittle = projectTittle;
    }

    public String getProjectTittle() 
    {
        return projectTittle;
    }
    public void setProjectObject(String projectObject) 
    {
        this.projectObject = projectObject;
    }

    public String getProjectObject() 
    {
        return projectObject;
    }
    public void setPrincipal(String principal) 
    {
        this.principal = principal;
    }

    public String getPrincipal() 
    {
        return principal;
    }
    public void setProjectProgress(Long projectProgress) 
    {
        this.projectProgress = projectProgress;
    }

    public Long getProjectProgress() 
    {
        return projectProgress;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "PaymentProject{" +
                "projectId=" + projectId +
                ", projectTittle='" + projectTittle + '\'' +
                ", projectObject='" + projectObject + '\'' +
                ", principal='" + principal + '\'' +
                ", projectProgress=" + projectProgress +
                ", createTime=" + createTime +
                '}';
    }
}
