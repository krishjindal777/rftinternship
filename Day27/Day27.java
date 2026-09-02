import java.util.ArrayList;
import java.util.Scanner;

public class Day27 {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Customer> customers = new ArrayList<>();
    static ArrayList<Account> accounts = new ArrayList<>();

    static int customerId = 1;
    static int accountNumber = 1001;

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== DIGITAL BANKING DASHBOARD =====");
            System.out.println("1. Customer Registration");
            System.out.println("2. Create Account");
            System.out.println("3. Account Summary");
            System.out.println("4. Fund Transfer");
            System.out.println("5. Mini Statement");
            System.out.println("6. Transaction History");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    registerCustomer();
                    break;

                case 2:
                    createAccount();
                    break;

                case 3:
                    accountSummary();
                    break;

                case 4:
                    fundTransfer();
                    break;

                case 5:
                    miniStatement();
                    break;

                case 6:
                    transactionHistory();
                    break;

                case 7:
                    System.out.println("Thank you for using Digital Banking.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }


    // Customer Registration

    public static void registerCustomer() {

        sc.nextLine();

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter phone: ");
        String phone = sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        Customer customer =
                new Customer(customerId, name, phone, email);

        customers.add(customer);

        System.out.println("Customer registered successfully.");
        System.out.println("Customer ID: " + customerId);

        customerId++;
    }


    // Create Account

    public static void createAccount() {

        if (customers.size() == 0) {
            System.out.println("Please register a customer first.");
            return;
        }

        System.out.print("Enter Customer ID: ");
        int id = sc.nextInt();

        Customer customer = findCustomer(id);

        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.print("Enter initial deposit: ");
        double money = sc.nextDouble();

        if (money < 0) {
            System.out.println("Invalid amount.");
            return;
        }

        Account account =
                new Account(accountNumber, id, money);

        accounts.add(account);

        System.out.println("Account created successfully.");
        System.out.println("Account Number: " + accountNumber);

        accountNumber++;
    }


    // Find Customer

    public static Customer findCustomer(int id) {

        for (Customer c : customers) {

            if (c.customerId == id) {
                return c;
            }
        }

        return null;
    }


    // Find Account

    public static Account findAccount(int number) {

        for (Account a : accounts) {

            if (a.accountNumber == number) {
                return a;
            }
        }

        return null;
    }


    // Account Summary

    public static void accountSummary() {

        System.out.print("Enter account number: ");
        int number = sc.nextInt();

        Account account = findAccount(number);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        Customer customer = findCustomer(account.customerId);

        System.out.println("\n===== ACCOUNT SUMMARY =====");

        System.out.println("Customer ID : " + customer.customerId);
        System.out.println("Name        : " + customer.name);
        System.out.println("Phone       : " + customer.phone);
        System.out.println("Email       : " + customer.email);

        System.out.println("Account No  : " + account.accountNumber);
        System.out.println("Balance     : " + account.balance);
    }


    // Fund Transfer

    public static void fundTransfer() {

        System.out.print("Enter your account number: ");
        int fromNumber = sc.nextInt();

        System.out.print("Enter receiver account number: ");
        int toNumber = sc.nextInt();

        Account fromAccount = findAccount(fromNumber);
        Account toAccount = findAccount(toNumber);

        if (fromAccount == null) {
            System.out.println("Sender account not found.");
            return;
        }

        if (toAccount == null) {
            System.out.println("Receiver account not found.");
            return;
        }

        if (fromNumber == toNumber) {
            System.out.println("Cannot transfer money to same account.");
            return;
        }

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        if (fromAccount.balance < amount) {
            System.out.println("Insufficient balance.");
            return;
        }

        fromAccount.balance =
                fromAccount.balance - amount;

        toAccount.balance =
                toAccount.balance + amount;

        Transaction transaction =
                new Transaction(
                        "TRANSFER",
                        amount,
                        fromNumber,
                        toNumber
                );

        fromAccount.transactions.add(transaction);
        toAccount.transactions.add(transaction);

        System.out.println("Fund transfer successful.");
    }


    // Mini Statement

    public static void miniStatement() {

        System.out.print("Enter account number: ");
        int number = sc.nextInt();

        Account account = findAccount(number);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.println("\n===== MINI STATEMENT =====");

        if (account.transactions.size() == 0) {
            System.out.println("No transactions found.");
        } else {

            int count = 0;

            for (int i = account.transactions.size() - 1;
                 i >= 0 && count < 5;
                 i--) {

                account.transactions.get(i).showTransaction();

                count++;
            }
        }

        System.out.println("Current Balance: " + account.balance);
    }


    // Transaction History

    public static void transactionHistory() {

        System.out.print("Enter account number: ");
        int number = sc.nextInt();

        Account account = findAccount(number);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.println("\n===== TRANSACTION HISTORY =====");

        if (account.transactions.size() == 0) {
            System.out.println("No transactions found.");
            return;
        }

        for (Transaction transaction : account.transactions) {

            transaction.showTransaction();
        }
    }


    // Customer Class

    static class Customer {

        int customerId;
        String name;
        String phone;
        String email;

        Customer(int customerId, String name,
                 String phone, String email) {

            this.customerId = customerId;
            this.name = name;
            this.phone = phone;
            this.email = email;
        }
    }


    // Account Class

    static class Account {

        int accountNumber;
        int customerId;
        double balance;

        ArrayList<Transaction> transactions =
                new ArrayList<>();

        Account(int accountNumber, int customerId,
                double balance) {

            this.accountNumber = accountNumber;
            this.customerId = customerId;
            this.balance = balance;
        }
    }


    // Transaction Class

    static class Transaction {

        String type;
        double amount;
        int fromAccount;
        int toAccount;

        Transaction(String type, double amount,
                    int fromAccount, int toAccount) {

            this.type = type;
            this.amount = amount;
            this.fromAccount = fromAccount;
            this.toAccount = toAccount;
        }

        public void showTransaction() {

            System.out.println(
                    type +
                    " | Amount: " + amount +
                    " | From: " + fromAccount +
                    " | To: " + toAccount
            );
        }
    }
}