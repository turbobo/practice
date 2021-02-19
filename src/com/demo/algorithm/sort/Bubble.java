package com.demo.algorithm.sort;

/**
 * @Author Jusven
 * @Date 2021/2/19 13:43
 */
public class Bubble {

    //������Ԫ������
    public static void sort(Comparable[] a){
        for(int i=a.length-1;i>0;i--){  //�ȽϵĻغ���  ʣ�����һ�����Զ��ŵ���λ������Ҫ�Ƚ�
            for(int j=0;j<i;j++){   //ÿ�غϴӵ�һ������ʼ����Ƚ�
                if(compareMax(a[j],a[j+1])){  //ǰ�ߴ��ں���
                    swap(a,j,j+1);
                }
            }
        }
    }

    //�Ƚϴ�С
    private static boolean compareMax(Comparable c1, Comparable c2){
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
