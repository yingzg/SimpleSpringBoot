package Com.Example.Common;

import Com.Example.Service.*;
import Com.Example.model.Role;
import Com.Example.model.User;
import Com.Example.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Role> authorities = new ArrayList<>();
// 从数据库中取出用户信息
        User user = userService.selectUserByName(username);

// 判断用户是否存在
        if(user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }

// 添加权限
        try {
            List<UserRole>  userRoles = userRoleService.selectRoleById(user.getId());
            for (UserRole userRole : userRoles)
            {
                Role role = roleService.selectRoleById(userRole.getRoleId());
                authorities.add(role);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


// 返回UserDetails实现类
        return new CustomUserDEtail(user, authorities);
    }
}
