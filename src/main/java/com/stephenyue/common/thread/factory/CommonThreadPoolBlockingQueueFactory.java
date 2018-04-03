package com.stephenyue.common.thread.factory;

import java.util.concurrent.*;

/**
 *  通用线程池队列工厂
 */
public class CommonThreadPoolBlockingQueueFactory {

    public BlockingQueue<Runnable> createBlockingQueue(BlockingQueueType blockingQueueType, int queues) {

        switch (blockingQueueType) {
            case LINKED_BLOCKING_QUEUE:
                return new LinkedBlockingQueue<Runnable>();
            case ARRAY_BLOCKING_QUEUE:
                return new ArrayBlockingQueue<Runnable>(queues);
            case SYNCHRONOUS_QUEUE:
                return new SynchronousQueue<Runnable>();
        }

        return null;
    }
}

