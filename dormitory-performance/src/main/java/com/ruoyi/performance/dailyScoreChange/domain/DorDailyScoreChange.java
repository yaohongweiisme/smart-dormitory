package com.ruoyi.performance.dailyScoreChange.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 宿舍每日分数浮动对象 dor_daily_score_change
 * 
 * @author ruoyi
 * @date 2023-03-31
 */
@TableName("dor_daily_score_change")
public class DorDailyScoreChange extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 宿舍编号 */
    @TableField("dor_id")
    @Excel(name = "宿舍编号")
    private String dorId;

    /** 宿舍楼id */
    @TableField("building_Id")
    @Excel(name = "宿舍楼id")
    private Long buildingId;

    /** 对应总分数表编号 */
    @TableField("total_sorce_id")
    @Excel(name = "对应总分数表编号")
    private Long totalSorceId;

    /** 分数变动详情值 */
    @TableField("score_change_value")
    @Excel(name = "分数变动详情值")
    private Long scoreChangeValue;

    /** 原因 */
    @TableField("reason")
    @Excel(name = "原因")
    private String reason;

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
    public void setBuildingId(Long buildingId) 
    {
        this.buildingId = buildingId;
    }

    public Long getBuildingId() 
    {
        return buildingId;
    }
    public void setTotalSorceId(Long totalSorceId) 
    {
        this.totalSorceId = totalSorceId;
    }

    public Long getTotalSorceId() 
    {
        return totalSorceId;
    }
    public void setScoreChangeValue(Long scoreChangeValue) 
    {
        this.scoreChangeValue = scoreChangeValue;
    }

    public Long getScoreChangeValue() 
    {
        return scoreChangeValue;
    }
    public void setReason(String reason) 
    {
        this.reason = reason;
    }

    public String getReason() 
    {
        return reason;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("dorId", getDorId())
            .append("buildingId", getBuildingId())
            .append("totalSorceId", getTotalSorceId())
            .append("scoreChangeValue", getScoreChangeValue())
            .append("reason", getReason())
            .toString();
    }
}
