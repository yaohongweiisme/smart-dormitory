package com.ruoyi.payment.projectManager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.dormitory.stuDormitory.domain.Dormitory;
import com.ruoyi.dormitory.stuDormitory.mapper.DormitoryMapper;
import com.ruoyi.payment.projectManager.domain.PaymentProject;
import com.ruoyi.payment.projectManager.mapper.PaymentProjectMapper;
import com.ruoyi.payment.projectManager.service.IPaymentProjectService;
import com.ruoyi.payment.statusManager.domain.PaymentStatus;
import com.ruoyi.payment.statusManager.mapper.PaymentStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Autowired
    private DormitoryMapper dormitoryMapper;
    @Autowired
    private PaymentStatusMapper paymentStatusMapper;

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
        int insertResult = paymentProjectMapper.insertPaymentProject(paymentProject);
        if(insertResult!=0){
            PaymentStatus paymentStatus = new PaymentStatus();
            paymentStatus.setProjectId(paymentProject.getProjectId());
            paymentStatus.setStatus(0L);
            paymentStatus.setCreateTime(DateUtils.getNowDate());
            List<Dormitory> dormitories = getDormitoriesByBuildingId(paymentProject);
            for (Dormitory dormitory : dormitories) {
                String dorId = dormitory.getDorId();
                paymentStatus.setDormitoryId(dorId);
                paymentStatusMapper.insert(paymentStatus);
            }
        }
        return insertResult;
    }

    private List<Dormitory> getDormitoriesByBuildingId(PaymentProject paymentProject) {
        String projectObject = paymentProject.getProjectObject();
        LambdaQueryWrapper<Dormitory> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Dormitory::getBuildingId,projectObject);
        return dormitoryMapper.selectList(wrapper);
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
