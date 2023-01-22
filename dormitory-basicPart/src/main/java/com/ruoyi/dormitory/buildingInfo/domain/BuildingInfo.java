package com.ruoyi.dormitory.buildingInfo.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 宿舍楼信息对象 buildingInfo
 * 
 * @author ruoyi
 * @date 2023-01-22
 */
@TableName("buildingInfo")
public class BuildingInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 宿舍楼编号 */
    private String buildingId;

    /** 宿舍楼名称 */
    @TableField("buildingName")
    @Excel(name = "宿舍楼名称")
    private String buildingName;

    /** 楼层数 */
    @TableField("floorNumber")
    @Excel(name = "楼层数")
    private Long floorNumber;

    /** 可住宿舍数 */
    @TableField("capacity")
    @Excel(name = "可住宿舍数")
    private Long capacity;

    /** 实住宿舍数 */
    @TableField("permanentResidents")
    @Excel(name = "实住宿舍数")
    private Long permanentResidents;



    public void setBuildingId(String buildingId) 
    {
        this.buildingId = buildingId;
    }

    public String getBuildingId() 
    {
        return buildingId;
    }
    public void setBuildingName(String buildingName) 
    {
        this.buildingName = buildingName;
    }

    public String getBuildingName() 
    {
        return buildingName;
    }
    public void setFloorNumber(Long floorNumber) 
    {
        this.floorNumber = floorNumber;
    }

    public Long getFloorNumber() 
    {
        return floorNumber;
    }
    public void setCapacity(Long capacity) 
    {
        this.capacity = capacity;
    }

    public Long getCapacity() 
    {
        return capacity;
    }
    public void setPermanentResidents(Long permanentResidents) 
    {
        this.permanentResidents = permanentResidents;
    }

    public Long getPermanentResidents() 
    {
        return permanentResidents;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("buildingId", getBuildingId())
            .append("buildingName", getBuildingName())
            .append("floorNumber", getFloorNumber())
            .append("capacity", getCapacity())
            .append("permanentResidents", getPermanentResidents())
            .toString();
    }
}
