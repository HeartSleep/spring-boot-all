package com.shuidihuzhu.springbootdocker.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gehuadong@shuidihuzhu.com
 * @date 2020-01-22 11:49
 */
@RestController
public class DockerTestController {

    @Value("${test.title}")
    private String title;

    @RequestMapping("/docker-test")
    public String dockerTest() {
        return "Hello " + title;
    }
}
