package com.gosuncn.pfr.config;


import com.gosuncn.pfr.common.TokenInterceptor;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * Copyright © 1997 - 2018 Gosuncn. All Rights Reserved.
 *
 * @author Michael
 * @description web 安全配置：可实现映射修改，添加拦截器等功能
 * @date 10/24/2018
 * @email 2751358839@qq.com
 */
@Configuration
public class WebSecurityConfig implements WebMvcConfigurer, WebMvcRegistrations {

    //fixme:测试用，生产环境必须启用token拦截器
    boolean isEnableInterceptor=true;

    @Bean
    public TokenInterceptor getTokenIntercepter() {
        return new TokenInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        if(!isEnableInterceptor){
            return ;
        }
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        registry
                .addInterceptor(getTokenIntercepter())
                .addPathPatterns("/**")
                //去除登录拦截
                .excludePathPatterns("/**/api/account/v1/getToken")
                .excludePathPatterns("/**/api/account/v2/getToken")

                //排除在线文档的拦截
                .excludePathPatterns("/doc.html","/error")
                //去除对swagger api doc的拦截
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html", "/csrf/**");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }


}
