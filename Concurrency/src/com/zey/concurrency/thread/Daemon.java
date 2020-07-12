package com.zey.concurrency.thread;

public class Daemon {
    private static class UseThread extends Thread {
        @Override
        public void run() {
            try {
                while (!isInterrupted()) {
                    System.out.println(getName() + " is running");
                }
                System.out.println(getName() + " interrupt flag is " + isInterrupted());
            } finally {
                //守护线程中的finally不一定执行
                System.out.println("子线程finally");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UseThread thread = new UseThread();
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(5);
//        thread.interrupt();
        System.out.println("main结束了");
    }
}
