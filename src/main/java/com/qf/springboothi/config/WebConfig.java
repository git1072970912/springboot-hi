package com.qf.springboothi.config;

import com.qf.springboothi.filter.MyFilter;
import com.qf.springboothi.interceptor.MyInterceptor;
import com.qf.springboothi.listener.MyListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author GuanYeFan
 * @Date 2019/6/3
 * 使拦截器、过滤器、监听器生效
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private MyFilter myFilter;

    @Autowired
    private MyListener myListener;

    @Autowired
    private MyInterceptor myInterceptor;

    /**
     * 过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean initFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        //设置过滤器
        filterRegistrationBean.setFilter(myFilter);
        //设置过滤器的名字,一般为类名
        filterRegistrationBean.setName("MyFilter");
        //设置过滤器过滤的请求范围
        filterRegistrationBean.addUrlPatterns("/*");
        return  filterRegistrationBean;
    }

    /**
     * 监听器
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean initListener(){
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(myListener);
        return servletListenerRegistrationBean;
    }

    /**
     * 拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器并设置拦截范围
        registry.addInterceptor(myInterceptor).addPathPatterns("/**");
    }
}
