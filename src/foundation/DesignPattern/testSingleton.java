package foundation.DesignPattern;

/**
 * @Author Jusven
 * @Date 2023/11/12 17:11
 */
public class testSingleton  extends Thread {
    // 懒汉式
    volatile private static testSingleton singleton;

    private testSingleton() {
        System.out.println(Thread.currentThread().getName()+"");
    }

//    public static testSingleton getInstance() {
////        getInstance(); // 打印并不是所有10个线程
//        if (null == singleton) {
//            singleton = new testSingleton();
//        }
//        return singleton;
//    }

/*    public static testSingleton getInstance() {
//        getInstance(); // 打印并不是所有10个线程
        if (null == singleton) {
            synchronized (testSingleton.class) {
                if (null == singleton) {
                    singleton = new testSingleton();
                }
            }
        }
        return singleton;
    }*/

    @Override
    public void run() {
        System.out.println();;
    }

    public static void main(String[] args) {
        // 测试懒汉式问题
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                getInstance(); // 打印并不是所有10个线程
////                System.out.println(instance.toString());
//            }).start();
//        }

        new testSingleton().start();
    }
}
