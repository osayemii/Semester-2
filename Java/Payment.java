public interface Payment {
    abstract void makePayment(double amount);
}

// implement using cash payment
class CashPayment implements Payment {
    @Override
    public void makePayment(double amount) {
        System.out.println("Paid " + amount + " using cash.");
    }
}

// implement using card payment
class CardPayment implements Payment {
    @Override
    public void makePayment(double amount) {
        System.out.println("Paid " + amount + " using card.");
    }
}

// implement using online payment
class OnlinePayment implements Payment {
    @Override
    public void makePayment(double amount) {
        System.out.println("Paid " + amount + " using online payment.");
    }
}