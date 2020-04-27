package com.n1.weixin.log;

import ch.qos.logback.core.util.TimeUtil;
import com.n1.weixin.util.LogUtil;
import com.n1.weixin.util.TimeTrans;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by admin on 2020/4/27.
 */

@Component
public class Logging {
    public static void writeNickName(String nickName){
        LogUtil.writeLog(nickName+"\t");
    }

    public static void writeTime(){
        LogUtil.writeLog(TimeTrans.getBjTime()+"\t");
    }

    public static void writeType(Boolean type){
        LogUtil.writeLog(type.toString()+"\n");
    }

}
