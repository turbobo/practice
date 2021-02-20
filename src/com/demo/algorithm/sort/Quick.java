package com.demo.algorithm.sort;

/**
 * @Author Jusven
 * @Date 2021/2/20 17:22
 * ��������
 */
public class Quick {
    //���߸�С
    private static boolean less(Comparable c1, Comparable c2){
        return c1.compareTo(c2)<0;   //ֱ�ӷ��رȽϽ��
    }
    //����Ԫ��i ��j ����
    private static void swap(Comparable[] a, int i, int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //������a��������
    public static void sort(Comparable[] a) {
        //�����������Сλ��low ���λ��high
        int low = 0;
        int high = a.length-1;
        //���÷�����a�����low��highԪ������
        sort(a,low,high);
    }

    //������a�д�low��high֮���������
    private static void sort(Comparable[] a, int low, int high) {
        //��ȫ���
        if(low>=high){
            return ;
        }
        //��÷ֽ������
        int pivot = partition(a, low, high);

        //����������
        sort(a,low,pivot-1);
        //����������
        sort(a,pivot+1,high);

    }


    private static int partition(Comparable[] a, int low, int high) {
       return 1;
    }

}
