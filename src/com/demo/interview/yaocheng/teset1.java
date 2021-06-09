package com.demo.interview.yaocheng;

import java.util.*;

/**
 * @Author Jusven
 * @Date 2021/6/2 16:27
 */
public class teset1 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> factorization = factorization(24);
        System.out.println("factorization = " + factorization);
    }
    public static ArrayList<ArrayList<Integer>> factorization (int n) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
//        solution(n,list2);
//        System.out.println("list2 = " + list2);

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        solution2(n,list2,map);
        if(map.containsKey(1)){  //存在键值为 1
            map.remove(1);
        }

/*        for(int k: list2){
            if(map.containsKey(k)){
                map.put(k,map.get(k)+1);
                }else {
                    map.put(k,1);
                }
        }

        for(Map.Entry<Integer,Integer> m : map.entrySet()){
            ArrayList<Integer> list3 = new ArrayList<Integer>();
            list3.add(m.getKey());
            list3.add(m.getValue());
            list.add(list3);
        }*/


//        int[][] res = new int[n][2];
//        int index = 0;
//        // write code here
//        for (int i = 2; i < n; i++) {
//            //找到第一个质因数
//            if(n % i == 0 && isPrime(i)){
//                res[index][0] = i;
//                res[index][1] = res[index][1] + 1;
//                index++;
//
//                int div = n / i;
//                if(isPrime(div)){  //结果也是质数
//                    res[index][0] = i;
//                    res[index][1] = res[index][1] + 1;
//                    break;
//                }
//            }
//        }
//
//
//        int i=2;
//        for (i=2;i<=n;i++){
//            while (n!=i){
//                if(n%i==0) {
//                    n = n / i;
//                    if(map.containsKey(1)){
//                        map.put(i,map.get(i)+1);
//                    }else {
//                        map.put(i,1);
//                    }
//                }
//                else{
//                    break;
//                };
//            }
//        }
//        //到最后都没有找到质因子
//        if(i==n+1) {
//            map.put(1,1);
//            map.put(n,1);
//        }

        return list;
    }
    public static boolean isPrime(int x){
        for (int i = 2; i < x; i++) {
            if(x % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void solution(int num, ArrayList l){  //递归求非质数的因数
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

    public static void solution2(int n, ArrayList l, Map map){  //递归求非质数的因数
        int i=2;
        for (i=2;i<=n;i++){
            while (n!=i){
                if(n%i==0) {
                    n = n / i;
                    if(map.containsKey(i)){
                        map.put(i,(int)map.get(i) + 1);
                    }else {
                        map.put(i,1);
                    }
                }
                else{
                    break;
                };
            }
        }
        //到最后都没有找到质因子
        if(i==n+1) {
            map.put(1,1);
            map.put(n,1);
        }
    }
}
