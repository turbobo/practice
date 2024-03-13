package com.example.testautoconfig;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author Jusven
 * @Date 2024/3/7 15:18
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class test1 {

    @Resource
    private ThreadPoolExecutor newThreadPoolExecutor;

    public void test() {
        System.out.println("newThreadPoolExecutor.getCorePoolSize() = " + newThreadPoolExecutor.getCorePoolSize());
    }
}
