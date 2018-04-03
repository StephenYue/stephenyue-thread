package com.stephenyue.common.thread;

import com.stephenyue.common.thread.factory.CommonThreadPoolRejectedPolicyFactory;
import com.stephenyue.common.thread.policy.RejectedPolicyType;

import java.util.concurrent.*;

public class ThreadPoolTest {

    public static void main(String[] args) throws Exception {
        int coreSize = 1;
        int maxSize = 20;
        long time = 1;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(5);
        BlockingQueue blockingQueue = arrayBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(coreSize, maxSize, time, timeUnit, blockingQueue, rejectedExecutionHandler());
        int threadSize = 100;
        for (int i = 0; i < threadSize; i++) {
            try {
                threadPoolExecutor.execute(new TestRunnable());
//                threadPoolExecutor.execute(new TestRunnable2(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("d");
        Thread.sleep(2000);
        threadPoolExecutor.shutdown();
    }

    public static RejectedExecutionHandler rejectedExecutionHandler() {
        CommonThreadPoolRejectedPolicyFactory gameThreadPoolHelpFactory = new CommonThreadPoolRejectedPolicyFactory();
        RejectedPolicyType rejectedPolicyType = RejectedPolicyType.BLOCKING_POLICY;
        return gameThreadPoolHelpFactory.createPolicy(rejectedPolicyType, "test");
    }
}
