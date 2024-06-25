package com.opencejav.LibMaster.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {
    @Bean
    public Docket libMasterApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.opencejav.LibMaster.controllers"))
                .paths(regex("/api/v1/libmaster.*"))
                .build()
                .apiInfo(libMasterMetaData());
    }

    private ApiInfo libMasterMetaData() {
        return new ApiInfoBuilder()
                .title("LibMaster REST API")
                .description("\"LibMaster RESTful API for Library Management System\"")
                .version("1.0.0")
                .license("GNU General Public License v3.0 (GNU GPLv3")
                .licenseUrl("https://choosealicense.com/licenses/lgpl-3.0/")
                .contact(new Contact("Muhammad Bilal Khan", "", "hikue.opencejav@gmail.com"))
                .build();
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
