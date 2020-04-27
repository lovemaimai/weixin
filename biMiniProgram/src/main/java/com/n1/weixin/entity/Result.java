package com.n1.weixin.entity;

import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2020/4/20.
 */
@Repository
public class Result {
    //游戏平台
    private String platform;
    // 游戏名称
    private String gameName;
    // 数字列表
    private String numList;
    //时间列表
    private String timeList;
    //时间段
    private String period;
    //数据种类
    private String type;


    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getNumList() {
        return numList;
    }

    public void setNumList(String numList) {
        this.numList = numList;
    }

    public String getTimeList() {
        return timeList;
    }

    public void setTimeList(String timeList) {
        this.timeList = timeList;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return "{\"Result\":{"
                + "\"platform\":\""
                + platform + '\"'
                + ",\"gameName\":\""
                + gameName + '\"'
                + ",\"numList\":\""
                + numList + '\"'
                + ",\"timeList\":\""
                + timeList + '\"'
                + ",\"period\":\""
                + period + '\"'
                + ",\"type\":\""
                + type + '\"'
                + "}}";

    }

}
