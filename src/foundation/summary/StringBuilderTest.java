package foundation.summary;

/**
 * @author: wangbo82
 * @Date: 2022年05月17日 19:58
 */
public class StringBuilderTest {
    public static void main(String[] args) throws InterruptedException {
        StringBuilder builder = new StringBuilder();
//        我们能看到这段代码创建了10个线程，每个线程循环1000次往StringBuilder对象里面append字符。
//        正常情况下代码应该输出10000，但是实际运行会输出什么呢？
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        builder.append("a");
                    }
                }
            }).start();
        }
        Thread.sleep(100);
        System.out.println(builder.length());
        //8926  每次结果不一样
    }
}
