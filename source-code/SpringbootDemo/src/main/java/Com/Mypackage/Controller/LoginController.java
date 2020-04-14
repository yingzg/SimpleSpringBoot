package Com.Mypackage.Controller;

import Com.Mypackage.Common.CustomUserDetailsService;
import Com.Mypackage.Common.JsonData;
import Com.Mypackage.Model.Role;
import Com.Mypackage.Model.User;
import Com.Mypackage.Model.UserRole;
import Com.Mypackage.Service.RoleService;
import Com.Mypackage.Service.UserRoleService;
import Com.Mypackage.Service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);
    private final String USER_ID_KEY = "USER_ID";

    @Autowired
    private CustomUserDetailsService CustomUserDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/Home")
    public String showHome() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        logger.info("当前登陆用户：" + name);
        return "Home";
    }


    @GetMapping("/me")
    @ResponseBody
    public Object me(Authentication authentication) {
         return authentication;
    }

    @GetMapping("/GetUserDetail")
    @ResponseBody
    public Object GetUserDetail(@AuthenticationPrincipal UserDetails userDetails) {
        return userDetails;
    }



    @RequestMapping(path = "/login")
    public String Login() {
        return "login";
    }

    @RequestMapping("/login/error")
    public void loginError(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        AuthenticationException exception =
                (AuthenticationException)request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        try {
            response.getWriter().write(exception.toString());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/register")
    public String showRegister() {
        return "register";
    }

    @PostMapping("/register")
    public Object register(User user, Integer[] roles) throws Exception {
        String name = user.getUsername();

        if (StringUtils.isBlank(name) || StringUtils.isBlank(user.getPassword())) {
            throw new Exception("输入数据错误");
        }

        if (userService.selectUserByName(name) != null) {
            throw new Exception("用户名已被注册");
        }

        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userService.InsertUser(user);
        int id = userService.selectUserByName(name).getId();
        for (Integer roleId : roles) {
            UserRole userrole=new UserRole(id, roleId);
        }

        return "redirect:/login";
    }

    @GetMapping("/userInfo")
    @ResponseBody
    public JsonData getSelfUserInfo() throws IOException {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userService.selectUserByName(name);
        List<UserRole> userRoles = userRoleService.selectRoleById(user.getId());
        List<Role> roles = new ArrayList<>();
        for (UserRole userRole : userRoles) {
            Role role = roleService.selectRoleById(userRole.getRoleId());
            roles.add(role);
        }

        Map<String, Object> map = new HashMap<>(16);
        map.put("name", name);
        map.put("roles", roles);

        return new JsonData(1, map, "返回成功");
    }

    @GetMapping("api/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public String printAdmin(@RequestAttribute(USER_ID_KEY) Integer userid) {
        return "如果你看见这句话，说明你有ROLE_ADMIN角色"+" 用户Id: "+userid;
    }

    @GetMapping("api/user")
    @PreAuthorize("hasRole('ROLE_USER')")
    @ResponseBody
    public String printUser(@RequestAttribute(USER_ID_KEY) Integer userid) {
        return "如果你看见这句话，说明你有ROLE_User角色"+" 用户Id: "+userid;
    }

    @GetMapping("/Superadmin")
    @PreAuthorize("hasRole('ROLE_SuperADMIN')")
    @ResponseBody
    public String printTeacher() {
        return "如果你看见这句话，说明你有ROLE_SuperADMIN角色";
    }


    @RequestMapping("/admin/r")
    @ResponseBody
    @PreAuthorize("hasPermission('/admin','r')")
    public String printAdminR() {
        return "如果你看见这句话，说明你访问/admin路径具有r权限";
    }

    @RequestMapping("/admin/c")
    @ResponseBody
    @PreAuthorize("hasPermission('/admin','c')")
    public String printAdminC() {
        return "如果你看见这句话，说明你访问/admin路径具有c权限";
    }

}
