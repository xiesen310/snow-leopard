package com.github.leopard.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 谢森
 * @Description swagger 文档配置
 * @Email xiesen310@163.com
 * @Date 2020/11/18 18:20
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    /**
     * 集成 swagger2 如果出现问题，添加此注解 @Primary
     *
     * @return
     */
    @Bean
    @Primary
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2).
                apiInfo(apiinfo2()).
                select()
                // 包路径
                .apis(RequestHandlerSelectors.basePackage("com.github.datahub.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiinfo2() {
        return new ApiInfoBuilder()
                //页面标题
                .title("snow-leopard")
                //页面描述
                .description("API描述")
                //版本号
                .version("1.0.0")
                .build();
    }
}
