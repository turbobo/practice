package com.demo.algorithm.test;

import com.demo.algorithm.sort.Shell;

import java.util.Arrays;

/**
 * @Author Jusven
 * @Date 2021/2/19 18:25
 */
public class ShellTest {
    public static void main(String[] args) {
        Integer[] arr = {4,73,32,6,3,34};
        Shell.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
