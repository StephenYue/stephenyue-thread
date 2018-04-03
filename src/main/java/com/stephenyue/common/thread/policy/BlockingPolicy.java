package com.stephenyue.common.thread.policy;

import com.stephenyue.common.thread.Loggers;
import org.slf4j.Logger;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 阻塞
 */

public class BlockingPolicy implements RejectedExecutionHandler {
    private static final Logger logger = Loggers.threadLogger;

    private String threadName;

    public BlockingPolicy() {
        this(null);
    }

    public BlockingPolicy(String threadName) {
        this.threadName = threadName;
    }

    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor executor) {
        if (threadName != null) {
            logger.error("Thread pool [{}] is exhausted, executor={}", threadName, executor.toString());
        }

        if (!executor.isShutdown()) {
            try {
                executor.getQueue().put(runnable);
            } catch (InterruptedException e) {
            }
        }
    }
}