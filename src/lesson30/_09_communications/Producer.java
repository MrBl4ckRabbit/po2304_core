package lesson30._09_communications;

public class Producer implements Runnable {
    private MyQueue myQueue;

    public Producer(MyQueue myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        for (var i = 0; i < 10; i++) {
            myQueue.put(i);
        }
    }
}
