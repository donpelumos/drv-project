package ie.ait.drvproject.config;

import springfox.documentation.service.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * Created by Pelumi.Oyefeso on 24-04-2020
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public static final Contact CUSTOM_CONTACT = new Contact("Oyefeso Oluwapelumi", "https://github.com/donpelumos",
            "A00277162@student.ait.ie");
    public static final ApiInfo CUSTOM_API_INFO = new ApiInfo("DRV REST Api Documentation",
            "Java based service for an e-commerce or online store", "1.0.0", "urn.tos",
            CUSTOM_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(CUSTOM_API_INFO)
                .select()
                .apis(RequestHandlerSelectors.basePackage("ie.ait.drvproject"))
                .paths(PathSelectors.any())
                .build();
    }
}
