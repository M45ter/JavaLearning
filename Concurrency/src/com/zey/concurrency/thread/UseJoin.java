package com.zey.concurrency.thread;

public class UseJoin {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("正在主线程main");
        Thread thread = new Thread("子线程") {
            @Override
            public void run() {
                System.out.println("子线程开始运行");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程运行结束");
            }
        };
        thread.start();
        //挂起当前线程，执行插队的线程，完成后通知挂起的线程继续执行
        thread.join();
//        thread.join(200);
        System.out.println("回到主线程运行");
    }
}
