package com.ruoyi.dormitoryRepair.buildingStaff.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 物业人员信息对象 buildingStaff
 * 
 * @author ruoyi
 * @date 2023-01-07
 */
@TableName("buildingStaff")
public class BuildingStaff extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 物业人员id */
    private Long id;

    /** 姓名 */
    @TableField("name")
    @Excel(name = "姓名")
    private String name;

    /** 联系号码 */
    @TableField("phoneNumber")
    @Excel(name = "联系号码")
    private String phoneNumber;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
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
            .append("id", getId())
            .append("name", getName())
            .append("phoneNumber", getPhoneNumber())
            .toString();
    }
}
