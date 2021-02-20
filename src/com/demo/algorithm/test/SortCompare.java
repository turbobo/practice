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
 * ϣ������Ͳ����������ܱȽ�
 */
public class SortCompare {
    public static void main(String[] args) throws IOException {
        //1.�������ϱ����ȡ��������
        ArrayList<Integer> arrayList = new ArrayList<>();
        //2.���������ȡ����ȡ����
//        BufferedReader reader = new BufferedReader(new InputStreamReader(SortCompare.class.getClassLoader().getResourceAsStream("newFile.txt")));
        BufferedReader reader = new BufferedReader(new FileReader("E:\\IdeaSpace\\TEST\\newFile.txt"));
        String line = null;
        while((line=reader.readLine())!=null){
            //line���ַ���
            int i = Integer.parseInt(line);
            arrayList.add(i);
        }
        reader.close();  //�ر���
        //3.�Ѽ���תΪ����
        Integer[] arr = new Integer[arrayList.size()];
        arrayList.toArray(arr);

        //4.���ò��Դ���
        testShell(arr);  //151����
//        testInsertion(arr);


       /* ArrayList<Integer> list = new ArrayList<Integer> ();
        long start = System.currentTimeMillis();
        for(int i=100000;i>=1;i--){
            list.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("����10�������ݣ�"+(end-start)+"����");
        Integer[] a = new Integer[list.size()];
        //����ת����
        list.toArray(a);
        //        System.out.println(list);

//        testInsertion(a);    //25968����
//        testShell(a);    //33����
*/
    }

    private static void testInsertion(Integer[] a){
        long start = System.currentTimeMillis();
        Insertion.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("��������10��������������ʱ��"+(end-start)+"����");
    }

    private static void testShell(Integer[] a){
        long start = System.currentTimeMillis();
        Shell.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("ϣ������10��������������ʱ��"+(end-start)+"����");
    }
}
