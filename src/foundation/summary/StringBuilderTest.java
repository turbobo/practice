package foundation.summary;

/**
 * @author: wangbo82
 * @Date: 2022��05��17�� 19:58
 */
public class StringBuilderTest {
    public static void main(String[] args) throws InterruptedException {
        StringBuilder builder = new StringBuilder();
//        �����ܿ�����δ��봴����10���̣߳�ÿ���߳�ѭ��1000����StringBuilder��������append�ַ���
//        ��������´���Ӧ�����10000������ʵ�����л����ʲô�أ�
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
        //8926  ÿ�ν����һ��
    }
}
