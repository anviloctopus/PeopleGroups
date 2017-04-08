package com.novauc;

/**
 * Created by ANVIL_OCTOPUS on 4/8/17.
 */
import com.google.common.base.Predicates;
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
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error")))
                .build()
                .apiInfo(metaData())
                .pathMapping("/");
    }
    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "SSA's Student info",
                "RESTful API for IronYard assignment",
                "5.1",
                "I can't even use this",
                new Contact("Al Williams", "www.booty.com", "alvin.williams00@gmail.com"),
                "I think I'm learning",
                "http://screenrant.com/star-wars-darth-vader-anthology-movie-rogue-one/");
        return apiInfo;
    }
}