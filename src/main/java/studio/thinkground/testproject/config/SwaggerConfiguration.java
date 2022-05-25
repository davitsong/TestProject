package studio.thinkground.testproject.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;



public class SwaggerConfiguration {

    @Bean
    public GroupedOpenApi publicApi(){
        return GroupedOpenApi.builder()
                .group("testProject")
                .build();
    }

    private GroupedOpenApi adminApi(){
        return GroupedOpenApi.builder()
                .group("Around Hub Open API test with SAWAGGER")
                .pathsToMatch("/testproject/**")
                .build();
    }
}

