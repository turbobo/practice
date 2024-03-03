//package com.demo.interview.ali;
//
//import java.util.concurrent.*;
//
////import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
////import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
//
///**
// * @Author Jusven
// * @Date 2023/8/9 21:10
// * <p>
// * 请编写一个程序，使用线程池模式实现以下功能:有10个任务需要处理，每个任务需要执行1秒钟;线程池中有5个线程，每个线程可以处理多个任务。所有线程执行完成后才能执行主线程。
// */
//public class ali_health20230809 {
//    public static void main(String[] args) throws InterruptedException {
////        test2();
////        test2();
//        myTest();
//    }
//
//
//    public static void test1() {
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//
//        for (int i = 0; i < 10; i++) {
//            int taskId = i + 1;
//            executorService.execute(() -> {
//                processTask(taskId);
//            });
//        }
//        executorService.shutdown();
//
//        try {
//            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
//            System.out.println("主线程任务 tasks completed.");
//        } catch (InterruptedException e) {
//            System.err.println("主线程任务 execution interrupted.");
//        }
//    }
//
//    private static void processTask(int taskId) {
//        System.out.println("线程池任务 " + taskId + " started.");
//        try {
//            Thread.sleep(1000); // 模拟任务执行 1 秒钟
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("线程池任务 " + taskId + " completed.");
//    }
//
//    public static void test2() throws InterruptedException {
//        // 创建线程池
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(5);
//        executor.setMaxPoolSize(5);
//        executor.setQueueCapacity(10);
//        executor.initialize();
//
//        // 创建 CountDownLatch，计数器设置为任务数量
//        CountDownLatch latch = new CountDownLatch(10);
//
//        // 提交任务到线程池
//        for (int i = 0; i < 10; i++) {
//            int taskId = i + 1;
//            executor.execute(() -> {
//                try {
//                    System.out.println("Task " + taskId + " is processing...");
//                    Thread.sleep(1000); // 模拟任务执行时间
//                    System.out.println("Task " + taskId + " is completed.");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    latch.countDown(); // 任务执行完成，计数器减一
//                }
//            });
//        }
//
//        // 等待所有任务完成
//        latch.await();
//
//        // 关闭线程池
//        executor.shutdown();
//
//        // 主线程输出信息
//        System.out.println("All tasks are completed. Main thread is continuing...");
//
//    }
//
//    // 面试写法改进
//    public static void myTest() throws InterruptedException {
//        CountDownLatch countDownLatch = new CountDownLatch(10);
////        try {
////        } catch ()
//
//        ThreadPoolTaskExecutor threadPollaskExecitor = new ThreadPoolTaskExecutor();
//        threadPollaskExecitor.setCorePoolSize(5);
//        threadPollaskExecitor.setMaxPoolSize(5);
//        // 线程池初始化
//        threadPollaskExecitor.initialize();
////        5, 5, 2, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10),
//
////        synchronized(this){
////
////        }
//
//        for (int i = 0; i < 10; i++) {
//            // 执行任务
//            int finalI = i;
//            threadPollaskExecitor.execute(() -> {
////                countDownLatch.countDown();
//                try {
//                    Thread.sleep(1000);
//                    System.out.println("线程池任务 " + finalI);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    // 任务执行完成，计数器减一
//                    countDownLatch.countDown();
//                }
//            });
//
//        }
//        // 等待所有任务完成
//        countDownLatch.await();
//        // 关闭
//        threadPollaskExecitor.shutdown();
//
//        // 主线程
////        try {
////            countDownLatch.await();
//            System.out.println("主线程任务");
////        }
////        catch (InterruptedException e) {
////            e.printStackTrace();
////        } finally {
////        }
//    }
//}
//
