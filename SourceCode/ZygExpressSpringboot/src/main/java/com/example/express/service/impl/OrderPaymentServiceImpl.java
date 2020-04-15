package com.example.express.service.impl;

import com.example.express.entity.OrderPayment;
import com.example.express.mapper.OrderPaymentMapper;
import com.example.express.service.OrderPaymentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单支付表 服务实现类
 * </p>
 *
 * @author guozhiying
 * @since 2020-04-10
 */
@Service
public class OrderPaymentServiceImpl extends ServiceImpl<OrderPaymentMapper, OrderPayment> implements OrderPaymentService {

}
