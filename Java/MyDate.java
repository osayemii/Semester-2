import java.util.*;
import java.util.Date;
import java.util.Random;

public class MyDate {
    public static void main(String[] args) {
        Date date = new Date();
        Date specificDate = new Date(2020 - 1900, 0, 1); // January 1, 2020
        System.out.println("Specific Date: " + specificDate);
        System.out.println("Current Date: " + date);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(specificDate);
        System.out.println("Year: " + calendar.getTime());

        Random random = new Random();
        System.out.println("Random Number: " + random.nextInt(6));
    }

    public interface Bank {
        void openAccount();
        void closeAccount();
        double getBalance();
        void deposit(double amount);
        void withdraw(double amount);
    }

    class MyBank implements Bank {
        private double balance;

        @Override
        public void openAccount() {
            balance = 0;
            System.out.println("Account opened.");
        }

        @Override
        public void closeAccount() {
            balance = 0;
            System.out.println("Account closed.");
        }

        @Override
        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited: " + amount);
            } else {
                System.out.println("Deposit amount must be positive.");
            }
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrew: " + amount);
            } else {
                System.out.println("Invalid withdrawal amount.");
            }
        }
    }
}