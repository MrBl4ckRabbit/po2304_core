package lesson30._06_deadlock;

import lombok.SneakyThrows;

public class TestThread {
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) {
        var t1 = new ThreatDemo1();
        var t2 = new ThreatDemo2();

        t1.start();
        t2.start();
    }

    private static class ThreatDemo1 extends Thread {
        @SneakyThrows
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("Threat 1: Holding lock1...");
                Thread.sleep(10);
                System.out.println("Threat 1: Waiting for lock2");
                synchronized (lock2) {
                    System.out.println("Threat 1: Holding lock1 and lock2...");
                }
            }
        }
    }

    private static class ThreatDemo2 extends Thread {
        @SneakyThrows
        @Override
        public void run() {
            synchronized (lock2) {
                System.out.println("Threat 2: Holding lock2...");
                Thread.sleep(10);
                System.out.println("Threat 2: Waiting for lock1");
                synchronized (lock1) {
                    System.out.println("Threat 2: Holding lock1 and lock2...");
                }
            }
        }
    }
}
