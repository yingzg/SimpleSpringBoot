package Com.Mypackage.Filter;


import Com.Mypackage.ComPonent.SpringBeanFactoryUtils;
import Com.Mypackage.Common.CustomAuthenticationDetailsSource;
import Com.Mypackage.Common.JwtUtils;
import Com.Mypackage.Model.User;
import Com.Mypackage.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.context.ContextLoader;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 该filter继承自UsernamePasswordAuthenticationFilter
 * 在验证用户名密码正确后，生成一个token，并将token返回给客户端
 */
public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {


    static final String USER_ID_KEY = "USER_ID";

    private AuthenticationManager authenticationManager;

    public JwtLoginFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }



    /**
     * 该方法执行具体的用户认证 如果认证成功，将会把返回的Authentication对象存放在SecurityContext
     * 将用户信息从request中取出，并放入authenticationManager中
     */
   @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
        try {

            String username = req.getParameter("username");
            String password = req.getParameter("password");

            if (username == null) {
                username = "";
            }
            if (password == null) {
                password = "";
            }
            username = username.trim();

            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                    username, password);

            // Allow subclasses to set the "details" property

            CustomAuthenticationDetailsSource authenticationDetailsSource = new CustomAuthenticationDetailsSource();
            authRequest.setDetails(authenticationDetailsSource.buildDetails(req));
            return authenticationManager.authenticate(authRequest);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 该方法在Spring Security验证成功后调用
     * 在这个方法里生成JWT token，并返回给用户
     * @author jitwxs
     * @since 2018/5/4 10:37
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) throws IOException, ServletException {
        String username = (String)auth.getPrincipal();

        // 从数据库中取出用户信息

        UserService userService = new UserService();
        User user = userService.selectUserByName(username);;

        // 将用户id放入JWT token
        Map<String,Object> map = new HashMap<>();
        map.put(USER_ID_KEY, user.getId());
        String token = JwtUtils.sign(map, 3600_000);

        // 将token放入响应头中
        res.addHeader("Authorization", token);

        chain.doFilter(req,res);

    }
}