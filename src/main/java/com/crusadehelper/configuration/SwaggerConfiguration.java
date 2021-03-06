package com.crusadehelper.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket api() {
        //https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
        //Reach Swagger using: http://localhost:8080/swagger-ui.html
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
          .paths(PathSelectors.any())
          .build()
                .apiInfo(metadata());
    }
    private ApiInfo metadata() {
        return new ApiInfo(
                "40k Crusade Manager REST API",
                "40k Crusade Manager REST API for managing W40k crusade campaign",
                "1.0",
                "Terms of service",
                new Contact("Vincent Brunet", "https://github.com/Tinqiu/crusade-helper", "vincent.brunet.vb@40kcrusademanagement.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0",
                Collections.emptyList()
                );
    }
}
