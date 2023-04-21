package com.demo.leetcode.hashset;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Jusven
 * @Date 2023/1/18 11:37
 */
public class subarraySum {
    public static void main(String[] args) {
//        int[] nums = {-1, -1, 1};
        int[] nums = {0,0};
        System.out.println(subarraySum(nums, 0));
    }

    //错误！！！！
    public static int subarraySum(int[] nums, int k) {
        // 数组位置不可变，不能排序
        // 只需要记录数组个数，不用统计每个下标
        int left = 0;
        int right = 0;
        int count = 0;

        while (left < nums.length -1) {

            int sum = nums[left];
            // 每次要判断当前是否刚好等于k
            if (sum == k) {
                // 等于后,需要继续找,后面可能有负数,0 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                count++;
            } else {
                // 判断后面的元素
                right = left + 1;
                while (right < nums.length) {
//                    right = left + 1;
                    sum += nums[right];
                    if (sum == k) {
                        // 找到后也需要继续找,可能有负数
                        count++;
//                        break;
                    } else if (sum > k) {
                        // 大于后也需要继续找,可能有负数
//                        break;
                    }
                    right++;
                }
            }
            left++;
        }
        // 最后一个元素
        if (nums[nums.length-1] == k) {
            count++;
        }
        return count;
    }

    /**
     * 双指针---成功！！！
     * 时间复杂度：O(n^2)O(n
     2
     *  )，其中 nn 为数组的长度。枚举子数组开头和结尾需要 O(n^2)O(n
     * 2
     *  ) 的时间，其中求和需要 O(1)O(1) 的时间复杂度，因此总时间复杂度为 O(n^2)O(n
     * 2
     *  )。
     *
     * 空间复杂度：O(1)O(1)。只需要常数空间存放若干变量。
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum2(int[] nums, int k) {
        // 数组位置不可变，不能排序
        // 只需要记录数组个数，不用统计每个下标
        int left = 0;
        int right = 0;
        int count = 0;

        while (left < nums.length) {
            int sum = nums[left];
            // 首先判断当前元素
            if (sum == k) {
                count++;
            }
            right = left + 1;
            while (right < nums.length) {
                sum += nums[right];
                if (sum == k) {  //后面的元素可能为负数，找到一个目标值后，需要继续遍历
                    count++;
                }
                right++;
            }
            left++;
        }
        return count;
    }

    /**
     * 哈希表  成功！！！
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum3(int[] nums, int k) {
        // 数组位置不可变，不能排序
        // 只需要记录数组个数，不用统计每个下标
        int left = 0;
        int right = 0;
        int count = 0;

        while (left < nums.length) {
            int sum = nums[left];
            // 首先判断当前元素
            if (sum == k) {
                count++;
            }
            right = left + 1;
            while (right < nums.length) {
                sum += nums[right];
                if (sum == k) {
                    count++;
                }
                right++;
            }
            left++;
        }
        return count;
    }


    // 成功！！！
    // 子数组和  问题转为  前缀和，简单化，只考虑前缀和的情况即可
    // 如果子数组和为k， 那么pre[j−1]==pre[i]−k，
    // 考虑以 ii 结尾的和为 kk 的连续子数组个数时只要统计有多少个前缀和为pre[i] - k的pre[j] 即可。
    /*
    * 时间复杂度：O(n)O(n)，其中 nn 为数组的长度。我们遍历数组的时间复杂度为 O(n)O(n)，中间利用哈希表查询删除的复杂度均为 O(1)O(1)，因此总时间复杂度为 O(n)O(n)。

空间复杂度：O(n)O(n)，其中 nn 为数组的长度。哈希表在最坏情况下可能有 nn 个不同的键值，因此需要 O(n)O(n) 的空间复杂度。
*/
    public static int subarraySum55(int[] nums, int k) {
        //使用哈希表保存前缀和出现的次数
        Map<Integer, Integer> map = new HashMap();
        //默认值(防止pre-k == 0  这个值不需要通过遍历添加，表示和为0的连续子数组出现1次)
        map.put(0, 1);
        //使用变量保存当前前缀和
        int pre = 0;
        int count = 0;
        //遍历
        for (int n: nums) {
            pre += n;
            // 判断pre-k是否存在
            if (map.containsKey(pre-k)) {
                count += map.get(pre-k);
            }
            // map.put(pre-k, map.getOrDefault(pre-k, 0) + 1);
            // 记录的是pre  不是pre-k
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }

        return count;
    }

}
