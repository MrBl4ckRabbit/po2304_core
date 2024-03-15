package lesson30._02_creation;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Running from " + Thread.currentThread());
        System.out.println("Hello from Runnable");
    }
}
