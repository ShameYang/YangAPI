package com.shameyang.yangapi.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ShameYang
 * @date 2024/8/24 22:19
 * @description Knife4j 配置
 */
@Configuration
public class Knife4jConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("YangAPI")
                        .description("YangAPI 接口文档")
                        .version("v1.0")
                        .contact(new Contact().name("shameyang"))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}