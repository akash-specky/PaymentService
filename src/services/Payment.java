package services;

import payClass.Account;

public interface Payment {

    void pay(Account sender, Account receiver,double amount);
    void validate(String receiverDetails);
}
