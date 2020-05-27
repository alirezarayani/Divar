package io.rayani.divar.config;

import io.rayani.divar.DivarApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket apiDocket() {

        Docket docket =  new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("io.rayani"))
                .paths(PathSelectors.any())
                .build().apiInfo(metaData());
        return docket;
    }
    private ApiInfo metaData(){
        return new ApiInfoBuilder()
                .title("Spring Boot EST API")
                .description("Rest API for Divar Project")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .contact(new Contact("Alireza Rayani","","Alireza.rayani@gmail.com"))
                .build();
    }
}
