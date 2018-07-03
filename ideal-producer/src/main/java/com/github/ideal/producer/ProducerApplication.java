package com.github.ideal.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

/**
 * SpringBoot 启动类
 *
 * @author junliang
 */
@SpringBootApplication
@Slf4j
public class ProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam String param){
        return "Hello Is Producer! "+param;
    }

    @Bean
    public RouterFunction<ServerResponse> routeCity(CityHandler cityHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/hello")
                                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                        cityHandler::helloCity);
    }

    @Component
    public class CityHandler {
        public Mono<ServerResponse> helloCity(ServerRequest request) {
            return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                    .body(BodyInserters.fromObject("Hello, City!"));
        }
    }

}