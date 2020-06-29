package br.com.tt.petshop.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2

//Somente em nao-prod
@Profile("!prod")

@ConditionalOnExpression("${app.swagger.enable:true}")
public class SwaggerConfig {

    public Docket docketV1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
//                .apis(RequestHandlerSelectors.any())
//                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
//                .apis(RequestHandlerSelectors.basePackage(PetshopApplication.class.getPackageName()))
                .apis(RequestHandlerSelectors.basePackage("br.com.tt.petshop.api"))
                .paths(PathSelectors.any())
                .build();
    }

}
