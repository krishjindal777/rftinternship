import java.util.ArrayList;
import java.util.Scanner;

class Room {
    int roomNumber;
    String type;
    double price;
    boolean booked;

    Room(int roomNumber, String type, double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.booked = false;
    }

    void showRoom() {
        System.out.println("Room No: " + roomNumber +
                ", Type: " + type +
                ", Price: " + price +
                ", Available: " + !booked);
    }
}

class Customer {
    String name;
    String phone;

    Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}

class Booking {
    Customer customer;
    Room room;
    int days;

    Booking(Customer customer, Room room, int days) {
        this.customer = customer;
        this.room = room;
        this.days = days;
    }

    void checkIn() {
        System.out.println(customer.name + " has checked in.");
    }

    void checkOut() {
        System.out.println(customer.name + " has checked out.");
        room.booked = false;
    }

    void generateBill() {
        double bill = room.price * days;

        System.out.println("\n----- BILL -----");
        System.out.println("Customer: " + customer.name);
        System.out.println("Phone: " + customer.phone);
        System.out.println("Room No: " + room.roomNumber);
        System.out.println("Room Type: " + room.type);
        System.out.println("Price per day: " + room.price);
        System.out.println("Number of days: " + days);
        System.out.println("Total Bill: " + bill);
    }
}

class Hotel {
    String name;
    ArrayList<Room> rooms = new ArrayList<>();

    Hotel(String name) {
        this.name = name;
    }

    void addRoom(Room room) {
        rooms.add(room);
    }

    void showAvailableRooms() {
        System.out.println("\nAvailable Rooms:");

        for (Room room : rooms) {
            if (!room.booked) {
                room.showRoom();
            }
        }
    }

    Booking bookRoom(int roomNumber, Customer customer, int days) {

        for (Room room : rooms) {

            if (room.roomNumber == roomNumber) {

                if (!room.booked) {
                    room.booked = true;

                    System.out.println("\nRoom booked successfully!");

                    return new Booking(customer, room, days);
                } else {
                    System.out.println("Room is already booked.");
                    return null;
                }
            }
        }

        System.out.println("Room not found.");
        return null;
    }
}

public class Day23 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Hotel hotel = new Hotel("Sunshine Hotel");

        // Adding rooms
        hotel.addRoom(new Room(101, "Single", 1000));
        hotel.addRoom(new Room(102, "Double", 1500));
        hotel.addRoom(new Room(103, "Deluxe", 2500));

        System.out.println("Welcome to " + hotel.name);

        // Show available rooms
        hotel.showAvailableRooms();

        // Customer details
        System.out.print("\nEnter customer name: ");
        String name = sc.nextLine();

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        Customer customer = new Customer(name, phone);

        // Booking details
        System.out.print("Enter room number: ");
        int roomNumber = sc.nextInt();

        System.out.print("Enter number of days: ");
        int days = sc.nextInt();

        // Book room
        Booking booking = hotel.bookRoom(roomNumber, customer, days);

        if (booking != null) {

            // Check-in
            booking.checkIn();

            // Generate bill
            booking.generateBill();

            // Check-out
            System.out.println("\nChecking out...");
            booking.checkOut();

            // Show rooms after checkout
            hotel.showAvailableRooms();
        }

        sc.close();
    }
}