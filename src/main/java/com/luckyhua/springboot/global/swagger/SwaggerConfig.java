package com.luckyhua.springboot.global.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author luckyhua
 * @date 2016/11/18
 * @description Swagger generate api document database
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 可以定义多个组，比如本类中定义把test和demo区分开了 （访问页面就可以看到效果了）
     *
     */
    @Bean
    public Docket testApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.luckyhua.springboot"))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
            "SpringBoot学习demo", // 大标题
            "Spring boot + swagger + mybatis + druid", // 小标题
            "1.0", // 版本
            "NO terms of service", "zhouguanghua@liegouchina.com", // 作者
            "luckyhua", // 链接显示文字
            "http://liegouchina.com"// 网站链接
        );

        return apiInfo;
    }

}
