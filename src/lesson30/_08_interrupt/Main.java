package lesson30._08_interrupt;

import lombok.SneakyThrows;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        var t=new Thread(new MyRunnable());
        t.start();
        Thread.sleep(5*1000);
        t.interrupt();
    }
}
