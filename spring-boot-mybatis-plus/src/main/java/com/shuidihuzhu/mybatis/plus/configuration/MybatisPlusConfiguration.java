package com.shuidihuzhu.mybatis.plus.configuration;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author gehuadong@shuidihuzhu.com
 * @date 2020-02-07 00:14
 */
@Configuration
public class MybatisPlusConfiguration {

    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }
}
