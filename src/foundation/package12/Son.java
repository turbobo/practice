package foundation.package12;

import foundation.package1.Father;

public class Son extends Father {
    //2.
    public static void main(String[] args) {
      Son son = new Son();
      //2. ��Father�����в��ܵ��ã�����λ�ò�����
      son.method1(345);
    }
}