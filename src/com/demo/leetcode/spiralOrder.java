package com.demo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author Jusven
 * @Date 2021/11/22 17:14
 */
public class spiralOrder {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9},{11,12,13}};
        int[] ints = spiralOrder(matrix);
        System.out.println(Arrays.toString(ints));

    }

    public static int[] spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        //结束条件？
        int len = (matrix.length) * (matrix[0].length);
        int[] result = new int[len];
        int i = 0;
        while(i<len){
            //上边
            for(int j=left;j<=right;j++){
                result[i++] = matrix[top][j];
            }
            top++;
            //右边
            for(int j=top;j<=bottom;j++){
                result[i++] = matrix[j][right];
            }
            right--;
            //下边
            for(int j=right;j>=left;j--){
                result[i++] = matrix[bottom][j];
            }
            bottom--;
            //左边
            for(int j=bottom;j>=top;j--){
                result[i++] = matrix[j][left];
            }
            left++;
        }
        return result;
    }

    public int totalFruit(int[] fruits) {
        //记录两个篮子和对应水果数量
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        //记录其实位置，需要及时移除首个位置的水果
        int start = 0;
        //当前收集水果总量
        int res = 0;
        for(int i=0;i<fruits.length;i++){
            if(map.containsKey(fruits[i])){
                map.put(fruits[i],map.get(fruits[i]) + 1);
            }else{
                map.put(fruits[i],1);
            }
            //判断当前篮子里水果类型
            //超过3,需要修改起点,起点位置对应位置的水果数量减1
            if(map.size() >= 3){
                map.put(fruits[start],map.get(fruits[start]) - 1);
                //该类型水果没有，则移除
                if(map.get(fruits[start]) == 0){
                    map.remove(fruits[start]);
                }
                start++;
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            res += m.getValue();
        }
        return res;
    }
}
