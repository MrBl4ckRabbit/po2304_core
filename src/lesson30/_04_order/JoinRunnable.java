package lesson30._04_order;

import lombok.SneakyThrows;

public class JoinRunnable extends Thread {
    public JoinRunnable(String name) {
        super(name);
    }

    @SneakyThrows
    @Override
    public void run() {
        var currentThreatName = Thread.currentThread().getName();
        for (int i = 0; i < 10; i++) {
            System.out.println(currentThreatName + " Is running " + i);
//            Thread.sleep(500);
            Thread.yield();
        }
        System.out.println(currentThreatName + " Complete");
    }
}
