package com.zey.concurrency.thread;

import java.util.Random;
import java.util.concurrent.Callable;

public class CallableWay implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("实现Callable实现线程 " + Thread.currentThread().getName());
        return new Random().nextInt();
    }
}
