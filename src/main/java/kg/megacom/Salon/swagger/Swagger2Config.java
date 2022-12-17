package kg.megacom.Salon.swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    public static final String Auth="Авторизация";
    public static final String Master="Мастера";
    public static final String Client="Клиенты";
    public static final String Salon="Салоны";
    public static final String Work="Рабочие дни";
    public static final String Booking="Записи";
    public static final String Acc="Аккаунт";
    public static final String Email="Почта";





    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors
                        .basePackage("kg.megacom.Salon.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiEndPointsInfo())
                .tags(new Tag(Auth, ""))
                .tags(new Tag(Master, ""))
                .tags(new Tag(Client, ""))
                .tags(new Tag(Salon, ""))
                .tags(new Tag(Work, ""))
                .tags(new Tag(Acc, ""))
                .tags(new Tag(Booking, ""))
                .tags(new Tag(Email, ""));

    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Сервис записи в салон красоты")
                .description("Salon service")
                .version("1.0.0")
                .build();
    }


}
