package com.n1.weixin.service;

import com.n1.weixin.entity.Result;

import java.util.List;

/**
 * Created by admin on 2020/4/21.
 */
public interface ResultService {
    List<Result> getResultListByParm(String platform,String period,String type);
}
