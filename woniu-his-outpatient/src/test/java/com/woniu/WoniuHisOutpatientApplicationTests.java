package com.woniu;

import com.woniu.utils.SnowflakeIdGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class WoniuHisOutpatientApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(System.currentTimeMillis());
        SnowflakeIdGenerator idWorker = new SnowflakeIdGenerator(1, 1);
        long startTime = System.nanoTime();
        for (int i = 0; i < 50000; i++) {
            long id = idWorker.nextId();
            System.out.println(id);
        }
        System.nanoTime(); //获取当前纳秒
        System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");
    }

}
