package com.demo.jianzhiOffer;

/**
 * @Author Jusven
 * @Date 2021/6/15 17:54
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），
 * 每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class cutRope {
    public static void main(String[] args) {
        System.out.println("solution(8) = " + solution(8));
        System.out.println("cutRope(8) = " + cutRope(8));
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public static int solution(int n){
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        //动态规划, arr[i]表示的是n = i时，最大乘积
        int[] arr = new int[n+1];
        // n <= 4, 作为绳子的一段时，这一段不分开，长度是最大的
        //n = 4 最大 2*2 =4
        for (int i = 2; i <= 4; i++) {
            arr[i] = i;
        }
        for (int i = 5; i <= n; i++) {
            for (int j = 0; j < i; j++) {   //i本身不用乘
                arr[i] = Math.max(arr[i],j * arr[i-j]);  //此时 n=i+j
            }
        }

        return arr[n];
    }

    /**
     * 递归
     * @param
     * @param
     * @return
     */
    public static int cutRope(int target) {
        // number = 2 和 3 时，分 2 段和分 1 段的结果是不一样的，所以需要特判一下
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        int[] arr = new int[target+1];
        return back_track(target,arr);
    }
    public static int back_track(int n, int[] arr) {
        // n <= 4, 作为绳子的一段时，这一段不分，长度是最大的
        if (n <= 4) {
            return n;
        }
        if(arr[n] != 0){
            return arr[n];
        }
        //长度为n的绳子最大值
        int ret = 0;
        for (int i = 1; i < n; ++i) {
            ret = Math.max(ret, i * back_track(n-i,arr));  //此时 n=i+j
        }
        arr[n] = ret;
        return ret;
    }
}
