package com.demo.interview.huawei20230523;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2023/5/23 20:50
 */
public class test1 {
    //desk数组  0 空位  1占位
    // 隔一个座位才可以坐人
    public static void main(String[] args) {
/*        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        String s = in.nextLine();
//        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            int a = in.nextInt();
//            String c = in.next();
//            list.add(a);
//        }
        String[] split = s.split(",");
        int[] arr = new int[split.length];
        for (int i=0;i<arr.length;i++) {
            arr[i] = Integer.valueOf(split[i]);
        }
        System.out.println(getSeat(arr));*/

        int[] seats = {1, 0, 0, 1};
        System.out.println(getSeat2(seats));


//        int[] seats = {1, 0, 0, 0, 1, 0, 1};
//        int[] seats = {1, 0, 0, 1};
//        System.out.println(getMaxOccupancy(seats));
    }

    public static int getSeat(int[] arr) {

        // 双指针
        int res = 0;
        int left = 0;
        int right = left;
        while (left <arr.length) {
            if (left == 0) {
                // 初始位置只判断后面
                if (arr[left] ==0 ){
                    if (arr[left+1] == 0) {
                        res++;
                        arr[left] = 1;
                        left++;
                    } else {
                        left++;
                    }
                } else {
                    left++;
                }
            } else if (left == arr.length-1) {
                // 只需要判断前面
                if (arr[left] == 0) {
                    if (arr[left-1] == 0) {
                        res++;
                        left++;
                    } else {
                        left++;
                    }
                } else {
                    left++;
                }
            } else {
                //处于中间的元素
                if (arr[left] == 0) {
                    // 判断前后
                    if (arr[left-1] == 0 && arr[left+1] == 0) {
                        res++;
                        arr[left] = 1;
                        left++;
                    } else {
                        left++;
                    }

                } else {
                    // 继续找
                    left++;
                }
            }
        }
        return res;


//        while (left < arr.length) {
//            right = left+1;
//            while (right < arr.length) {
//                // 找到第一个0的位置
//                if (arr[right] == 0)
//
//            }
//            // 判断完之后，立即赋值
//            if (arr[left] == 0) {
//                // 判断后面
//                if (left < arr.length-1) {
//                    if (arr[left+1] == 0) {
//                        res++;
//                        arr[left] = 1;
//                    }
//                }
//            } else {
//                left++;
//            }
//        }
    }

    // gpt
    private static int getMaxOccupancy(int[] seats) {
        int maxOccupancy = 0;
        int count = 0;
        int n = seats.length;

        for (int i = 0; i < n; i++) {
            if (seats[i] == 0) {
                count++;
            } else {
                count = 0;
            }

            if (count == 2) {
                maxOccupancy++;
                count = 0;
            }
        }

        return maxOccupancy;
    }

    public static int getSeat2(int[] arr) {
        int res = 0;  // 可坐下的人数
        int prevSeat = -1;  // 前一个座位的状态，初始值设为-1表示前一个座位为空座

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 && prevSeat == 0 && (i == arr.length - 1 || arr[i + 1] == 0)) {
                res++;
                prevSeat = 1;  // 将当前座位设为已占座
            } else {
                prevSeat = arr[i];  // 更新前一个座位的状态
            }
        }

        return res;
    }
}
