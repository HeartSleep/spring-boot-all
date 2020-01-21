package com.shuidihuzhu.springboot.springbootloader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gehuadong@shuidihuzhu.com
 * @date 2020-01-19
 */
@RestController
@SpringBootApplication
public class SpringBootLoaderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLoaderApplication.class, args);
    }

    @RequestMapping("/test")
    public String test01() {
        return "Hello World";
    }
}
