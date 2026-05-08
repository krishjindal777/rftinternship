import java.util.ArrayList;
import java.util.Scanner;

// Class to store expense details
class ExpenseData {

    double money;
    String type;
    String expenseDate;

    // Constructor
    ExpenseData(double money, String type, String expenseDate) {
        this.money = money;
        this.type = type;
        this.expenseDate = expenseDate;
    }

    // Method to print expense
    void showData() {
        System.out.println("Expense Amount : ₹" + money);
        System.out.println("Expense Type   : " + type);
        System.out.println("Expense Date   : " + expenseDate);
        System.out.println("------------------------------");
    }
}

// Class to manage all expenses
class TrackerSystem {

    ArrayList<ExpenseData> list = new ArrayList<>();

    // Add new expense
    void addNewExpense(ExpenseData obj) {
        list.add(obj);
        System.out.println("Expense Saved Successfully!");
    }

    // Show all expenses
    void displayExpenses() {

        if (list.isEmpty()) {
            System.out.println("No Expense Available.");
            return;
        }

        System.out.println("\n===== Expense Records =====");

        for (int i = 0; i < list.size(); i++) {
            list.get(i).showData();
        }
    }

    // Find total money spent
    void totalSpent() {

        double sum = 0;

        for (ExpenseData obj : list) {
            sum = sum + obj.money;
        }

        System.out.println("Total Money Spent : ₹" + sum);
    }
}

// Main class
public class Day5  {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        TrackerSystem tracker = new TrackerSystem();

        int option;

        do {

            System.out.println("\n========== Expense Tracker ==========");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Check Total Spending");
            System.out.println("4. Exit");
            System.out.print("Choose Option : ");

            option = input.nextInt();
            input.nextLine();

            if (option == 1) {

                System.out.print("Enter Expense Amount : ");
                double amount = input.nextDouble();
                input.nextLine();

                System.out.print("Enter Expense Category : ");
                String category = input.nextLine();

                System.out.print("Enter Expense Date : ");
                String date = input.nextLine();

                ExpenseData expense = new ExpenseData(amount, category, date);

                tracker.addNewExpense(expense);

            } else if (option == 2) {

                tracker.displayExpenses();

            } else if (option == 3) {

                tracker.totalSpent();

            } else if (option == 4) {

                System.out.println("Program Closed.");

            } else {

                System.out.println("Wrong Choice Entered!");
            }

        } while (option != 4);

        input.close();
    }
}