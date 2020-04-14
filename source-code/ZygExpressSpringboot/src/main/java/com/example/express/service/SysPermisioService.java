package com.example.express.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.express.entity.SysPermision;

import java.util.List;

public interface SysPermisioService extends IService<SysPermision> {


    List<SysPermision> GetPermissionByRoleId(int RoleId);

}
