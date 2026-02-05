package factory;

import services.Payment;

abstract public class PaymentProcessFactory {

   public abstract Payment createPaymentMethod();


}
