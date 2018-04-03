package com.stephenyue.common.thread.executor;

import com.stephenyue.common.thread.ThreadNameFactory;
import com.stephenyue.common.thread.worker.AbstractWork;

import java.util.concurrent.*;

/**
 * 无序队列线程池
 */
public class NonOrderedQueuePoolExecutor extends ThreadPoolExecutor {

    public NonOrderedQueuePoolExecutor(int corePoolSize) {
        super(corePoolSize, corePoolSize*2, 30, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());
    }

    public NonOrderedQueuePoolExecutor(String name, int corePoolSize) {
        super(corePoolSize, corePoolSize*2, 30, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(), new ThreadNameFactory(name));
    }

    public NonOrderedQueuePoolExecutor(String name, int corePoolSize, int maxPoolSize) {
        super(corePoolSize, maxPoolSize, 30, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(), new ThreadNameFactory(name));
    }

    public NonOrderedQueuePoolExecutor(String name, int corePoolSize, int maxSize, RejectedExecutionHandler rejectedExecutionHandler) {
        super(corePoolSize, maxSize, 30, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(), new ThreadNameFactory(name), rejectedExecutionHandler);
    }


    public NonOrderedQueuePoolExecutor(String name, int corePoolSize, int maxSize, BlockingQueue blockingQueue, RejectedExecutionHandler rejectedExecutionHandler) {
        super(corePoolSize, maxSize, 30, TimeUnit.SECONDS,
                blockingQueue, new ThreadNameFactory(name), rejectedExecutionHandler);
    }

    public void executeWork(AbstractWork work) {
        execute(work);
    }

}