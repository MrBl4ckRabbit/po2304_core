package lesson30._07_stop;

import lombok.SneakyThrows;

public class MyRunnable implements Runnable {
    private boolean doStop = false;

    public synchronized void doStop() {
        doStop = true;
    }

    private synchronized boolean keepRunning() {
        return !doStop;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (keepRunning()){
            System.out.println("I'm running!");
            Thread.sleep(3000);
        }
    }
}
