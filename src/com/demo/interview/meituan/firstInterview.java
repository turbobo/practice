package com.demo.interview.meituan;

import java.util.*;

/**
 * @Author Jusven
 * @Date 2021/4/27 22:21
 *
 * �������������ҳ���y�����x����---ָ�����ڱ������е�λ�þ���
 * [1,2,3,4,5] x=4,y=3 ===>[1,2,4,5]
 * [1,3,6,7,8,9] x=4,y=5  ===>[1,3,6,7]
 * [1,3,6,7,8,9] x=4,y=8   ===>[3,6,7,9]
 */
public class firstInterview {
    public static void main(String[] args) {
        int[] arr = {1,3,6,7,8,9};
        int x = 3;
        int y = 8;
        //�ü��ϴ�ÿ������y�ľ��룬
        Map<Float,Integer> map = new HashMap<Float,Integer>();
//        Arrays.sort();

        //����y��λ��
        float d = findY(arr, y);
        for (int i = 0; i < arr.length; i++) {
            float f = Math.abs(i - d);
            if(map.containsKey(f)){
                if(arr[i]<map.get(f))    //��ǰֵ��Map�е�ֵС
                    map.put(f,arr[i]);
            }else
                map.put(f,arr[i]);
        }
        //���ｫ  map.entrySet()  ��ArrayList���캯���� mapת����list,Ԫ���Ǽ�ֵ��Entry
        // Ȼ��� listȡ��Ԫ�ؾ��������
        List<Map.Entry<Float,Integer>> list = new ArrayList<Map.Entry<Float,Integer>>((Collection<? extends Map.Entry<Float,Integer>>) map.entrySet());
        List l1 = new ArrayList(map.entrySet());
        //Ȼ��ͨ���Ƚ�����ʵ������
        Collections.sort(list,new Comparator<Map.Entry<Float,Integer>>() {
            @Override
            public int compare(Map.Entry<Float,Integer> o1, Map.Entry<Float,Integer> o2) {
                return o1.getValue()-o2.getValue();   //�Ƚ�ֵ
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
        //���������������
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
                //�ȹؼ��ִ���ؼ�����������
                high = middle - 1;
            } else if (arr[middle] < key) {
                if(arr[middle+1] > key)
                    return (float)(2*middle+1) / 2;
                //�ȹؼ���С��ؼ�����������
                low = middle + 1;
            } else {
                return (float) middle;
            }
        }
        return -1f;
    }


}
