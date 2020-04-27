package com.n1.weixin.aspect;

import com.n1.weixin.log.Logging;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import sun.rmi.runtime.Log;

import java.io.File;
import java.util.Arrays;

/**
 * Created by admin on 2020/4/27.
 */
@Aspect
@Component
public class LogAspect {
    @Before(value = "execution(* com.n1.weixin.controller.UserControll.returnLimit(*))&&args(nickName)",argNames = "nickName")
    public void beforeLogin(String nickName){
        //System.out.println(nickName+"登陆");
        //System.out.println(Arrays.asList(new File("./").list()) );
        Logging.writeNickName(nickName);
        Logging.writeTime();
    }

    @AfterReturning(value ="execution(* com.n1.weixin.controller.UserControll.returnLimit(*))" ,returning = "type")
    public void afterReturning(Boolean type){
        System.out.println(type);
        Logging.writeType(type);
    }
}
