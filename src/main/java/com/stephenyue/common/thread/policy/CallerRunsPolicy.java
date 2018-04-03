package com.stephenyue.common.thread.policy;

import com.stephenyue.common.thread.Loggers;
import org.slf4j.Logger;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 在调用execute的线程里面执行此command，会阻塞入口
 */
public class CallerRunsPolicy extends ThreadPoolExecutor.CallerRunsPolicy {
    private static final Logger logger = Loggers.threadLogger;

    private String threadName;

    public CallerRunsPolicy() {
        this(null);
    }

    public CallerRunsPolicy(String threadName) {
        this.threadName = threadName;
    }

    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor executor) {
        if (threadName != null) {
            logger.error("Thread pool [{}] is exhausted, executor={}", threadName, executor.toString());
        }

        super.rejectedExecution(runnable, executor);
    }
}