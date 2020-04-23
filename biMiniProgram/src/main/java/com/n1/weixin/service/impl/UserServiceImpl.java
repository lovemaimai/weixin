package com.n1.weixin.service.impl;

import com.n1.weixin.dao.UserDao;
import com.n1.weixin.entity.User;
import com.n1.weixin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2020/4/22.
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User getUserByNickName(String nickName) {
        User user = userDao.queryUserByName(nickName);
        return user;
    }
}
