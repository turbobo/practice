package com.demo.jianzhiOffer;

import java.util.*;

/**
 * @Author Jusven
 * @Date 2021/4/28 23:06
 */
public class FindNumbersWithSum {
    public static void main(String[] args) {
        int[] a = {1,2,4,7,11,15};
//        System.out.println(FindNumbersWithSum(a,15));
        System.out.println(FindNumbersWithSum2(a,15));
    }

    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //ֱ��ѭ����������Map�洢
        for (int i = 0; i < array.length; i++) {
            if (map.containsValue(array[i]))  //���������ͬ����ֵkey�����ܳ���; ��Ҫ�ж�valueֵ�Ƿ��Ѵ���
                continue;
            for (int j = 0; j < array.length; j++) {
                if (j == i)   //�������������, valueֵ��Ҳ���ɴ���j
                    continue;
                if (array[i] + array[j] == sum) {
                    //������ֵ
//                    map.put(array[i], array[j]);

                    //��һ��ֵ�ͳ˻�
                    map.put(array[i], array[i]*array[j]);
                }
            }
        }
        if(!map.isEmpty()){
            List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
//                @Override  //������ֵ
//                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                    return (o1.getKey() * o1.getValue()) - (o2.getKey() * o2.getValue());  //���ճ˻�����
//                }

                @Override  //ֱ�ӱȽϳ˻�--->value
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o1.getValue() - o2.getValue();  //���ճ˻�����
                }
            });
            Map.Entry<Integer, Integer> m = list.get(0);
            //������ֵ
//            resultList.add(m.getKey());
//            resultList.add(m.getValue());

            //��һ��ֵ�ͳ˻�
            resultList.add(m.getKey());
            resultList.add(sum-m.getKey());
        }
        return resultList;

    }

    //˫ָ��ⷨ
    public static ArrayList<Integer> FindNumbersWithSum2(int[] array, int sum) {
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //��ЧУ��
        if(array.length<2)
            return resultList;

        //����ָ���ǰ �����м����
        int left = 0;
        int right = array.length-1;
        int tempSum = 0;
        while(left<right){   //����ָ�벻������
            tempSum = array[left] + array[right];
            if(tempSum < sum){  //��ָ������
                left++;
//                tempSum = array[left] + array[right];
            }else if(tempSum > sum){  //��ָ������
                right--;
//                tempSum = array[left] + array[right];
            }else{
                //��һ��ֵ�ͳ˻�
                map.put(array[left], array[left]*array[right]);

                //�����ƶ�ָ��**************************************
                right--;
            }
        }
        if(!map.isEmpty()){
            List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
//                @Override  //������ֵ
//                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                    return (o1.getKey() * o1.getValue()) - (o2.getKey() * o2.getValue());  //���ճ˻�����
//                }

                @Override  //ֱ�ӱȽϳ˻�--->value
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o1.getValue() - o2.getValue();  //���ճ˻�����
                }
            });
            Map.Entry<Integer, Integer> m = list.get(0);

            //��һ��ֵ�ͳ˻�
            resultList.add(m.getKey());
            resultList.add(sum-m.getKey());
        }

        return resultList;
    }
}
