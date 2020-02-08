package com.shuidihuzhu.mybatis.plus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.shuidihuzhu.mybatis.plus.dao.UserMapper;
import com.shuidihuzhu.mybatis.plus.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 乐观锁插件测试
 * 特别说明:
 * <p>
 * 支持的数据类型只有:int,Integer,long,Long,Date,Timestamp,LocalDateTime
 * 整数类型下 newVersion = oldVersion + 1
 * newVersion 会回写到 entity 中
 * 仅支持 updateById(id) 与 update(entity, wrapper) 方法
 * 在 update(entity, wrapper) 方法下, wrapper 不能复用!!!
 *
 * @author gehuadong@shuidihuzhu.com
 * @date 2020-02-07 00:06
 */
public class OptTest extends BaseApplicationTests {

    @Autowired
    @SuppressWarnings("all")
    private UserMapper userMapper;

    /**
     * 在 update(entity, wrapper) 方法下, wrapper 不能复用!!!
     * <p>
     * 复用会导致复用的更新不起作用
     */
    @Test
    public void testUpdate() {
        LambdaQueryWrapper<User> lambdaQuery = Wrappers.lambdaQuery();
        lambdaQuery.eq(User::getId, 1087982257332887553L);

        User user1 = User.builder().age(25).version(2).build();
        int updateRaw1 = userMapper.update(user1, lambdaQuery);
        System.out.println("影响行数: " + updateRaw1);

        lambdaQuery.eq(User::getName, "大boss");
        User user = User.builder().age(30).version(3).build();
        int updateRaw2 = userMapper.update(user, lambdaQuery);
        System.out.println("影响行数: " + updateRaw2);

    }

    /**
     * update后newVersion = oldVersion + 1
     */
    @Test
    public void testUpdateById() {
        User user = User.builder().id(1087982257332887553L).age(41).version(1).build();
        userMapper.updateById(user);
    }
}
