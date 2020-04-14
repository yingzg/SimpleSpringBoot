package com.example.express.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.express.Common.Utils.CollectionUtils;
import com.example.express.entity.SysUser;
import com.example.express.mapper.SysUserMapper;
import com.example.express.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author guozhiying
 * @since 2020-04-10
 */
@Slf4j
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getByName(String username) {
        List<SysUser> userList = sysUserMapper.selectList(new QueryWrapper<SysUser>().eq("username", username));

        return CollectionUtils.getListFirst(userList);
    }
}
