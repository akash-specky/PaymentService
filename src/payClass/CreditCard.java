package payClass;

import services.Payment;

public class CreditCard  implements Payment  {



    @Override
    public void pay(Account sender, Account receiver, double amount) {
        sender.debit(amount);
        receiver.credit(amount);
        System.out.println("Paid via CreditCard");
    }

    @Override
    public void validate(String card) {
        if (card.length() != 16)
            throw new RuntimeException("Invalid Card Number");
    }
}
