package com.demo.leetcode.greedy;

import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * @Author Jusven
 * @Date 2023/6/24 21:57
 */
public class largestSumAfterKNegations {
    public static void main(String[] args) {
        System.out.println();
        for (int i = 0; i <5 ; i++) {
            System.out.println("before");
            if (i==1) {
                continue;
            }
            System.out.println(i);
        }
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        // 根据绝对值排序
//        nums = IntStream.of(nums).boxed().sorted(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return Math.abs(o2) - Math.abs(o1);
//            }
//        }).mapToInt(Integer::intValue).toArray();

        //
//        nums = IntStream.of(nums)
//                .boxed()
//                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
//                .mapToInt(Integer::intValue).toArray();


        for (int i = 0; i <5 ; i++) {
            System.out.println();
        }

        return 0;
    }
}

