package com.demo.interview.CTrip;

import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/9/9 18:59
 * �� cd s: sΪһ��Ŀ¼������ʾ�ӵ�ǰ����Ŀ¼��·��������Ϊs��Ŀ¼��
 * �ر�أ�"cd .."(��s=="..")��ʾ������һ��Ŀ¼������ǰ��Ϊ��Ŀ¼�������Ӹôβ�����
 * ���ݱ�֤��s��Ϊ".."����һ��ΪСд��ĸ��ɵĳ��Ȳ�����10���ַ�����
 * <p>
 * �� pwd: ��ʾ�鿴��ǰ����Ŀ¼��·��������Ҫ������·����
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = "\\";
        System.out.println(str.length());
        for (int i = 0; i < n; i++) {
            String temp = sc.nextLine();
            if ("pwd".equals(temp)) {
                System.out.println(str);
            } else {
                String[] arr = temp.split(" ");
                if ("..".equals(arr[1])) {
                    if (str.length() == 0 || str.length() == 1) {
                        continue;
                    }
                    else if (str.length() == 2) {
                        str = str.substring(0, str.length() - 1);
                    }
                    else {
                        str = str.substring(0, str.length() - 2);
                    }
                } else {
                    if (str.length() == 1) {
                        str += arr[1];
                    } else {
                        str += "\\" + arr[1];
                    }
                }
            }
        }
//        String s = "abcde";
//        System.out.println(s.substring(0, s.length() - 1));
    }
}
