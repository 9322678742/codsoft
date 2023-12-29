import java.util.Scanner;

// BankAccount class represents the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

// ATM class represents the ATM machine
class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        this.userAccount = account;
    }

    public void withdraw(double amount) {
        if (userAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful. Remaining balance: " + userAccount.getBalance());
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }

    public void deposit(double amount) {
        userAccount.deposit(amount);
        System.out.println("Deposit successful. New balance: " + userAccount.getBalance());
    }

    public void checkBalance() {
        System.out.println("Current balance: " + userAccount.getBalance());
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a user's bank account with an initial balance of 1000
        BankAccount userAccount = new BankAccount(1000);

        // Create an ATM linked to the user's account
        ATM atmMachine = new ATM(userAccount);

        // Provide a simple console-based UI for the user
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Withdraw\n2. Deposit\n3. Check Balance\n4. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    atmMachine.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    atmMachine.deposit(depositAmount);
                    break;
                case 3:
                    atmMachine.checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting. Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}
