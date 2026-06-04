interface PaymentStrategy {
    boolean processPayment(double amount);
}

class CreditCardStrategy implements PaymentStrategy {

    public boolean processPayment(double amount) {
        System.out.println("Processing credit card payment: " + amount);
        return true;
    }
}

class CryptoStrategy implements PaymentStrategy {

    public boolean processPayment(double amount) {
        System.out.println("Processing crypto payment: " + amount);
        return true;
    }
}

class PayPalStrategy implements PaymentStrategy {

    public boolean processPayment(double amount) {
        System.out.println("Processing PayPal payment: " + amount);
        return true;
    }
}

class TransactionProcessor {

    private PaymentStrategy strategy;

    public TransactionProcessor(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeTransaction(double amount) {
        if (strategy.processPayment(amount)) {
            System.out.println("Payment successful");
        } else {
            System.out.println("Payment failed");
        }
    }
}

public class Main4 {
    public static void main(String[] args) {

        TransactionProcessor processor =
                new TransactionProcessor(new CreditCardStrategy());

        processor.executeTransaction(5000);

        processor.setPaymentStrategy(new CryptoStrategy());
        processor.executeTransaction(12000);

        processor.setPaymentStrategy(new PayPalStrategy());
        processor.executeTransaction(3000);
    }
}