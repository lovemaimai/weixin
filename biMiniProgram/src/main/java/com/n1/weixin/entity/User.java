package com.n1.weixin.entity;

import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2020/4/20.
 */
@Repository
public class User {
    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "{\"User\":{"
                + "\"nickName\":\""
                + nickName + '\"'
                + "}}";

    }
}
