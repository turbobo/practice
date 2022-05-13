package foundation.package1;

import foundation.package12.Son;

/**
 * @author: wangbo82
 * @Date: 2022年05月13日 13:49
 */
public class test3 {
    public static void main(String[] args) {
        Son som = new Son();
        //1.在Father同包下任意位置调用protected方法
        som.method1(564);
        Father father = new Father();
        father.method1(84);
    }
}
