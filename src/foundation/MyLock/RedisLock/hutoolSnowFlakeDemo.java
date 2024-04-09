package foundation.MyLock.RedisLock;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;

/**
 * ѩ���㷨
 *
 */
public class hutoolSnowFlakeDemo {
    private long workerId = 0;
    private long datacenterId = 1;
    private Snowflake snowFlake;

//    @PostConstruct
//    public void init() {
//        try {
//            // ������ipת����long
//            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public hutoolSnowFlakeDemo(String ipString, long datacenterId) {
        workerId = NetUtil.ipv4ToLong(ipString);
        this.snowFlake = IdUtil.getSnowflake(workerId, datacenterId);
    }

    /**
     * ��ȡѩ��ID
     * @return
     */
    public synchronized long snowflakeId() {
        return this.snowFlake.nextId();
    }

    public synchronized long snowflakeId(long workerId, long datacenterId) {
        Snowflake snowflake = IdUtil.getSnowflake(workerId, datacenterId);
        return snowflake.nextId();
    }

    public static void main(String[] args) {
        hutoolSnowFlakeDemo snowFlakeDemo = new hutoolSnowFlakeDemo("127.0.0.1", 1);
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                System.out.println(snowFlakeDemo.snowflakeId());
            }, String.valueOf(i)).start();
        }
    }
}