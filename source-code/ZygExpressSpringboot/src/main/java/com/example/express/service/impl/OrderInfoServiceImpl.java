package com.example.express.service.impl;

import com.example.express.entity.OrderInfo;
import com.example.express.mapper.OrderInfoMapper;
import com.example.express.service.OrderInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单信息表 服务实现类
 * </p>
 *
 * @author guozhiying
 * @since 2020-04-10
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {

}
