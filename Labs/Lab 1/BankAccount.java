/*
 * The professor provided a bug filled BankAccount class which was to be debugged.
 * This is the result.
 */

public class BankAccount {

    private int accntNo;
    private String custName;
    private double balance;

    /* Constructor for creating a Bank Account with zero balance */
    public BankAccount(int newAccntNo, String newCustName)
    {
        this.accntNo = newAccntNo;
        this.custName = newCustName;
        this.balance = 0.0;
    }

    /* Constructor for creating a Bank Account with non‐zero balance */
    public BankAccount(int newAccntNo, String newCustName, double newBal)
    {
        this.accntNo = newAccntNo;
        this.custName = newCustName;
        this.balance = newBal;
    }

    /* Method to make a deposit to an account */
    public void deposit (double amount)
    {
        /* Validate the amount being deposited */
        if (amount > 0.0)
            balance += amount;
        else
            System.out.println("Transaction Unsuccessful!");
    }

    /* Method to make a withdrawal from an account */
    public void withdraw (double amount)
    {
        /* Validate the amount being deposited. The balance should be more than the withdrawal amount */
        if (amount > 0.0 && amount <= balance)
            this.balance -= amount;
        else
            System.out.println("Transaction Unsuccessful!");
    }

    /* Method to transfer an amount from one account to another */
    public void transfer (BankAccount destAccnt, double amount)
    {
        /* Validate the amount being deposited. The balance should be more than the withdrawal amount */
        if (amount > 0.0 && amount <= this.balance)
        {
            /* The amount will be deposited to the specified destination account */
            destAccnt.deposit(amount);
            /* The amount will be withdrawn from the source account that has initiated the transfer*/
            /* 'this' refers to the calling object (the one whose name appeared in front of the dot in the method call) */
            this.withdraw(amount);
        }
        else
            System.out.println("Transaction Unsuccessful!");
    }
    /* Method to display the status of the account */
    public void display()
    {
        System.out.println("Account Number: " + accntNo);
        System.out.println("Customer Name: " + custName);
        System.out.println("Balance: $" + balance);
    }
}
