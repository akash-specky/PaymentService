package factory;

import payClass.CreditCard;
import payClass.NetBanking;
import payClass.UPI;
import services.Payment;
import services.PaymentType;

import java.util.HashMap;
import java.util.Map;

public class PaymentFactory {

private static Map<PaymentType, Payment> paymentMap = new HashMap<PaymentType, Payment>();



static {
    paymentMap.put(PaymentType.UPI,new UPI());
    paymentMap.put(PaymentType.CREDIT_CARD,new CreditCard());
    paymentMap.put(PaymentType.NET_BANKING,new NetBanking());
}

public static Payment getPayment(PaymentType paymentType) {
    return paymentMap.get(paymentType);
}
    public static Payment createEmployee(PaymentProcessFactory factory){

        return factory.createPaymentMethod();
    }
}
