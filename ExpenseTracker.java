import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpenseTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Expense> expenses = new ArrayList<>();
        System.out.println("Personal Expense Tracker");
        while (true) {
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addExpense(scanner, expenses);
                    break;
                case 2:
                    viewExpenses(expenses);
                    break;
                case 3:
                    System.out.println("Exiting Expense Tracker...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }

    }

    public static void addExpense(Scanner scanner, List<Expense> expenses) {
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter the description: ");
        String description = scanner.nextLine();
        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();
        Expense expense = new Expense(description, amount);
        expenses.add(expense);
        System.out.println("Expense added successfully!");
    }

    public static void viewExpenses(List<Expense> expenses) {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
        } else {
            System.out.println("Expense List:");
            for (Expense expense : expenses) {
                System.out.println(expense);
            }
        }
    }
}

class Expense {
    private String description;
    private double amount;

    public Expense(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    @Override

    public String toString() {
        return "Description: " + description + ", Amount: " + amount;
    }
}