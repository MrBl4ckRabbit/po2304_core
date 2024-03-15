package lesson30._03_daemon;

public class DaemonThread extends Thread{
    @Override
    public void run() {
        try {
            sleep(3000);
            System.out.println("I'm finished...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
