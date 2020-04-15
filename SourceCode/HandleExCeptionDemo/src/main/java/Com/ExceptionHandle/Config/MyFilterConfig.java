package Com.ExceptionHandle.Config;

import Com.ExceptionHandle.Filter.MyFilter;
import Com.ExceptionHandle.Filter.MyFilter2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class MyFilterConfig {

    @Autowired
    MyFilter myFilter;

    @Autowired
    MyFilter2 myFilter2;

    @Bean
    public FilterRegistrationBean<MyFilter> setUpMyFilter() {
        FilterRegistrationBean<MyFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setOrder(2);
        filterRegistrationBean.setFilter(myFilter);
        filterRegistrationBean.addUrlPatterns("/api/*");
       /* filterRegistrationBean.setUrlPatterns(new ArrayList<>(Arrays.asList("apiFilter/*")));*/
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<MyFilter2> setUpMyFilter2() {
        FilterRegistrationBean<MyFilter2> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.setFilter(myFilter2);
        filterRegistrationBean.addUrlPatterns("/api2/*");
      /*  filterRegistrationBean.setUrlPatterns(new ArrayList<>(Arrays.asList("api2/*")));*/
        return filterRegistrationBean;
    }

}
