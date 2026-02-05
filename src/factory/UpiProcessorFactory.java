package factory;

import payClass.UPI;
import services.Payment;

public class UpiProcessorFactory extends PaymentProcessFactory{
    @Override
    public Payment createPaymentMethod() {
        System.out.println("Creating UPI Payment Process");
        return new UPI();
    }
}
