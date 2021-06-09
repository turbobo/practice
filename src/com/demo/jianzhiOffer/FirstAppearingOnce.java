package com.demo.jianzhiOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Jusven
 * @Date 2021/6/5 13:55
 */
public class FirstAppearingOnce {
    public static void main(String[] args) {
        Insert('g');
        Insert('o');
        Insert('o');
        Insert('g');
        Insert('l');
        Insert('e');
        System.out.println("FirstAppearingOnce() = " + FirstAppearingOnce());
    }

    static int[] charCnt = new int[128];
    static Queue<Character> queue = new LinkedList<Character>();

    //Insert one char from stringstream
    public static void Insert(char ch) {
        if (charCnt[ch]++ == 0) //�����ĵ����ַ������
            queue.add(ch);
    }
    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce() {
        Character CHAR = null;
        char c = 0;
        while ((CHAR = queue.peek()) != null) {
            c = CHAR.charValue();
            if (charCnt[c] == 1) //�ж��Ƿ��ѵ��ˣ�û�ѵ������
                return c;
            else queue.remove(); //�ѵ��˾��Ƴ����У��������ٻ�����
        }
        return '#'; //�ӿգ�����#
    }
}
