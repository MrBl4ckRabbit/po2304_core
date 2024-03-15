package lesson30._02_creation;

public class Main1 {
    public static void main(String[] args) {
        var t1 = new Thread(() -> {
            System.out.println("Lambda from " + Thread.currentThread());
        });

        var t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable from " + Thread.currentThread());
            }
        });

        t1.start();
        t2.start();
    }
}
