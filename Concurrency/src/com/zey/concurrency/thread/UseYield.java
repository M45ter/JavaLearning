package com.zey.concurrency.thread;

/**
 * yield让出cpu，但是可能还是分配原来的线程执行
 */
public class UseYield {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("当前线程为：" + Thread.currentThread().getName() + i);
                    if (i == 5) {
                        System.out.println("当前线程为：" + Thread.currentThread().getName() + "我yield了");
                        Thread.yield();
                    }
                }
            }
        };
        Thread threadA = new Thread(runnable, "A");
        Thread threadB = new Thread(runnable, "B");
        threadA.start();
        threadB.start();
    }
}
