package com.ruoyi.payment.statusManager.vo;

import com.ruoyi.payment.statusManager.domain.PaymentStatus;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PaymentStatusVo extends PaymentStatus {
    private String projectTittle;

    public String getProjectTittle() {
        return projectTittle;
    }

    public void setProjectTittle(String projectTittle) {
        this.projectTittle = projectTittle;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("statusId", getStatusId())
                .append("projectId", getProjectId())
                .append("projectTittle", getProjectTittle())
                .append("dormitoryId", getDormitoryId())
                .append("status", getStatus())
                .append("createTime", getCreateTime())
                .append("finishTime", getFinishTime())
                .toString();
    }
}
