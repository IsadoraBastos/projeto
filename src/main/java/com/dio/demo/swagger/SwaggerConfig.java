package com.dio.demo.swagger;

import org.springframework.context.annotation.Bean;
import springfox.documentation.spring.web.plugind.Docket;

import java.util.Collections;


public class SwaggerConfig {
    @Bean
    public Docket apiAdmin(){
        return new Docket (DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dio.backend"))
                .paths(PathSelectors.ant("/**"))
                .apiInfo(apiInfo())
                .globalOperationParameters(
                        Collections.singletonList(
                                new ParameterBuilder()
                                .name("Authorization")
                                .description("Header para Token JWT")
                                .modelRef( new ModelRef ("String"))
                                .parameterType("header")
                                .required(false)
                                .build()));
    }
    @Bean
    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
    .tittle("API-REST")
                .description("super live code")
                .version("1.0.0")
                .license("ApacheLicense Version 2.0")
                .licenseUr("https://www.apache.org//licenses/LICENSE-2.0")
                .contact(new Contact("DIO", "https//web.digitalinonovation.one"," contato@digitalinnovationone.com.br"))
                .build();
    }
}
