package com.stephenyue.common.thread.policy;

import com.stephenyue.common.thread.Loggers;
import org.slf4j.Logger;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池默认的阻塞策略，不执行此任务，而且直接抛出一个运行时异常。
 * 切记ThreadPoolExecutor.execute需要try catch，否则程序会直接退出
 */
public class AbortPolicy extends ThreadPoolExecutor.AbortPolicy {
    private static final Logger logger = Loggers.threadLogger;

    private String threadName;

    public AbortPolicy() {
        this(null);
    }

    public AbortPolicy(String threadName) {
        this.threadName = threadName;
    }

    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor executor) {
        if (threadName != null) {
            logger.error("Thread pool [{}] is exhausted, executor={}", threadName, executor.toString());
        }

        String msg = String.format("Server["
                        + " Thread Name: %s, Pool Size: %d (active: %d, core: %d, max: %d, largest: %d), Task: %d (completed: %d),"
                        + " Executor status:(isShutdown:%s, isTerminated:%s, isTerminating:%s)]",
                threadName, executor.getPoolSize(), executor.getActiveCount(), executor.getCorePoolSize(), executor.getMaximumPoolSize(), executor.getLargestPoolSize(),
                executor.getTaskCount(), executor.getCompletedTaskCount(), executor.isShutdown(), executor.isTerminated(), executor.isTerminating());

        logger.error(msg);
        super.rejectedExecution(runnable, executor);
    }
}
