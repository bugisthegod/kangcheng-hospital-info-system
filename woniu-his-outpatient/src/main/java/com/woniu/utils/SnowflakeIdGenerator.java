package com.woniu.utils;

public class SnowflakeIdGenerator {

    // ==============================Fields===========================================

    // 所占位数、位移、掩码/极大值
    private static final long sequenceBits = 12;  //序列号占用位数
    private static final long workerIdBits = 5;  //工作机器占用位数
    private static final long dataCenterIdBits = 5;  //数据中心占用位数

    private static final long sequenceShift = 0L;
    //~表示非，例如 01 的非  10     负数的二进制 = 该正数的二进制取反+1
    //为什么不直接写4095呢？（主要计算机运算的时候是二进制，如果写4095的话，还是要转二进制，效率低）
    private static final long sequenceMask = ~(-1L << sequenceBits);  //4095  （0到4095 刚好是4096个）


    private static final long workerIdShift = sequenceBits;
    private static final long workerIdMask = ~(-1L << workerIdBits); //31


    private static final long dataCenterIdShift = sequenceBits + workerIdBits;
    private static final long dataCenterIdMask = ~(-1L << dataCenterIdBits); //31

    private static final long timestampBits = 41L;
    private static final long timestampLeftShift = sequenceBits + workerIdBits + dataCenterIdBits;
    private static final long timestampMask = ~(-1L << timestampBits);

    /**
     * 开始时间截 (2015-01-01)
     */
    private static final long twepoch = 1420070400000L;

    private long sequence = 0;  //序列号
    private long workerId;      //工作机器标识
    private long dataCenterId;  //数据中心
    private long lastTimestamp = -1L; //上次生成 ID 的时间截

    //==============================Constructors=====================================

    public SnowflakeIdGenerator() {
        this(0, 0);
    }

    /**
     * 构造函数
     *
     * @param workerId     工作ID (0~31)
     * @param dataCenterId 数据中心 ID (0~31)
     */
    public SnowflakeIdGenerator(long workerId, long dataCenterId) {
        if (workerId > workerIdMask || workerId < 0) {
            throw new IllegalArgumentException(String.format("workerId can't be greater than %d or less than 0", workerIdMask));
        }

        if (dataCenterId > dataCenterIdMask || dataCenterId < 0) {
            throw new IllegalArgumentException(String.format("dataCenterId can't be greater than %d or less than 0", dataCenterIdMask));
        }

        this.workerId = workerId;
        this.dataCenterId = dataCenterId;
    }

    // ============================== Methods ==========================================

    /**
     * 获得下一个 ID (该方法是线程安全的，synchronized)
     */
    public synchronized long nextId() {
        long timestamp = timeGen();

        // 如果当前时间小于上一次 ID 生成的时间戳，说明系统时钟回退过，这个时候应当抛出异常。
        // 出现这种原因是因为系统的时间被回拨，或出现闰秒现象。
        // 你也可以不抛出异常，而是调用 tilNextMillis 进行等待
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(
                    String.format("Clock moved backwards. Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }

        // 如果是同一时间生成的，则进行毫秒内序列
        if (lastTimestamp == timestamp) {
            // 相同毫秒内，序列号自增
            sequence = (sequence + 1) & sequenceMask;   //得到的是 0
            // 毫秒内序列溢出，即，同一毫秒的序列数已经达到最大
            if (sequence == 0) {
                // 阻塞到下一个毫秒,获得新的时间戳
                timestamp = tilNextMillis(lastTimestamp);
            }
        }
        // 时间戳改变，毫秒内序列重置
        else {
            sequence = 0L;
        }

        // 将当前生成的时间戳记录为『上次时间戳』。『下次』生成时间戳时要用到。
        lastTimestamp = timestamp;

        // 移位并通过或运算拼到一起组成 64 位的 ID
        return ((timestamp - twepoch) << timestampLeftShift) // 时间戳部分
                | (dataCenterId << dataCenterIdShift) // 数据中心（机房）部分
                | (workerId << workerIdShift) // 机器标识部分
                | sequence; // 序列号部分
    }

    /**
     * 阻塞到下一个毫秒，直到获得新的时间戳
     *
     * @param lastTimestamp 上次生成ID的时间截
     * @return 当前时间戳
     */
    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    /**
     * 阻塞到下一个毫秒，直到获得新的时间戳
     *
     * @param timestamp     当前时间错
     * @param lastTimestamp 上次生成ID的时间截
     * @return 当前时间戳
     */
    protected long tilNextMillis(long timestamp, long lastTimestamp) {
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    /**
     * 返回以毫秒为单位的当前时间
     *
     * @return 当前时间(毫秒)
     */
    protected long timeGen() {
        return System.currentTimeMillis();
    }
}

