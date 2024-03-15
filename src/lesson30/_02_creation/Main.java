package lesson30._02_creation;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Creating the new Thread from " + Thread.currentThread());
        MyThread myThread = new MyThread("My Thread");
        myThread.start();
//        myThread.setPriority(1);
        myThread.join();
        System.out.println("Leaving from " + Thread.currentThread());

        System.out.println("Creating the new Thread from " + Thread.currentThread());
        var myRunnable = new Thread(new MyRunnable(), "My Runnable");
        myRunnable.start();
        myRunnable.join();
        System.out.println("Leaving from " + Thread.currentThread());



    }
}
