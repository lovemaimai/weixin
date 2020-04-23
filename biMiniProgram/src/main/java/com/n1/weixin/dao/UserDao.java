package com.n1.weixin.dao;

import com.n1.weixin.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by admin on 2020/4/20.
 */
public interface UserDao {
    public User queryUserByName(@Param("nickName") String nickName);
}
