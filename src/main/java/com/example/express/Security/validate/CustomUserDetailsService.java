package com.example.express.Security.validate;

import com.example.express.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private com.example.express.service.SysUserService SysUserService;


    @Override
    public CustomUserDetail loadUserByUsername(String username) throws UsernameNotFoundException {

        List<GrantedAuthority> authorities = new ArrayList<>();
        // 从数据库中取出用户信息
        SysUser user = SysUserService.getByName(username);

        // 判断用户是否存在
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        // 判断用户是否存在
        if(user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }


   /*     List<UserRole> userRoles=new ArrayList<>();
        try {
            // 添加权限
            userRoles = userRoleService.selectRoleById(user.getId());
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (UserRole userRole : userRoles) {

            try {
                Role role = roleService.selectRoleById(userRole.getRoleId());
                authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }*/

        // 返回UserDetails实现类
        return new CustomUserDetail(user, authorities);
    }

}

