package com.n1.weixin.service;

import com.n1.weixin.entity.Result;
import com.n1.weixin.entity.User;

import java.util.List;

/**
 * Created by admin on 2020/4/22.
 */
public interface UserService {
    User getUserByNickName(String nickName);
}
