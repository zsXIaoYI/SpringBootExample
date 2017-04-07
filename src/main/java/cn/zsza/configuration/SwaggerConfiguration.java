package cn.zsza.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.time.LocalDate;

/**
 * Created by zs on 2017/4/7.
 * 9:50
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket webApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .directModelSubstitute(LocalDate.class,String.class)
                .genericModelSubstitutes(ResponseEntity.class).apiInfo(webApiInfo());
    }

    private ApiInfo webApiInfo() {
        ApiInfo apiInfo = new ApiInfo("my boot title",
                "my boot api desc",
                "1.0",
                "service",
                "zsza5466@sina.com",
                "zsza",
                "1505198763@qq.com");

        return apiInfo;
    }
}
