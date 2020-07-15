package com.zey.concurrency.waitnotify;

import java.util.ArrayList;
import java.util.List;

public class Gun {

    private final Object o = new Object();

    private class Bullet {

    }

    private List<Bullet> bullets = new ArrayList<>(20);

    public void addBullet() throws InterruptedException {
        synchronized (o) {
            while (bullets.size() >= 20) {
                o.wait();
            }
            bullets.add(new Bullet());
            o.notifyAll();
            System.out.println("压入一颗子弹 目前数量: " + bullets.size());
        }
    }

    public void shot() throws InterruptedException {
        synchronized (o) {
            while (bullets.size() <= 0) {
                o.wait();
            }
            bullets.remove(0);
            System.out.println("射出一颗子弹 目前数量: " + bullets.size());
            o.notifyAll();
        }
    }

    static class InThread extends Thread {

        private Gun gun;

        public InThread(Gun gun) {
            this.gun = gun;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    gun.addBullet();
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class OutThread extends Thread {
        private Gun gun;

        public OutThread(Gun gun) {
            this.gun = gun;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    gun.shot();
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Gun gun = new Gun();
        new InThread(gun).start();
        new OutThread(gun).start();
    }
}
