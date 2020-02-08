package com.shuidihuzhu.mybatis.plus;

import com.shuidihuzhu.mybatis.plus.dao.UserMapper;
import com.shuidihuzhu.mybatis.plus.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 自动填充测试
 *
 * @author gehuadong@shuidihuzhu.com
 * @date 2020-02-06 23:35
 */
public class AutoFillTest extends BaseApplicationTests {

    @Autowired
    @SuppressWarnings("all")
    private UserMapper userMapper;

    /**
     * 测试自动填充FieldFill.INSERT
     */
    @Test
    public void testInsert() {
        User user =
                User.builder().id(1088248166230832385L).age(30).email("hz@baomidou.com").managerId(1087982257332887553L).build();
        userMapper.insert(user);
    }

    /**
     * 测试自动填充FieldFill.UPDATE
     */
    @Test
    public void testUpdate() {
        User user = User.builder().id(1087982257332887553L).age(30).updateTime(new Date()).build();
        userMapper.updateById(user);
    }
}
