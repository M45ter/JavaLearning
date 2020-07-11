package com.zey.concurrency.thread;

public class RunnableWay implements Runnable {
    @Override
    public void run() {
        System.out.println("实现Runnable接口实现线程 " + Thread.currentThread().getName());
    }
}
