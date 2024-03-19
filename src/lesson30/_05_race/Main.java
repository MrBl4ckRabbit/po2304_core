package lesson30._05_race;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        var ba = new BankAccount(100);
        var t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                ba.deposit(100);
            }
        });
        var t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                ba.withdraw(100);
            }
        });

        t1.start();
        t2.start();
//        t1.join();
//        t2.join();
        System.out.println(ba);
    }
}
