package com.n1.weixin.controller;

import com.n1.weixin.entity.User;
import com.n1.weixin.service.UserService;
import com.n1.weixin.util.HandleList;
import com.n1.weixin.util.HandleStr;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by admin on 2020/4/22.
 */
@Controller
public class UserControll {
    @Autowired
    private UserService userService;
    @RequestMapping("/user")
    @ResponseBody
    public Boolean returnLimit(@Param("nickName") String nickName){
        User user = userService.getUserByNickName(HandleStr.filterEmoji(nickName));
        System.out.println(user+"logging...");
        if(user==null){
            return false;
        }else{
            return true;
        }
    }
}

