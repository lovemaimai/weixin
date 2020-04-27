package com.n1.weixin.dao;

import com.n1.weixin.entity.UserMap;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2020/4/22.
 */
@Repository
public interface UserMapDao {
    public List<UserMap> queryUserMap();
}
