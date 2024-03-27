package com.demo.leetcode;

/**
 * @Author Jusven
 * @Date 2024/3/13 16:43
 */
public class SwapTest {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2};
        for(int i :  arr) {
            System.out.println(i);

        }
        swap2(arr, 0, 1);
        System.out.println("*******************");
        for(int i :  arr) {
            System.out.println(i);

        }
    }
    // 交换位置，加法
    public static void swap1(int[] nums, int a, int b) {

        nums[a] = nums[a] + nums[b];
        nums[b] = nums[a] - nums[b];
        nums[a] = nums[a] - nums[b];
    }

    // 异或
    public static void swap2(int[] nums, int x, int y) {
        nums[x] = nums[x] ^ nums[y];
        nums[y] = nums[x] ^ nums[y];
        nums[x] = nums[x] ^ nums[y];
    }
}
