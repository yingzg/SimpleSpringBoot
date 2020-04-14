package Com.Mypackage.intecepter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * springboot 3.X的过滤器配置器
 */
@Configuration
public class NewCustomWebMvcConfihgura implements WebMvcConfigurer {

    /**
     * 重写方法 添加自定义拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/api2/*/**");
       // .excludePathPatterns("/api2/user/**"); //拦截路由，除开某些路由

        WebMvcConfigurer.super.addInterceptors(registry);
    }

}
