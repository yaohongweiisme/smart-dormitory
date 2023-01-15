package com.ruoyi.payment.projectManager.service;

import java.util.List;
import com.ruoyi.payment.projectManager.domain.PaymentProject;
import org.springframework.stereotype.Service;

/**
 * 缴费项目管理Service接口
 * 
 * @author ruoyi
 * @date 2023-01-03
 */
public interface IPaymentProjectService
{
    /**
     * 查询缴费项目管理
     * 
     * @param projectId 缴费项目管理主键
     * @return 缴费项目管理
     */
    public PaymentProject selectPaymentProjectByProjectId(Long projectId);

    /**
     * 查询缴费项目管理列表
     * 
     * @param paymentProject 缴费项目管理
     * @return 缴费项目管理集合
     */
    public List<PaymentProject> selectPaymentProjectList(PaymentProject paymentProject);

    /**
     * 新增缴费项目管理
     * 
     * @param paymentProject 缴费项目管理
     * @return 结果
     */
    public int insertPaymentProject(PaymentProject paymentProject);

    /**
     * 修改缴费项目管理
     * 
     * @param paymentProject 缴费项目管理
     * @return 结果
     */
    public int updatePaymentProject(PaymentProject paymentProject);

    /**
     * 批量删除缴费项目管理
     * 
     * @param projectIds 需要删除的缴费项目管理主键集合
     * @return 结果
     */
    public int deletePaymentProjectByProjectIds(String projectIds);

    /**
     * 删除缴费项目管理信息
     * 
     * @param projectId 缴费项目管理主键
     * @return 结果
     */
    public int deletePaymentProjectByProjectId(Long projectId);
}
