import java.util.Scanner;

class BankAccount {
    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void displayBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Current Balance: ₹" + balance);
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = null;
        int choice;

        do {
            System.out.println("\n===== Bank Management System =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    if (account == null) {
                        System.out.print("Enter Account Holder Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Initial Deposit: ₹");
                        double initialDeposit = scanner.nextDouble();
                        account = new BankAccount(name, initialDeposit);
                        System.out.println("Account Created Successfully!");
                    } else {
                        System.out.println("Account already exists.");
                    }
                    break;
                case 2:
                    if (account != null) {
                        System.out.print("Enter Deposit Amount: ₹");
                        double amount = scanner.nextDouble();
                        account.deposit(amount);
                    } else {
                        System.out.println("No account found. Create an account first.");
                    }
                    break;
                case 3:
                    if (account != null) {
                        System.out.print("Enter Withdrawal Amount: ₹");
                        double amount = scanner.nextDouble();
                        account.withdraw(amount);
                    } else {
                        System.out.println("No account found. Create an account first.");
                    }
                    break;
                case 4:
                    if (account != null) {
                        account.displayBalance();
                    } else {
                        System.out.println("No account found. Create an account first.");
                    }
                    break;
                case 5:
                    System.out.println("Thank you for using our Bank System!");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
