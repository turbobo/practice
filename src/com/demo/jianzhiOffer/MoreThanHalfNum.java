package com.demo.jianzhiOffer;

import java.util.Arrays;
import java.util.HashMap;
/*
* ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
* ��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
* ��������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2����������������0��
* */
public class MoreThanHalfNum {
    public static void main(String[] args) {
        String s="";
        char ch = 's';
        int[] a = {1,2,5,5,7,8,5,2,2,2,3,2,2,2,};
//        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println("�����г��ֵĴ����������鳤�ȵ�һ�������Ϊ��"+MoreThanHalfNum_Solution2(a));
    }

    public static int MoreThanHalfNum_Solution2(int [] array){
        int temp = array[0];   //temp��ų�������Ԫ��
        int count = 1;
        //1�����ҳ� ������������----��һ���Ǵ����������鳤��һ��
        for(int i=1;i<array.length;i++){
            if(array[i]==temp){
                count++;
            }else{  //ֵ��ͬ������ͳ��
                count--;   //��֮ǰ�ظ��Ĵ�������ȥ��---��������ֳ��ִ�����������һ�룬�����������֮ǰ�����Ĵ����϶�������꣬����temp�����Ǹ�����
            }
            //�����ֵ�һ�γ���  ���¸�ֵtemp
            if(count==0){
                temp=array[i];
                count=1;
            }
        }
        //2��ͳ�Ƹ����ִ���
        count = 0;
        for(int i=0;i<array.length;i++){
            if(array[i]==temp)
                count++;
        }
        return count>array.length/2 ? temp : 0;
    }

    public static int MoreThanHalfNum_Solution(int [] array) {
        //ʹ�ù�ϣ��洢Ԫ�س��ִ���
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        //�������飬ͳ�ƴ���
        for(int i=0;i<array.length;i++){
            if(!map.containsKey(array[i])){  //��һ��ͳ��
                map.put(array[i],1);
            }
            else{
                int currCount = map.get(array[i]);
                currCount++;
                map.put(array[i],currCount);
            }
        }
        int haflArray = array.length/2;
        //�ҳ����ִ��� �������鳤�ȵ�һ��Ԫ��
        for(int key : map.keySet()) {  //map.keySet()---��ȡMap���ϵ����м���
            if(map.get(key)>haflArray)
                return key;
        }
        
        return 0;
    }
}