package com.n1.weixin.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.n1.weixin.entity.Result;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 处理List数据类
 * Created by admin on 2020/4/22.
 */
public class HandleList {

    /**
     *
     * @param list 目标List
     * @param item 判断是否在List里的元素
     * @return
     */
    public static Boolean isInList(List list, String item){
        Boolean flag = true;
        if (list.size() == 0) {
            flag = true;
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (item.equals(list.get(i))) {
                    flag = false;
                    return flag;
                }
            }
        }
        return flag;
    }

    /**
     * 获取30日时间List
     * @return 30日时间List [yyyy-MM-dd,yyyy-MM-dd..]
     */
    public static List getDayList() {
        Calendar now = Calendar.getInstance();
        List<String > dateList = new ArrayList();
        for (int i = 1; i <= 30; i++) {
            now.add(Calendar.DAY_OF_MONTH, -1);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/Chicago"));
            String date = simpleDateFormat.format(now.getTime());
            dateList.add(date);
        }
        Collections.sort(dateList);
        return dateList;
    }

    /**
     * 获取12月时间List
     * @return 12月时间List [yyyy-MM,yyyy-MM..]
     */
    public static List getMonthList() {
        Calendar now = Calendar.getInstance();
        List<String > dateList = new ArrayList();
        for (int i = 1; i <= 12; i++) {
            now.add(Calendar.MONTH, -1);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/Chicago"));
            String date = simpleDateFormat.format(now.getTime());
            dateList.add(date);
        }
        Collections.sort(dateList);
        return dateList;
    }

    /**
     *  获取当天经过时间List，如果时间为11点，返回为11点之前所有的整点
     * @return 当天经过时间List [yyyy-MM-dd HH:mm:ss,yyyy-MM-dd HH:mm:ss..]
     */
    public static List getTodayHourList() {
        List<String > hourList = new ArrayList();
        try{
            Calendar now = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            simpleDateFormat1.setTimeZone(TimeZone.getTimeZone("America/Chicago"));
            String date1 = simpleDateFormat1.format(now.getTime());
            //System.out.println(date1);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/Chicago"));
            String nowdate = simpleDateFormat.format(now.getTime())+" 00:00:00";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
            Date dt = sdf.parse(nowdate);
            now.setTime(dt);
            for (int i = 0; i <= 23; i++) {
                String date = sdf.format(now.getTime());
                //System.out.println(date1.substring(1,13));
                if(date1.substring(0,13).equals(date)){
                    break;
                }
                hourList.add(date+":00:00");
                now.add(Calendar.HOUR_OF_DAY, 1);
            }
            Collections.sort(hourList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return hourList;
    }

    /**
     *  获取24小时时间List
     * @return 24小时时间List [yyyy-MM-dd HH:mm:ss,yyyy-MM-dd HH:mm:ss..]
     */
    public static List getTodayAlldayHourList() {
        List<String > hourList = new ArrayList();
        try{
            Calendar now = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/Chicago"));
            String nowdate = simpleDateFormat.format(now.getTime())+" 00:00:00";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
            Date dt = sdf.parse(nowdate);
            now.setTime(dt);
            for (int i = 0; i <= 23; i++) {
                String date = sdf.format(now.getTime());
                hourList.add(date+":00:00");
                now.add(Calendar.HOUR_OF_DAY, 1);
            }
            Collections.sort(hourList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return hourList;
    }

    /**
     * 获取24小时list
     * @return 24小时时间List [HH:mm:ss,HH:mm:ss..]
     */
    public static List get24HourList() {
        List<String > hourList = new ArrayList();
        try{
            Calendar now = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/Chicago"));
            String nowdate = simpleDateFormat.format(now.getTime())+" 00:00:00";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
            Date dt = sdf.parse(nowdate);
            now.setTime(dt);
            for (int i = 0; i <= 23; i++) {
                String date = sdf.format(now.getTime());
                hourList.add(date.substring(11,13)+":00:00");
                now.add(Calendar.HOUR_OF_DAY, 1);
            }
            Collections.sort(hourList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return hourList;
    }

    /**
     * 将时间和对应数量结合，如果没有数量则为0
     * @param dateList 实际日期list
     * @param numList 数量list
     * @param allDateList 标准日期list
     * @return 返回完整数量List
     */
    public static  List combineDateAndNum(List dateList, List numList, List allDateList){
        Map d2l = new HashMap();
        List newList = new ArrayList();
        for(int i=0;i<dateList.size();i++){
            d2l.put(dateList.get(i),numList.get(i));
        }
        if(dateList.size()!=allDateList.size()){
            for(int i=0;i<allDateList.size();i++){
                if(dateList.contains(allDateList.get(i))){
                    continue;
                }else{
                    d2l.put(allDateList.get(i),"0");
                }
            }
        }
        for(int i=0;i<allDateList.size();i++){
            newList.add(d2l.get(allDateList.get(i)));
        }
        //System.out.println(newList);
        return newList;
    }

    /**
     * 实时数据累加集合中的数据
     * @param list  数量集合
     * @param timeList 时间集合
     * @return 数量累加集合
     */
    public static List sumList(List <String>list,List timeList){
        List sumList= new ArrayList();
        List hourList = new ArrayList();
        //System.out.println(list.toString());
        //如果传入时间集合大小为24，说明是昨天的对比数据
        if(timeList.size()==24){
            hourList=get24HourList();
            //实时数据
        }else{
            hourList=getTodayHourList();
        }
        for(int i =0;i<hourList.size();i++){
            double sum=0;
            for(int j=0;j<=i;j++){

                sum=sum+ Double.parseDouble(list.get(j));
            }
            sumList.add(sum);
        }
        //System.out.println(sumList.size());
        //实时数据没到时间后面数量均为0
        int dev=24-sumList.size();
        for(int i=0;i<dev;i++){
            sumList.add(0);
        }
        return sumList;
    }

    /**
     * 将Resut集合转换成json
     * @param list
     * @return
     */
    public static JSONObject combineResut(List<Result> list){
        List resultList = new ArrayList();
        for(int i =0;i<list.size();i++){
            Result result = list.get(i);
            JSONObject json = JSONObject.parseObject(result.toString());
            resultList.add(json);
        }
        JSONObject resultJson = new JSONObject();
        resultJson.put("result",list);
        return  resultJson;
    }

    /**
     * 将resultJson 转换为字符串
     * @param result resultJson
     * @param seriesType 表格类型     *
     * @param dateList 时间类型
     * @return json 字符串
     */
    public  static String getData(JSONObject result,String seriesType,List dateList){
        List <String> gameList = new ArrayList<String>();
        List seriesList = new ArrayList();
        JSONObject allJson = new JSONObject();
        String platform=null;
        String period =null;
        try {
            JSONArray resultList = result.getJSONArray("result");
            for(int i=0;i<resultList.size();i++){
                String gameName = resultList.getJSONObject(i).getString("gameName");
                if(!gameList.contains(gameName)){
                    gameList.add(gameName);
                }
                String num = resultList.getJSONObject(i).getString("numList");
                List<String> numList = Arrays.asList(num.split(","));
                //System.out.println(numList);
                String time = resultList.getJSONObject(i).getString("timeList");

                List<String> timeList = Arrays.asList(time.split(","));

                platform = resultList.getJSONObject(i).getString("platform");
                period = resultList.getJSONObject(i).getString("period");
                JSONObject json = new JSONObject();
                if(!period.equals("yesterday")){
                    List newnumList = combineDateAndNum(timeList, numList, dateList);
                    json.put("name",gameName);
                    json.put("type",seriesType);
                    json.put("stack","数量");
                    if(dateList.size()==30|| dateList.size()==12){
                        json.put("data",newnumList);
                    }else {
                        json.put("data",sumList(newnumList,timeList));
                    }
                }else{
                    List newtimeList =new ArrayList();
                    for(int j=0;j<timeList.size();j++){
                        //System.out.println(TimeTrans.addDate(timeList.get(j)));
                        newtimeList.add(TimeTrans.addDate(timeList.get(j)));
                    }
                    List newnumList = combineDateAndNum(newtimeList, numList, dateList);
                    json.put("name",gameName);
                    json.put("type","line");
                    json.put("stack","数量1");
                    if(dateList.size()==30){
                        json.put("data",newnumList);
                    }else {
                        json.put("data",sumList(newnumList,dateList));
                    }
                    //System.out.println(newtimeList.size());
                }


                seriesList.add(json);
                //System.out.println(gameList.size());
            }

            //System.out.println(seriesList.toString());
            allJson.put("gamename",gameList);
            allJson.put("date",dateList);
            allJson.put("series",seriesList);
            allJson.put("platform",platform);
            //System.out.println(gameList.toString());
            //System.out.println(seriesList.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        return allJson.toString();
    }
    public static void main(String[] args) {
        //System.out.println(getDateDev("2001-01-01","2001-01-02"));
    }
}
