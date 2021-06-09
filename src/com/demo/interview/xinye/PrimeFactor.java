package com.demo.interview.xinye;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Jusven
 * @Date 2021/5/15 16:10
 *
 * ���������---��������������
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
        for(int i=0;i<l.size();i++){  //�����Ӵ�С����
            if(i!=l.size()-1)
                System.out.print(l.get(i)+"*");
            else
                System.out.print(l.get(i));
        }
        long end2 = System.nanoTime();
        System.out.println();
        System.out.println(end2-start2);
    }

    public static void solution(int num,List l){  //�ݹ��������������
        int i =2;
        for (; i < num/2; i++) {
            if(num%i==0){  //�ҵ���һ������
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
    * ��y��x����������ôx/y Ҳ��x��������ֻ��Ҫ�ж� y �� x/y ���ɣ�
    * ���������ÿ��ѡ��У�������еĽ�С�������ѷ��ֽ�С��һ������ [2,sqrt(x)] ��������,
    * �������ֻ��Ҫö�� [2,sqrt{x}] �е����������ɣ��������μ���ʱ�临�Ӷȴ� O(n)  ������  O(sqrt(n))
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
        //�����û���ҵ�������
        if(i==n+1)
            System.out.print(1+"*"+n);
//        System.out.println(n);
    }
}
