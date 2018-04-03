package com.stephenyue.common.thread.worker;

public abstract class AbstractWork implements Runnable {

    private TaskQueue<AbstractWork> taskQueue;

    public TaskQueue<AbstractWork> getTaskQueue() {
        return taskQueue;
    }

    public void setTaskQueue(TaskQueue<AbstractWork> taskQueue) {
        this.taskQueue = taskQueue;
    }
}