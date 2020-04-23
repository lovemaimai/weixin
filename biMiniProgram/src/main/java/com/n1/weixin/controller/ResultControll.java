package com.n1.weixin.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.n1.weixin.entity.Result;
import com.n1.weixin.service.ResultService;
import com.n1.weixin.service.impl.ResultServiceImpl;
import com.n1.weixin.util.HandleList;
import com.n1.weixin.util.TimeTrans;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by admin on 2020/4/21.
 */
@Controller
public class ResultControll {
    @Autowired
    private ResultService resultService ;
    @RequestMapping(value="/gamedata" ,method = RequestMethod.GET)
    @ResponseBody
    public JSONObject returnResult(@Param("platform") String platform,@Param("period") String period,@Param("type") String type){

        List<Result> resultList = resultService.getResultListByParm(platform, period, type);
       // System.out.println(resultList);
        JSONObject jsonObject = HandleList.combineResut(resultList);
        //System.out.println(jsonObject);
        //System.out.println(jsonObject.getJSONArray("result"));

        String result=null;
        if(period.equals("month")){
            result = HandleList.getData(jsonObject, "bar", HandleList.getDayList());
        }else if(period.equals("today")||period.equals("yesterday")){
            result = HandleList.getData(jsonObject, "bar", HandleList.getTodayAlldayHourList());
        }else if(period.equals("year")){
            result = HandleList.getData(jsonObject, "bar", HandleList.getMonthList());
        }
        return JSONObject.parseObject(result);
    }


}
