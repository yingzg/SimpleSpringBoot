package com.example.express.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.express.entity.SysRole;

public interface SysRoleService extends IService<SysRole> {

     SysRole selectRoleByRoleName(String Rolename);

}
