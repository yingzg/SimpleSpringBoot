package com.example.express.service.impl;

import com.example.express.entity.PersistentLogins;
import com.example.express.mapper.PersistentLoginsMapper;
import com.example.express.service.PersistentLoginsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 登录持久化表 服务实现类
 * </p>
 *
 * @author guozhiying
 * @since 2020-04-10
 */
@Service
public class PersistentLoginsServiceImpl extends ServiceImpl<PersistentLoginsMapper, PersistentLogins> implements PersistentLoginsService {

}
