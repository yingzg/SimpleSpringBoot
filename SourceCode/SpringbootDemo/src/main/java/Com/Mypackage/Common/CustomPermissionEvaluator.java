package Com.Mypackage.Common;

import Com.Mypackage.Model.SysPermission;

import Com.Mypackage.Service.permissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import Com.Mypackage.Service.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {
    @Autowired
    private permissionService permissionService;
    @Autowired
    private RoleService roleService;

    @Override
    public boolean hasPermission(Authentication authentication, Object targetUrl, Object targetPermission) {
        // 获得loadUserByUsername()方法的结果
        CustomUserDetail user = (CustomUserDetail)authentication.getPrincipal();
        // 获得loadUserByUsername()中注入的角色
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) user.getAuthorities();

        // 遍历用户所有角色
        for(GrantedAuthority authority : authorities) {
            String roleName = authority.getAuthority();
            Integer roleId = null;
            try {
                roleId = roleService.selectRoleByRoleName(roleName).getId();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 得到角色所有的权限
            List<SysPermission> permissionList = null;
            try {
                permissionList = permissionService.GetPermissionByRoleId(roleId);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 遍历permissionList
            for(SysPermission sysPermission : permissionList) {
                // 获取权限集
                List permissions = sysPermission.getPermissions();
                // 如果访问的Url和权限用户符合的话，返回true
                if(targetUrl.equals(sysPermission.getUrl())
                        && permissions.contains(targetPermission)) {
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
