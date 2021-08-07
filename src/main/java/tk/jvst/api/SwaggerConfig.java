package tk.jvst.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.jvst.api.util.literals.Documentation;

import java.sql.Timestamp;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("tk.jvst.api")).build()
                .tags(
                        new Tag("Activity", Documentation.ACTIVITY_TAG_DESCRIPTION),
                        new Tag("Exercise", Documentation.EXERCISE_TAG_DESCRIPTION),
                        new Tag("File", Documentation.FILE_TAG_DESCRIPTION),
                        new Tag("Session", Documentation.SESSION_TAG_DESCRIPTION),
                        new Tag("Tag", Documentation.TAG_TAG_DESCRIPTION),
                        new Tag("Training", Documentation.TRAINING_TAG_DESCRIPTION),
                        new Tag("User", Documentation.USER_TAG_DESCRIPTION),
                        new Tag("User Library", Documentation.USER_LIBRARY_TAG_DESCRIPTION))
                .directModelSubstitute(Timestamp.class, String.class);
    }

}
