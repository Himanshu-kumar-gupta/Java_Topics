class Account {

    // Final static variable (constant for all instances)
    public static final String BANK_NAME = "National Bank";

    // Final instance variable (unique for each account, but cannot be changed)
    private final String accountNumber;

    // Constructor to initialize the final instance variable
    public Account(String accNumber) {
        this.accountNumber = accNumber;
    }

    // Final method — cannot be overridden by subclasses
    public final void displayAccountType() {
        System.out.println("This is a basic bank account.");
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

class SavingsAccount extends Account {

    public SavingsAccount(String accNumber) {
        super(accNumber);
    }

    // This would cause an error:
    // @Override
    // public void displayAccountType() {
    //     System.out.println("This is a savings account.");
    // }
}

public class FinalUsage1 {
    public static void main(String[] args) {
        Account acc = new Account("1234567890");

        // Access final instance variable
        System.out.println("Account Number: " + acc.getAccountNumber());

        // Access final static variable (class constant)
        System.out.println("Bank Name: " + Account.BANK_NAME);

        // Call final method
        acc.displayAccountType();

        SavingsAccount svacc = new SavingsAccount("567647566");
        System.out.println("Savings Account Number: " + svacc.getAccountNumber());
        svacc.displayAccountType();
    }
}
