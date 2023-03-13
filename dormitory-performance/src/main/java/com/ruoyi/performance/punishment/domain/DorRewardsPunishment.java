package com.ruoyi.performance.punishment.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 宿舍奖惩活动对象 dor_rewards_punishment
 * 
 * @author ruoyi
 * @date 2023-03-11
 */
@TableName("dor_rewards_punishment")
public class DorRewardsPunishment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 宿舍编号 */
    @TableField("dor_id")
    @Excel(name = "宿舍编号")
    private String dorId;

    /** 奖惩内容 */
    @TableField("content")
    @Excel(name = "奖惩内容")
    private String content;

    /** 性质（1表示奖励，0表示惩罚） */
    @TableField("kind")
    @Excel(name = "性质", readConverterExp = "1=表示奖励，0表示惩罚")
    private String kind;

    /** 1表示完成，0表示进行中 */
    @TableField("state")
    @Excel(name = "1表示完成，0表示进行中")
    private Long state;

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
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setKind(String kind) 
    {
        this.kind = kind;
    }

    public String getKind() 
    {
        return kind;
    }
    public void setState(Long state) 
    {
        this.state = state;
    }

    public Long getState() 
    {
        return state;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("dorId", getDorId())
            .append("content", getContent())
            .append("kind", getKind())
            .append("state", getState())
            .toString();
    }
}
