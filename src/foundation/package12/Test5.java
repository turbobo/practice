package foundation.package12;

public class Test5 {
      public static void main(String[] args) {
          Son son = new Son();
          //本方法和Father不在同一个包中
//          son.method1();//编译报错：'method1(int)' has protected access in

          //1. Father所在包下通过Son实例调用该方法
          //2. 在Son类里面调用该方法（此时在该类中调用，相当于直接调用继承的父类的protectd方法）。
      }
  }