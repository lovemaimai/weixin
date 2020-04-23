package com.n1.weixin.service.impl;

import com.n1.weixin.dao.ResultDao;
import com.n1.weixin.entity.Result;
import com.n1.weixin.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2020/4/21.
 */
@Service
public class ResultServiceImpl implements ResultService {
    @Autowired
    private ResultDao resultDao;
    @Override
    public List<Result> getResultListByParm(String platform, String period, String type) {
        System.out.println(platform+period+type);
        List<Result> results =null;
        if(period.equals("today")||period.equals("yesterday")){
            results = resultDao.queryResultList(platform, "'today','yesterday'", type);
        }else{
            results = resultDao.queryResultList(platform, "'"+period+"'", type);
        }

        return results;
    }
}
