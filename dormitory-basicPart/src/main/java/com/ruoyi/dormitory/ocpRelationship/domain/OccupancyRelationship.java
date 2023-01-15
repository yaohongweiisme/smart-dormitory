package com.ruoyi.dormitory.ocpRelationship.domain;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 宿舍入住关系对象 occupancyRelationship
 * 
 * @author ruoyi
 * @date 2023-01-01
 */
@TableName("occupancyRelationship")
public class OccupancyRelationship extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 入住表id */
    private Long ocpId;

    /** 学生id */
    @Excel(name = "学生id")
    private String stuId;

    /** 宿舍编号 */
    @Excel(name = "宿舍编号")
    private String dormitoryId;

    /** 床号 */
    @Excel(name = "床号")
    private Long bedNumber;

    /** 入住开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入住开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 入住结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入住结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    public void setOcpId(Long ocpId)
    {
        this.ocpId = ocpId;
    }

    public Long getOcpId()
    {
        return ocpId;
    }
    public void setStuId(String stuId) 
    {
        this.stuId = stuId;
    }

    public String getStuId() 
    {
        return stuId;
    }
    public void setDormitoryId(String dormitoryId) 
    {
        this.dormitoryId = dormitoryId;
    }

    public String getDormitoryId() 
    {
        return dormitoryId;
    }
    public void setBedNumber(Long bedNumber) 
    {
        this.bedNumber = bedNumber;
    }

    public Long getBedNumber() 
    {
        return bedNumber;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ocpId", getOcpId())
            .append("stuId", getStuId())
            .append("dormitoryId", getDormitoryId())
            .append("bedNumber", getBedNumber())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .toString();
    }
}
