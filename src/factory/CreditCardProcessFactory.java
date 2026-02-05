package factory;

import payClass.CreditCard;
import services.Payment;

public class CreditCardProcessFactory extends PaymentProcessFactory {
    @Override
    public Payment createPaymentMethod() {
        System.out.println("Creating CreditCard Process");
        return new CreditCard();
    }

}
