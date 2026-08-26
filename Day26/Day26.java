import java.util.ArrayList;
import java.util.Scanner;

class Customer {
    int id;
    String name;
    String phone;

    Customer(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
}

class Vehicle {
    String number;
    String model;
    Customer owner;

    Vehicle(String number, String model, Customer owner) {
        this.number = number;
        this.model = model;
        this.owner = owner;
    }
}

class Technician {
    int id;
    String name;

    Technician(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Service {
    String serviceType;
    Vehicle vehicle;
    Technician technician;
    double cost;

    Service(String serviceType, Vehicle vehicle, Technician technician, double cost) {
        this.serviceType = serviceType;
        this.vehicle = vehicle;
        this.technician = technician;
        this.cost = cost;
    }
}

class Invoice {
    int invoiceNumber;
    Service service;
    double amount;

    Invoice(int invoiceNumber, Service service) {
        this.invoiceNumber = invoiceNumber;
        this.service = service;
        this.amount = service.cost;
    }

    void showInvoice() {
        System.out.println("\n----- Invoice -----");
        System.out.println("Invoice No: " + invoiceNumber);
        System.out.println("Vehicle: " + service.vehicle.number);
        System.out.println("Service: " + service.serviceType);
        System.out.println("Technician: " + service.technician.name);
        System.out.println("Amount: Rs. " + amount);
    }
}

public class Day26 {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Customer> customers = new ArrayList<>();
    static ArrayList<Vehicle> vehicles = new ArrayList<>();
    static ArrayList<Service> services = new ArrayList<>();
    static ArrayList<Invoice> invoices = new ArrayList<>();

    public static void main(String[] args) {

        Technician technician = new Technician(1, "Rahul");

        while (true) {

            System.out.println("\n===== Vehicle Service Center =====");
            System.out.println("1. Register Customer");
            System.out.println("2. Add Vehicle");
            System.out.println("3. Schedule Service");
            System.out.println("4. Generate Invoice");
            System.out.println("5. View Service History");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                registerCustomer();

            } else if (choice == 2) {
                addVehicle();

            } else if (choice == 3) {
                scheduleService(technician);

            } else if (choice == 4) {
                generateInvoice();

            } else if (choice == 5) {
                viewHistory();

            } else if (choice == 6) {
                System.out.println("Thank you!");
                break;

            } else {
                System.out.println("Invalid choice");
            }
        }
    }

    static void registerCustomer() {

        System.out.print("Enter customer ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        Customer customer = new Customer(id, name, phone);
        customers.add(customer);

        System.out.println("Customer registered successfully.");
    }

    static void addVehicle() {

        if (customers.size() == 0) {
            System.out.println("Please register a customer first.");
            return;
        }

        System.out.print("Enter customer ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Customer customer = null;

        for (Customer c : customers) {
            if (c.id == id) {
                customer = c;
            }
        }

        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.print("Enter vehicle number: ");
        String number = sc.nextLine();

        System.out.print("Enter vehicle model: ");
        String model = sc.nextLine();

        Vehicle vehicle = new Vehicle(number, model, customer);
        vehicles.add(vehicle);

        System.out.println("Vehicle added successfully.");
    }

    static void scheduleService(Technician technician) {

        if (vehicles.size() == 0) {
            System.out.println("No vehicles available.");
            return;
        }

        System.out.print("Enter vehicle number: ");
        String number = sc.nextLine();

        Vehicle vehicle = null;

        for (Vehicle v : vehicles) {
            if (v.number.equalsIgnoreCase(number)) {
                vehicle = v;
            }
        }

        if (vehicle == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        System.out.print("Enter service type: ");
        String serviceType = sc.nextLine();

        System.out.print("Enter service cost: ");
        double cost = sc.nextDouble();
        sc.nextLine();

        Service service = new Service(
                serviceType,
                vehicle,
                technician,
                cost
        );

        services.add(service);

        System.out.println("Service scheduled successfully.");
    }

    static void generateInvoice() {

        if (services.size() == 0) {
            System.out.println("No service available.");
            return;
        }

        Service service = services.get(services.size() - 1);

        int invoiceNumber = invoices.size() + 1;

        Invoice invoice = new Invoice(invoiceNumber, service);

        invoices.add(invoice);

        invoice.showInvoice();
    }

    static void viewHistory() {

        if (services.size() == 0) {
            System.out.println("No service history available.");
            return;
        }

        System.out.println("\n----- Service History -----");

        for (Service s : services) {

            System.out.println("Vehicle: " + s.vehicle.number);
            System.out.println("Model: " + s.vehicle.model);
            System.out.println("Service: " + s.serviceType);
            System.out.println("Technician: " + s.technician.name);
            System.out.println("Cost: Rs. " + s.cost);
            System.out.println("--------------------------");
        }
    }
}