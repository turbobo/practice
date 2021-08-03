package com.demo.jianzhiOffer;

public class InversePairs {

    //     private static long l = 0;
    private static int[] assist;

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,0};
        System.out.println("InversePairs(array) = " + InversePairs(array));
        System.out.println();
    }

    public static int InversePairs(int [] array) {
//         long l = 0;
//         for (int i = 1; i < array.length; i++) {
//             //统计每个数的逆序
//             for (int j = 0; j < i; j++) {
//                 if(array[i] < array[j]){
//                     l++;
//                 }
//                if(j+1 < i && array[i] >= array[j+1]){
//                     break;
//                 }
//             }
//             //该数及之前的数据排序
//             Arrays.sort(array,0,i+1);
//         }
//         return (int) (l%1000000007);
        if(array==null||array.length==0)
        {
            return 0;
        }
//       sort(array);
//       return (int) (l%1000000007);

        return sort(array);
    }

    public static int sort(int[] arr){
        assist = new int[arr.length];
        return sort(arr,0,arr.length-1);
    }

    public static int sort(int[] arr, int low, int high){
        //有效校验
        if(low>=high){
            return 0;
        }
        int res = 0;
        int mid = low + (high - low)/2;
        res += sort(arr,low,mid);
        res %= 1000000007;
        res += sort(arr,mid+1,high);
        res %= 1000000007;
        res += merge(arr,low,mid,high);
        res %= 1000000007;
        return res;
    }

    /**
     * 归并排序，(21,7) (18,9)，两个子序列的逆序为2，当两个子序列有序时，逆序还是2
     * 归并的时候，判断左序列大于右序列的个数即可
     */
    public static int merge(int[] arr, int low,  int mid, int high){
        int res = 0;
        //先对左右子序列排序
        int index=low;    //辅助数组指针
        int p1=low;   //左子组指针
        int p2=mid+1;   //右子组指针
        //两个子组进行比较，小的放到辅助数组
        while(p1<=mid && p2<=high){   //两个条件   只要一个子组遍历完就结束
            if(arr[p1] > arr[p2]){
                //核心---计算逆序数
                res = mid - p1 + 1;
                res = res % 1000000007;
                assist[index++] = arr[p2++];   //把小的数放到辅助数组中
            }else{
                assist[index++] = arr[p1++];
            }
        }

        //如果左子组没有遍历完，就顺序遍历左子组(已经有序)的元素直接放入辅助数组
        while(p1<=mid){
            assist[index++] = arr[p1++];
        }
        //如果右子组没有遍历完，就顺序遍历右子组(已经有序)的元素直接放入辅助数组
        while(p2<=high){
            assist[index++] = arr[p2++];
        }

        //拷贝辅助数组到原数组对应位置   本次是从low到high位置的元素
        for(int i=low;index<=high;index++){
            arr[i] = assist[i];
        }
//         //下次起始坐标
//         int start = mid + 1;
//         //右子序列中已经确定小于左子序列的个数
//         int count = 0;
//         //此时mid左右子序列才分别有序
//         for (int i = low; i <= mid; i++) {
//             int j = start;
// //            for (int j = start; j <= high; j++) {
// //                if(arr[i] > arr[j]){
// //                    l++;
// //                }
//                 while(j<=high && arr[i] > arr[j]){
//                     j++;
//                 }
//                 if(j<=high){
//                     l = l+j-start+count;
//                     count = j-start;
//                     start = j;
//                 }
// //                break;
// //            }
//             l = l % 1000000007;
//         }
        return res;
    }
}
