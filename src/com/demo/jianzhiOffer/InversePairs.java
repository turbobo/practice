package com.demo.jianzhiOffer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Author Jusven
 * @Date 2021/6/21 19:00
 * �������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�����һ������,�����������е�����Ե�����P������P��1000000007ȡģ�Ľ������� �����P%1000000007
 *
 * ����50\%50%������,size\leq 10^4size��10
 * 4
 *
 * ����100\%100%������,size\leq 10^5size��10
 * 5
 *
 *
 * ����������
 * ��Ŀ��֤�����������û�е���ͬ������
 * ʾ��1
 * ���룺
 * [1,2,3,4,5,6,7,0]
 * ����ֵ��7
 */
public class InversePairs {
    private static int[] assist;
    private static long l = 0;
    public static void main(String[] args) {
//        int[] a = {392,49,3924958,4,48};
//        int[] a = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        int[] a = {7,21,33,5,6,44};
        //        Arrays.sort(a,0,2);
//        System.out.println("Arrays.toString(a) = " + Arrays.toString(a));
//        System.out.println("solution(a) = " + solution(a));
        sort(a);
        System.out.println("(int) (l%1000000007) = " + (int) (l%1000000007));

    }

    public static void sort(int[] arr){
        assist = new int[arr.length];
        sort(arr,0,arr.length-1);
    }

    public static void sort(int[] arr, int low, int high){
        //��ЧУ��
        if(low>=high){
            return;
        }
        int mid = (low + high)/2;
        sort(arr,low,mid);
        sort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }

    /**
     * �鲢����(21,7) (18,9)�����������е�����Ϊ2������������������ʱ��������2
     * �鲢��ʱ���ж������д��������еĸ�������
     */
    public static void merge(int[] arr, int low,  int mid, int high){
        //�ȶ���������������
        int index=low;    //��������ָ��
        int p1=low;   //������ָ��
        int p2=mid+1;   //������ָ��
        //����������бȽϣ�С�ķŵ���������
        while(p1<=mid && p2<=high){   //��������   ֻҪһ�����������ͽ���
            if(arr[p1] < arr[p2]){
                assist[index++] = arr[p1++];
            }else{
                assist[index++] = arr[p2++];
            }
        }

        //���������û�б����꣬��˳�����������(�Ѿ�����)��Ԫ��ֱ�ӷ��븨������
        while(p1<=mid){
            assist[index++] = arr[p1++];
        }
        //���������û�б����꣬��˳�����������(�Ѿ�����)��Ԫ��ֱ�ӷ��븨������
        while(p2<=high){
            assist[index++] = arr[p2++];
        }

        //�����������鵽ԭ�����Ӧλ��   �����Ǵ�low��highλ�õ�Ԫ��
        for(int i=low;index<=high;index++){
            arr[i] = assist[i];
        }

        //�´���ʼ����
        int start = mid + 1;
        //�����������Ѿ�ȷ��С���������еĸ���
        int count = 0;
        //��ʱmid���������вŷֱ�����
        for (int i = low; i <= mid; i++) {
            int j = start;
//            for (int j = start; j <= high; j++) {
//                if(arr[i] > arr[j]){
//                    l++;
//                }
                while(j<=high && arr[i] > arr[j]){
                    j++;
                }
                if(j<=high){
                    l = l+j-start+count;
                    count = j-start;
                    start = j;
                }
//                break;
//            }
            l = l % 1000000007;
        }

    }


    public static int solution(int[] array){
        long l = 0;
        for (int i = 1; i < array.length; i++) {
            //ͳ��ÿ����������
            for (int j = 0; j < i; j++) {
                if(array[i] < array[j]){
                    l++;
                }
                if(j+1 < i && array[i] >= array[j+1]){
                    break;
                }
            }
            //������֮ǰ����������
            Arrays.sort(array,0,i+1);
        }
        return (int) (l%1000000007);
    }

//    public long findIndex(int[] array,int k, int kIndex){
//        long left = 0;
//        long right = kIndex;
//        long mid = 0;
//        while(){
//
//        }
//    }
}
