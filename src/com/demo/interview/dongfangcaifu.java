package com.demo.interview;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author Jusven
 * @Date 2021/6/3 16:05
 * 东方财富信息
 *
 * 密码必须：
 * 1、同时包含大写字母、小写字母、数字、特殊符号（不是字母，数字，下划线，汉字的字符）
 * 2、8位以上
 * 3、且不可包含用户名
 *
 *
 */
public class dongfangcaifu {
    //正则表达式
    public static final String PW_PATTERN = "^(?![A-Za-z0-9]+$)(?![a-z0-9\\W]+$)(?![A-Za-z\\W]+$)(?![A-Z0-9\\W]+$)[a-zA-Z0-9\\W]{8,}$";

    public static void main(String[] args) throws IOException {
        File file = new File("E:/test.txt");
        BufferedReader br  = new BufferedReader(new FileReader(file));
        String s1 = null;
        while ((s1 = br.readLine()) != null){
            checkPassword(s1);
        }

//        String str = "User2 JSOJOFjiuser1odkf93";

    }

    public static boolean checkPassword(String str){
        String[] s = str.split(" ");
        if(s[1].length() < 8){
            System.out.println(str+" 长度小于8！");
            return false;
        }
        if(ifContainsUser(str)){
            System.out.println(str+" 密码包含用户名！");
            return false;
        }
        if(!s[1].matches(PW_PATTERN)){
            System.out.println(str+" 不满足同时包含大写字母、小写字母、数字、特殊符号");
            return false;
        }
        System.out.println(str+" 满足要求");
        return true;
    }

    //判断是否包含用户名
    public static boolean ifContainsUser(String str){
        String[] s = str.split(" ");
        if(s[1].toLowerCase().contains(s[0].toLowerCase())){   //忽略大小写
            return true;
        }
        return false;
    }
}
