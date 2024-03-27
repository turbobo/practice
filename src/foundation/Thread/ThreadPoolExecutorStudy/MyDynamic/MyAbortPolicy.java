package foundation.Thread.ThreadPoolExecutorStudy.MyDynamic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author Jusven
 * @Date 2024/3/13 19:44
 *
 * https://blog.csdn.net/moakun/article/details/106172385
 * 可以参考消息队列的拒绝策略：将任务放入一个队列，有定时任务去执行失败的线程任务
 * 权限下发，会通过回调接口来获取结果，系统也有定时重新下发失败任务的冗余方案
 * 正常情况很少出现下发权限失败的 几乎都是按照线程池的性能来决定的，有时候会增大等待队列的数量，保证任务完成，但是可能速度会慢
 *
 */
@Slf4j
public class MyAbortPolicy extends ThreadPoolExecutor.AbortPolicy {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
        log.info("拒绝了任务" + r.toString());
        super.rejectedExecution(r, e);
    }
}
