package foundation.DesignPattern.ObservePattern.PublishSubscribe;

import org.springframework.context.ApplicationEvent;

/**
 * ��������ģ��
 * �۲���ģʽ��������һ�Զ��������ϵ������һ���������⣩ά����һ���۲��߶�����б��������״̬�����仯ʱ������֪ͨ���еĹ۲��ߡ�
 * ����ģʽ���ص��ǹ۲��ߺͱ��۲���ֱ�ӽ������۲�����Ҫע�ᵽ��������Ա����֪ͨ��
 *
 * ����-����ģʽ��������һ���м����������ģ������ģʽ�У������߸��𷢲��¼�����Ϣ�����������������Ǹ���Ȥ���¼���
 * �������ĸ�������ĺͷ���֮�����ϵ��ʹ�÷����ߺͶ�����֮�䲻��Ҫֱ�ӽ�����
 * �����������ߺͶ����߿��Ի������ŵع����������ϵͳ�Ľ����Ժ�����ԡ�
 * @Author Jusven
 * @Date 2024/4/18 12:40
 * �����¼�
 */
public class EventDto extends ApplicationEvent {
    // �Զ����¼�
    private final String event;

    /**
     *
     * @param source source����ָ���Ƿ����¼��Ķ��󣬸ö�������ڼ����ڱ���ȡ�� ���Բ�ȥ����event��ֱ�ӻ�ȡObject���͵���Ϣ
     * @param event
     */
    public EventDto(Object source, String event) {
        super(source);
        this.event = event;
    }
    // ��ȡ�¼�
    public String getEvent() {
        return event;
    }
}
