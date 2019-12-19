package com.altimetrik.playground.vin.decoder.vindecoder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The type Swagger configuration.
 * @author fabrice
 * @version 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    /**
     * Api docket.
     *
     * @return the docket
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.altimetrik.playground.vin.decoder.vindecoder"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Vin decoder REST API Documentation")
                .description("More description about vin decoder REST API")
                .contact(new Contact("Fabrice Nduwayo","https://www.linkedin.com/in/fabrice-nduwayo/","fabrice.nduwayo12@gmail.com"))
                .licenseUrl("https://www.linkedin.com/in/fabrice-nduwayo/")
                .termsOfServiceUrl("https://www.linkedin.com/in/fabrice-nduwayo/")
                .version("1.0")
                .build();
    }

}
