/*
 * A test to determine if BankAccount had been successfully debugged
 */

public class TestBankAccount {
    public static void main(String args [])
    {
        /* Create a new account with no balance */
        BankAccount account1 = new BankAccount (1, "John Doe");
        /* Create a new account with non zero balance */ BankAccount
            account2 = new BankAccount (2, "Michael", 1000);
        System.out.println("Before Deposit");
        System.out.println("‐‐‐‐‐‐‐‐‐‐‐‐‐‐");
        account1.display(); account1.deposit(100);
        System.out.println("After Deposit");
        System.out.println("‐‐‐‐‐‐‐‐‐‐‐‐‐");
        account1.display(); System.out.println("");
        System.out.println("Before Withdrawal");
        System.out.println("‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐");
        account2.display();
        account2.withdraw(800);
        System.out.println("After Withdrawal");
        System.out.println("‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐");
        account2.display(); System.out.println("");
        System.out.println("After Transfer");
        System.out.println("‐‐‐‐‐‐‐‐‐‐‐‐‐‐");
        account2.transfer(account1,50);
        account1.display();
        account2.display();
    }
}
