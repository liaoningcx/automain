package com.mic.generator.webser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by dd on 2018/9/10.
 */
public class TestMain {

    public static void main(String [] args){
        System.out.println("ReadTest, Please Enter Data:");
        InputStreamReader is = new InputStreamReader(System.in); //new构造InputStreamReader对象
        BufferedReader br = new BufferedReader(is); //拿构造的方法传到BufferedReader中，此时获取到的就是整个缓存流
        try{ //该方法中有个IOExcepiton需要捕获
            String name = br.readLine();
            System.out.println("ReadTest Output:" + name);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

}
