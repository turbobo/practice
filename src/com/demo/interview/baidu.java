package com.demo.interview;

/**
 * @Author Jusven
 * @Date 2021/3/30 20:13
 */
public class baidu {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int p = in.nextInt();
//        int[] arr = new int[n];
//        for(int i=0;i<n;i++){
//            arr[i] = in.nextInt();
//        }
        String str = "01";
        int a = 0;
//        String str = null;
////        while (in.hasNext()) {
//            a = in.nextInt();
////        }
//        while (in.hasNext()) {
//            str = in.nextLine();
//            break;
//        }

//        String[] arr = str.split("");
        int i = 0;
        int count = 0;
        while(i<str.length()){
            //后面数组是否存在本元素
            int index = existElem(str,str.charAt(i),i);
            if(index!=-1){
                i=index;
                count++;
            }
            else{
                i++;
                count++;
            }
        }
        System.out.println(count-1);
    }

    public static int existElem(String arr, char s, int k){
        int index = -1;
        for(int i=k+1;i<arr.length();i++){
            if(arr.charAt(i)==s)
                index=i;
        }
        return index;
    }
}
