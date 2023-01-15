package com.ruoyi.payment.projectManager.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.payment.projectManager.mapper.PaymentProjectMapper;
import com.ruoyi.payment.projectManager.domain.PaymentProject;
import com.ruoyi.payment.projectManager.service.IPaymentProjectService;
import com.ruoyi.common.core.text.Convert;

/**
 * 缴费项目管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-01-03
 */
@Service
public class PaymentProjectServiceImpl implements IPaymentProjectService 
{
    @Autowired
    private PaymentProjectMapper paymentProjectMapper;

    /**
     * 查询缴费项目管理
     * 
     * @param projectId 缴费项目管理主键
     * @return 缴费项目管理
     */
    @Override
    public PaymentProject selectPaymentProjectByProjectId(Long projectId)
    {
        return paymentProjectMapper.selectPaymentProjectByProjectId(projectId);
    }

    /**
     * 查询缴费项目管理列表
     * 
     * @param paymentProject 缴费项目管理
     * @return 缴费项目管理
     */
    @Override
    public List<PaymentProject> selectPaymentProjectList(PaymentProject paymentProject)
    {
        return paymentProjectMapper.selectPaymentProjectList(paymentProject);
    }

    /**
     * 新增缴费项目管理
     * 
     * @param paymentProject 缴费项目管理
     * @return 结果
     */
    @Override
    public int insertPaymentProject(PaymentProject paymentProject)
    {
        paymentProject.setCreateTime(DateUtils.getNowDate());
        return paymentProjectMapper.insertPaymentProject(paymentProject);
    }

    /**
     * 修改缴费项目管理
     * 
     * @param paymentProject 缴费项目管理
     * @return 结果
     */
    @Override
    public int updatePaymentProject(PaymentProject paymentProject)
    {
        return paymentProjectMapper.updatePaymentProject(paymentProject);
    }

    /**
     * 批量删除缴费项目管理
     * 
     * @param projectIds 需要删除的缴费项目管理主键
     * @return 结果
     */
    @Override
    public int deletePaymentProjectByProjectIds(String projectIds)
    {
        return paymentProjectMapper.deletePaymentProjectByProjectIds(Convert.toStrArray(projectIds));
    }

    /**
     * 删除缴费项目管理信息
     * 
     * @param projectId 缴费项目管理主键
     * @return 结果
     */
    @Override
    public int deletePaymentProjectByProjectId(Long projectId)
    {
        return paymentProjectMapper.deletePaymentProjectByProjectId(projectId);
    }
}
