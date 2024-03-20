package com.demo.interview.xtransfer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @Author Jusven
 * @Date 2024/3/20 13:46
 * 4个人
 * 2副牌 * 54
 * 均匀发牌
 * 打印每个人的牌
 * <p>
 * <p>
 * <p>
 * 发牌之前，洗牌时就直接把牌打乱，然后顺序发牌就行，牌需要按照分类打印出来
 */
public class test2 {
    public static void main(String[] args) {
        // 2副牌  默认为0  使用为1
        int[] a = new int[56];
        int[] b = new int[56];
        int index = 0;
        // 使用set集合去重
        int[] repeat = new int[108];

        // 4个人
//        List<List<Integer>> res = new ArrayList<>();
//        for (int i = 0; i < 4; i++) {
//            List<Integer> temp = new ArrayList<>();
//            // 无法评分一副牌
//            for (int j = 0; j < 13; j++) {
//                // 两幅牌随机获取一张
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

        // 直接随机获取牌，然后分给4个人
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

        // 输出牌
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
            String[] suits = {"黑桃", "红心", "方块", "梅花"};
            System.out.print(suits[remainder]);


            System.out.print(card + " ");
            if (i % 27 == 0 && i!= 0) {
                System.out.println("i = " + i);
                System.out.println();
            }
        }

        // 统计洗牌之后的牌
        System.out.println();
        System.out.println("统计洗牌之后的牌 ");
        Collections.sort(after);
        for (int i = 0; i < after.size(); i++) {
            System.out.print(after.get(i) + " ");
        }


        // 牌数 1-54  随机数 1-13 46

        //


    }

    // 洗牌
    public static void shuffleCard(List<Integer> list) {
        // 创建牌数
        for (int i = 1; i <= 108; i++) {
            list.add(i);
        }
        // 洗牌
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

    // 方法一  每次发牌时获取随机牌
    public static int getRomdonCard(int[] repeat) {
//        if(index==108) {
//            return 0;
//        }
        int res = 0;

        // 直接获取 两副牌的任一张，在随机数上控制是否重复  生成的数是0-107
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

    // 方法二  先随机洗一次牌，然后顺序发给4个人也可以
}
