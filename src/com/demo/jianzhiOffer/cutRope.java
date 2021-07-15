package com.demo.jianzhiOffer;

/**
 * @Author Jusven
 * @Date 2021/6/15 17:54
 * ����һ������Ϊn�����ӣ�������Ӽ�����������m�Σ�m��n����������n>1����m>1��m<=n����
 * ÿ�����ӵĳ��ȼ�Ϊk[1],...,k[m]������k[1]x...xk[m]���ܵ����˻��Ƕ��٣�
 * ���磬�����ӵĳ�����8ʱ�����ǰ������ɳ��ȷֱ�Ϊ2��3��3�����Σ���ʱ�õ������˻���18��
 */
public class cutRope {
    public static void main(String[] args) {
        System.out.println("solution(8) = " + solution(8));
        System.out.println("cutRope(8) = " + cutRope(8));
    }

    /**
     * ��̬�滮
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
        //��̬�滮, arr[i]��ʾ����n = iʱ�����˻�
        int[] arr = new int[n+1];
        // n <= 4, ��Ϊ���ӵ�һ��ʱ����һ�β��ֿ�������������
        //n = 4 ��� 2*2 =4
        for (int i = 2; i <= 4; i++) {
            arr[i] = i;
        }
        for (int i = 5; i <= n; i++) {
            for (int j = 0; j < i; j++) {   //i�����ó�
                arr[i] = Math.max(arr[i],j * arr[i-j]);  //��ʱ n=i+j
            }
        }

        return arr[n];
    }

    /**
     * �ݹ�
     * @param
     * @param
     * @return
     */
    public static int cutRope(int target) {
        // number = 2 �� 3 ʱ���� 2 �κͷ� 1 �εĽ���ǲ�һ���ģ�������Ҫ����һ��
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
        // n <= 4, ��Ϊ���ӵ�һ��ʱ����һ�β��֣�����������
        if (n <= 4) {
            return n;
        }
        if(arr[n] != 0){
            return arr[n];
        }
        //����Ϊn���������ֵ
        int ret = 0;
        for (int i = 1; i < n; ++i) {
            ret = Math.max(ret, i * back_track(n-i,arr));  //��ʱ n=i+j
        }
        arr[n] = ret;
        return ret;
    }
}
