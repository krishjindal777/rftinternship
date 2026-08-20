import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    boolean issued;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
        issued = false;
    }
}

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Library {

    ArrayList<Book> books = new ArrayList<>();

    // Add Book
    void addBook(int id, String title) {
        books.add(new Book(id, title));
        System.out.println("Book added successfully!");
    }

    // Issue Book
    void issueBook(int id) {
        for (Book b : books) {
            if (b.id == id) {
                if (!b.issued) {
                    b.issued = true;
                    System.out.println("Book issued!");
                } else {
                    System.out.println("Book is already issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Return Book
    void returnBook(int id) {
        for (Book b : books) {
            if (b.id == id) {
                b.issued = false;
                System.out.println("Book returned!");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Search Book
    void searchBook(String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                System.out.println("Book ID: " + b.id);
                System.out.println("Book Title: " + b.title);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Display Available Books
    void displayAvailableBooks() {
        System.out.println("\nAvailable Books:");

        for (Book b : books) {
            if (!b.issued) {
                System.out.println(b.id + " - " + b.title);
            }
        }
    }

    // Display Issued Books
    void displayIssuedBooks() {
        System.out.println("\nIssued Books:");

        for (Book b : books) {
            if (b.issued) {
                System.out.println(b.id + " - " + b.title);
            }
        }
    }
}

public class Day22 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Library library = new Library();

        // Adding some books
        library.addBook(101, "Java");
        library.addBook(102, "Python");
        library.addBook(103, "Data Structures");

        int choice;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Search Book");
            System.out.println("5. Display Available Books");
            System.out.println("6. Display Issued Books");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice == 1) {

                System.out.print("Enter Book ID: ");
                int id = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter Book Title: ");
                String title = sc.nextLine();

                library.addBook(id, title);

            } else if (choice == 2) {

                System.out.print("Enter Book ID: ");
                int id = sc.nextInt();

                library.issueBook(id);

            } else if (choice == 3) {

                System.out.print("Enter Book ID: ");
                int id = sc.nextInt();

                library.returnBook(id);

            } else if (choice == 4) {

                sc.nextLine();

                System.out.print("Enter Book Title: ");
                String title = sc.nextLine();

                library.searchBook(title);

            } else if (choice == 5) {

                library.displayAvailableBooks();

            } else if (choice == 6) {

                library.displayIssuedBooks();

            } else if (choice == 7) {

                System.out.println("Thank you!");

            } else {

                System.out.println("Invalid choice.");

            }

        } while (choice != 7);

        sc.close();
    }
}