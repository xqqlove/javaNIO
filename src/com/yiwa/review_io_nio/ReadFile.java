package com.yiwa.review_io_nio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Author qiangqiang
 * @Date 2020/6/11 11:20
 * @Version 1.0
 */
public class ReadFile {
    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream=new FileInputStream("e:\\io.txt");
        InputStreamReader reader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String b=null;
        while((b=bufferedReader.readLine())!=null){
            System.out.println(new String(b.getBytes("UTF-8")));
        }


    }
}
