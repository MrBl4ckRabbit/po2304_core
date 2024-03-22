package lesson30._07_stop;

import lombok.SneakyThrows;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        var r = new MyRunnable();
        var t = new Thread(r);
        t.start();

        Thread.sleep(10 * 1000);
        r.doStop();
    }
}
