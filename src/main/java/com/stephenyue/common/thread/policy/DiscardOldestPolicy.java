package com.stephenyue.common.thread.policy;

import com.stephenyue.common.thread.Loggers;
import org.slf4j.Logger;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 从队列里面抛弃head的一个任务，并再次execute 此task。
 */
public class DiscardOldestPolicy extends ThreadPoolExecutor.DiscardOldestPolicy {
    private static final Logger logger = Loggers.threadLogger;

    private String threadName;

    public DiscardOldestPolicy() {
        this(null);
    }

    public DiscardOldestPolicy(String threadName) {
        this.threadName = threadName;
    }

    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor executor) {
        if (threadName != null) {
            logger.error("Thread pool [{}] is exhausted, executor={}", threadName, executor.toString());
        }

        super.rejectedExecution(runnable, executor);
    }
}

