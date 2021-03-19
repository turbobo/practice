package com.demo.algorithm.jianzhiOffer;


import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author Jusven
 * @Date 2021/3/17 20:19
 *
 * ��һ���ַ���ת����һ��������Ҫ����ʹ���ַ���ת�������Ŀ⺯���� ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0
 */
public class StrToInt {
    public static void main(String[] args) {  //************************�������пո�
        String str = "-12 3 4";
        System.out.println(StrToInt(str));
    }



    public static int StrToInt(String str) {
        if(str.length()==0)
            return 0;

        int num;
        int sum = 0;

        //��һλ�Ƿ���λ
        if(str.charAt(0)=='+'||str.charAt(0)=='-'){
            for(int i=1;i<str.length();i++){      //�з���λ,�ӵڶ�λ��ʼ
                //1.��λ����
                num = str.charAt(i)-'0';
                //���������ַ�
                if(num>9)
                    return 0;
                //2.��λ��ֵ
                sum += num*Math.pow(10,str.length()-i-1);     //����i����
            }
            if(str.charAt(0)=='-')
                sum *=-1;
        }else{
            for(int i=0;i<str.length();i++){
                //1.��λ����
                num = str.charAt(i)-'0';
                //���������ַ�
                if(num>9)
                    return 0;
                //2.��λ��ֵ
                sum += num*Math.pow(10,str.length()-i-1);
            }
        }
        return sum;

    }
}
