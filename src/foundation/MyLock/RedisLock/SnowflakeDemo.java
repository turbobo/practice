package foundation.MyLock.RedisLock;

import org.springframework.beans.factory.DisposableBean;

/**
 * ѩ���㷨���ʺϴ�����ҪΨһid�ĳ���
 */
public class SnowflakeDemo implements DisposableBean {
    /** ��ʼʱ��� (2023-01-01) */
    private static final long START_TIME = 1672502400000L;
 
    /** ����id��ռ��λ�� */
    private static final long MACHINE_BIT = 5L;
 
    /** ���ݱ�ʶid��ռ��λ�� */
    private static final long DATA_CENTER_BIT = 5L;
 
    /** ������id��ռ��λ�� */
    private static final long SEQUENCE_BIT = 12L;
 
    /** ֧�ֵ�������id�������31 */
    private static final long MAX_MACHINE_ID = ~(-1L << MACHINE_BIT);
 
    /** ֧�ֵ�������ݱ�ʶid�������31 */
    private static final long MAX_DATA_CENTER_ID = ~(-1L << DATA_CENTER_BIT);
 
    /** �������е����룬����Ϊ4095 */
    private static final long SEQUENCE_MASK = ~(-1L << SEQUENCE_BIT);
 
    /** ����ID������12λ */
    private static final long MACHINE_LEFT = SEQUENCE_BIT;
 
    /** ���ݱ�ʶid������17λ */
    private static final long DATA_CENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
 
    /** ʱ���������22λ */
    private static final long TIMESTAMP_LEFT = SEQUENCE_BIT + MACHINE_BIT + DATA_CENTER_BIT;
 
    /** ���ݱ�ʶid���������ֲ�ͬ����������  2^5 ���31�� 011111*/
    private long dataCenterId;
 
    /** ����id���������ֲ�ͬ�Ļ��� 2^5 ���31�� 011111 */
    private long machineId;
 
    /** ���кţ���������ͬһ���������ɵĲ�ͬID */
    private long sequence = 0L;
 
    /** ��һ������ID��ʱ��� */
    private long lastTimeStamp = -1L;
 
    /** ���캯�����������ݱ�ʶid�ͻ���id */
    public SnowflakeDemo(long dataCenterId, long machineId) {
        if (dataCenterId > MAX_DATA_CENTER_ID || dataCenterId < 0) {
            throw new IllegalArgumentException("���ݱ�ʶid���ܴ���31��С��0");
        }
        if (machineId > MAX_MACHINE_ID || machineId < 0) {
            throw new IllegalArgumentException("����id���ܴ���31��С��0");
        }
        this.dataCenterId = dataCenterId;
        this.machineId = machineId;
    }
 
    /** ����ID */
    public synchronized long nextId() {
        long timeStamp = System.currentTimeMillis();
        if (timeStamp < lastTimeStamp) {
            throw new RuntimeException("ʱ�ӻز��쳣���ܾ�����id");
        }
        if (timeStamp == lastTimeStamp) {
            sequence = (sequence + 1) & SEQUENCE_MASK;
            if (sequence == 0) {
                timeStamp = nextTimeStamp(lastTimeStamp);
            }
        } else {
            sequence = 0L;
        }
        lastTimeStamp = timeStamp;
        return ((timeStamp - START_TIME) << TIMESTAMP_LEFT)
                | (dataCenterId << DATA_CENTER_LEFT)
                | (machineId << MACHINE_LEFT)
                | sequence;
    }
 
    /** ��ȡ��һ��ʱ��� */
    private long nextTimeStamp(long lastTimeStamp) {
        long timeStamp = System.currentTimeMillis();
        while (timeStamp <= lastTimeStamp) {
            timeStamp = System.currentTimeMillis();
        }
        return timeStamp;
    }

    @Override
    public void destroy() throws Exception {

    }

    public static void main(String[] args) {
        SnowflakeDemo demo = new SnowflakeDemo(1, 1);
        for (int i = 0; i < 10; i++) {
            System.out.println(demo.nextId());

        }
    }
}