package com.ruoyi.dormitory.stuDormitory.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生宿舍信息对象 dormitory
 * 
 * @author ruoyi
 * @date 2023-01-08
 */
@TableName("dormitory")
public class Dormitory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 宿舍编号 */
    @TableField("dor_id")
    @Excel(name = "宿舍编号")
    private String dorId;

    /** 所处宿舍楼Id */
    @TableField("building_id")
    @Excel(name = "宿舍楼id")
    private String buildingId;

    /** 宿舍长学生id */
    @TableField("stu_id")
    @Excel(name = "宿舍长学生id")
    private String stuId;

    /** 宿舍地址（例如第几宿舍楼） */
    @TableField("location")
    @Excel(name = "宿舍地址", readConverterExp = "例=如第几宿舍楼")
    private String location;

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    /** 宿舍可容纳人数 */
    @TableField("capacity")
    @Excel(name = "宿舍可容纳人数")
    private Long capacity;

    /** 宿舍现人数 */
    @TableField("present_number")
    @Excel(name = "宿舍现人数")
    private Long presentNumber;

    /** 宿舍状态（0是正常，1是闲置，2是停宿） */
    @TableField("status")
    @Excel(name = "宿舍状态", readConverterExp = "0=是正常，1是闲置，2是停宿")
    private Long status;

    public void setDorId(String dorId) 
    {
        this.dorId = dorId;
    }

    public String getDorId() 
    {
        return dorId;
    }
    public void setStuId(String stuId) 
    {
        this.stuId = stuId;
    }

    public String getStuId() 
    {
        return stuId;
    }
    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
    }
    public void setCapacity(Long capacity) 
    {
        this.capacity = capacity;
    }

    public Long getCapacity() 
    {
        return capacity;
    }
    public void setPresentNumber(Long presentNumber) 
    {
        this.presentNumber = presentNumber;
    }

    public Long getPresentNumber() 
    {
        return presentNumber;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return "Dormitory{" +
                "dorId='" + dorId + '\'' +
                ", buildingId='" + buildingId + '\'' +
                ", stuId='" + stuId + '\'' +
                ", location='" + location + '\'' +
                ", capacity=" + capacity +
                ", presentNumber=" + presentNumber +
                ", status=" + status +
                '}';
    }
}
