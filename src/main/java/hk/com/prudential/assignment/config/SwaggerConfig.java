package hk.com.prudential.assignment.config;

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

/**
 * @author zhnlk
 * @date 2020/4/11
 * @mail tomleader0828@gmail.com
 */
@Configuration
@EnableSwagger2
@ComponentScan(basePackages = "hk.prudential.assignment.controller")
public class SwaggerConfig {

    @Bean
    public Docket swaggerUiDocker() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(swaggerApiInfo())
//                .groupName("v1")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/api/v1/*/*"))
                .build();
    }

    private ApiInfo swaggerApiInfo() {
        Contact contact = new Contact("eran cheung", "github.com/zhnlk", "tomleader0828@gmail.com");
        return new ApiInfoBuilder()
//                .contact(contact)
                .title("Car Rental Company Api Document")
//                .description("Power by SwaggerUI")
                .version("1.0.0")
                .build();
    }

}
