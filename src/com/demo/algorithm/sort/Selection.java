package com.demo.algorithm.sort;

/**
 * @Author Jusven
 * @Date 2021/2/19 16:01
 * ѡ������API
 */
public class Selection {
    //������Ԫ������
    public static void sort(Comparable[] a){
        //�ȶ�����С����λ��
        int minIndex;
        for(int i=0;i<a.length-1;i++){   //ʣ�����һ�������ñȽ�
            minIndex = i; //��ǰĬ����СԪ��λ�� i���� minIndex
            for(int j=i+1;j<a.length;j++){  //ÿ������һֱ�Ƚϵ����һ��Ԫ��
                if(greater(a[minIndex],a[j])){  //��ǰλ��j��Ԫ�ر���С������Ԫ��ֵС���򽻻�����λ��
                    minIndex = j;
                }
            }

            //����СԪ��minIndex�ŵ���ǰ��һ��λ��i
            swap(a,i,minIndex);
        }
    }

    //�Ƚϴ�С
    private static boolean greater(Comparable c1, Comparable c2){
        return c1.compareTo(c2)>0;   //ֱ�ӷ��رȽϽ��
    }

    //����Ԫ��i ��j ����
    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
