package com.demo.algorithm.test;

import com.demo.algorithm.sort.Selection;

import java.util.Arrays;

/**
 * @Author Jusven
 * @Date 2021/2/19 16:17
 */
public class SelectionTest {
    public static void main(String[] args) {
        Integer[] arr = {4,73,32,6,3,34};
        Selection.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
