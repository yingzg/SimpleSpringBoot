package Com.Mypackage.Common;


import Com.Mypackage.Model.*;
import Com.Mypackage.Service.RoleService;
import Com.Mypackage.Service.UserRoleService;
import Com.Mypackage.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public CustomUserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = new ArrayList<>();
        // 从数据库中取出用户信息
        User user = userService.selectUserByName(username);

        // 判断用户是否存在
        if(user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }


        List<UserRole> userRoles=new ArrayList<>();
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

        }

        // 返回UserDetails实现类
        return new CustomUserDetail(user, authorities);
    }
}
