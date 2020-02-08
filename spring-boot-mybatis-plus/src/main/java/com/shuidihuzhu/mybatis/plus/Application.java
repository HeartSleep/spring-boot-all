package com.shuidihuzhu.mybatis.plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author gehuadong@shuidihuzhu.com
 * @date 2020-02-06
 */
@SpringBootApplication
@MapperScan("com.shuidihuzhu.mybatis.plus.dao")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
