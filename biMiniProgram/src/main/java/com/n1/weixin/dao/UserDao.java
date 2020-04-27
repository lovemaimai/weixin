package com.n1.weixin.dao;

import com.n1.weixin.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2020/4/20.
 */
@Repository
public interface UserDao {
    public User queryUserByName(@Param("nickName") String nickName);
}
