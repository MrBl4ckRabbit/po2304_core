package lesson30._09_communications;

import lombok.SneakyThrows;

public class MyQueue {
    private int n;
    private boolean valueSet = false;

    @SneakyThrows
    public synchronized int get() {
        while (!valueSet) {
            wait();
        }
        System.out.println("Got: " + n);
        valueSet = false;
        notify();
        return n;
    }

    @SneakyThrows
    public synchronized void put(int n) {
        while (valueSet) {
            wait();
        }
        valueSet = true;
        this.n = n;
        System.out.println("Sent: " + n);
        notify();
    }
}
