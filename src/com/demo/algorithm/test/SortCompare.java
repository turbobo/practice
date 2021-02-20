package com.demo.algorithm.test;

import com.demo.algorithm.sort.Insertion;
import com.demo.algorithm.sort.Shell;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author Jusven
 * @Date 2021/2/19 18:40
 * 希尔排序和插入排序性能比较
 */
public class SortCompare {
    public static void main(String[] args) throws IOException {
        //1.创建集合保存读取出的整数
        ArrayList<Integer> arrayList = new ArrayList<>();
        //2.创建缓存读取流读取数据
//        BufferedReader reader = new BufferedReader(new InputStreamReader(SortCompare.class.getClassLoader().getResourceAsStream("newFile.txt")));
        BufferedReader reader = new BufferedReader(new FileReader("E:\\IdeaSpace\\TEST\\newFile.txt"));
        String line = null;
        while((line=reader.readLine())!=null){
            //line是字符串
            int i = Integer.parseInt(line);
            arrayList.add(i);
        }
        reader.close();  //关闭流
        //3.把集合转为数组
        Integer[] arr = new Integer[arrayList.size()];
        arrayList.toArray(arr);

        //4.调用测试代码
        testShell(arr);  //151毫秒
//        testInsertion(arr);


       /* ArrayList<Integer> list = new ArrayList<Integer> ();
        long start = System.currentTimeMillis();
        for(int i=100000;i>=1;i--){
            list.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("生成10万条数据："+(end-start)+"毫秒");
        Integer[] a = new Integer[list.size()];
        //集合转数组
        list.toArray(a);
        //        System.out.println(list);

//        testInsertion(a);    //25968毫秒
//        testShell(a);    //33毫秒
*/
    }

    private static void testInsertion(Integer[] a){
        long start = System.currentTimeMillis();
        Insertion.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("插入排序10万条逆序数据用时："+(end-start)+"毫秒");
    }

    private static void testShell(Integer[] a){
        long start = System.currentTimeMillis();
        Shell.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("希尔排序10万条逆序数据用时："+(end-start)+"毫秒");
    }
}
