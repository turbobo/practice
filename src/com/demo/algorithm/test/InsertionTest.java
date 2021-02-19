package com.demo.algorithm.test;

import com.demo.algorithm.sort.Insertion;

import java.util.Arrays;

/**
 * @Author Jusven
 * @Date 2021/2/19 17:24
 */
public class InsertionTest {
    public static void main(String[] args) {
        Integer[] arr = {4,73,32,6,3,34};
        Insertion.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
