package com.derrick.springbootrestapisactivemq;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
    public Docket postsApi(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.derrick.springbootrestapisactivemq"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo getApiInfo(){

        String title="JavaJMSAngularTask API";
        String description="Java Jms Angular API reference for developers";
        String version="1.0";
        String termsOfServiceUrl="http://www.mimshacktechnologies.com";
        Contact contact=new Contact("Derrick Maila","http://www.mimshacktechnologies.com","info@mimshacktechnologies.co.za");
        String license="JavaJMS Angular License";
        String licenseUrl="http://www.mimshacktechnologies.com";

        return new ApiInfo(
                title,
                description,
                version,
                termsOfServiceUrl,
                contact,
                license,
                licenseUrl
        );
    }
}
