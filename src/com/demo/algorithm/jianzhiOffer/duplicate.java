package com.demo.algorithm.jianzhiOffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author Jusven
 * @Date 2021/3/17 21:11
 */
public class duplicate {

    public static void main(String[] args) {
//        int[] numbers = {23,4,32,23,45,4,342,4,66};
        int[] numbers = {2,1,3,1,4};
//        Arrays.sort(numbers);  //���������ظ��Ľϴ�Ԫ�طŵ������λ��
        System.out.println(duplicate(numbers));
        System.out.println(duplicate22(numbers));
    }

    public static int duplicate (int[] numbers) {
        for(int i=0;i<numbers.length-1;i++){
            if(numbers[i+1]==numbers[i])
                return numbers[i];
        }
        return -1;
    }

    public  static int duplicate22(int[] numbers){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            if (!set.add(numbers[i])) {  //����ظ�Ԫ�ػ᷵��false
                return numbers[i];
            }
        }
        return -1;
    }


    //         //������  ---����
//         Arrays.sort(numbers);
//         //�ٱ���
//         for(int i=0;i<numbers.length-1;i++){
//             if(numbers[i+1]==numbers[i])
//                 return numbers[i];
//         }
//         return -1;



//         //����ASCII��ֵ  ---����
//         int[] a = new int[10];
//         for(int key: numbers){
//             a[key-'0']++;   //��'0'�Ĳ�ֵ���Ǹ�����
//             if(a[key-'0']>=2)
//                 return key;
//         }
//         return -1;

    //ʹ��HashMap����ֵ---���ܼ���
//         HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
//         for(int key: numbers){
//             if(map.containsKey(key))
//                 return key;
//             else
//                 map.put(key,1);
//         }
//         return -1;
}
