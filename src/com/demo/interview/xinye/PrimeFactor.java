package com.demo.interview.xinye;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Jusven
 * @Date 2021/5/15 16:10
 *
 * 质子数相乘---求整数的质因数
 *
 */
public class PrimeFactor {
    public static void main(String[] args) {
        List l = new ArrayList<Integer>();
//        Scanner in = new Scanner(System.in);
//        int num = in.nextInt();
        int num = 900;
        long start = System.nanoTime();
        solution2(num);
        long end = System.nanoTime();
        System.out.println();
        System.out.println(end-start);

        long start2 = System.nanoTime();
        if(isPrime(num)){
            l.add(1);
            l.add(num);
        }else{
            solution(num,l);
        }
        System.out.print(num+"=");
        for(int i=0;i<l.size();i++){  //质因子从小到大
            if(i!=l.size()-1)
                System.out.print(l.get(i)+"*");
            else
                System.out.print(l.get(i));
        }
        long end2 = System.nanoTime();
        System.out.println();
        System.out.println(end2-start2);
    }

    public static void solution(int num,List l){  //递归求非质数的因数
        int i =2;
        for (; i < num/2; i++) {
            if(num%i==0){  //找到第一个除数
                break;
            }
        }
        int div = num/i;
        if(isPrime(i)) {
            l.add(i);
            if(!isPrime(div))
                solution(div, l);
            else
                l.add(div);

        }else{
            solution(i, l);
        }
//        if(isZhiShu(div)){
//            l.add(div);
//            if(!isZhiShu(i))
//                solution(i,l);
//        }else{
//            solution(div, l);
//        }
    }

    /*
    * 若y是x的因数，那么x/y 也是x的因数，只需要判断 y 和 x/y 即可；
    * 而如果我们每次选择校验两者中的较小数，则不难发现较小数一定落在 [2,sqrt(x)] 的区间中,
    * 因此我们只需要枚举 [2,sqrt{x}] 中的所有数即可，这样单次检查的时间复杂度从 O(n)  降低至  O(sqrt(n))
    * */
    public static boolean isPrime(int num){
        for (int i = 2; i * i < num; i++) {
            if(num%i==0)
                return false;
        }
//        for (int i = 2; i * i <= x; ++i) {
//            if (x % i == 0) {
//                return false;
//            }
//        }
        return true;
    }

    public static void solution2(int n){
        int i=2;
        for (i=2;i<=n;i++){
            while (n!=i){
                if(n%i==0) {
                    n = n / i;
                    System.out.print(i+"*");
                }
                else break;;
            }
        }
        //到最后都没有找到质因子
        if(i==n+1)
            System.out.print(1+"*"+n);
//        System.out.println(n);
    }
}
