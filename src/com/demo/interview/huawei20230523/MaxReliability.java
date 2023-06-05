package com.demo.interview.huawei20230523;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxReliability {
    public static int maxReliability(int S, int T, List<List<Integer>> components) {
        // 创建一个二维数组来存储中间结果
        int[][] dp = new int[T][S + 1];

        // 初始化第一种类型的元器件
        for (int budget = components.get(0).get(2); budget <= S; budget++) {
            dp[0][budget] = components.get(0).get(1);
        }

        // 填充其他类型的元器件
        for (int i = 1; i < T; i++) {
            for (int budget = 1; budget <= S; budget++) {
                int minReliability = Integer.MAX_VALUE;
                List<Integer> component = components.get(i);
                if (component.get(2) <= budget) {
                    minReliability = Math.min(minReliability, component.get(1));
                }
                dp[i][budget] = minReliability;
            }
        }

        return dp[T - 1][S];
    }

    public static void main(String[] args) {
        int S = 500;
        int T = 3;
        List<List<Integer>> components = new ArrayList<>();
        components.add(Arrays.asList(0, 80, 100));
        components.add(Arrays.asList(0, 90, 200));
        components.add(Arrays.asList(1, 50, 50));
        components.add(Arrays.asList(1, 70, 210));
        components.add(Arrays.asList(2, 50, 100));
        components.add(Arrays.asList(2, 60, 150));
        components.add(Arrays.asList(2, 70, 550));

        int maxReliability = maxReliability(S, T, components);
        System.out.println("Maximum reliability: " + maxReliability);
    }
}
