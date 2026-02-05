package factory;

import payClass.NetBanking;
import services.Payment;

public class NetBankingProcessFactory extends   PaymentProcessFactory {
    @Override
    public Payment createPaymentMethod() {
        System.out.println("Creating NetBanking Payment");
        return new NetBanking();
    }
}
