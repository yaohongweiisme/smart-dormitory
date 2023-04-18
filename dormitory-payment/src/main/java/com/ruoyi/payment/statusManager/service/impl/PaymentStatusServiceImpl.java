package com.ruoyi.payment.statusManager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.dormitory.stuDormitory.mapper.DormitoryMapper;
import com.ruoyi.payment.projectManager.domain.PaymentProject;
import com.ruoyi.payment.projectManager.service.IPaymentProjectService;
import com.ruoyi.payment.statusManager.domain.PaymentStatus;
import com.ruoyi.payment.statusManager.mapper.PaymentStatusMapper;
import com.ruoyi.payment.statusManager.service.IPaymentStatusService;
import com.ruoyi.payment.statusManager.vo.PaymentStatusVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    private DormitoryMapper dormitoryMapper;

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
        int rows = paymentStatusMapper.updatePaymentStatus(paymentStatus);
        Long status = paymentStatus.getStatus();
        handleStatusChange(paymentStatus, status);
        return rows;
    }
    //处理状态变更
    private void handleStatusChange(PaymentStatus paymentStatus, Long status) {
        Long statusId = paymentStatus.getStatusId();
        Long projectId = paymentStatusMapper.selectPaymentStatusByStatusId(statusId).getProjectId();
        if (status == 1) {        //若已完成，检测其他宿舍是否已完成
            boolean buildingPaid = checkIfOneBuildAllPaid(projectId);
            if (buildingPaid) {
                PaymentProject paymentProject = new PaymentProject();
                paymentProject.setProjectProgress(1L);
                paymentProject.setProjectId(projectId);
                paymentProjectService.updatePaymentProject(paymentProject);
            }
        } else {      //当更改为未完成状态或原先已经是未完成状态时，都要将缴费项目的状态置为进行中
            PaymentProject paymentProject = new PaymentProject();
            paymentProject.setProjectProgress(0L);
            paymentProject.setProjectId(projectId);
            paymentProjectService.updatePaymentProject(paymentProject);
        }
    }
    //返回值为true则当前缴费单id对应的缴费项目是已完成的状态
    private boolean checkIfOneBuildAllPaid(Long project_id) {
        boolean flag = true;
        LambdaQueryWrapper<PaymentStatus> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(PaymentStatus::getStatus, 0);
        queryWrapper.eq(PaymentStatus::getProjectId, project_id);
        if (paymentStatusMapper.selectOne(queryWrapper) != null) {
            flag = false;
        }
        return flag;
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
