package com.demo.leetcode.hashset;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author:
 * @Date: 2022年12月17日 14:46
 */
public class longestConsecutive {

    public static void main(String[] args) {
        int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
//        int[] nums = new int[]{1,0,1,2};
        System.out.println("longestConsecutiveMine(nums) = " + longestConsecutiveMine(nums));
        System.out.println("longestConsecutive(nums) = " + longestConsecutive(nums));
    }

    public static int longestConsecutiveMine(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int res = 1;
        if (nums.length == 1) {
            return res;
        }
        //滑动窗口？
        //先将数组排序
        Arrays.sort(nums);
        int temp = 1;


        //遍历数组 判断每个位置是否比前一个位置大1, 不是则移动，同时记录当前最大连续长度
        for (int i = 1; i < nums.length; i++) {
            //重复值在连续子串中间可以计算，在开始或者结束处不计入？
            if (nums[i] - nums[i - 1] == 1) {
                // set.add(nums[i-1]);
                // set.add(nums[i]);

                temp++;
            } else if (nums[i] == nums[i - 1]) {
                //什么都不执行

                // if (temp == 1) {
                //     continue;
                // } else {
                //     temp++;
                // }

            } else {
                //可能当前值 存在于 当前连续的子串中
                // if (!set.contains(nums[i]))
                // if (i<nums.length -1 &&  nums[i] == nums[i+1]) {
                //     i++;
                // }
                //重置
                temp = 1;
            }

            if (temp > res) {
                //记录最大
                res = temp;
            }
        }


        //当前元素前一个数值不存在时，作为起点，重置临时长度
        //当前元素后面的元素存在时，临时长度加1，继续遍历
        //使用哈希表保存


        return res;
    }

    public static int longestConsecutive(int[] nums) {
        // 建立一个存储所有数的哈希表，同时起到去重功能
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int ans = 0;
        // 遍历去重后的所有数字
        for (int num : set) {
            int cur = num;
            // 只有当num-1不存在时，才开始向后遍历num+1，num+2，num+3......
            if (!set.contains(cur - 1)) {
                while (set.contains(cur + 1)) {
                    cur++;
                }
            }
            // [num, cur]之间是连续的，数字有cur - num + 1个
            ans = Math.max(ans, cur - num + 1);
        }
        return ans;
    }
}


