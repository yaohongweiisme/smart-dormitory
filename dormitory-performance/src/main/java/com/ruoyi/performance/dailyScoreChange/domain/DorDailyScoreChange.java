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
 * @date 2023-03-11
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

    /** 分数变动值 */
    @TableField("score_change_value")
    @Excel(name = "分数变动值")
    private Long scoreChangeValue;

    /** 1代表加分，0代表扣分 */
    @TableField("kind")
    @Excel(name = "1代表加分，0代表扣分")
    private Long kind;

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
    public void setScoreChangeValue(Long scoreChangeValue) 
    {
        this.scoreChangeValue = scoreChangeValue;
    }

    public Long getScoreChangeValue() 
    {
        return scoreChangeValue;
    }
    public void setKind(Long kind) 
    {
        this.kind = kind;
    }

    public Long getKind() 
    {
        return kind;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("dorId", getDorId())
            .append("scoreChangeValue", getScoreChangeValue())
            .append("kind", getKind())
            .toString();
    }
}
