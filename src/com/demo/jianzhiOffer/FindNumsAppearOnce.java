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
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param array int整型一维数组
     * @return int整型一维数组
     */
    public static int[] FindNumsAppearOnce_Solution (int[] array) {
        // write code here
        long start = System.currentTimeMillis();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            if (list.contains(array[i])) {
//                list.remove(array[i]);    //按下标移除
                list.remove((Object) array[i]);    //移除的是元素
            } else {
                list.add(array[i]);  //添加的是元素
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start+"秒");
        if(list.get(0)<list.get(1))
            return new int[]{list.get(0), list.get(1)};
        else
            return new int[]{list.get(1), list.get(0)};


        //用map集合保存数字，相同就移除
//        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
//        for(int i=0;i<array.length;i++){
//             if(map.containsKey(array[i])){  //存在过就移除
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





        //1、初始化一个长度为10的整型数组,赋值为-1
//         int[] a = new int[10];
//         for(int i=0;i<array.length;i++){
//             a[i]=-1;
//         }
//         int[] b = new int[2];
//         int j=0;
//         //2、每个数字和0比较差值就是该数字值
// //         for(int i=0;i<array.length;i++){
// //             a[array[i]-0]++;
// //         }
// //         for(int i=0;i<a.length;i++){
// //             if(j>=2)
// //                 break;
// //             if(a[i]==-1)   //该数字为出现
// //                 continue;
// //             if(a[i]==0)
// //                 b[j++]=i;
// //         }
//         return b;
    }

    public static int[] FindNumsAppearOnce2 (int[] array) {
        // 用以提取异或结果
        Function<IntPredicate, Integer> getXor = (intPredicate) -> Arrays.stream(array)
                .filter(intPredicate).reduce((a, b) -> a ^ b).getAsInt();

        // 提取全量数据的异或结果
        int xorResult = getXor.apply(a -> true);
        // 取全量异或结果的末位
        int lastBit = xorResult ^ (xorResult & (xorResult - 1));

        int[] result = new int[2];
        // 按数据与全量异或结果的末位是否相等，进行二次异或
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
        int[] a = new int[2];   //空数组默认为0
        int x = array[0];
        //将数组中的所有数字做异或处理
        //相同的数字异或结果为0， 0与数字x异或的结果为x
        //所以最终的结果为单独出现的数字的异或结果
        for(int i = 1; i < array.length; i++){
            x ^= array[i];   //异或   不同为真
        }
        int m=1;
        //两个单独出现的数字若在m位相异，则在x中第m位为1
        //找到这样的m位
        while ((m&x)==0){
            m=m<<1;   //将x的每一位和1与，如果为0，该位就是1
        }
        //根据第m位的值将原数组分为两组，单独出现的两个数字分在不同的组
        for(int i:array){
            if((m&i)==0){
                a[0]^=i;    //同一个条件一直异或下去就能得到原值
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
