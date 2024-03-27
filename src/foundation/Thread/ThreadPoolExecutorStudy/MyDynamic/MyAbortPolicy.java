package foundation.Thread.ThreadPoolExecutorStudy.MyDynamic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author Jusven
 * @Date 2024/3/13 19:44
 *
 * https://blog.csdn.net/moakun/article/details/106172385
 * ���Բο���Ϣ���еľܾ����ԣ����������һ�����У��ж�ʱ����ȥִ��ʧ�ܵ��߳�����
 * Ȩ���·�����ͨ���ص��ӿ�����ȡ�����ϵͳҲ�ж�ʱ�����·�ʧ����������෽��
 * ����������ٳ����·�Ȩ��ʧ�ܵ� �������ǰ����̳߳ص������������ģ���ʱ�������ȴ����е���������֤������ɣ����ǿ����ٶȻ���
 *
 */
@Slf4j
public class MyAbortPolicy extends ThreadPoolExecutor.AbortPolicy {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
        log.info("�ܾ�������" + r.toString());
        super.rejectedExecution(r, e);
    }
}
