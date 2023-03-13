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
 * @date 2023-03-11
 */
@TableName("dor_total_score")
public class DorTotalScore extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 总分数表id */
    private Long id;

    /** 宿舍楼id */
    @TableField("building_Id")
    @Excel(name = "宿舍楼id")
    private String buildingId;

    /** 宿舍编号 */
    @TableField("dor_id")
    @Excel(name = "宿舍编号")
    private String dorId;

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
    @TableField("last_update_time")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastUpdateTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBuildingId(String buildingId) 
    {
        this.buildingId = buildingId;
    }

    public String getBuildingId() 
    {
        return buildingId;
    }
    public void setDorId(String dorId) 
    {
        this.dorId = dorId;
    }

    public String getDorId() 
    {
        return dorId;
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
    public void setLastUpdateTime(Date lastUpdateTime) 
    {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Date getLastUpdateTime() 
    {
        return lastUpdateTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("buildingId", getBuildingId())
            .append("dorId", getDorId())
            .append("totalScore", getTotalScore())
            .append("buildTime", getBuildTime())
            .append("lastUpdateTime", getLastUpdateTime())
            .toString();
    }
}
