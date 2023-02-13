package co.kr.sharek.config.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.List;

@Configuration
@EnableWebMvc
public class SwaggerConfig {

  private static final String API_NAME = "Sharek Rest API";
  private static final String API_VERSION = "1.0.0";
  private static final String API_DESCRIPTION = "Sharek Spring Boot 2.7 application.";

  @Bean
  public Docket swaggerApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .useDefaultResponseMessages(false)
        .securityContexts(List.of(this.securityContext()))
        .securitySchemes(List.of(this.apiKey()))
        .select()
        .apis(RequestHandlerSelectors.basePackage("co.kr.sharek.project.controller"))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(apiInfo());
  }

  private SecurityContext securityContext() {
    return SecurityContext.builder()
        .securityReferences(swaggerAuth())
        .build();
  }

  private List<SecurityReference> swaggerAuth() {
    AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
    authorizationScopes[0] = authorizationScope;

    return List.of(new SecurityReference("Authorization", authorizationScopes));
  }


  private ApiKey apiKey() {
    return new ApiKey("JWT", "jwt", "header");
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title(API_NAME)
        .version(API_VERSION)
        .description(API_DESCRIPTION)
        .build();
  }

}
