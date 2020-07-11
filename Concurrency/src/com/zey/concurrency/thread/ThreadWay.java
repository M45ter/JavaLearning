package com.zey.concurrency.thread;

public class ThreadWay extends Thread {

    @Override
    public void run() {
        System.out.println("继承Thread类实现线程 " + Thread.currentThread().getName());
    }
}
