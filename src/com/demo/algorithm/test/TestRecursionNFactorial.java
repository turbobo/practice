package com.demo.algorithm.test;

/**
 * �ݹ����n�Ľ׳�
 * @author ConstXiong
 */
public class TestRecursionNFactorial {
    
    public static void main(String[] args) {
        System.out.println(recursionN(3));
    }
    
    /**
     * �ݹ����n�Ľ׳�
     * @param n
     * @return
     */
    private static int recursionN(int n) {
        if (n <1) {
            throw new IllegalArgumentException("�����������0");
        } else if (n == 1) {
            return 1;
        } else {
            return n * recursionN(n - 1);
        }
    }


}