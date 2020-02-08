package com.shuidihuzhu.mybatis.plus.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.shuidihuzhu.mybatis.plus.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author gehuadong@shuidihuzhu.com
 * @date 2020-02-06 21:43
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * ${ew.customSqlSegment}
     * ref: com.baomidou.mybatisplus.core.conditions.Wrapper#getCustomSqlSegment()
     *
     * @param wrappers
     * @return
     */
    @Select("select * from user ${ew.customSqlSegment}")
    List<User> getUserList(@Param(Constants.WRAPPER) Wrapper<User> wrappers);
}
