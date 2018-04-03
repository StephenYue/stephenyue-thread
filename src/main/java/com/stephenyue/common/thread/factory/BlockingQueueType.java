package com.stephenyue.common.thread.factory;

/**
 * 定义阻塞队列类型
 */
public enum BlockingQueueType {

    LINKED_BLOCKING_QUEUE("LinkedBlockingQueue"),
    ARRAY_BLOCKING_QUEUE("ArrayBlockingQueue"),
    SYNCHRONOUS_QUEUE("SynchronousQueue");

    private String value;

    BlockingQueueType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static BlockingQueueType toType(String value) {
        for (BlockingQueueType type : BlockingQueueType.values()) {
            if (type.getValue().equalsIgnoreCase(value.trim())) {
                return type;
            }
        }

        throw new IllegalArgumentException("Mismatched type with value=" + value);
    }

    public String toString() {
        return value;
    }
}