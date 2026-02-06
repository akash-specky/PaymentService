package payClass;

import factory.*;
import services.Payment;
import services.PaymentType;

public class PaymentGateway {

    private static PaymentGateway instance;
    private PaymentGateway() {}


    public static PaymentGateway getInstance() {
        if (instance == null) {
            synchronized (PaymentGateway.class) {
                if (instance == null) {
                    instance = new PaymentGateway();
                }
            }
        }
        return instance;
    }

    public void processPayment(
            PaymentType paymentType,
            double amount,
            Account sender,
            Account receiver,
            String receiverDetails) {

        Payment payment = switch (paymentType) {
            case CREDIT_CARD -> PaymentFactory.createPayment(
                    new CreditCardProcessFactory());
            case UPI -> PaymentFactory.createPayment(
                    new UpiProcessorFactory());
            case NET_BANKING -> PaymentFactory.createPayment(
                    new NetBankingProcessFactory());
            default -> throw new IllegalArgumentException("Invalid Payment Type");
        };

        payment.validate(receiverDetails);
        payment.pay(sender, receiver, amount);
    }

}
