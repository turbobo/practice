package com.demo.algorithm.sort;

/**
 * @Author Jusven
 * @Date 2021/2/19 17:19
 * ��������---������ץ�˿���
 */
public class Insertion {
    //������Ԫ������
    public static void sort(Comparable[] a){
        for(int i=1;i<a.length;i++){  //Ĭ���������о��ǵ�һ��Ԫ��  �������о��ǵڶ���Ԫ�ص�ĩβ
            //�����һ�������������е�������Ƚ�
            for(int j=i;j>0;j--){    //�������е�һ��Ԫ�غ������������һ��Ԫ�ضԱȣ�����С�ͽ�����һֱ��ǰ�Ƚ�; j����Խ��
                if(greater(a[j-1],a[j])){
                    swap(a,j-1,j);
                }
            }
        }
    }

    //�Ƚ�c1,c2Ԫ�ش�С
    private static boolean greater(Comparable c1, Comparable c2){
        return c1.compareTo(c2)>0;   //ֱ�ӷ��رȽϽ��
    }

    //����Ԫ��i ��j ����
    private static void swap(Comparable[] a, int i, int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
