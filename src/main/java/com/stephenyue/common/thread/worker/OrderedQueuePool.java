package com.stephenyue.common.thread.worker;

import java.util.concurrent.ConcurrentHashMap;


public class OrderedQueuePool<K, V> {

    private ConcurrentHashMap<K, TaskQueue<V>> map = new ConcurrentHashMap<K, TaskQueue<V>>();

    /**
     * 获得任务队列
     *
     * @param key
     * @return
     */
    public TaskQueue<V> getTaskQueue(K key) {
        TaskQueue<V> queue = map.get(key);

        if (queue == null) {
            TaskQueue<V> newQueue = new TaskQueue<V>();
            queue = map.putIfAbsent(key, newQueue);
            if (queue == null) {
                queue = newQueue;
            }
        }

        return queue;
    }

    /**
     * 获得全部任务队列
     * @return
     */
    public ConcurrentHashMap<K, TaskQueue<V>> getTaskQueues() {
        return map;
    }

    /**
     * 移除任务队列
     *
     * @param key
     * @return
     */
    public void removeTaskQueue(K key) {
        map.remove(key);
    }
}
