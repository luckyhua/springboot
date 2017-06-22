package com.luckyhua.springboot.global.webmvc;

import com.luckyhua.springboot.global.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * 配置拦截器
 * @EnableWebMvc+继承WebMvcConfigurationAdapter会屏蔽springboot的@EnableAutoConfiguration的设置
 * 继承WebMvcConfigurationSupport会屏蔽springboot的@EnableAutoConfiguration的设置
 * 继承WebMvcConfigurationAdapter依旧使用springboot的@EnableAutoConfiguration的设置
 *
 * @author    qinxiaoqing
 * @date      2017/02/15
 * @version   1.0
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 发现如果继承了WebMvcConfigurationSupport，则在yml中配置的相关内容会失效。
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//        registry.addResourceHandler("/**")
//                .addResourceLocations(
//                        config().getResourcesPathMerchant(),
//                        config().getResourcesPathManager(),
//                        config().getResourcesPathShop())
//                .resourceChain(true)
//                .addResolver(new GzipResourceResolver());
//
//        registry.addResourceHandler("/merchantUi/**")
//                .addResourceLocations(config().getResourcesPathMerchant())
//                .resourceChain(true)
//                .addResolver(new GzipResourceResolver());
//
//        registry.addResourceHandler("/managerUi/**")
//                .addResourceLocations(config().getResourcesPathManager())
//                .resourceChain(true)
//                .addResolver(new GzipResourceResolver());
//
//        registry.addResourceHandler("/shopUi/**")
//                .addResourceLocations(config().getResourcesPathShop())
//                .resourceChain(true)
//                .addResolver(new GzipResourceResolver());
    }

    /**
     * 配置servlet处理
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(
                  "/",
                  "/user/customer/login/**",
                  "/user/cellphone/verifyCode");
    }

    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

}
