package com.example.express.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 登录持久化表 前端控制器
 * </p>
 *
 * @author guozhiying
 * @since 2020-04-10
 */
@Controller
public class LoginController {

    @RequestMapping(path = "/login")
    public String Login() {
        return "login";
    }

}
