public class Bank {
    static int money = 7000;
    private Object lock = new Object();

    static public int getMoney() {
        return money;
    }

    void take(int money) {
        synchronized (lock) {
            Bank.money -= money;
        }
    }

    void replay(int money) {
        synchronized (lock) {
            Bank.money += money;
        }
    }

    class Client extends Thread{
        @Override
                public void run() {
            while (true) {
                take(500);
                replay(500);
            }
        }
    }

    public Bank() {
        new Client().start();
        new Client().start();
        new Client().start();
    }
}
