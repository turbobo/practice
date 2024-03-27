package com.demo.leetcode.hot100.doublePointer;

import java.util.*;

/**
 * @Author Jusven
 * @Date 2024/3/15 10:26
 */
public class threeSum {

    public static void main(String[] args) {
        int[] arr = new int[] {-1,0,1,2,-1,-4};
        threeSum2(arr);

    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        // 是否存在k + (i + j) = 0
        // 用map存放所有值
        Map<Integer, Integer> map = new HashMap();
        Set<String> strSet = new HashSet();
        for (int i = 0;i<nums.length;i++) {
            // 存储最大位置
            map.put(nums[i], i);
        }
        for (int i = 0;i<nums.length;i++) {
            for (int j = i+1;j<nums.length;j++) {
                // k的位置必须大于j
                int temp = 0 - (nums[i] + nums[j]);
                if (map.containsKey(temp) && map.get(temp) > j) {
                    int[] arr = new int[3];
                    arr[0] = nums[i];
                    arr[1] = nums[j];
                    arr[2] = temp;
                    Arrays.sort(arr);
                    // 比较数组是否完全相同
                    // 排序后转为字符串
                    StringBuilder sb = new StringBuilder(3);
                    sb.append(arr[0]).append(arr[1]).append(arr[2]);
                    String str = sb.toString();
                    strSet.add(str);
                }
            }
        }
        if (strSet.size() > 0) {
            for (String s : strSet) {
                List<Integer> tempList = new ArrayList(3);
                char[] charArray = s.toCharArray();
                tempList.add(charArray[0] - '0');
                tempList.add(charArray[1] - '0');
                tempList.add(charArray[2] - '0');
                res.add(tempList);
            }
        }
        return res;

    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        // 要求不重复，数组可以排序后再遍历！！！！
        Arrays.sort(nums);
        int i=0;
        int left = i+1;
        int right = nums.length - 1;

        while (i < nums.length) {
            // 对第一个位置去重
            if (i>0 && nums[i] == nums[i-1]) {
                i++;
                continue;
            }
            // 首先判断两个指针
            while (left < right) {
                // 计算当前总和
                int sum = nums[i] + nums[left] + nums[right];
                if (sum ==0) {
                    List<Integer> tempList = new ArrayList(3);
                    tempList.add(nums[i]);
                    tempList.add(nums[left]);
                    tempList.add(nums[right]);
                    res.add(tempList);
                    // 双指针都移动，都找到下一个不相同的位置
                    while (left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                }else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return res;

    }
}
