package com.n1.weixin.service.impl;

import com.n1.weixin.dao.UserMapDao;
import com.n1.weixin.entity.UserMap;
import com.n1.weixin.service.UserMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2020/4/22.
 */
@Service
public class UserMapServiceImpl implements UserMapService {
    @Autowired
    private UserMapDao userMapDao;

    @Override
    public List<UserMap> getUserMapList() {
        List<UserMap> userMaps = userMapDao.queryUserMap();
        return userMaps;
    }
}

