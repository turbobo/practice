package com.demo.algorithm.sort;

/**
 * @Author Jusven
 * @Date 2021/2/19 13:43
 * ð������API
 *
 * Comparable�˽ӿ�ǿ�ж�ʵ������ÿ����Ķ���������������������򱻳�Ϊ�����Ȼ������� compareTo ��������Ϊ������Ȼ�ȽϷ�����
 */
public class Bubble {

    //������Ԫ������
    public static void sort(Comparable[] a){
        for(int i=a.length-1;i>0;i--){  //�ȽϵĻغ���  ʣ�����һ�����Զ��ŵ���λ������Ҫ�Ƚ�
            for(int j=0;j<i;j++){      //ÿ�غϴӵ�һ������ʼ����Ƚ�,ÿ��ѡ�����ֵ�ŵ���ǰ����λ��
                if(greater(a[j],a[j+1])){  //ǰ�ߴ��ں���    *****�ȶ�������ʱ���ύ��˳��
                    swap(a,j,j+1);
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
