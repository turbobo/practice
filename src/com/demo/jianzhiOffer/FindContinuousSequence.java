package com.demo.jianzhiOffer;

import java.util.*;

/**
 * @Author Jusven
 * @Date 2021/4/25 23:01
 *
 * 滑动窗口的操作
 *
 * 扩大窗口，j += 1
 * 缩小窗口，i += 1
 * 算法步骤：
 * 初始化，i=1,j=1, 表示窗口大小为0
 * 如果窗口中值的和小于目标值sum， 表示需要扩大窗口，j += 1
 * 否则，如果狂口值和大于目标值sum，表示需要缩小窗口，i += 1
 * 否则，等于目标值，存结果，缩小窗口，继续进行步骤2,3,4
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
                if(numSum==sum && i!=j){  //至少包含两个数
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
        //最少大于1
        if(sum<=1)
            return resultList;
        //两个指针作为滑动窗口的边界
        int left = 1;
        int right = 2;
        int tempSum = left + right;
        while(right<sum){
            //和大于sum,需要缩小窗口,左指针右移即可
            if(tempSum>sum){
                //先减去left值，再移动！！！！！！！！！！！！！！
                tempSum = tempSum - left;
                left++;
            }else if(tempSum<sum){  //和小于sum,需要缩小窗口,右指针右移即可
                //先移动，再求和！！！！！！！！！！！！！！
                right++;
                tempSum = tempSum + right;
            }else {
                ArrayList<Integer> al = new ArrayList<Integer>();
                for(int i=left;i<=right;i++){
                    al.add(i);
                }
                resultList.add(al);
                //添加后继续右移窗口！！！！！！！！！！！！！！
                //先移动，再求和
                right++;
                tempSum = tempSum + right;
            }
        }
        return resultList;
    }
}
