package foundation.test;


/**
 * @Author Jusven
 * @Date 2021/6/16 16:49
 * 剪绳子
 */
public class CutRope {
    public static void main(String[] args) {
        for (int i = 2; i < 11; i++) {
            System.out.println("cutRope("+ i +") = " + cutRope(i));
        }
        System.out.println("cutRope(8) = " + cutRope(8));
    }

    public static int cutRope(int n){
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        if(n == 4){
            return 4;
        }
        //使用数组记录长度为n的绳子，切分以后得到的最大乘积
        int[] arr = new int[n+1];
        //小于4的情况下，绳子作为一部分，不用切分就是最大乘积
        for (int i = 1; i <= 4; i++) {
            arr[i] = i;
        }

        for (int i = 5; i <= n; i++) {
            //将长度为i的绳子切分，考虑每种情况的最大值，再取最大值
            for (int j = 1; j < i; j++) {   //切分为 j  和 i-j  总长度为 i
                arr[i] = Math.max(arr[i],j*arr[i-j]);
            }
        }
        return arr[n];
    }
}
