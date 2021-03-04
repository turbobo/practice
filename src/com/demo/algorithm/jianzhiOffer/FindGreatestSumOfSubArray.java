package com.demo.algorithm.jianzhiOffer;

/**
 * @Author Jusven
 * @Date 2021/3/3 19:35
 */

/*
* 使用动态规划
F（i）：以array[i]为末尾元素的子数组的和的最大值，子数组的元素的相对位置不变
F（i）=max（F（i-1）+array[i] ， array[i]）
res：所有子数组的和的最大值
res=max（res，F（i））
如数组[6, -3, -2, 7, -15, 1, 2, 2]
初始状态：
    F（0）=6
    res=6
i=1：
    F（1）=max（F（0）-3，-3）=max（6-3，3）=3
    res=max（F（1），res）=max（3，6）=6
i=2：
    F（2）=max（F（1）-2，-2）=max（3-2，-2）=1
    res=max（F（2），res）=max（1，6）=6
i=3：
    F（3）=max（F（2）+7，7）=max（1+7，7）=8
    res=max（F（2），res）=max（8，6）=8
i=4：
    F（4）=max（F（3）-15，-15）=max（8-15，-15）=-7
    res=max（F（4），res）=max（-7，8）=8
以此类推
最终res的值为8
* */
public class FindGreatestSumOfSubArray {

    public static void main(String[] args) {
        int[] a = {1,-2,3,10,-4,7,2,-5};
        System.out.println(FindGreatestSumOfSubArray_Solution(a));
    }

    public static int FindGreatestSumOfSubArray_Solution(int[] a){
        //当前子数组最大和
        int sum = 0;
        int maxResult = a[0];   //动态规划：最优解可以从上个步骤得出
        for(int i=1;i<a.length;i++){
            maxResult = Math.max(maxResult+a[i],a[i]);
            sum = Math.max(sum,maxResult);
        }
        return sum;
    }
}
