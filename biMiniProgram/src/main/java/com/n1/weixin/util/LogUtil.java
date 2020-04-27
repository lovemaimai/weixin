package com.n1.weixin.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;

/**
 * Created by admin on 2020/4/27.
 */
public class LogUtil {

    public static void writeLog(String str){
        FileWriter fw = null;

        try{
             fw = new FileWriter(new File("logs/login.log"),true);
             fw.write(str);
             fw.flush();
             fw.close();

        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
    }




}
