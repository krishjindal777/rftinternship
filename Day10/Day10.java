import java.util.*;

class Product {
    String name;
    double price;
    int quantity;

    // Constructor
    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // For easy printing
    public String toString() {
        return name + " | Price: " + price + " | Quantity: " + quantity;
    }
}

public class Day10 {
    public static void main(String[] args) {
        // Step 1: Create a HashMap to store products
        HashMap<String, Product> inventory = new HashMap<>();

        // Step 2: Add products
        inventory.put("Laptop", new Product("Laptop", 50000, 5));
        inventory.put("Phone", new Product("Phone", 20000, 10));
        inventory.put("Tablet", new Product("Tablet", 15000, 7));

        // Step 3: Update quantity (example: add 3 more phones)
        Product phone = inventory.get("Phone");
        phone.quantity = phone.quantity + 3;
        inventory.put("Phone", phone);

        // Step 4: Search product
        String searchKey = "Laptop";
        if (inventory.containsKey(searchKey)) {
            System.out.println("Found: " + inventory.get(searchKey));
        } else {
            System.out.println(searchKey + " not found in inventory.");
        }

        // Step 5: Calculate total inventory value
        double totalValue = 0;
        for (Product p : inventory.values()) {
            totalValue = totalValue + (p.price * p.quantity);
        }
        System.out.println("Total Inventory Value: " + totalValue);

       System.out.println("\nAll Products in Inventory:");
        for (String key : inventory.keySet()) {
            System.out.println(inventory.get(key));
        }
    }
}
