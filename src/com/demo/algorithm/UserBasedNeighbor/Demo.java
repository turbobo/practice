package com.demo.algorithm.UserBasedNeighbor;

import java.util.List;
/*
 *   ������
 */


public class Demo {
 
    public static void main(String[] args) {
 
        //�����û�����
        UserSet userSet = new UserSet();
        userSet.put("С��")
                .set("�й��ϻ���", 50)
                .set("̫ƽ��", 30)
                .set("��Ұ����", 45)
                .set("���ڶ�", 50)
                .set("�ҵ���Ůʱ��", 30)
                .set("Ф���ط���", 45)
                .set("���Ǿ�Ԯ", 50)
                .create();

        userSet.put("С��")
                .set("Сʱ��4", 40)
                .set("��Ұ����", 30)
                .set("�ҵ���Ůʱ��", 50)
                .set("Ф���ط���", 50)
                .set("���Ǿ�Ԯ", 30)
                .set("�������", 30)
                .create();


        userSet.put("С��")
                .set("Сʱ��4", 20)
                .set("�й��ϻ���", 50)
                .set("�ҵ���Ůʱ��", 30)
                .set("���ڶ�", 50)
                .set("Ф���ط���", 45)
                .set("�ٶ��뼤��7", 50)
                .create();

        userSet.put("С��")
                .set("Сʱ��4", 50)
                .set("�й��ϻ���", 30)
                .set("�ҵ���Ůʱ��", 40)
                .set("�Ҵ�����", 40)
                .set("�ٶ��뼤��7", 35)
                .set("���Ǿ�Ԯ", 35)
                .set("�������", 45)
                .create();

        userSet.put("��ү")
                .set("Сʱ��4", 20)
                .set("�й��ϻ���", 40)
                .set("��Ұ����", 45)
                .set("���ڶ�", 50)
                .set("�ҵ���Ůʱ��", 20)
                .create();

        userSet.put("С��")
                .set("��Ұ����", 50)
                .set("���οռ�", 50)
                .set("�ҵ���Ůʱ��", 30)
                .set("�ٶ��뼤��7", 50)
                .set("����", 45)
                .set("���ڶ�", 40)
                .set("�������", 35)
                .create();

        userSet.put("��������")
                .set("��Ұ����", 50)
                .set("�й��ϻ���", 40)
                .set("�ҵ���Ůʱ��", 10)
                .set("Phoenix", 50)
                .set("��ִ�", 40)
                .set("The Strokes", 50)
                .create();

        userSet.put("�ڴ�С��")
                .set("Сʱ��4", 40)
                .set("�ҵ���Ůʱ��", 45)
                .set("�Ҵ�����", 45)
                .set("��ִ�", 25)
                .set("The Strokes", 30)
                .create();


        Recommend recommend = new Recommend();
        List<UserSet.Set> recommendations = recommend.recommend("С��", userSet);
        System.out.println("-----------------------");
        for (UserSet.Set set : recommendations) {
            System.out.println(set.username+" "+set.score);
        }
    }
 
 
}