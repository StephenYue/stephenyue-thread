package com.stephenyue.common.thread;

import com.stephenyue.common.thread.factory.CommonThreadPoolRejectedPolicyFactory;
import com.stephenyue.common.thread.policy.RejectedPolicyType;

import java.util.concurrent.*;

public class ThreadPoolTest2 {
    public static void main(String[] args) throws Exception {
        int coreSize = 1;
        int maxSize = 1;
        long time = 1;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(5);
        BlockingQueue blockingQueue = arrayBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(coreSize, maxSize, time, timeUnit, blockingQueue, rejectedExecutionHandler());

        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new TestRunnable3());
        }

        System.out.println("d");
        Thread.sleep(2000);
        //threadPoolExecutor.shutdown();
    }

    public static RejectedExecutionHandler rejectedExecutionHandler() {
        CommonThreadPoolRejectedPolicyFactory gameThreadPoolHelpFactory = new CommonThreadPoolRejectedPolicyFactory();
        RejectedPolicyType rejectedPolicyType = RejectedPolicyType.BLOCKING_POLICY;
        return gameThreadPoolHelpFactory.createPolicy(rejectedPolicyType, "CommonThread");
    }
}
