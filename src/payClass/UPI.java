package payClass;

import services.Payment;

public class UPI implements Payment {


    @Override
    public void pay(Account sender, Account receiver, double amount) {
        sender.debit(amount);
        receiver.credit(amount);
        System.out.println("Paid via UPI");
    }

    @Override
    public void validate(String upiId) {
        if (!upiId.contains("@"))
            throw new RuntimeException("Invalid UPI ID");
    }
}
