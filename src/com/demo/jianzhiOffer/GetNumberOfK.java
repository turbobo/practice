package com.demo.jianzhiOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Jusven
 * @Date 2021/4/25 15:41
 *
 * ͳ��һ�����������������г��ֵĴ�����
 */
public class GetNumberOfK {
    public static void main(String[] args) {
        Map map = new HashMap<>();
        int fd = (int) map.getOrDefault(1,0);
        int[] a = {3,3,3,3};

        System.out.println(GetNumberOfK_Solution(a,3));
    }

    public static int GetNumberOfK_Solution(int [] array , int k) {
        //����
        int low = 0;
        int high = array.length-1;
//         int count = 0;
//         int left = -1;
//         int right = -1;
        int index = -1;
        //����Ŀ��ֵλ��
        while(low<=high){
            int mid = (low+high)/2;
            if(array[mid] == k){
                index = mid;
                break;
//                 count++;
//                 if(array[mid+1]>k)
//                     right = mid+1;
//                 if(array[mid-1]<k)
//                     left = mid-1;
//                 if(left!=-1 && right!=-1)
//                     break;
            }
            else if(array[mid] < k){
                low = mid + 1;
            }else if(array[mid] > k){
                high = mid -1;
            }
        }
        //Ŀ��ֵ����
        if(index!=-1){
//            //����ָ��
//             int left = index-1;
//             int right = index+1;
            int count = 1;  //�Ѿ��鵽һ��
            for(int i=index+1; i < array.length ;i++){
                if(array[i]!=k)
                    break;
                count++;
            }
            for(int i=index-1; i >=0 ;i--){
                if(array[i]!=k)
                    break;
                count++;
            }
            return count;
        }


        return 0;
    }
}
