package foundation.package1;

import foundation.package12.Son;

/**
 * @author: wangbo82
 * @Date: 2022��05��13�� 13:49
 */
public class test3 {
    public static void main(String[] args) {
        Son som = new Son();
        //1.��Fatherͬ��������λ�õ���protected����
        som.method1(564);
        Father father = new Father();
        father.method1(84);
    }
}
