import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Product class
class Product {
    String name;
    double price;
    int quantity;

    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void display() {
        System.out.println("Name: " + name + ", Price: " + price + ", Quantity: " + quantity);
    }
}

// Main class
public class inventorySystem {
    static HashMap<String, Product> inventory = new HashMap<>();

    // Add product
    public static void addProduct(String name, double price, int quantity) {
        inventory.put(name, new Product(name, price, quantity));
        System.out.println("Product added!");
    }

    // Update quantity
    public static void updateQuantity(String name, int quantity) {
        if (inventory.containsKey(name)) {
            inventory.get(name).quantity = quantity;
            System.out.println("Quantity updated!");
        } else {
            System.out.println("Product not found!");
        }
    }

    // Search product
    public static void searchProduct(String name) {
        if (inventory.containsKey(name)) {
            inventory.get(name).display();
        } else {
            System.out.println("Product not found!");
        }
    }

    // Calculate total inventory value
    public static void totalValue() {
        double total = 0;
        for (Product p : inventory.values()) {
            total += p.price * p.quantity;
        }
        System.out.println("Total Inventory Value: " + total);
    }

    // Remove product (Bonus)
    public static void removeProduct(String name) {
        if (inventory.remove(name) != null) {
            System.out.println("Product removed!");
        } else {
            System.out.println("Product not found!");
        }
    }

    // Low stock alert (Bonus)
    public static void lowStockAlert(int threshold) {
        for (Product p : inventory.values()) {
            if (p.quantity < threshold) {
                System.out.println("Low stock: " + p.name);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Add 2.Update 3.Search 4.Total Value 5.Remove 6.Low Stock 7.Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();
                    addProduct(name, price, qty);
                    break;

                case 2:
                    System.out.print("Enter name: ");
                    name = sc.nextLine();
                    System.out.print("Enter new quantity: ");
                    qty = sc.nextInt();
                    updateQuantity(name, qty);
                    break;

                case 3:
                    System.out.print("Enter name: ");
                    name = sc.nextLine();
                    searchProduct(name);
                    break;

                case 4:
                    totalValue();
                    break;

                case 5:
                    System.out.print("Enter name: ");
                    name = sc.nextLine();
                    removeProduct(name);
                    break;

                case 6:
                    System.out.print("Enter threshold: ");
                    int t = sc.nextInt();
                    lowStockAlert(t);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }
}