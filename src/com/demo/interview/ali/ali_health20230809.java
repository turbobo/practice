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
// * ���дһ������ʹ���̳߳�ģʽʵ�����¹���:��10��������Ҫ����ÿ��������Ҫִ��1����;�̳߳�����5���̣߳�ÿ���߳̿��Դ��������������߳�ִ����ɺ����ִ�����̡߳�
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
//            System.out.println("���߳����� tasks completed.");
//        } catch (InterruptedException e) {
//            System.err.println("���߳����� execution interrupted.");
//        }
//    }
//
//    private static void processTask(int taskId) {
//        System.out.println("�̳߳����� " + taskId + " started.");
//        try {
//            Thread.sleep(1000); // ģ������ִ�� 1 ����
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("�̳߳����� " + taskId + " completed.");
//    }
//
//    public static void test2() throws InterruptedException {
//        // �����̳߳�
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(5);
//        executor.setMaxPoolSize(5);
//        executor.setQueueCapacity(10);
//        executor.initialize();
//
//        // ���� CountDownLatch������������Ϊ��������
//        CountDownLatch latch = new CountDownLatch(10);
//
//        // �ύ�����̳߳�
//        for (int i = 0; i < 10; i++) {
//            int taskId = i + 1;
//            executor.execute(() -> {
//                try {
//                    System.out.println("Task " + taskId + " is processing...");
//                    Thread.sleep(1000); // ģ������ִ��ʱ��
//                    System.out.println("Task " + taskId + " is completed.");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    latch.countDown(); // ����ִ����ɣ���������һ
//                }
//            });
//        }
//
//        // �ȴ������������
//        latch.await();
//
//        // �ر��̳߳�
//        executor.shutdown();
//
//        // ���߳������Ϣ
//        System.out.println("All tasks are completed. Main thread is continuing...");
//
//    }
//
//    // ����д���Ľ�
//    public static void myTest() throws InterruptedException {
//        CountDownLatch countDownLatch = new CountDownLatch(10);
////        try {
////        } catch ()
//
//        ThreadPoolTaskExecutor threadPollaskExecitor = new ThreadPoolTaskExecutor();
//        threadPollaskExecitor.setCorePoolSize(5);
//        threadPollaskExecitor.setMaxPoolSize(5);
//        // �̳߳س�ʼ��
//        threadPollaskExecitor.initialize();
////        5, 5, 2, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10),
//
////        synchronized(this){
////
////        }
//
//        for (int i = 0; i < 10; i++) {
//            // ִ������
//            int finalI = i;
//            threadPollaskExecitor.execute(() -> {
////                countDownLatch.countDown();
//                try {
//                    Thread.sleep(1000);
//                    System.out.println("�̳߳����� " + finalI);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    // ����ִ����ɣ���������һ
//                    countDownLatch.countDown();
//                }
//            });
//
//        }
//        // �ȴ������������
//        countDownLatch.await();
//        // �ر�
//        threadPollaskExecitor.shutdown();
//
//        // ���߳�
////        try {
////            countDownLatch.await();
//            System.out.println("���߳�����");
////        }
////        catch (InterruptedException e) {
////            e.printStackTrace();
////        } finally {
////        }
//    }
//}
//
