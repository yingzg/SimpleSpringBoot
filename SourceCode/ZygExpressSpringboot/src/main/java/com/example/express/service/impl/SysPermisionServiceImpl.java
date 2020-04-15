package com.example.express.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.express.entity.SysPermision;
import com.example.express.mapper.SysPermisionMapper;
import com.example.express.service.SysPermisioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysPermisionServiceImpl extends ServiceImpl<SysPermisionMapper, SysPermision> implements SysPermisioService {

   @Autowired
   private SysPermisionMapper sysPermisionMapper;

    @Override
    public List<SysPermision> GetPermissionByRoleId(int RoleId) {

        List<SysPermision> Permisionlist= sysPermisionMapper.selectList(new QueryWrapper<SysPermision>().eq("RoleId", RoleId));

        return  Permisionlist;
    }
}
