package com.demo.algorithm.sort;

/**
 * @Author Jusven
 * @Date 2021/2/20 17:22
 * ��������
 */
public class Quick {
    public static void main(String[] args) {

    }

    //���߸�С
    private static boolean less(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) < 0;   //ֱ�ӷ��رȽϽ��
    }

    //����Ԫ��i ��j ����
    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //������a��������
    public static void sort(Comparable[] a) {
        //�����������Сλ��low ���λ��high
        int low = 0;
        int high = a.length - 1;
        //���÷�����a�����low��highԪ������
        sort(a, low, high);
    }

    //������a�д�low��high֮���������
    private static void sort(Comparable[] a, int low, int high) {  //ʵ�����������partition������
        //��ȫ���
        if (low >= high) {
            return;
        }
        //��÷ֽ������
        int pivot = partition(a, low, high);

        //����������  ����partition
        sort(a, low, pivot - 1);
        //����������
        sort(a, pivot + 1, high);

    }

    //����������з�
    private static int partition(Comparable[] a, int low, int high) {
        //ȷ���ֽ�ֵ----�����һ��Ԫ��
        Comparable key = a[low];

        //��������ָ�룬ָ����С  ���
        int left = low;
        int right = high + 1;

        while (true) {
            //right��������ɨ�裬�ҵ�һ���ȷֽ�ֵС��ֵ��ֹͣ
            while (less(key, a[--right])) {   //��rightλ�ñȷֽ�ֵpivotС��  �ŷֽ�ֵ���
                if (right == low) {  //ɨ�赽lowλ�� �˳�
                    break;
                }
            }
            //left�������ң��ҵ�һ���ȷֽ�ֵ���ֵ
            while (less(a[++left], key)) {   //��rightλ�ñȷֽ�ֵpivot���  �ŷֽ�ֵ�ұ�
                if (left == high) {  //ɨ�赽highλ�� �˳�
                    break;
                }
            }
            //left>=right ɨ��������˳�ѭ�������򽻻�λ��
            if (left >= right) {
                break;
            } else {
                swap(a, right, left);
            }
        }
        //����ָ���غ�ʱ��������һָ���pivotλ��
        swap(a, right, low);
        return right;
    }

}
