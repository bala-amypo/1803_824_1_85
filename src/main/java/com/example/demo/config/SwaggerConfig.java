package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                // You need to change the port as per your server
                .servers(List.of(
                        new Server().url("https://9071.pro604cr.amypo.ai/")
                ));
        }
}


// package com.example.demo.config;

// import io.swagger.v3.oas.models.Components;
// import io.swagger.v3.oas.models.OpenAPI;
// import io.swagger.v3.oas.models.info.Info;
// import io.swagger.v3.oas.models.security.SecurityRequirement;
// import io.swagger.v3.oas.models.security.SecurityScheme;
// import io.swagger.v3.oas.models.servers.Server;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import java.util.List;

// @Configuration
// public class SwaggerConfig {

//     @Bean
//     public OpenAPI customOpenAPI() {
//         final String securitySchemeName = "bearerAuth";

//         return new OpenAPI()
//                 // Metadata (Recommended)
//                 .info(new Info()
//                         .title("Real Estate Rating Engine API")
//                         .version("1.0")
//                         .description("API for Property management and Rating logic."))
                
//                 // Your specific server URL
//                 .servers(List.of(
//                         new Server().url("https://9006.32procr.amypo.ai/"),
//                         new Server().url("http://localhost:8080") // Useful for local testing
//                 ))

//                 // REQUIRED: Adds the JWT "Authorize" button to the UI
//                 .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
//                 .components(new Components()
//                         .addSecuritySchemes(securitySchemeName, new SecurityScheme()
//                                 .name(securitySchemeName)
//                                 .type(SecurityScheme.Type.HTTP)
//                                 .scheme("bearer")
//                                 .bearerFormat("JWT")));
//     }
// }