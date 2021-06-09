package com.demo.jianzhiOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Jusven
 * @Date 2021/4/25 15:41
 *
 * 统计一个数字在升序数组中出现的次数。
 */
public class GetNumberOfK {
    public static void main(String[] args) {
        Map map = new HashMap<>();
        int fd = (int) map.getOrDefault(1,0);
        int[] a = {3,3,3,3};

        System.out.println(GetNumberOfK_Solution(a,3));
    }

    public static int GetNumberOfK_Solution(int [] array , int k) {
        //二分
        int low = 0;
        int high = array.length-1;
//         int count = 0;
//         int left = -1;
//         int right = -1;
        int index = -1;
        //先找目标值位置
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
        //目标值存在
        if(index!=-1){
//            //左右指针
//             int left = index-1;
//             int right = index+1;
            int count = 1;  //已经查到一个
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
