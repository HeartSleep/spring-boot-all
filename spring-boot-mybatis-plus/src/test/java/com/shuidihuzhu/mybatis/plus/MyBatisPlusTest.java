package com.shuidihuzhu.mybatis.plus;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.shuidihuzhu.mybatis.plus.dao.UserMapper;
import com.shuidihuzhu.mybatis.plus.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author gehuadong@shuidihuzhu.com
 * @date 2020-02-06 21:55
 */
public class MyBatisPlusTest extends BaseApplicationTests {

    @Autowired
    @SuppressWarnings("all")
    private UserMapper userMapper;

    /**
     * 自定义sql实现查询时，实体类中注解不会起作用
     */
    @Test
    public void testGetUserList() {
        List<User> users = userMapper.getUserList(Wrappers.<User>lambdaQuery().ge(User::getAge, 25));
        users.forEach(System.out::println);
    }

    @Test
    public void testSelect() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    /**
     * 测试逻辑删除
     */
    @Test
    public void testLogicDelete() {
        int raws = userMapper.deleteById(1094592041087729666L);
        System.out.println("影响的行数: " + raws);

        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void test01() {
        System.out.println(userMapper.selectList(Wrappers.<User>lambdaQuery().eq(User::getId,
                "1087982257332887553")));
    }
}
