package com.stephenyue.common.thread.policy;


import com.stephenyue.common.thread.Loggers;
import org.slf4j.Logger;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 直接抛弃，任务不执行，空方法
 */
public class DiscardPolicy extends ThreadPoolExecutor.DiscardPolicy {
    private static final Logger logger = Loggers.threadLogger;

    private final String threadName;

    public DiscardPolicy() {
        this(null);
    }

    public DiscardPolicy(String threadName) {
        this.threadName = threadName;
    }

    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor executor) {
        if (threadName != null) {
            logger.error("hread pool [{}] is exhausted, executor={}", threadName, executor.toString());
        }

        super.rejectedExecution(runnable, executor);
    }
}