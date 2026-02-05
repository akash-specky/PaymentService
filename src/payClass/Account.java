package payClass;


public class Account {
    private final String accountId;
    private double balance;
    private final User user;

    private Account(AccountBuilder builder) {
        this.accountId = builder.accountId;
        this.balance = builder.balance;
        this.user = builder.user;
    }

    public synchronized void debit(double amount) {
        if (balance < amount) {
            throw new RuntimeException("Insufficient balance");
        }
        balance -= amount;
    }

    public synchronized void credit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    static public class AccountBuilder {
        private String accountId;
        private double balance;
        private User user;

        public AccountBuilder(){}

        public AccountBuilder accountId(String accountId) {
            this.accountId = accountId;
            return this;
        }

        public AccountBuilder balance(double balance) {
            this.balance = balance;
            return this;
        }

        public AccountBuilder user(User user) {
            this.user = user;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }
}
