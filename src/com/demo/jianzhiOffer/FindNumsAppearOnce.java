package com.demo.jianzhiOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.IntPredicate;

/**
 * @Author Jusven
 * @Date 2021/3/12 17:21
 */
public class FindNumsAppearOnce {
    public static void main(String[] args) {
        int[] a = {1,4,1,6};
//        List l = Arrays.asList(FindNumsAppearOnce_Solution(a));
//        System.out.println(Arrays.toString(FindNumsAppearOnce_Solution(a)));
//        System.out.println(Arrays.toString(FindNumsAppearOnce2(a)));
        System.out.println(Arrays.toString(FindNumsAppearOnce3(a)));

    }

    /**
     * �����е����������������������Ѿ�ָ���������޸ģ�ֱ�ӷ��ط����涨��ֵ����
     *
     *
     * @param array int����һά����
     * @return int����һά����
     */
    public static int[] FindNumsAppearOnce_Solution (int[] array) {
        // write code here
        long start = System.currentTimeMillis();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            if (list.contains(array[i])) {
//                list.remove(array[i]);    //���±��Ƴ�
                list.remove((Object) array[i]);    //�Ƴ�����Ԫ��
            } else {
                list.add(array[i]);  //��ӵ���Ԫ��
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start+"��");
        if(list.get(0)<list.get(1))
            return new int[]{list.get(0), list.get(1)};
        else
            return new int[]{list.get(1), list.get(0)};


        //��map���ϱ������֣���ͬ���Ƴ�
//        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
//        for(int i=0;i<array.length;i++){
//             if(map.containsKey(array[i])){  //���ڹ����Ƴ�
//                 map.remove(array[i]);
//             }else
//                 map.put(array[i],1);
//         }
//         int[] a=new int[2];
//         int i=0;
//         for (Integer key : map.keySet())
//         {
//             a[i++]=key;
//         }
//         if(a[0]>a[1]){
//             int temp=a[0];
//             a[0]=a[1];
//             a[1]=temp;
//         }
//         return a;





        //1����ʼ��һ������Ϊ10����������,��ֵΪ-1
//         int[] a = new int[10];
//         for(int i=0;i<array.length;i++){
//             a[i]=-1;
//         }
//         int[] b = new int[2];
//         int j=0;
//         //2��ÿ�����ֺ�0�Ƚϲ�ֵ���Ǹ�����ֵ
// //         for(int i=0;i<array.length;i++){
// //             a[array[i]-0]++;
// //         }
// //         for(int i=0;i<a.length;i++){
// //             if(j>=2)
// //                 break;
// //             if(a[i]==-1)   //������Ϊ����
// //                 continue;
// //             if(a[i]==0)
// //                 b[j++]=i;
// //         }
//         return b;
    }

    public static int[] FindNumsAppearOnce2 (int[] array) {
        // ������ȡ�����
        Function<IntPredicate, Integer> getXor = (intPredicate) -> Arrays.stream(array)
                .filter(intPredicate).reduce((a, b) -> a ^ b).getAsInt();

        // ��ȡȫ�����ݵ������
        int xorResult = getXor.apply(a -> true);
        // ȡȫ���������ĩλ
        int lastBit = xorResult ^ (xorResult & (xorResult - 1));

        int[] result = new int[2];
        // ��������ȫ���������ĩλ�Ƿ���ȣ����ж������
        result[0] = getXor.apply(a -> (a & lastBit) == lastBit);
        result[1] = getXor.apply(a -> (a & lastBit) == 0);
        Arrays.sort(result);
        return result;
    }



    public static void swap(int[] a, int l, int r){
        int o = a[l];
        a[l] = a[r];
        a[r] = o;
    }
    public static int[] FindNumsAppearOnce3 (int[] array) {
        // write code here
        int[] a = new int[2];   //������Ĭ��Ϊ0
        int x = array[0];
        //�������е����������������
        //��ͬ�����������Ϊ0�� 0������x���Ľ��Ϊx
        //�������յĽ��Ϊ�������ֵ����ֵ������
        for(int i = 1; i < array.length; i++){
            x ^= array[i];   //���   ��ͬΪ��
        }
        int m=1;
        //�����������ֵ���������mλ���죬����x�е�mλΪ1
        //�ҵ�������mλ
        while ((m&x)==0){
            m=m<<1;   //��x��ÿһλ��1�룬���Ϊ0����λ����1
        }
        //���ݵ�mλ��ֵ��ԭ�����Ϊ���飬�������ֵ��������ַ��ڲ�ͬ����
        for(int i:array){
            if((m&i)==0){
                a[0]^=i;    //ͬһ������һֱ�����ȥ���ܵõ�ԭֵ
            }else {
                a[1]^=i;
            }
        }
        if(a[0] > a[1]){
            swap(a, 0, 1);
        }
        return a;
    }
}
