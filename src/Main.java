import payClass.Account;
import payClass.PaymentGateway;
import payClass.User;
import services.PaymentType;

import java.util.Scanner;
import java.util.UUID;



      void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter Sender Name:");
        String senderName = input.nextLine();

        System.out.println("Enter Sender Address:");
        String senderAddress = input.nextLine();

        System.out.println("Enter Sender Email:");
        String senderEmail = input.nextLine();

        System.out.println("Enter Sender Initial Balance:");
        double senderBalance = input.nextDouble();
        input.nextLine();

        User senderUser = new User.UserBuilder()
                .setUserId(UUID.randomUUID().toString())
                .setName(senderName)
                .setAddress(senderAddress)
                .setEmail(senderEmail)
                .build();

        Account senderAccount = new Account.AccountBuilder()
                .accountId(UUID.randomUUID().toString())
                .user(senderUser)
                .balance(senderBalance)
                .build();

        System.out.println("\nEnter Receiver Name:");
        String receiverName = input.nextLine();

        System.out.println("Enter Receiver Address:");
        String receiverAddress = input.nextLine();

        System.out.println("Enter Receiver Email:");
        String receiverEmail = input.nextLine();

        System.out.println("Enter Receiver Initial Balance:");
        double receiverBalance = input.nextDouble();
        input.nextLine();

        User receiverUser = new User.UserBuilder()
                .setUserId(UUID.randomUUID().toString())
                .setName(receiverName)
                .setAddress(receiverAddress)
                .setEmail(receiverEmail)
                .build();

        Account receiverAccount = new Account.AccountBuilder()
                .accountId(UUID.randomUUID().toString())
                .user(receiverUser)
                .balance(receiverBalance)
                .build();

        System.out.println("\nSelect Payment Type:");
        System.out.println("1. UPI");
        System.out.println("2. NETBANKING");
        System.out.println("3. CREDIT_CARD");

        int choice = input.nextInt();

        PaymentType paymentType;
        switch (choice) {
            case 1:
                paymentType = PaymentType.UPI;
                break;
            case 2:
                paymentType = PaymentType.NET_BANKING;
                break;
            case 3:
                paymentType = PaymentType.CREDIT_CARD;
                break;
            default:
                throw new IllegalArgumentException("Invalid payment option");
        }
        System.out.println("Enter Receiver Details:");
        input.nextLine();
        String receiverDetails = input.nextLine();
        System.out.println("Enter Amount to Transfer:");
        double amount = input.nextDouble();

        PaymentGateway gateway = PaymentGateway.getInstance();

        try {
            gateway.processPayment(paymentType, amount, senderAccount, receiverAccount, receiverDetails);
            System.out.println("\n Payment Successful!");
        } catch (Exception e) {
            System.out.println("\n Payment Failed: " + e.getMessage());
        }

        System.out.println("\nFinal Balances:");
        System.out.println("Sender Balance: " + senderAccount.getBalance());
        System.out.println("Receiver Balance: " + receiverAccount.getBalance());
    }

