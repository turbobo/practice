package foundation.summary;

import java.util.Arrays;

/**
 * @Author Jusven
 * @Date 2021/5/19 21:06
 *
 * 总结练习
 */
public class demo {
    public static void main(String[] args) {
        System.out.println("5"+2);
//        System.out.println(Arrays.toString(args));
        int[] a = {13,42,59,594,3496,350};
        int[] b = new int[4];
        //数组赋值
        System.arraycopy(a,0,b,0,b.length);
        System.out.println(Arrays.toString(b));


        String s;
//        System.out.println("S"+s);   //s必须初始化
        String s1 = "dfs";
        char[] cc = {'d','2','g'};
        System.out.println(s1+"   "+Arrays.toString(cc));
        change(s1,cc);
        System.out.println(s1+"   "+Arrays.toString(cc));  //String是不可变数组，修改后会创建新对象，原对象内容不会变
    }
    static void change(String s, char[] c){
        s = s+"..";
        c[0] = 'c';  //数组传递的是地址
        System.out.println(s+"   "+c);
    }
}
