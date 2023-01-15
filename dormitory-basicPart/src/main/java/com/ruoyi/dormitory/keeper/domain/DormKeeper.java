package com.ruoyi.dormitory.keeper.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 宿管信息对象 dorm_keeper
 * 
 * @author ruoyi
 * @date 2023-01-06
 */
@TableName("dorm_keeper")
public class DormKeeper extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 宿管id */
    private Long dkId;

    /** 宿管名字 */
    @TableField("name")
    @Excel(name = "宿管名字")
    private String name;

    /** 管理宿舍楼号 */
    @TableField("manager_dor")
    @Excel(name = "管理宿舍楼号")
    private String managerDor;

    /** 所处办公室地址 */
    @TableField("location")
    @Excel(name = "所处办公室地址")
    private String location;

    /** 联系电话 */
    @TableField("phoneNumber")
    @Excel(name = "联系电话")
    private String phoneNumber;

    public void setDkId(Long dkId) 
    {
        this.dkId = dkId;
    }

    public Long getDkId() 
    {
        return dkId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setManagerDor(String managerDor) 
    {
        this.managerDor = managerDor;
    }

    public String getManagerDor() 
    {
        return managerDor;
    }
    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
    }
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("dkId", getDkId())
            .append("name", getName())
            .append("managerDor", getManagerDor())
            .append("location", getLocation())
            .append("phoneNumber", getPhoneNumber())
            .toString();
    }
}
