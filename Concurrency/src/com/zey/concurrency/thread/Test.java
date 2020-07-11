package com.zey.concurrency.thread;

import java.util.concurrent.*;

public class Test {

    public static void main(String[] args) {
        //实现线程
        //方式一
        new Thread(new RunnableWay()).start();
        //方式二
        new ThreadWay().start();
        //方式三
//        ExecutorService service = Executors.newFixedThreadPool(10);
//        Future<Integer> future = service.submit(new CallableWay());
        FutureTask<Integer> futureTask = new FutureTask<>(new CallableWay());
        new Thread(futureTask).start();
        //方式四
        //线程池 本质上还是new Thread
        //...
        //实现线程本质上都是实现Runnable接口或者继承Thread类
        //再提升，本质都是构造Thread类
//        实现Runnable接口要比继承Thread要更好
//        1.可以把不同的内容进行解耦，权责分明
//        2.某些情况下可以提升性能，减小开销（创建Thead开销比较大）
//        3.继承Thread类相当于限制了代码未来的可扩展性
    }
}
