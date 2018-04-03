package com.stephenyue.common.thread.factory;

import com.stephenyue.common.thread.policy.*;

import java.util.concurrent.*;

/**
 *
 */
public class CommonThreadPoolRejectedPolicyFactory {

    public RejectedExecutionHandler createPolicy(RejectedPolicyType rejectedPolicyType) {
        return createPolicy(rejectedPolicyType, null);
    }

    public RejectedExecutionHandler createPolicy(RejectedPolicyType rejectedPolicyType, String threadName) {

        switch (rejectedPolicyType) {
            case BLOCKING_POLICY:
                return new BlockingPolicy(threadName);
            case CALLER_RUNS_POLICY:
                return new CallerRunsPolicy(threadName);
            case ABORT_POLICY:
                return new AbortPolicy(threadName);
            case DISCARD_POLICY:
                return new DiscardPolicy(threadName);
            case DISCARD_OLDEST_POLICY:
                return new DiscardOldestPolicy(threadName);
        }

        return null;
    }
}

