package com.metlushko.gateway.config;

//@Configuration
//@RequiredArgsConstructor
//public class GatewayConfig {
//    public final AuthFilter authFilter;
//
////    @Bean
////    public RouteLocator routes(RouteLocatorBuilder builder) {
////        return builder.routes()
////                .route("user-service", r -> r.path("/api/v1/users/**")
////                        .filters(f -> f.filter(authFilter))
////                        .uri("lb://user-service"))
////                .route("book-service", r -> r.path("/api/v1/books/**")
////                        .filters(f -> f.filter(authFilter))
////                        .uri("lb://book-service"))
////                .route("auth-service", r -> r.path("/api/auth/**","/admin","/user")
////                        .filters(f -> f.filter(authFilter))
////                        .uri("lb://auth-service"))
////                .build();
////    }
//}
