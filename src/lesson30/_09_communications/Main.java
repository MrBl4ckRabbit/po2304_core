package lesson30._09_communications;

public class Main {
    public static void main(String[] args) {
        var myQueue = new MyQueue();
        var consumer = new Consumer(myQueue);
        var producer = new Producer(myQueue);

        var t1 = new Thread(consumer);
        var t2 = new Thread(producer);

        t1.start();
        t2.start();
    }
}
