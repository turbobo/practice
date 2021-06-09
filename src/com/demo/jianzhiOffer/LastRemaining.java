package com.demo.jianzhiOffer;

import java.util.ArrayList;

/**
 * @Author Jusven
 * @Date 2021/5/12 15:55
 *
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 * HF作为牛客的资深元老,自然也准备了一些小游戏。
 * 其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。
 * 然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,
 * 然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,
 * 可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 *
 * 如果没有小朋友，请返回-1
 *
 *
 * 约瑟夫环——公式法（递推公式）
 * f(N,M)=(f(N?1,M)+M)%N   需要把每个值演算出来----迭代
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
        long startTime=System.nanoTime();   //获取开始时间
        System.out.println(LastRemaining_Solution(5, 3));
        long endTime=System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ns");   //380900ns

        long startTime2=System.nanoTime();   //获取开始时间
        System.out.println(LastRemaining_Solution2(5, 3));
        long endTime2=System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime2-startTime2)+"ns");   //45900ns

        System.out.println(LastRemaining_Solution3(5, 3));
    }


    public static int LastRemaining_Solution(int n, int m) {
        if(n==0)
            return -1;
        if(m==0)
            return n-2;

        //喊到m-1的人数
        int cnt = 0;
        //默认为0
        int[] arr = new int[n];
        //报数
        int number = 0;
        //数组下标
        int index = 0;
        while(true){
            if(arr[index]!=-1){  //未喊到m-1的人
                if(number==m-1){
                    //1.用-1表示喊到m-1的人
                    arr[index] = -1;
                    //2.记录喊到m-1的人
                    cnt++;
                    if(cnt==n-1) //只剩下一个人未喊到m-1的人
                        break;
                    number = 0;

                }else{
                    number++;
                }
            }
            //数组遍历结束
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


//    约瑟夫环——公式法（递推公式）
//   result = f(N,M) = (f(N?1,M)+M)%N   需要把每个值演算出来
    public static int LastRemaining_Solution2(int n, int m) {
        //N=0  f(0,M) = -1
        if(n==0 || m==0)
            return -1;
//         if(m==1)  //特殊情况
//             return n-2;

        //N=1  result = f(1,M) = 0   迭代
        int result = 0;
        // result = f(N,M) = (f(N?1,M)+M)%N   需要把每个值演算出来
        for(int i=2;i<=n;i++){
//             result = (result+m)%n;  错误，每个n就是当前i
            result = (result+m)%i;
        }
        return result;   //下角标从0开始
    }

    public static int LastRemaining_Solution3(int n, int m){
        ListNode head = new ListNode(0);
        ListNode p = head;
        for(int i=1;i<n;i++){
            p.next = new ListNode(i);
            p = p.next;
        }
        p.next = head;  //环

/*        int k = 0;
        while (p.next != p) {
            if (++k == m) {
                p.next = p.next.next;
                k = 0;
            } else {
                p = p.next;
            }
        }*/

        p.next = head;  //环
        //操作指针，从头开始判断
        p = head;
        int cnt = 0;
        while(p.next != p){  //判断结束条件：只剩一下结点
            if(cnt == m-2){
                p.next = p.next.next; //删除结点,也会连成环
                p = p.next;  //指向下一个结点
                cnt = 0; //重新报数
            }else{
                p = p.next;
                cnt++;
            }
        }
        return p.val;
    }

    //集合模拟单链表----每次删除报数的人
    public static int LastRemaining_Solution4(int n, int m){
        ArrayList<Integer> list = new ArrayList<Integer>();
        //把 0 ~ n-1 编号放进去
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        //报数
        int cnt = 0;
        while(list.size()>1){  //集合只剩一个元素时退出
            //注意：此处异地更要让 index 取模，而且取模的对象不是 n，而是实际 list.size()；!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            cnt = (cnt + m - 1) % list.size();  //报数从删除的后一个开始，集合大小在随时变化
            list.remove(cnt);
        }
        return list.get(0);
    }
}
