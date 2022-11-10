package ca.bdeb.projetsynthese.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.time.LocalDate;

/**
 * Created by Thomas Wang on 11/8/2022.
 */
@Configuration
public class Swagger3Config {
    @Bean
    public Docket petApi() {
        ApiInfo apiInfo = new ApiInfoBuilder().title("Projet syntèse: Plateforme de location de logement courte durée ")
                .contact(new Contact("Lydia, Luisa, Shuang", "https://github.com/lydiaDida/projet-synthese", "lydiazekrini7@gmail.com"))
                .description("Technologies: front-end (Angular), back-end (Spring Boot), ORM(Hibernate), Database (MySQL), Swagger 3.0")
                .license("Apache 2.0")
                .licenseUrl("https://raw.githubusercontent.com/itlab1024/spring-boot-swagger3-tutorial/main/LICENSE")
                .version("1.0")
                .termsOfServiceUrl("URL")
                .build();
        return new Docket(DocumentationType.OAS_30).apiInfo(apiInfo)
                .groupName("Lydia-Luisa-Shuang")
                .enable(true)
                .select()
//                .apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("ca.bdeb.projetsynthese.controller"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .enableUrlTemplating(true);
    }
}

