public class BankAccount {
    private int accountBalance = 1000;

    public int getAccountBalance() {
        return accountBalance;
    }

    public void withdraw(int amount) {
        if (amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("Withdrawal: " + amount + "," + "\nBalance: " + accountBalance);
        } else {
            System.out.println("Insufficient Balance: " + accountBalance);
        }
    }

    public static void main(String[] args) throws InterruptedException{
        BankAccount user1 = new BankAccount();

        Thread t1 = new Thread(() -> {
            user1.withdraw(700);
        });
        Thread t2 = new Thread(() -> {
            user1.withdraw(700);
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(user1.getAccountBalance());
    }
}