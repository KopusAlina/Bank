public class Bank {
    static int money = 7000;

    static public int getMoney() {
        return money;
    }

    static synchronized void take(int money) {
        Bank.money -= money;
    }

    static synchronized void replay(int money) {
        Bank.money += money;
    }

    class Client extends Thread{
        @Override
                public void run() {
            while (true) {
                take(1000);
                replay(1000);
            }
        }
    }

    public Bank() {
        new Client().start();
        new Client().start();
        new Client().start();
    }
}
