package lesson30._04_order;

public class Main1 {
    public static void main(String[] args) throws InterruptedException {
        var a = new JoinRunnable("A");
        var b = new JoinRunnable("B");
        var c = new JoinRunnable("C");

        a.start();
        a.join();
        b.start();
//        b.join();
        c.start();


    }
}
