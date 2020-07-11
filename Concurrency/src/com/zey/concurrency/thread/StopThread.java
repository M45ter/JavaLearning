package com.zey.concurrency.thread;

/**
 * 正确中断线程调用interrupt方法发出中断信号，线程检测中断信号，自己决定如何处理
 */
public class StopThread implements Runnable {
    @Override
    public void run() {
        int count = 0;
        while (!Thread.currentThread().isInterrupted() && count < 1000) {
            System.out.println("count = " + count++);

            //当在一个被阻塞的线程（调用sleep或wait等会让线程阻塞的方法）上调用interrupt方法时
            //阻塞调用将会被InterruptedException异常中断，并将中断标记位设置成false
            /*try {
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException异常 isInterrupted = " + Thread.currentThread().isInterrupted());
                e.printStackTrace();
            }*/
            //InterruptedException异常的处理
            //1.直接处理异常或者方法签名声明抛出异常
            //2.catch中手动再次中断线程 Thread.currentThread().interrupt();

            //用volatile boolean标志去中断线程是错误的原因，线程被阻塞时无法及时感知标志修改
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new StopThread());
        thread.start();
        Thread.sleep(5);
        thread.interrupt();
    }
}
