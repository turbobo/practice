package foundation.DesignPattern;

/**
 * @Author Jusven
 * @Date 2023/11/12 17:11
 */
public class testSingleton  extends Thread {
    // ����ʽ
    volatile private static testSingleton singleton;

    private testSingleton() {
        System.out.println(Thread.currentThread().getName()+"");
    }

//    public static testSingleton getInstance() {
////        getInstance(); // ��ӡ����������10���߳�
//        if (null == singleton) {
//            singleton = new testSingleton();
//        }
//        return singleton;
//    }

/*    public static testSingleton getInstance() {
//        getInstance(); // ��ӡ����������10���߳�
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
        // ��������ʽ����
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                getInstance(); // ��ӡ����������10���߳�
////                System.out.println(instance.toString());
//            }).start();
//        }

        new testSingleton().start();
    }
}
