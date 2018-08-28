package jsjzx.wlyw.huitest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

//    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        //返回登录页面
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");

        registry.addViewController("/success").setViewName("success");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/dashboard").setViewName("dashboard");

        //显示用户列表
        registry.addViewController("/user/list").setViewName("user/list");
        //返回到用户添加页面
        registry.addViewController("/user/add").setViewName("user/add");
    }

//    @Bean
//    public LocaleResolver localeResolver(){
//        return new MyLocaleResolver();
//    }
/*
//暂时禁用，其他功能测试完成后再启用
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        springboot已经做好论文静态资源映射
        registry.addInterceptor(new MyLoginInterceptor()).addPathPatterns("/*")
                .excludePathPatterns("/index.html","/","user/lgin");
    }*/
}
