package com.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Jusven
 * @Date 2021/11/25 12:24
 * 电话号码的字母组合
 */
public class letterCombinations {
    public static void main(String[] args) {
        String digits = "234";
//        int digit = digits[0] - '0';
        int i = digits.charAt(0) - '0';
        System.out.println(i);
        System.out.println(letterCombinations("1*3"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        StringBuilder path = new StringBuilder();
        if (digits.length() == 0){
            return res;
        }
        String[] letterMap = {
                "", // 0
                "", // 1
                "abc", // 2
                "def", // 3
                "ghi", // 4
                "jkl", // 5
                "mno", // 6
                "pqrs", // 7
                "tuv", // 8
                "wxyz", // 9
        };
        //去掉转换
        // String[] input = digits.split("");
        backTrack(res,path,digits,0,letterMap);
        return res;
    }

    private static void backTrack(List<String> res, StringBuilder path, String digits, int index, String[] letterMap) {
        //结束条件：digits遍历完--每个数字选一个字母，最终有digits.length()个字母
        if (index == digits.length()){
            res.add(path.toString());
            return;
        }
        //当前输入的数字和对应的字母
        // int digit = Integer.parseInt(input[index]);
        // String[] letters = letterMap[digit].split("");
        //两部合并为一步 --- 字符和 '0'取差值即可得到整型
        String letters = letterMap[digits.charAt(index)-'0'];

        //每次递归都是从不同的集合开始取数字，所有i从0开始
        //本次for循环是digits的index位置数字对应的
        for (int i = 0; i < letters.length(); i++) {
            char c = letters.charAt(i);
            if(c == '*' || c == '#' || c == '0'){
                continue;
            }
            //处理当前结点
            path.append(letters.charAt(i));
            //递归
            backTrack(res,path,digits,index+1,letterMap);
            //回溯
            path.deleteCharAt(path.length()-1);
        }
    }


    //清 北 人大 北师大  北航  北理工  中国农业  中央民族
    //吉大  大连理工  东北大学   哈工大
    //南开  天大
    //山东大学
    //南大  东南
    //复旦  交大  同济  华师
    //科大
    // 浙大
    // 武大  华科
    //西交  西工大  西北农林
    //川大  电科
    //重大
    //湖大  中南   国防科大
    //厦门
    //中山大学  华南理工


    //兰州大学
    //中国海洋大学


}
