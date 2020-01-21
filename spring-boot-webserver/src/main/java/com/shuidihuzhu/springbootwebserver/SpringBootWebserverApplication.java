package com.shuidihuzhu.springbootwebserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.servlet.function.RequestPredicates.GET;
import static org.springframework.web.servlet.function.RouterFunctions.route;

/**
 * @author gehuadong@shuidihuzhu.com
 * @date 2020-01-19
 */
@RestController
@SpringBootApplication
public class SpringBootWebserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebserverApplication.class, args);
    }

    @RequestMapping("/test")
    public String test() {
        return "Hello World";
    }

    @Bean
    public RouterFunction<ServerResponse> helloWorld() {
        return route(GET("hello-world"), serverRequest -> ServerResponse.ok().body(Mono.just("Hello World")));
    }
}
