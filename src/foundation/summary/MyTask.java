package foundation.summary;

/**
 * @author: wangbo82
 * @Date: 2022��06��09�� 20:54
 * 20����ɱ10̫�ֻ���ǰ10���˳ɹ�����10����ʧ��
 */
public class MyTask implements Runnable {
    //��Ʒ����
    private static int id = 10;

    //�ͻ�����
    private String userName;

    public MyTask(String userName) {
        this.userName = userName;
    }


    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(userName + "����ʹ�� " + name + " ������ɱ����......");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (MyTask.class){
            if (id > 0){
                System.out.println(userName + "ʹ�� " + name + " ��ɱ" + id + " ����Ʒ�ɹ�����");
                id--;
            } else{
                System.out.println(userName + "ʹ�� " + name + "��ɱʧ���ˣ�");
            }
        }
    }
}
