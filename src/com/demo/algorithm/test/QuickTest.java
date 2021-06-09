package com.demo.algorithm.test;

import com.demo.algorithm.sort.Quick;

import java.util.Arrays;

/**
 * @Author Jusven
 * @Date 2021/2/22 19:48
 */
public class QuickTest {
    public static void main(String[] args) {
        Integer[] arr ={32, 385, 23, 4, 6, 6, 50, 11, 33, 406};
        Quick.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
