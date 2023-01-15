package com.ruoyi.dormitory.student.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生信息对象 student
 * 
 * @author ruoyi
 * @date 2023-01-01
 */
public class Student extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学号 */
    private String stuId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long age;

    /** 性别(1为男，0为女) */
    @Excel(name = "性别(1为男，0为女)")
    private String sex;

    /** 出生年月日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生年月日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthday;

    /** 所属院系 */
    @Excel(name = "所属院系")
    private String department;

    /** 班级 */
    @Excel(name = "班级")
    private String classes;

    public void setStuId(String stuId) 
    {
        this.stuId = stuId;
    }

    public String getStuId() 
    {
        return stuId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setAge(Long age) 
    {
        this.age = age;
    }

    public Long getAge() 
    {
        return age;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setBirthday(Date birthday) 
    {
        this.birthday = birthday;
    }

    public Date getBirthday() 
    {
        return birthday;
    }
    public void setDepartment(String department) 
    {
        this.department = department;
    }

    public String getDepartment() 
    {
        return department;
    }
    public void setClasses(String classes) 
    {
        this.classes = classes;
    }

    public String getClasses() 
    {
        return classes;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("stuId", getStuId())
            .append("name", getName())
            .append("age", getAge())
            .append("sex", getSex())
            .append("birthday", getBirthday())
            .append("department", getDepartment())
            .append("classes", getClasses())
            .toString();
    }
}
