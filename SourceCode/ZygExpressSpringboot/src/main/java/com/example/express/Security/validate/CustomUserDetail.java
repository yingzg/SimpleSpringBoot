package com.example.express.Security.validate;

import com.example.express.entity.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * SpringSecurity需要的用户详情
 */
public class CustomUserDetail implements UserDetails {

    private SysUser user;
    private Collection<GrantedAuthority> permissionList;

    public CustomUserDetail(SysUser user, Collection<GrantedAuthority> authorities) {

        this.user = user;
        this.permissionList = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的权限
        return permissionList;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
