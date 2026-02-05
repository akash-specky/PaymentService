package payClass;

import services.Payment;

public class NetBanking implements Payment {


    @Override
    public void pay(Account sender, Account receiver, double amount) {
        sender.debit(amount);
        receiver.credit(amount);
        System.out.println("Paid via Net Banking");
    }

    @Override
    public void validate(String bankDetails) {
        if (bankDetails.isEmpty())
            throw new RuntimeException("Invalid bank details");
    }
}
