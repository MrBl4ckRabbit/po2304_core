package lesson30._04_order;

public class Main {
    //private static volatile boolean running;
    private static boolean running;

    public static void main(String[] args) {
        var t1 = new Thread(() -> {
            while (!running) {
            }
            System.out.print("You ");
        });
//        t1.setPriority(10);
        var t2 = new Thread(() -> {
            running = true;
            System.out.print("I love ");

        });
//        t2.setPriority(1);

        t1.start();
        t2.start();
    }
}
