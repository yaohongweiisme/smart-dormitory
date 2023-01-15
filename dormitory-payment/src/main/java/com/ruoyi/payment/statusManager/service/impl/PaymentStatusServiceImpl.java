package com.ruoyi.payment.statusManager.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.payment.projectManager.domain.PaymentProject;
import com.ruoyi.payment.projectManager.service.IPaymentProjectService;
import com.ruoyi.payment.statusManager.vo.PaymentStatusVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.payment.statusManager.mapper.PaymentStatusMapper;
import com.ruoyi.payment.statusManager.domain.PaymentStatus;
import com.ruoyi.payment.statusManager.service.IPaymentStatusService;
import com.ruoyi.common.core.text.Convert;

/**
 * 缴费状态Service业务层处理
 *
 * @author ruoyi
 * @date 2023-01-03
 */
@Service
public class PaymentStatusServiceImpl extends ServiceImpl<PaymentStatusMapper, PaymentStatus> implements IPaymentStatusService {
    @Autowired
    private PaymentStatusMapper paymentStatusMapper;

    @Autowired
    private IPaymentProjectService paymentProjectService;

    /**
     * 查询缴费状态
     *
     * @param statusId 缴费状态主键
     * @return 缴费状态
     */
    @Override
    public PaymentStatus selectPaymentStatusByStatusId(Long statusId) {
        return paymentStatusMapper.selectPaymentStatusByStatusId(statusId);
    }

    /**
     * 查询缴费状态列表
     *
     * @param paymentStatus 缴费状态
     * @return 缴费状态
     */
    @Override
    public List<PaymentStatus> selectPaymentStatusList(PaymentStatus paymentStatus) {
        return paymentStatusMapper.selectPaymentStatusList(paymentStatus);
    }

    /**
     * 新增缴费状态
     *
     * @param paymentStatus 缴费状态
     * @return 结果
     */
    @Override
    public int insertPaymentStatus(PaymentStatus paymentStatus) {
        paymentStatus.setCreateTime(DateUtils.getNowDate());
        return paymentStatusMapper.insertPaymentStatus(paymentStatus);
    }

    /**
     * 修改缴费状态
     *
     * @param paymentStatus 缴费状态
     * @return 结果
     */
    @Override
    public int updatePaymentStatus(PaymentStatus paymentStatus) {
        return paymentStatusMapper.updatePaymentStatus(paymentStatus);
    }

    /**
     * 批量删除缴费状态
     *
     * @param statusIds 需要删除的缴费状态主键
     * @return 结果
     */
    @Override
    public int deletePaymentStatusByStatusIds(String statusIds) {
        return paymentStatusMapper.deletePaymentStatusByStatusIds(Convert.toStrArray(statusIds));
    }

    /**
     * 删除缴费状态信息
     *
     * @param statusId 缴费状态主键
     * @return 结果
     */
    @Override
    public int deletePaymentStatusByStatusId(Long statusId) {
        return paymentStatusMapper.deletePaymentStatusByStatusId(statusId);
    }

    @Override
    public List<PaymentStatusVo> getVoList(List<PaymentStatus> list) {
        return list.stream().map(item -> {
            PaymentStatusVo paymentStatusVo = new PaymentStatusVo();
            BeanUtils.copyProperties(item, paymentStatusVo);
            Long projectId = item.getProjectId();
            PaymentProject paymentProject = paymentProjectService.selectPaymentProjectByProjectId(projectId);
            String projectTittle = paymentProject.getProjectTittle();
            paymentStatusVo.setProjectTittle(projectTittle);
            return paymentStatusVo;
        }).collect(Collectors.toList());
    }
}
