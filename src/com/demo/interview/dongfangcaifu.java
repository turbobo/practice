package com.demo.interview;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author Jusven
 * @Date 2021/6/3 16:05
 * �����Ƹ���Ϣ
 *
 * ������룺
 * 1��ͬʱ������д��ĸ��Сд��ĸ�����֡�������ţ�������ĸ�����֣��»��ߣ����ֵ��ַ���
 * 2��8λ����
 * 3���Ҳ��ɰ����û���
 *
 *
 */
public class dongfangcaifu {
    //������ʽ
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
            System.out.println(str+" ����С��8��");
            return false;
        }
        if(ifContainsUser(str)){
            System.out.println(str+" ��������û�����");
            return false;
        }
        if(!s[1].matches(PW_PATTERN)){
            System.out.println(str+" ������ͬʱ������д��ĸ��Сд��ĸ�����֡��������");
            return false;
        }
        System.out.println(str+" ����Ҫ��");
        return true;
    }

    //�ж��Ƿ�����û���
    public static boolean ifContainsUser(String str){
        String[] s = str.split(" ");
        if(s[1].toLowerCase().contains(s[0].toLowerCase())){   //���Դ�Сд
            return true;
        }
        return false;
    }
}
