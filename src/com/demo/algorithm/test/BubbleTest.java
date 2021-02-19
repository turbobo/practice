package com.demo.algorithm.test;

import com.demo.algorithm.sort.Bubble;

import java.util.Arrays;

/**
 * @Author Jusven
 * @Date 2021/2/19 15:01
 */
public class BubbleTest {
    public static void main(String[] args) {
        Integer[] arr = {4,73,32,6,3,34};
        Bubble.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
