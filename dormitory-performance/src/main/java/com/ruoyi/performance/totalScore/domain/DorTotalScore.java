package com.ruoyi.performance.totalScore.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 宿舍总分数对象 dor_total_score
 * 
 * @author ruoyi
 * @date 2023-03-31
 */
@TableName("dor_total_score")
public class DorTotalScore extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 总分数表id */
    private Long id;

    /** 标题 */
    @TableField("title")
    @Excel(name = "标题")
    private String title;

    /** 宿舍编号 */
    @TableField("dor_id")
    @Excel(name = "宿舍编号")
    private String dorId;

    /** 宿舍楼id */
    @TableField("building_Id")
    @Excel(name = "宿舍楼id")
    private String buildingId;

    /** 总分数 */
    @TableField("total_score")
    @Excel(name = "总分数")
    private Long totalScore;

    /** 生成时间 */
    @TableField("build_time")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date buildTime;

    /** 最后更新时间 */
    @TableField("latest_update_time")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date latestUpdateTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setDorId(String dorId) 
    {
        this.dorId = dorId;
    }

    public String getDorId() 
    {
        return dorId;
    }
    public void setBuildingId(String buildingId) 
    {
        this.buildingId = buildingId;
    }

    public String getBuildingId() 
    {
        return buildingId;
    }
    public void setTotalScore(Long totalScore) 
    {
        this.totalScore = totalScore;
    }

    public Long getTotalScore() 
    {
        return totalScore;
    }
    public void setBuildTime(Date buildTime) 
    {
        this.buildTime = buildTime;
    }

    public Date getBuildTime() 
    {
        return buildTime;
    }
    public void setLatestUpdateTime(Date latestUpdateTime) 
    {
        this.latestUpdateTime = latestUpdateTime;
    }

    public Date getLatestUpdateTime() 
    {
        return latestUpdateTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("dorId", getDorId())
            .append("buildingId", getBuildingId())
            .append("totalScore", getTotalScore())
            .append("buildTime", getBuildTime())
            .append("latestUpdateTime", getLatestUpdateTime())
            .toString();
    }
}
