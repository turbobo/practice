package com.demo.interview.JD;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/9/11 18:41
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        sc.nextLine();
        String[][] arr = new String[n][m];

        HashMap<String, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str_temp = sc.nextLine();
            String[] arr_temp = str_temp.split("");
            arr[i] = arr_temp;
            for (int j = 0; j < m; j++) {
                int[] ints = {i, j};
                map.put(arr_temp[j], ints);
            }
        }

        //换行又换列才算转向
        String str = sc.nextLine();
        String[] arr_str = str.split("");

        int[] start = {0, 0};
        int res = 0;

        for (String s : arr_str) {
            int[] current = map.get(s);
            res += timeCount(start, current, x, y, z);
            start = current;
        }

//        Set<Map.Entry<String, int[]>> entries = map.entrySet();
//        for (Map.Entry<String, int[]> me : map.entrySet()) {
//            int[] current = me.getValue();
//
//        }
        System.out.println(res);

    }

    public static int timeCount(int[] start, int[] current, int x, int y, int z) {
        if (start[0] == current[0] && start[1] == current[1]) {
            return z;
        } else if (start[0] == current[0] || start[1] == current[1]) {
            int row = Math.abs(start[0] - current[0]);
            int col = Math.abs(start[1] - current[1]);
            return row + col + z;
        } else {
            int row = Math.abs(start[0] - current[0]);
            int col = Math.abs(start[1] - current[1]);
            return (row + col) * x + y + z;
        }
    }
}
