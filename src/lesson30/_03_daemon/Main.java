package lesson30._03_daemon;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        var daemon = new DaemonThread();
        daemon.setDaemon(true);
        daemon.start();
//        daemon.join();
        System.out.println("Last code string");
    }
}
