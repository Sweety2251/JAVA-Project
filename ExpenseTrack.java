import java.util.*;

class Expense {
    Double Amount;
    String Category;
    String Date;
    
    // constructor
    Expense(Double Amount, String Category, String Date) {
        this.Amount = Amount;
        this.Category = Category;
        this.Date = Date;
    }

    void Display() {
        System.out.println("Amount: " + Amount);
        System.out.println("Category: " + Category);
        System.out.println("Date: " + Date);
      }
}

class ExpenseManager {
    
    ArrayList<Expense> expenses = new ArrayList<>();

    void AddExpense(Double Amount, String Category, String Date) {
        Expense expense = new Expense(Amount, Category, Date);
        expenses.add(expense);
        System.out.println("Expense added successfully!");
    }
    
    void veiwExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to display.");
        } else {
            for (Expense expense : expenses) {
                expense.Display();
                System.out.println("-------------------");
            }
        }
    }

    void HighestExpense() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to analyze.");
            return;
        }
        Expense highest = expenses.get(0);
        for (Expense expense : expenses) {
            if (expense.Amount > highest.Amount) {
                highest = expense;
            }
        }
        System.out.println("Highest Expense:");
        highest.Display();
    }

    void TotoalSpending() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.Amount;
        }
        System.out.println("Total Spending: " + total);
    }
}

public class ExpenseTrack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();

        while (true) {
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Highest Expense");
            System.out.println("4. View Total Spending");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter category: ");
                    String category = sc.nextLine();
                    System.out.print("Enter date: ");
                    String date = sc.nextLine();
                    manager.AddExpense(amount, category, date);
                    break;
                case 2:
                    manager.veiwExpenses();
                    break;
                case 3:
                    manager.HighestExpense();
                    break;
                case 4:
                    manager.TotoalSpending();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}