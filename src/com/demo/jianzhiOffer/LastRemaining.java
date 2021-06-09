package com.demo.jianzhiOffer;

import java.util.ArrayList;

/**
 * @Author Jusven
 * @Date 2021/5/12 15:55
 *
 * ÿ����һ��ͯ��,ţ�Ͷ���׼��һЩС����ȥ�����¶�Ժ��С����,����������ˡ�
 * HF��Ϊţ�͵�����Ԫ��,��ȻҲ׼����һЩС��Ϸ��
 * ����,�и���Ϸ��������:����,��С������Χ��һ����Ȧ��
 * Ȼ��,�����ָ��һ����m,�ñ��Ϊ0��С���ѿ�ʼ������ÿ�κ���m-1���Ǹ�С����Ҫ���г��׸�,
 * Ȼ���������Ʒ�����������ѡ����,���Ҳ��ٻص�Ȧ��,��������һ��С���ѿ�ʼ,����0...m-1����....������ȥ....ֱ��ʣ�����һ��С����,
 * ���Բ��ñ���,�����õ�ţ������ġ�����̽���ϡ���ذ�(��������Ŷ!!^_^)��
 * ������������,�ĸ�С���ѻ�õ������Ʒ�أ�(ע��С���ѵı���Ǵ�0��n-1)
 *
 * ���û��С���ѣ��뷵��-1
 *
 *
 * Լɪ�򻷡�����ʽ�������ƹ�ʽ��
 * f(N,M)=(f(N?1,M)+M)%N   ��Ҫ��ÿ��ֵ�������----����
 */

public class LastRemaining {
    static class ListNode {

        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        long startTime=System.nanoTime();   //��ȡ��ʼʱ��
        System.out.println(LastRemaining_Solution(5, 3));
        long endTime=System.nanoTime(); //��ȡ����ʱ��
        System.out.println("��������ʱ�䣺 "+(endTime-startTime)+"ns");   //380900ns

        long startTime2=System.nanoTime();   //��ȡ��ʼʱ��
        System.out.println(LastRemaining_Solution2(5, 3));
        long endTime2=System.nanoTime(); //��ȡ����ʱ��
        System.out.println("��������ʱ�䣺 "+(endTime2-startTime2)+"ns");   //45900ns

        System.out.println(LastRemaining_Solution3(5, 3));
    }


    public static int LastRemaining_Solution(int n, int m) {
        if(n==0)
            return -1;
        if(m==0)
            return n-2;

        //����m-1������
        int cnt = 0;
        //Ĭ��Ϊ0
        int[] arr = new int[n];
        //����
        int number = 0;
        //�����±�
        int index = 0;
        while(true){
            if(arr[index]!=-1){  //δ����m-1����
                if(number==m-1){
                    //1.��-1��ʾ����m-1����
                    arr[index] = -1;
                    //2.��¼����m-1����
                    cnt++;
                    if(cnt==n-1) //ֻʣ��һ����δ����m-1����
                        break;
                    number = 0;

                }else{
                    number++;
                }
            }
            //�����������
            index++;
            if(index==n)
                index=0;
        }
        for(int j=0;j<n;j++){
            if(arr[j]!=-1)
                return j;
        }
        return -1;

    }


//    Լɪ�򻷡�����ʽ�������ƹ�ʽ��
//   result = f(N,M) = (f(N?1,M)+M)%N   ��Ҫ��ÿ��ֵ�������
    public static int LastRemaining_Solution2(int n, int m) {
        //N=0  f(0,M) = -1
        if(n==0 || m==0)
            return -1;
//         if(m==1)  //�������
//             return n-2;

        //N=1  result = f(1,M) = 0   ����
        int result = 0;
        // result = f(N,M) = (f(N?1,M)+M)%N   ��Ҫ��ÿ��ֵ�������
        for(int i=2;i<=n;i++){
//             result = (result+m)%n;  ����ÿ��n���ǵ�ǰi
            result = (result+m)%i;
        }
        return result;   //�½Ǳ��0��ʼ
    }

    public static int LastRemaining_Solution3(int n, int m){
        ListNode head = new ListNode(0);
        ListNode p = head;
        for(int i=1;i<n;i++){
            p.next = new ListNode(i);
            p = p.next;
        }
        p.next = head;  //��

/*        int k = 0;
        while (p.next != p) {
            if (++k == m) {
                p.next = p.next.next;
                k = 0;
            } else {
                p = p.next;
            }
        }*/

        p.next = head;  //��
        //����ָ�룬��ͷ��ʼ�ж�
        p = head;
        int cnt = 0;
        while(p.next != p){  //�жϽ���������ֻʣһ�½��
            if(cnt == m-2){
                p.next = p.next.next; //ɾ�����,Ҳ�����ɻ�
                p = p.next;  //ָ����һ�����
                cnt = 0; //���±���
            }else{
                p = p.next;
                cnt++;
            }
        }
        return p.val;
    }

    //����ģ�ⵥ����----ÿ��ɾ����������
    public static int LastRemaining_Solution4(int n, int m){
        ArrayList<Integer> list = new ArrayList<Integer>();
        //�� 0 ~ n-1 ��ŷŽ�ȥ
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        //����
        int cnt = 0;
        while(list.size()>1){  //����ֻʣһ��Ԫ��ʱ�˳�
            //ע�⣺�˴���ظ�Ҫ�� index ȡģ������ȡģ�Ķ����� n������ʵ�� list.size()��!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            cnt = (cnt + m - 1) % list.size();  //������ɾ���ĺ�һ����ʼ�����ϴ�С����ʱ�仯
            list.remove(cnt);
        }
        return list.get(0);
    }
}
