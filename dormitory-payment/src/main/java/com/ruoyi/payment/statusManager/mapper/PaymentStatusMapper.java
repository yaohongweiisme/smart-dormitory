package com.ruoyi.payment.statusManager.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.payment.statusManager.domain.PaymentStatus;
import org.apache.ibatis.annotations.Mapper;

/**
 * 缴费状态Mapper接口
 * 
 * @author ruoyi
 * @date 2023-01-03
 */
@Mapper
public interface PaymentStatusMapper extends BaseMapper<PaymentStatus>
{
    /**
     * 查询缴费状态
     * 
     * @param statusId 缴费状态主键
     * @return 缴费状态
     */
    public PaymentStatus selectPaymentStatusByStatusId(Long statusId);

    /**
     * 查询缴费状态列表
     * 
     * @param paymentStatus 缴费状态
     * @return 缴费状态集合
     */
    public List<PaymentStatus> selectPaymentStatusList(PaymentStatus paymentStatus);

    /**
     * 新增缴费状态
     * 
     * @param paymentStatus 缴费状态
     * @return 结果
     */
    public int insertPaymentStatus(PaymentStatus paymentStatus);

    /**
     * 修改缴费状态
     * 
     * @param paymentStatus 缴费状态
     * @return 结果
     */
    public int updatePaymentStatus(PaymentStatus paymentStatus);

    /**
     * 删除缴费状态
     * 
     * @param statusId 缴费状态主键
     * @return 结果
     */
    public int deletePaymentStatusByStatusId(Long statusId);

    /**
     * 批量删除缴费状态
     * 
     * @param statusIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePaymentStatusByStatusIds(String[] statusIds);
}
