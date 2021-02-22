package com.demo.algorithm.test;

import com.demo.algorithm.sort.Quick;

import java.util.Arrays;

/**
 * @Author Jusven
 * @Date 2021/2/22 19:48
 */
public class QuickTest {
    public static void main(String[] args) {
        Integer[] arr = {4,73,32,6,3,34};
        Quick.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
