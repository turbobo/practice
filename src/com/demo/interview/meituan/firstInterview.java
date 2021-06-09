package com.demo.interview.meituan;

import java.util.*;

/**
 * @Author Jusven
 * @Date 2021/4/27 22:21
 *
 * 从排序数组中找出离y最近的x个数---指的是在本数组中的位置距离
 * [1,2,3,4,5] x=4,y=3 ===>[1,2,4,5]
 * [1,3,6,7,8,9] x=4,y=5  ===>[1,3,6,7]
 * [1,3,6,7,8,9] x=4,y=8   ===>[3,6,7,9]
 */
public class firstInterview {
    public static void main(String[] args) {
        int[] arr = {1,3,6,7,8,9};
        int x = 3;
        int y = 8;
        //用集合存每个数和y的距离，
        Map<Float,Integer> map = new HashMap<Float,Integer>();
//        Arrays.sort();

        //先找y到位置
        float d = findY(arr, y);
        for (int i = 0; i < arr.length; i++) {
            float f = Math.abs(i - d);
            if(map.containsKey(f)){
                if(arr[i]<map.get(f))    //当前值比Map中的值小
                    map.put(f,arr[i]);
            }else
                map.put(f,arr[i]);
        }
        //这里将  map.entrySet()  用ArrayList构造函数把 map转换成list,元素是键值对Entry
        // 然后从 list取出元素就是有序的
        List<Map.Entry<Float,Integer>> list = new ArrayList<Map.Entry<Float,Integer>>((Collection<? extends Map.Entry<Float,Integer>>) map.entrySet());
        List l1 = new ArrayList(map.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list,new Comparator<Map.Entry<Float,Integer>>() {
            @Override
            public int compare(Map.Entry<Float,Integer> o1, Map.Entry<Float,Integer> o2) {
                return o1.getValue()-o2.getValue();   //比较值
//              return  o1.getValue().compareTo(o2.getValue());
            }
        });
        /*Set<Map.Entry<Float, Integer>> entries = map.entrySet();
        for(Map.Entry<Float, Integer> m1:map.entrySet()){
            System.out.println(m1.getKey());
        }*/

        int j = 0;
        int[] result = new int[x];
        for(Map.Entry<Float,Integer> mapping:list){
            if(j==x)
                break;
            result[j++] = mapping.getValue();
        }
        System.out.println(result);
    }

    public static float findY(int[] arr, int key) {
        //考虑两种特殊情况
        if (arr[0] < key && arr[1] > key)
            return 0.5f;
        if (arr[arr.length - 2] < key && arr[arr.length - 1] > key)
            return arr.length - 2 + 0.5f;

        int low = 0;
        int high = arr.length - 1;
        int middle = 0;
        while (low <= high) {
            middle = (low + high) / 2;
            if (middle == 0 || middle == arr.length - 1)
                return (float) middle;
            if (arr[middle] > key) {
                if(arr[middle-1] < key)
                    return (float)(2*middle-1) / 2;
                //比关键字大则关键字在左区域
                high = middle - 1;
            } else if (arr[middle] < key) {
                if(arr[middle+1] > key)
                    return (float)(2*middle+1) / 2;
                //比关键字小则关键字在右区域
                low = middle + 1;
            } else {
                return (float) middle;
            }
        }
        return -1f;
    }


}
