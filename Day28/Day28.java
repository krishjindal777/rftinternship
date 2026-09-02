import java.util.*;
import java.time.LocalDate;

class Member {
    int id;
    String name;
    String phone;
    String plan;
    double fee;
    LocalDate startDate;
    LocalDate endDate;
    int attendance;

    Member(int id, String name, String phone, String plan,
           double fee, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.plan = plan;
        this.fee = fee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.attendance = 0;
    }
}

public class Day28 {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Member> members = new ArrayList<>();

    static int memberId = 1;

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== GYM MEMBERSHIP MANAGEMENT SYSTEM =====");
            System.out.println("1. Register Member");
            System.out.println("2. Manage Membership Plans");
            System.out.println("3. Track Attendance");
            System.out.println("4. Generate Membership Bill");
            System.out.println("5. Renew Membership");
            System.out.println("6. Display Member Records");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    registerMember();
                    break;

                case 2:
                    membershipPlans();
                    break;

                case 3:
                    trackAttendance();
                    break;

                case 4:
                    generateBill();
                    break;

                case 5:
                    renewMembership();
                    break;

                case 6:
                    displayMembers();
                    break;

                case 7:
                    System.out.println("Thank you for using the system!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Register a new member
    static void registerMember() {

        System.out.println("\n===== REGISTER MEMBER =====");

        System.out.print("Enter member name: ");
        String name = sc.nextLine();

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        System.out.println("\nChoose Membership Plan:");
        System.out.println("1. Monthly - Rs. 1000");
        System.out.println("2. Quarterly - Rs. 2500");
        System.out.println("3. Yearly - Rs. 8000");

        System.out.print("Enter plan: ");
        int choice = sc.nextInt();

        String plan = "";
        double fee = 0;
        int months = 0;

        if (choice == 1) {
            plan = "Monthly";
            fee = 1000;
            months = 1;
        }
        else if (choice == 2) {
            plan = "Quarterly";
            fee = 2500;
            months = 3;
        }
        else if (choice == 3) {
            plan = "Yearly";
            fee = 8000;
            months = 12;
        }
        else {
            System.out.println("Invalid plan!");
            return;
        }

        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusMonths(months);

        Member m = new Member(
                memberId,
                name,
                phone,
                plan,
                fee,
                startDate,
                endDate
        );

        members.add(m);

        System.out.println("\nMember registered successfully!");
        System.out.println("Member ID: " + memberId);

        memberId++;
    }

    // Display membership plans
    static void membershipPlans() {

        System.out.println("\n===== MEMBERSHIP PLANS =====");

        System.out.println("1. Monthly");
        System.out.println("   Duration: 1 Month");
        System.out.println("   Fee: Rs. 1000");

        System.out.println("\n2. Quarterly");
        System.out.println("   Duration: 3 Months");
        System.out.println("   Fee: Rs. 2500");

        System.out.println("\n3. Yearly");
        System.out.println("   Duration: 12 Months");
        System.out.println("   Fee: Rs. 8000");
    }

    // Track attendance
    static void trackAttendance() {

        System.out.println("\n===== TRACK ATTENDANCE =====");

        System.out.print("Enter member ID: ");
        int id = sc.nextInt();

        Member m = findMember(id);

        if (m == null) {
            System.out.println("Member not found!");
            return;
        }

        LocalDate today = LocalDate.now();

        if (today.isAfter(m.endDate)) {
            System.out.println("Membership has expired!");
            return;
        }

        m.attendance++;

        System.out.println("Attendance marked successfully!");
        System.out.println("Member: " + m.name);
        System.out.println("Total Attendance: " + m.attendance);
    }

    // Generate membership bill
    static void generateBill() {

        System.out.println("\n===== MEMBERSHIP BILL =====");

        System.out.print("Enter member ID: ");
        int id = sc.nextInt();

        Member m = findMember(id);

        if (m == null) {
            System.out.println("Member not found!");
            return;
        }

        System.out.println("\n---------- GYM BILL ----------");
        System.out.println("Member ID   : " + m.id);
        System.out.println("Member Name : " + m.name);
        System.out.println("Phone       : " + m.phone);
        System.out.println("Plan        : " + m.plan);
        System.out.println("Start Date  : " + m.startDate);
        System.out.println("End Date    : " + m.endDate);
        System.out.println("Amount      : Rs. " + m.fee);
        System.out.println("-------------------------------");

        System.out.println("Bill generated successfully!");
    }

    // Renew membership
    static void renewMembership() {

        System.out.println("\n===== RENEW MEMBERSHIP =====");

        System.out.print("Enter member ID: ");
        int id = sc.nextInt();

        Member m = findMember(id);

        if (m == null) {
            System.out.println("Member not found!");
            return;
        }

        System.out.println("\nChoose Renewal Plan:");
        System.out.println("1. Monthly - Rs. 1000");
        System.out.println("2. Quarterly - Rs. 2500");
        System.out.println("3. Yearly - Rs. 8000");

        System.out.print("Enter plan: ");
        int choice = sc.nextInt();

        int months = 0;
        double fee = 0;
        String plan = "";

        if (choice == 1) {
            plan = "Monthly";
            fee = 1000;
            months = 1;
        }
        else if (choice == 2) {
            plan = "Quarterly";
            fee = 2500;
            months = 3;
        }
        else if (choice == 3) {
            plan = "Yearly";
            fee = 8000;
            months = 12;
        }
        else {
            System.out.println("Invalid plan!");
            return;
        }

        LocalDate today = LocalDate.now();

        // If membership is still active,
        // add the new period after the current end date.
        if (m.endDate.isAfter(today)) {
            m.endDate = m.endDate.plusMonths(months);
        }
        else {
            m.startDate = today;
            m.endDate = today.plusMonths(months);
        }

        m.plan = plan;
        m.fee = fee;

        System.out.println("Membership renewed successfully!");
        System.out.println("New Plan: " + m.plan);
        System.out.println("New End Date: " + m.endDate);
    }

    // Display all members
    static void displayMembers() {

        System.out.println("\n===== MEMBER RECORDS =====");

        if (members.size() == 0) {
            System.out.println("No members registered.");
            return;
        }

        for (Member m : members) {

            System.out.println("\n----------------------------");

            System.out.println("Member ID   : " + m.id);
            System.out.println("Name        : " + m.name);
            System.out.println("Phone       : " + m.phone);
            System.out.println("Plan        : " + m.plan);
            System.out.println("Fee         : Rs. " + m.fee);
            System.out.println("Start Date  : " + m.startDate);
            System.out.println("End Date    : " + m.endDate);
            System.out.println("Attendance  : " + m.attendance);

            if (m.endDate.isBefore(LocalDate.now())) {
                System.out.println("Status      : Expired");
            }
            else {
                System.out.println("Status      : Active");
            }
        }
    }

    // Find member using ID
    static Member findMember(int id) {

        for (Member m : members) {

            if (m.id == id) {
                return m;
            }
        }

        return null;
    }
}