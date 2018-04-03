package com.stephenyue.common.thread;


public class TestRunnable2 implements Runnable{
    private int i;

    public TestRunnable2(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(i);
        try {
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
