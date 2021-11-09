package com.demo.leetcode;

/**
 * @Author Jusven
 * @Date 2021/11/7 22:07
 */
public class backspaceCompare {

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab##", "a#d#"));
    }

    public static boolean backspaceCompare(String s, String t) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        String[] s1 = s.split("");
        String[] s2 = t.split("");
        for(int i=0;i<s1.length;i++){
            if(!"#".equals(s1[i])){
                sb1.append(s1[i]);
            }else{
                if(sb1.length()>0){
                    sb1.deleteCharAt(sb1.length()-1);
                }
            }
        }
        for(int i=0;i<s2.length;i++){
            if(!"#".equals(s2[i])){
                sb2.append(s2[i]);
            }else{
                if(sb2.length()>0){
                    sb2.deleteCharAt(sb2.length()-1);
                }
            }
        }
        if(sb1.toString().equals(sb2.toString())){
            return true;
        }
        return false;
    }
}
