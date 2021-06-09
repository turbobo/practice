package foundation;

import java.util.Arrays;

/**
 * @Author Jusven
 * @Date 2021/6/2 21:55
 */
public class IsPrime {
    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println("isPrime_num = " + isPrime_num(49234983));   //510200 - 649100 - 1065700
        long end = System.nanoTime();
        System.out.println("end - start = " + (end - start));

        long start2 = System.nanoTime();
        System.out.println("isPrime_num2 = " + isPrime_num2(49234983));   //510200 - 649100 - 1065700
        long end2 = System.nanoTime();
        System.out.println("end2 - start2 = " + (end2 - start2));
    }
    public static boolean isPrime_num(int n){
        if(n <= 2 ){
            return true;
        }
        boolean[] primeArr = new boolean[n];
        Arrays.fill(primeArr,true);

        // �� 2 ��ʼö�ٵ� sqrt(n)��
        for (int i = 2; i * i < n; i++) {
            // �����ǰ������
            if (primeArr[i]) {
                // �ͰѴ� i*i ��ʼ��i �����б���������Ϊ false��
                for (int j = i * i; j < n; j+=i) {
                    primeArr[j] = false;
                }
            }
        }
        return primeArr[n-1];
    }

    public static boolean isPrime_num2(int m){
        if(m <=2 ){
            return false;
        }
        for (int i = 2; i < m; i++) {
            if(m % i ==0){
                return false;
            }
        }
        return true;
    }
}
