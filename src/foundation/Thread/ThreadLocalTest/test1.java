package foundation.Thread.ThreadLocalTest;

/**
 * @Author Jusven
 * @Date 2024/3/2 20:22
 */
public class test1 {
    private static   ThreadLocal<String> value = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            test1.value.set("a");
            System.out.println(Thread.currentThread().getName() + "---" + test1.value.get());
        }, "a").start();

        new Thread(() -> {
//            test1.value.set("b");
            // b线程获取不到a线程设置的值
            System.out.println(Thread.currentThread().getName() + "---" + test1.value.get());

        }, "b").start();


    }
}
