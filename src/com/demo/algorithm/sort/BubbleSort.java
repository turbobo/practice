package com.demo.algorithm.sort;

import java.util.Arrays;

/**
 * @Author Jusven
 * @Date 2021/2/19 10:34
 * ð������
 * ÿ��ð�ݹ��̶��Ǵ����еĵ�һ��Ԫ�ؿ�ʼ��Ȼ�����κ�ʣ���Ԫ�ؽ��бȽ�, ���ж�һ��,
 * �������������ڵ�Ԫ�رȴ�С, �ߵľͺ͵͵Ļ�һ��λ��. ������(ֵ���)�Ŀ϶����ŵ�������
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4,73,32,6,3,34};
//        bubbleSort1(arr);
        bubbleSort2(arr);
        System.out.println(Arrays.toString(arr));
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    private static void bubbleSort1(int[] a){
        int temp;
        for(int i=0;i<a.length;i++){       //�ȽϵĻغ���
            for(int j=0;j<a.length-i-1;j++){   //ÿ�غ�ѡ�����ֵ���ڵ�ǰ����λ��
                if(a[j]>a[j+1]){   //ǰ����ں���  ����
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    private static void bubbleSort2(int[] a){
        int temp;
        for(int i=a.length-1;i>0;i--){       //�ȽϵĻغ���
            for(int j=0;j<i;j++){   //ÿ�غ�ѡ�����ֵ���ڵ�ǰ����λ��
                if(a[j]>a[j+1]){   //ǰ����ں���  ����
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
}
