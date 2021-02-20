package com.demo.algorithm.sort;

/**
 * @Author Jusven
 * @Date 2021/2/19 18:00
 * 希尔排序
 */
public class Shell {
    //对数组元素排序
    public static void sort(Comparable[] a){
        //1.根据数组长度确定增长量h初始值
        int h=1;
        while(h<a.length/2){
            h=2*h+1;
        }

        //2.希尔排序
        while(h>=1){
            //2.1 找到待插入的元素
            // i增加，换另一个元素和自己的间隔元素比较，直至每个分组内元素都比较过
            for(int i=h;i<a.length;i++) {
                //2.2 把待插入元素a[j]放到有序序列中
                for(int j=i;j>=h;j=j-h) {  //j就是待插入元素位置,和间隔元素比较; j>=h; 每次换新的增长量h后 从第一个h位置开始比较；
                    if(greater(a[j-h],a[j])){
                        swap(a,j-h,j);
                    }else{  //已经找到当前合适位置，不用再比较改插入位置
                        break;
                    }
                }
            }

            h=h/2; //逐渐缩小增长量
        }

        //第一个待插入元素下标就是 h
    }

    //比较c1,c2元素大小
    private static boolean greater(Comparable c1, Comparable c2){
        return c1.compareTo(c2)>0;   //直接返回比较结果
    }

    //数组元素i 和j 交换
    private static void swap(Comparable[] a, int i, int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
