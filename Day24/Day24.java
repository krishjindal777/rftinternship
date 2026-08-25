import java.util.ArrayList;

class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

class Customer {
    int id;
    String name;
    String email;

    Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}

class Cart {
    ArrayList<Product> list = new ArrayList<>();
    ArrayList<Integer> qty = new ArrayList<>();

    void addProduct(Product p, int q) {
        list.add(p);
        qty.add(q);
        System.out.println(p.name + " added");
    }

    void removeProduct(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).id == id) {
                list.remove(i);
                qty.remove(i);
                System.out.println("Product removed");
                return;
            }
        }
        System.out.println("Product not found");
    }

    void updateQuantity(int id, int q) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).id == id) {
                qty.set(i, q);
                System.out.println("Quantity updated");
                return;
            }
        }
    }

    double getTotal() {
        double total = 0;

        for (int i = 0; i < list.size(); i++) {
            total = total + list.get(i).price * qty.get(i);
        }

        return total;
    }

    void showCart() {
        System.out.println("\nCart:");

        for (int i = 0; i < list.size(); i++) {
            Product p = list.get(i);

            System.out.println(
                    p.name + "  " +
                    qty.get(i) + "  " +
                    p.price * qty.get(i)
            );
        }

        System.out.println("Total = " + getTotal());
    }
}

class Order {
    int orderId;
    Customer customer;
    Cart cart;

    Order(int orderId, Customer customer, Cart cart) {
        this.orderId = orderId;
        this.customer = customer;
        this.cart = cart;
    }

    void invoice() {
        System.out.println("\n---------- INVOICE ----------");
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer.name);
        System.out.println("Email: " + customer.email);

        System.out.println("\nProducts:");

        for (int i = 0; i < cart.list.size(); i++) {
            Product p = cart.list.get(i);

            System.out.println(
                    p.name + " x " +
                    cart.qty.get(i) + " = " +
                    p.price * cart.qty.get(i)
            );
        }

        System.out.println("-----------------------------");
        System.out.println("Total Bill: " + cart.getTotal());
    }
}

public class Day24 {
    public static void main(String[] args) {

        Product p1 = new Product(1, "Laptop", 50000);
        Product p2 = new Product(2, "Mouse", 700);
        Product p3 = new Product(3, "Keyboard", 1200);

        Customer c1 = new Customer(
                1,
                "Rahul",
                "rahul@gmail.com"
        );

        Cart cart = new Cart();

        cart.addProduct(p1, 1);
        cart.addProduct(p2, 2);
        cart.addProduct(p3, 1);

        cart.showCart();

        cart.updateQuantity(2, 3);

        cart.showCart();

        cart.removeProduct(3);

        cart.showCart();

        Order order = new Order(101, c1, cart);

        order.invoice();
    }
}