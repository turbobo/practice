package com.demo.algorithm.test;

import com.demo.algorithm.sort.Insertion;
import com.demo.algorithm.sort.Merge;
import com.demo.algorithm.sort.Quick;
import com.demo.algorithm.sort.Shell;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

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

        Integer[] array = new Integer[200000];
        Integer[] a =getRandomArr(array);  //�����
        testShell(a);
//        testQuick(a);
        //4.���ò��Դ���
//        testShell(arr);  //151����
//        testQuick(arr);   //174����
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

    /**
     * ��ȡһ�����ҵ�����
     * @param arr
     */
    private static Integer[] getRandomArr(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(arr.length);
        }
        return arr;
    }

    //���Բ�������
    private static void testInsertion(Integer[] a){
        long start = System.currentTimeMillis();
        Insertion.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("��������10��������������ʱ��"+(end-start)+"����");
    }

    //����ϣ������
    private static void testShell(Integer[] a){
        long start = System.currentTimeMillis();
        Shell.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("ϣ������10��������������ʱ��"+(end-start)+"����");
    }

    //���Թ鲢����
    private static void testMerge(Integer[] a){
        long start = System.currentTimeMillis();
        Merge.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("�鲢����10��������������ʱ��"+(end-start)+"����");
    }

    //���Կ�������
    private static void testQuick(Integer[] a){
        long start = System.currentTimeMillis();
        Quick.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("�鲢����10��������������ʱ��"+(end-start)+"����");
    }
}
