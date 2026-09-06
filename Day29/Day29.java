import java.util.*;

class Employee {
    int id;
    String name;
    String department;
    int leave = 20;

    Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
}

class Leave {
    int empId;
    String reason;
    int days;
    String status;

    Leave(int empId, int days, String reason) {
        this.empId = empId;
        this.days = days;
        this.reason = reason;
        status = "Pending";
    }
}

public class Day29 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Employee> employees = new ArrayList<>();
        ArrayList<Leave> leaves = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== Employee Leave Management =====");
            System.out.println("1. Register Employee");
            System.out.println("2. Apply Leave");
            System.out.println("3. Approve Leave");
            System.out.println("4. Reject Leave");
            System.out.println("5. View Leave History");
            System.out.println("6. Check Leave Balance");
            System.out.println("7. Leave Report");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if (choice == 1) {

                System.out.print("Enter employee id: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter employee name: ");
                String name = sc.nextLine();

                System.out.print("Enter department: ");
                String dept = sc.nextLine();

                employees.add(new Employee(id, name, dept));

                System.out.println("Employee registered.");

            } else if (choice == 2) {

                System.out.print("Enter employee id: ");
                int id = sc.nextInt();

                boolean found = false;

                for (Employee e : employees) {

                    if (e.id == id) {

                        found = true;

                        System.out.print("Enter leave days: ");
                        int days = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter reason: ");
                        String reason = sc.nextLine();

                        if (days <= e.leave) {
                            leaves.add(new Leave(id, days, reason));
                            System.out.println("Leave applied successfully.");
                        } else {
                            System.out.println("Not enough leave.");
                        }
                    }
                }

                if (found == false) {
                    System.out.println("Employee not found.");
                }

            } else if (choice == 3) {

                System.out.println("\nLeave Requests:");

                for (int i = 0; i < leaves.size(); i++) {

                    Leave l = leaves.get(i);

                    System.out.println(
                            (i + 1) + ". Employee ID: " + l.empId +
                            " Days: " + l.days +
                            " Reason: " + l.reason +
                            " Status: " + l.status
                    );
                }

                if (leaves.size() > 0) {

                    System.out.print("Enter request number: ");
                    int n = sc.nextInt();

                    Leave l = leaves.get(n - 1);

                    if (l.status.equals("Pending")) {

                        l.status = "Approved";

                        for (Employee e : employees) {
                            if (e.id == l.empId) {
                                e.leave = e.leave - l.days;
                            }
                        }

                        System.out.println("Leave approved.");

                    } else {
                        System.out.println("Already processed.");
                    }
                }

            } else if (choice == 4) {

                System.out.println("\nLeave Requests:");

                for (int i = 0; i < leaves.size(); i++) {

                    Leave l = leaves.get(i);

                    System.out.println(
                            (i + 1) + ". Employee ID: " + l.empId +
                            " Days: " + l.days +
                            " Reason: " + l.reason +
                            " Status: " + l.status
                    );
                }

                if (leaves.size() > 0) {

                    System.out.print("Enter request number: ");
                    int n = sc.nextInt();

                    Leave l = leaves.get(n - 1);

                    if (l.status.equals("Pending")) {
                        l.status = "Rejected";
                        System.out.println("Leave rejected.");
                    } else {
                        System.out.println("Already processed.");
                    }
                }

            } else if (choice == 5) {

                System.out.print("Enter employee id: ");
                int id = sc.nextInt();

                System.out.println("\nLeave History:");

                boolean found = false;

                for (Leave l : leaves) {

                    if (l.empId == id) {

                        found = true;

                        System.out.println("Days: " + l.days);
                        System.out.println("Reason: " + l.reason);
                        System.out.println("Status: " + l.status);
                        System.out.println();
                    }
                }

                if (found == false) {
                    System.out.println("No leave history found.");
                }

            } else if (choice == 6) {

                System.out.print("Enter employee id: ");
                int id = sc.nextInt();

                for (Employee e : employees) {

                    if (e.id == id) {

                        System.out.println("Employee Name: " + e.name);
                        System.out.println("Total Leave: 20");
                        System.out.println("Remaining Leave: " + e.leave);
                    }
                }

            } else if (choice == 7) {

                System.out.println("\n========== LEAVE REPORT ==========");

                for (Employee e : employees) {

                    System.out.println("Employee ID: " + e.id);
                    System.out.println("Name: " + e.name);
                    System.out.println("Department: " + e.department);
                    System.out.println("Remaining Leave: " + e.leave);

                    int used = 20 - e.leave;

                    System.out.println("Used Leave: " + used);
                    System.out.println("-------------------------");
                }

            } else if (choice == 8) {

                System.out.println("Thank you for using the system.");

            } else {

                System.out.println("Wrong choice.");

            }

        } while (choice != 8);

        sc.close();
    }
}