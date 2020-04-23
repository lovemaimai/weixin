package com.n1.weixin.dao;

import com.n1.weixin.entity.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2020/4/20.
 */
public interface ResultDao {
    //查询实时结果
    public List<Result> queryResultList(@Param("platform") String platform,@Param("period") String period,@Param("type") String type);

}
