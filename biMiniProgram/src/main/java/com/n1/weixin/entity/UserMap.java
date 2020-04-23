package com.n1.weixin.entity;

/**
 * Created by admin on 2020/4/20.
 */
public class UserMap {
    private String country;
    private long num;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "{\"UserMap\":{"
                + "name:\""
                + country + "\""
                + ",value:"
                + num
                + "}}";
    }
}
