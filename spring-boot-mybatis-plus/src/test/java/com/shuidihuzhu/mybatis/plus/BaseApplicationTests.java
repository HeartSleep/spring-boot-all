package com.shuidihuzhu.mybatis.plus;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@Slf4j
@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
class BaseApplicationTests {

    @Before
    public void init() {
        log.info("-----------------开始测试-----------------");
    }

    @After
    public void after() {
        log.info("-----------------测试结束-----------------");
    }
}
