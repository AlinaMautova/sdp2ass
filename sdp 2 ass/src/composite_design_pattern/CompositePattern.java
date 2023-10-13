package composite_design_pattern;

import java.util.ArrayList;
import java.util.List;

// An abstract class representing an account with a getBalance method
abstract class Account {
    public abstract float getBalance();
}

// A concrete class representing a deposit account, which is an individual account
class DepositAccount extends Account {
    private String accountNo;
    private float accountBalance;

    public DepositAccount(String accountNo, float accountBalance) {
        super();
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    public float getBalance() {
        return accountBalance;
    }
}

// A concrete class representing a savings account, which is another individual account
class SavingsAccount extends Account {
    private String accountNo;
    private float accountBalance;

    public SavingsAccount(String accountNo, float accountBalance) {
        super();
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    public float getBalance() {
        return accountBalance;
    }
}

// A composite class representing a group of accounts (composite of accounts)
class CompositeAccount extends Account {
    private float totalBalance;
    private List<Account> accountList = new ArrayList<Account>();

    public float getBalance() {
        totalBalance = 0;
        for (Account account : accountList) {
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }

    public void addAccount(Account account) {
        accountList.add(account);
    }

    public void removeAccount(Account account) {
        accountList.remove(account);
    }
}

public class CompositePattern {
    public static void main(String[] args) {
        // Create a composite account
        CompositeAccount composite = new CompositeAccount();

        // Add individual deposit and savings accounts to the composite account
        composite.addAccount(new DepositAccount("DA001", 100));
        composite.addAccount(new DepositAccount("DA002", 150));
        composite.addAccount(new SavingsAccount("SA001", 200));

        // Calculate and print the total balance of the composite account
        float totalBalance = composite.getBalance();
        System.out.println("Total Balance: " + totalBalance);
    }
}
