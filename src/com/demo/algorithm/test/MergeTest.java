package com.demo.algorithm.test;

import com.demo.algorithm.sort.Merge;
import java.util.Arrays;

/**
 * @Author Jusven
 * @Date 2021/2/20 16:22
 */
public class MergeTest {
    public static void main(String[] args) {
        Integer[] arr = {4,73,32,6,3,34};
        Merge.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
