package foundation.package12;

import foundation.package1.Father;

public class Son extends Father {
    //2.
    public static void main(String[] args) {
      Son son = new Son();
      //2. 在Father子类中才能调用，其他位置不可以
      son.method1(345);
    }
}