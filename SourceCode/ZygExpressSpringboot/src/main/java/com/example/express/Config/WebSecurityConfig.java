package com.example.express.Config;

import com.example.express.Security.handle.DefaultAuthenticationFailureHandler;
import com.example.express.Security.validate.TraditionSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private TraditionSecurityConfig traditionSecurityConfig;

    @Autowired
    private DefaultAuthenticationFailureHandler defaultAuthenticationFailureHandler;


    @Override
    public void configure(WebSecurity web) throws Exception {
        // 设置拦截忽略文件夹，可以对静态资源放行
        web.ignoring().antMatchers("/static/assets/**");
    }

    /**
     * spring security 基本路由配置
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
           http
                   // 不同登陆方式的配置 传统登录验证方式
                .apply(traditionSecurityConfig).and()
                // 设置登陆页
                .formLogin().loginPage("/login")

                // 登录失败Url 两种配置方式，第一种：直接failureUrl，第二种：添加自定义处理的FailureHandler
                //.failureUrl("/login/error")
                .failureHandler(defaultAuthenticationFailureHandler)
                // 设置登陆成功页
                .defaultSuccessUrl("/").permitAll().and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/index")
                .deleteCookies("JSESSIONID").and()
                .rememberMe()
                   .and()
                   .authorizeRequests()

                // 如果有允许匿名的url，填在下面
                .antMatchers("/register", "/auth/register", "/auth/face-check").permitAll()
                .antMatchers("/getVerifyCode").permitAll()
                .antMatchers("/api/v1/public/**").permitAll()
                //授权验证
                .anyRequest().authenticated() ;

        // 关闭CSRF跨域
        http.csrf().disable();
    }



}
