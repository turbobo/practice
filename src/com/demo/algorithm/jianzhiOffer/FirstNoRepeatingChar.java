package com.demo.algorithm.jianzhiOffer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author Jusven
 * @Date 2021/3/4 19:38
 */
public class FirstNoRepeatingChar {
    public static void main(String[] args) {
        String str = "google";
        String str2 = "ggoo7";
        String str3 = "AggooAaa";
        String str4="NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp";
        System.out.println("��һ��ֻ����һ�ε��ַ����½Ǳ�Ϊ��"+FirstNotRepeatingChar_Solution(str4));
        System.out.println("��һ��ֻ����һ�ε��ַ����½Ǳ�Ϊ��"+FirstNotRepeatingChar_Solution2(str4));
        System.out.println(str+"��һ���ַ���λ���½Ǳ�Ϊ��"+str.indexOf('g'));
    }

    public static int FirstNotRepeatingChar_Solution(String str) {
        //�ù�ϣ��洢���ִ���
        /*
        * HashMap������ģ�������ϣ����˳���ȥ�洢key-valueʱ������Ҫʹ��LinkedHashMap�ˡ�
        * LinkedHashMap������ģ��ҷ���˳��Ĭ��Ϊ����˳��
        * Linked + HashMap����˫������+HashMap
        * */
//        HashMap<Object,Integer> map = new HashMap<Object,Integer>();
        LinkedHashMap <Object,Integer> map = new LinkedHashMap<Object,Integer>();
        //��ǰ�ַ�
//         char temp = str.charAt(0);
       /* for(int i=0;i<str.length();i++) {
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),map.get(str.charAt(i))+1);
            }else{
                map.put(str.charAt(i),1);
            }
        }
        Object ch = '0';
        for(Object key: map.keySet()){
            if(map.get(key)==1)
                break;
        }
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==char.Parse(ch))
                return i;
        }
        return -1;*/

       for(int i=0;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
                int count = map.get(str.charAt(i));
                map.put(str.charAt(i),count+1);
            }else{  //��һ�γ���
                map.put(str.charAt(i),1);
            }
        }
//        Object result = null;
        for(Map.Entry<Object,Integer> entry: map.entrySet()){
            if(entry.getValue()==1)
                return str.indexOf(entry.getKey().toString());
//                result = entry.getKey();   //ȡmap�е����һ��Ԫ��
        }
//        if(result!=null)
//            return str.indexOf(result.toString());
//        else
            return -1;
    }

    public static int FirstNotRepeatingChar_Solution2(String str) {

        HashMap<Object,Integer> map = new HashMap<Object,Integer>();

        for(int i=0;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
                int count = map.get(str.charAt(i));
                map.put(str.charAt(i),count+1);
            }else{  //��һ�γ���
                map.put(str.charAt(i),1);
            }
        }
        //ֱ�ӱ����ַ������ɣ��ó���ȥmap�в��ñ���Map����ΪHashmap������ģ���������������������������������������������������
        for(int i=0;i<str.length();i++){
            if(map.get(str.charAt(i))==1)  //�ַ���str�г��ִ���ֻ��1��
                return i;
        }

        return -1;
    }
}
