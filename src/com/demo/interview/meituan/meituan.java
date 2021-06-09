package com.demo.interview.meituan;

import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/4/4 10:04
 */
public class meituan {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();

        while(sc.hasNextLine()){
            String s = sc.nextLine();
            if(" ".equals(s))
                break;
            sb.append(s);
        }
        //牛客上这句代码能执行，但是在本地上这句执行不了
        System.out.println(sb);

       /* Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if("".equals(str)){
            System.out.println(0);
        }
        int sum = 0;
        for(int i=0;i<str.length();i++){
            sum += sumSubStr(str.charAt(i),str.substring(i+1,str.length()));
        }
        System.out.println(sum+1);*/

//        Scanner sc = new Scanner(System.in);
      /*  int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[n][n];
        //使用List存最近的数字
        List<int[]> list = new ArrayList<int[]>();
        int index = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == index){
                    list.add(index, new int[]{i + 1, j + 1});
                    index++;
                }
            }
            sc.hasNextLine();
        }
        if(index==k+1){//有路径
            int[] a = list.get(1);
            int[] b = list.get(index);
            int res = Math.abs(b[0]-a[0]) + Math.abs(b[1]-a[1]);
            System.out.println(res);
        }else{
            System.out.println(-1);
        }*/

    }

    public static int sumSubStr(char c,String subStr){
        if("".equals(subStr))
            return 1;
        int count = 0;
        for(int i=0;i<subStr.length();i++){
            if(c!=subStr.charAt(i))
                count++;
        }
        if(count==1){
            return 2;
        }
        return (int) Math.pow(count,2);
    }
}
