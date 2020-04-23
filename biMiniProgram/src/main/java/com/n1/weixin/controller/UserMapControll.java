package com.n1.weixin.controller;

import com.alibaba.fastjson.JSONObject;
import com.n1.weixin.entity.UserMap;
import com.n1.weixin.service.impl.UserMapServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2020/4/22.
 */
@Controller
public class UserMapControll {
    @Autowired
    private UserMapServiceImpl userMapServiceImpl;
    @RequestMapping("/userMap")
    @ResponseBody
    public JSONObject returnUserMap(){
        List<UserMap> userMapList = userMapServiceImpl.getUserMapList();
        List<JSONObject> mapList = new ArrayList<>();
        for(int i=0;i<userMapList.size();i++){
            JSONObject jsonObject = JSONObject.parseObject(userMapList.get(i).toString());
            mapList.add(JSONObject.parseObject(jsonObject.getString("UserMap")));
        }
        JSONObject json = new JSONObject();
        json.put("result",mapList);
        return json;
    }
}
