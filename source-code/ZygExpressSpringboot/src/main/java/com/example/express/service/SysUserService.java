package com.example.express.service;

import com.example.express.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author guozhiying
 * @since 2020-04-10
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 根据用户名查找用户
     */
    SysUser getByName(String username);

}
