package com.demo.interview.xtransfer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @Author Jusven
 * @Date 2024/3/20 13:46
 * 4����
 * 2���� * 54
 * ���ȷ���
 * ��ӡÿ���˵���
 * <p>
 * <p>
 * <p>
 * ����֮ǰ��ϴ��ʱ��ֱ�Ӱ��ƴ��ң�Ȼ��˳���ƾ��У�����Ҫ���շ����ӡ����
 */
public class test2 {
    public static void main(String[] args) {
        // 2����  Ĭ��Ϊ0  ʹ��Ϊ1
        int[] a = new int[56];
        int[] b = new int[56];
        int index = 0;
        // ʹ��set����ȥ��
        int[] repeat = new int[108];

        // 4����
//        List<List<Integer>> res = new ArrayList<>();
//        for (int i = 0; i < 4; i++) {
//            List<Integer> temp = new ArrayList<>();
//            // �޷�����һ����
//            for (int j = 0; j < 13; j++) {
//                // �����������ȡһ��
//                int temp_card = getRomdonCard(repeat, index, a, b);
//                if (temp_card > 54) {
//                    temp_card = temp_card - 54;
//                }
//                temp.add(temp_card);
//                index++;
//            }
//            res.add(temp);
//
//        }
//        for (List<Integer> l : res) {
//            for (Integer k : l) {
//                System.out.print(getCard(k) + " " );
//            }
//            System.out.println();
//        }

        // ֱ�������ȡ�ƣ�Ȼ��ָ�4����
//        int[] temp = new int[108];
//        for (int i = 0; i < 108; i++) {
//            temp[i] = getRomdonCard(repeat);
//        }


//        System.out.println(list);
//        Collections.sort(list);
//        System.out.println(list);

        List<Integer> list = new ArrayList<>(108);
        List<Integer> after = new ArrayList<>();
        shuffleCard(list);

        // �����
        for (int i = 0; i < 108; i++) {
//            if (list.get(i) > 54) {
//                list.set(i, list.get(i) - 54);
//            }
//            if (list.get(i) >= 51 && list.get(i) <= 52) {
//                System.out.println(i);
//            }
//            System.out.print(getCard(temp[i]) + " ");
            System.out.print(list.get(i) + "-");


            String card = printCard(list.get(i));
//            after.add(card);
            after.add(list.get(i));
            int remainder = list.get(i) % 4;
            String[] suits = {"����", "����", "����", "÷��"};
            System.out.print(suits[remainder]);


            System.out.print(card + " ");
            if (i % 27 == 0 && i!= 0) {
                System.out.println("i = " + i);
                System.out.println();
            }
        }

        // ͳ��ϴ��֮�����
        System.out.println();
        System.out.println("ͳ��ϴ��֮����� ");
        Collections.sort(after);
        for (int i = 0; i < after.size(); i++) {
            System.out.print(after.get(i) + " ");
        }


        // ���� 1-54  ����� 1-13 46

        //


    }

    // ϴ��
    public static void shuffleCard(List<Integer> list) {
        // ��������
        for (int i = 1; i <= 108; i++) {
            list.add(i);
        }
        // ϴ��
        Collections.shuffle(list);
    }

    public static String printCard(int i) {
        if (i > 54) {
            i = i - 54;
        }
        if (i >= 1 && i <= 4) {
            return "A";
        } else if (i >= 5 && i <= 8) {
            return "2";
        } else if (i >= 9 && i <= 12) {
            return "3";
        } else if (i >= 13 && i <= 16) {
            return "4";
        } else if (i >= 17 && i <= 20) {
            return "5";
        } else if (i >= 21 && i <= 24) {
            return "6";
        } else if (i >= 25 && i <= 28) {
            return "7";
        } else if (i >= 29 && i <= 32) {
            return "8";
        } else if (i >= 33 && i <= 36) {
            return "9";
        } else if (i >= 37 && i <= 40) {
            return "10";
        } else if (i >= 41 && i <= 44) {
            return "J";
        } else if (i >= 45 && i <= 48) {
            return "Q";
        } else if (i >= 49 && i <= 52) {
            return "K";
        } else if (i == 53) {
            return "BigJoker";
        } else if(i == 54) {
            return "SmallJoker";
        }

        return "";
    }

    // ����һ  ÿ�η���ʱ��ȡ�����
    public static int getRomdonCard(int[] repeat) {
//        if(index==108) {
//            return 0;
//        }
        int res = 0;

        // ֱ�ӻ�ȡ �����Ƶ���һ�ţ���������Ͽ����Ƿ��ظ�  ���ɵ�����0-107
        int randomNumber = (int) (Math.random() * 108) + 1;
        while (repeat[randomNumber - 1] == 1) {
            randomNumber = (int) (Math.random() * 108);
            repeat[randomNumber - 1] = 1;
        }
        return randomNumber;


//        Random random = new Random(2);
//        int i = random.nextInt();
//        while (res==0) {
//            if (i==1) {
//                Random random2 = new Random(2);
//                int i2 = random.nextInt();
//                if (a[i2-1] == 0) {
//                    res = i2;
//                    a[i2-1] = 1;
//                }
//            } else {
//                Random random2 = new Random(2);
//                int i2 = random.nextInt();
//                if (b[i2-1] == 0) {
//                    res = i2;
//                    b[i2-1] = 1;
//                }
//            }
//        }
//        return 0;
    }

    // ������  �����ϴһ���ƣ�Ȼ��˳�򷢸�4����Ҳ����
}
