package foundation.MyLock.RedisLock;

import org.springframework.beans.factory.DisposableBean;

/**
 * 雪花算法，适合大量需要唯一id的场景
 */
public class SnowflakeDemo implements DisposableBean {
    /** 开始时间截 (2023-01-01) */
    private static final long START_TIME = 1672502400000L;
 
    /** 机器id所占的位数 */
    private static final long MACHINE_BIT = 5L;
 
    /** 数据标识id所占的位数 */
    private static final long DATA_CENTER_BIT = 5L;
 
    /** 序列在id中占的位数 */
    private static final long SEQUENCE_BIT = 12L;
 
    /** 支持的最大机器id，结果是31 */
    private static final long MAX_MACHINE_ID = ~(-1L << MACHINE_BIT);
 
    /** 支持的最大数据标识id，结果是31 */
    private static final long MAX_DATA_CENTER_ID = ~(-1L << DATA_CENTER_BIT);
 
    /** 生成序列的掩码，这里为4095 */
    private static final long SEQUENCE_MASK = ~(-1L << SEQUENCE_BIT);
 
    /** 机器ID向左移12位 */
    private static final long MACHINE_LEFT = SEQUENCE_BIT;
 
    /** 数据标识id向左移17位 */
    private static final long DATA_CENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
 
    /** 时间截向左移22位 */
    private static final long TIMESTAMP_LEFT = SEQUENCE_BIT + MACHINE_BIT + DATA_CENTER_BIT;
 
    /** 数据标识id，用于区分不同的数据中心  2^5 最大31个 011111*/
    private long dataCenterId;
 
    /** 机器id，用于区分不同的机器 2^5 最大31个 011111 */
    private long machineId;
 
    /** 序列号，用于区分同一毫秒内生成的不同ID */
    private long sequence = 0L;
 
    /** 上一次生成ID的时间截 */
    private long lastTimeStamp = -1L;
 
    /** 构造函数，传入数据标识id和机器id */
    public SnowflakeDemo(long dataCenterId, long machineId) {
        if (dataCenterId > MAX_DATA_CENTER_ID || dataCenterId < 0) {
            throw new IllegalArgumentException("数据标识id不能大于31或小于0");
        }
        if (machineId > MAX_MACHINE_ID || machineId < 0) {
            throw new IllegalArgumentException("机器id不能大于31或小于0");
        }
        this.dataCenterId = dataCenterId;
        this.machineId = machineId;
    }
 
    /** 生成ID */
    public synchronized long nextId() {
        long timeStamp = System.currentTimeMillis();
        if (timeStamp < lastTimeStamp) {
            throw new RuntimeException("时钟回拨异常，拒绝生成id");
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
 
    /** 获取下一个时间戳 */
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