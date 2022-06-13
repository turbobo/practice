package foundation.summary;

/**
 * @author: wangbo82
 * @Date: 2022年06月09日 20:54
 * 20人秒杀10太手机，前10个人成功，后10个人失败
 */
public class MyTask implements Runnable {
    //商品数量
    private static int id = 10;

    //客户变量
    private String userName;

    public MyTask(String userName) {
        this.userName = userName;
    }


    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(userName + "正在使用 " + name + " 参与秒杀任务......");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (MyTask.class){
            if (id > 0){
                System.out.println(userName + "使用 " + name + " 秒杀" + id + " 号商品成功啦！");
                id--;
            } else{
                System.out.println(userName + "使用 " + name + "秒杀失败了！");
            }
        }
    }
}
