package lesson30._09_communications;

public class Consumer implements Runnable {
    private MyQueue myQueue;

    public Consumer(MyQueue myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        for (var i = 0; i < 10; i++) {
            myQueue.get();
        }
    }
}
