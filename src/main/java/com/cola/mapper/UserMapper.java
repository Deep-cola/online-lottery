package com.cola.mapper;

import com.cola.base.BaseMapper;
import com.cola.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    // 根据用户名查询用户
    User selectByUsername(String username);
}