package tk.jvst.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.sql.Timestamp;
import java.util.ArrayList;

import tk.jvst.api.util.Documentation;

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
                        new Tag("Image", Documentation.IMAGE_TAG_DESCRIPTION),
                        new Tag("Session", Documentation.SESSION_TAG_DESCRIPTION),
                        new Tag("Tag", Documentation.TAG_TAG_DESCRIPTION),
                        new Tag("Training", Documentation.TRAINING_TAG_DESCRIPTION),
                        new Tag("User", Documentation.USER_TAG_DESCRIPTION),
                        new Tag("Video", Documentation.VIDEO_TAG_DESCRIPTION))
                .apiInfo(metaInfo())
                .directModelSubstitute(Timestamp.class, String.class);
    }

    private ApiInfo metaInfo() {
        return new ApiInfo("API for a Personal Trainer App",
                "API for my Undergraduate thesis", "0.0.1", "Java - Spring Framework",
                new Contact("Jacques", "http://t.me/jacquesvst", "jacquesvst@gmail.com"), "Apache License 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0", new ArrayList<>());
    }
}
