package com.toi;

/**
 * @auth Toifyx
 * @date 2018/12/3
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class LoggerThroughputTest {
    //private static Logger logger = LoggerFactory.getLogger(LoggerThroughputTest.class);
    private static Logger logger = LoggerFactory.getLogger("LoggerThroughputTest.trc");
    /**
     * 100字节
     */
    private static String record_100_byte = "Performance Testing.Performance Testing.Performance Testing.Performance Testing.Performance Testing.";
    /**
     * 200字节
     */
    private static String record_200_byte = "Performance Testing.Performance Testing.Performance Testing.Performance Testing.Performance Testing.Performance Testing.Performance Testing.Performance Testing.Performance Testing.Performance Testing.";
    /**
     * 400字节
     */
    private static String record_400_byte = "Performance Testing.Performance Testing.Performance Testing.Performance Testing.Performance Testing.Performance Testing.Performance Testing.Performance Testing.Performance Testing.Performance Testing.Performance Testing.Performance Testing.Performance Testing.Performance Testing.Performance Testing.Performance Testing.Performance Testing.Performance Testing.Performance Testing.Performance Testing.";
    /**
     * 基准数值，以messageCount为准
     */
    private static int count = 100;
    /**
     * 1,2,4,8,16,32
     */
    private static int threadNum = 1;

    private static AtomicInteger messageCount = new AtomicInteger(0);

    private static String recordSize = record_100_byte;

    public static void main(String[] args) throws InterruptedException {
        if (args.length >= 3) {
            count = Integer.parseInt(args[0]);
            threadNum = Integer.parseInt(args[1]);
            int size = Integer.parseInt(args[2]);
            switch (size){
                case 200 : recordSize = record_200_byte; break;
                case 400 : recordSize = record_400_byte; break;
                default:;
            }
        }
        final CountDownLatch latch = new CountDownLatch(threadNum);
        long st = System.currentTimeMillis();
        for (int i = 0; i < threadNum; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (messageCount.get() < count) {
                        messageCount.incrementAndGet();
                        logger.info(recordSize);
                    }
                    latch.countDown();
                }
            }).start();
        }
        latch.await();
        long et = System.currentTimeMillis();

        long costTime = (et - st);
        long throughput = (1000 * messageCount.get() / (et - st));
        System.out.printf("messageCount= %05d , threadNum= %05d , costTime= %08d ms, throughput= %08d\n", messageCount.get(), threadNum, costTime, throughput);

        System.exit(0);
    }

}