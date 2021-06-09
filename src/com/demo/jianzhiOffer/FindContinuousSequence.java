package com.demo.jianzhiOffer;

import java.util.*;

/**
 * @Author Jusven
 * @Date 2021/4/25 23:01
 *
 * �������ڵĲ���
 *
 * ���󴰿ڣ�j += 1
 * ��С���ڣ�i += 1
 * �㷨���裺
 * ��ʼ����i=1,j=1, ��ʾ���ڴ�СΪ0
 * ���������ֵ�ĺ�С��Ŀ��ֵsum�� ��ʾ��Ҫ���󴰿ڣ�j += 1
 * ����������ֵ�ʹ���Ŀ��ֵsum����ʾ��Ҫ��С���ڣ�i += 1
 * ���򣬵���Ŀ��ֵ����������С���ڣ��������в���2,3,4
 */
public class FindContinuousSequence {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(3493);
        list.add(12);
        list.add(324);
        list.add(4325);
        System.out.println(list);
        FindContinuousSequence_Solution(18);
    }
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence_Solution(int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if(sum==1)
            return list;
        int m=0;
        int start = 0;
        int end = 0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 1; i < sum; i++) {
            int numSum = 0;
            for (int j = i; j < sum; j++) {
                numSum += j;
                if(numSum==sum && i!=j){  //���ٰ���������
                    map.put(i,j);
                    break;
                }
            }
        }
//        int[] arr = new int[map.size()];
//        int[] arr = new int[];

        int arr_index = 0;
        //
        for(int k: map.keySet()){
            int j = map.get(k);
//            ArrayList<Integer> al = new ArrayList<Integer>(j-k+1);
            ArrayList<Integer> al = new ArrayList<Integer>();
            for(int index=0,i=k;i<=j;i++,index++){
                al.add(i);
            }
            list.add(al);
        }
        Collections.sort(list, new Comparator<ArrayList<Integer>>() {

            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });
        System.out.println(list);


//        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
       /* for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }



        for(Map.Entry<Integer,Integer> en: map.entrySet()){
            System.out.println(en.getKey()+"--"+en.getValue());
        }*/
        return list;
    }

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence_Solution22(int sum){
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        //���ٴ���1
        if(sum<=1)
            return resultList;
        //����ָ����Ϊ�������ڵı߽�
        int left = 1;
        int right = 2;
        int tempSum = left + right;
        while(right<sum){
            //�ʹ���sum,��Ҫ��С����,��ָ�����Ƽ���
            if(tempSum>sum){
                //�ȼ�ȥleftֵ�����ƶ�����������������������������
                tempSum = tempSum - left;
                left++;
            }else if(tempSum<sum){  //��С��sum,��Ҫ��С����,��ָ�����Ƽ���
                //���ƶ�������ͣ���������������������������
                right++;
                tempSum = tempSum + right;
            }else {
                ArrayList<Integer> al = new ArrayList<Integer>();
                for(int i=left;i<=right;i++){
                    al.add(i);
                }
                resultList.add(al);
                //��Ӻ�������ƴ��ڣ���������������������������
                //���ƶ��������
                right++;
                tempSum = tempSum + right;
            }
        }
        return resultList;
    }
}
