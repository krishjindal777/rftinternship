import java.util.ArrayList;
import java.util.Scanner;

// Contact class to store name and phone
class Contact {
    String name;
    String phone;

    Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    void display() {
        System.out.println("Name: " + name + ", Phone: " + phone);
    }
}

public class Day6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Contact> contacts = new ArrayList<>();

        int choice;
        do {
            System.out.println("\n--- Contact Manager ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Display All Contacts");
            System.out.println("3. Search by Name");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = sc.nextLine();
                    contacts.add(new Contact(name, phone));
                    System.out.println("Contact added!");
                    break;

                case 2:
                    System.out.println("\nAll Contacts:");
                    for (Contact c : contacts) {
                        c.display();
                    }
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String searchName = sc.nextLine();
                    boolean found = false;
                    for (Contact c : contacts) {
                        if (c.name.equals(searchName)) {
                            System.out.println("Contact found:");
                            c.display();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("No contact found with that name.");
                    }
                    break;

                case 0:
                    System.out.println("Exiting Contact Manager...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);

        sc.close();
    }
}
