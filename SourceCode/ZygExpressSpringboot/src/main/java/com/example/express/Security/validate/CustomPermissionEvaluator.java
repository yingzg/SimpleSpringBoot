package com.example.express.Security.validate;

import com.example.express.entity.SysPermision;
import com.example.express.service.SysPermisioService;
import com.example.express.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {
    @Autowired
    private SysPermisioService permissionService;
    @Autowired
    private SysRoleService roleService;

    @Override
    public boolean hasPermission(Authentication authentication, Object targetUrl, Object targetPermission) {
        // 获得loadUserByUsername()方法的结果
        CustomUserDetail user = (CustomUserDetail)authentication.getPrincipal();
        // 获得loadUserByUsername()中注入的角色
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) user.getAuthorities();

        // 遍历用户所有角色
        for(GrantedAuthority authority : authorities) {

            String roleName = authority.getAuthority();
            int roleId = roleService.selectRoleByRoleName(roleName).getId();
            // 得到角色所有的权限

            List<SysPermision> permissionList = permissionService.GetPermissionByRoleId(roleId);


            // 遍历permissionList
            for(SysPermision sysPermission : permissionList) {
                // 获取权限集
                String permissions = sysPermission.getPermision();
                // 如果访问的Url和权限用户符合的话，返回true
                if(targetUrl.equals(sysPermission.getUrl())
                        && permissions.contains((String)targetPermission)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }
}

