package com.demo.algorithm.sort;


import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author Jusven
 * @Date 2021/2/20 10:58
 * �鲢����
 */
public class Merge {
    private static Comparable[] assist;  //�鲢��������

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
        //��ʼ����������
        assist = new Comparable[a.length];
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

        //�����Ϊ������
        int mid = low+(high-low)/2;   // (low+high)/2
        //�ֱ��������������
        sort(a,low,mid);   //������
        sort(a,mid+1,high);   //������
        //��������ֱ�������ٽ��й鲢
        merge(a,low,mid,high);
    }

    //ÿ�ι鲢���������飺����������λ��ʼ��С�ķŵ��������飬�÷���ָ����ƣ�
    // ��һ�μ����ʹ�ķ�����бȽϣ���ķ���ָ�벻������������ָ����ƣ�
    private static void merge(Comparable[] a, int low, int mid, int high) {
        //����3��ָ��
        int i=low;    //��������ָ��
        int p1=low;   //������ָ��
        int p2=mid+1;   //������ָ��
        //����������бȽϣ�С�ķŵ���������
        while(p1<=mid && p2<=high){   //��������   ֻҪһ�����������ͽ���
            if(less(a[p1],a[p2])){
                assist[i++] = a[p1++];
            }else{
                assist[i++] = a[p2++];
            }
        }

        //���������û�б����꣬��˳�����������(�Ѿ�����)��Ԫ��ֱ�ӷ��븨������
        while(p1<=mid){
            assist[i++] = a[p1++];
        }
        //���������û�б����꣬��˳�����������(�Ѿ�����)��Ԫ��ֱ�ӷ��븨������
        while(p2<=high){
            assist[i++] = a[p2++];
        }
        //�����������鵽ԭ�����Ӧλ��   �����Ǵ�low��highλ�õ�Ԫ��
        for(int index=low;index<=high;index++){
            a[index] = assist[index];
        }
    }


}
