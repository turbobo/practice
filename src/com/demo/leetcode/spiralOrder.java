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
        //����������
        int len = (matrix.length) * (matrix[0].length);
        int[] result = new int[len];
        int i = 0;
        while(i<len){
            //�ϱ�
            for(int j=left;j<=right;j++){
                result[i++] = matrix[top][j];
            }
            top++;
            //�ұ�
            for(int j=top;j<=bottom;j++){
                result[i++] = matrix[j][right];
            }
            right--;
            //�±�
            for(int j=right;j>=left;j--){
                result[i++] = matrix[bottom][j];
            }
            bottom--;
            //���
            for(int j=bottom;j>=top;j--){
                result[i++] = matrix[j][left];
            }
            left++;
        }
        return result;
    }

    public int totalFruit(int[] fruits) {
        //��¼�������ӺͶ�Ӧˮ������
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        //��¼��ʵλ�ã���Ҫ��ʱ�Ƴ��׸�λ�õ�ˮ��
        int start = 0;
        //��ǰ�ռ�ˮ������
        int res = 0;
        for(int i=0;i<fruits.length;i++){
            if(map.containsKey(fruits[i])){
                map.put(fruits[i],map.get(fruits[i]) + 1);
            }else{
                map.put(fruits[i],1);
            }
            //�жϵ�ǰ������ˮ������
            //����3,��Ҫ�޸����,���λ�ö�Ӧλ�õ�ˮ��������1
            if(map.size() >= 3){
                map.put(fruits[start],map.get(fruits[start]) - 1);
                //������ˮ��û�У����Ƴ�
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
