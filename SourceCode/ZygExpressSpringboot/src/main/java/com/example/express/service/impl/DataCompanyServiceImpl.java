package com.example.express.service.impl;

import com.example.express.entity.DataCompany;
import com.example.express.mapper.DataCompanyMapper;
import com.example.express.service.DataCompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 快递公司数据表 服务实现类
 * </p>
 *
 * @author guozhiying
 * @since 2020-04-10
 */
@Service
public class DataCompanyServiceImpl extends ServiceImpl<DataCompanyMapper, DataCompany> implements DataCompanyService {

}
