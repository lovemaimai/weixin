package com.n1.weixin.service;

import com.n1.weixin.dao.UserMapDao;
import com.n1.weixin.entity.UserMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2020/4/22.
 */

public interface UserMapService {
    List<UserMap> getUserMapList();

}
