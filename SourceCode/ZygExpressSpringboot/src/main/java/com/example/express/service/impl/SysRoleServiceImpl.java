package com.example.express.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.express.entity.SysRole;
import com.example.express.mapper.SysRoleMapper;
import com.example.express.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public SysRole selectRoleByRoleName(String Rolename) {

        SysRole role = sysRoleMapper.selectOne(new QueryWrapper<SysRole>().eq("Rolename", Rolename));

        return role;

    }
}
