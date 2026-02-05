package payClass;

import factory.CreditCardProcessFactory;
import factory.PaymentFactory;
import factory.PaymentProcessFactory;
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

    public void processPayment(PaymentType paymentType,double amount,Account sender,Account receiver,String receiverDetails) {
        Payment payment = PaymentFactory.getPayment(paymentType);
//        Payment payment4 = PaymentFactory.createEmployee(new CreditCardProcessFactory());
        payment.validate(receiverDetails);
        payment.pay(sender,receiver,amount);
//        payment4.pay(sender,receiver,amount);

    }
}
