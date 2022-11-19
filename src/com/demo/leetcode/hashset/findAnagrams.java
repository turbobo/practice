package com.demo.leetcode.hashset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: wangbo82
 * @Date: 2022年11月19日 13:55
 * <p>
 * 给定两个字符串?s?和 p，找到?s?中所有?p?的?异位词?的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class findAnagrams {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "bac"));
    }

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return res;
        }


        //一、借助hashset思路
        /*int[] recordS = new int[26];
        int[] recordP = new int[26];

        for (int i = 0; i < p.length(); i++) {
            recordP[p.charAt(i) - 'a']++;
        }
        //将记录次数转为字符串
        String recordP_str = Arrays.toString(recordP);

        //仅包含小写字母
        int lengthP = p.length();
        //字串起始指针
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            recordS[s.charAt(i) - 'a']++;
            if (i >= lengthP - 1) {
                String recordS_str = Arrays.toString(recordS);
                if (recordS_str.equals(recordP_str)) {
                    res.add(i - lengthP + 1);
                }
                //无论上述是否相等，都要去掉当前第一个位置的元素,因为p长度固定，s往后遍历，个数会增加
                recordS[s.charAt(i - lengthP + 1) - 'a']--;

            }
        }*/


        //二、按照小写字母 将字符串转为数组再转为字符串排序
        /*char[] arrayP = p.toCharArray();
        Arrays.sort(arrayP);
        String strP = Arrays.toString(arrayP);
        int lengthP = p.length();
        for (int i = 0; i < s.length(); i++) {
            if (i >= lengthP - 1) {
                String substring = s.substring(i - lengthP + 1, i + 1);
                char[] arrS = substring.toCharArray();
                Arrays.sort(arrS);
                String strS = Arrays.toString(arrS);
                if (strP.equals(strS)) {
                    res.add(i - lengthP + 1);
                }
            }
        }*/

        //三、滑动窗口
        int[] recordS = new int[26];
        int[] recordP = new int[26];
        for (int i = 0; i < p.length(); i++) {
            recordP[p.charAt(i) - 'a']++;
        }
        //将记录次数转为字符串
        String recordP_str = Arrays.toString(recordP);

        //仅包含小写字母
        int lengthP = p.length();
        //字串起始指针
        int j = 0;
        for (int i = lengthP-1; i < s.length(); i++) {
            recordS[s.charAt(i) - 'a']++;
            if (i >= lengthP - 1) {
                String recordS_str = Arrays.toString(recordS);
                if (recordS_str.equals(recordP_str)) {
                    res.add(i - lengthP + 1);
                }
                //无论上述是否相等，都要去掉当前第一个位置的元素,因为p长度固定，s往后遍历，个数会增加
                recordS[s.charAt(i - lengthP + 1) - 'a']--;

            }
        }

        return res;
    }
}
