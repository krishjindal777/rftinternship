import java.util.ArrayList;
import java.util.Scanner;

public class Day21 {

    // Student class
    static class Student {

        private int id;
        private String name;
        private int age;
        private String course;

        // Constructor
        public Student(int id, String name, int age, String course) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.course = course;
        }

        // Getters
        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getCourse() {
            return course;
        }

        // Setters
        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setCourse(String course) {
            this.course = course;
        }

        // Display student
        public void displayStudent() {
            System.out.println("ID     : " + id);
            System.out.println("Name   : " + name);
            System.out.println("Age    : " + age);
            System.out.println("Course : " + course);
            System.out.println("-------------------------");
        }
    }


    // ArrayList to store students
    static ArrayList<Student> students = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);


    // Add Student
    public static void addStudent() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        Student student = new Student(id, name, age, course);

        students.add(student);

        System.out.println("Student added successfully!");
    }


    // Search Student
    public static void searchStudent() {

        System.out.print("Enter Student ID to search: ");
        int id = sc.nextInt();

        for (Student student : students) {

            if (student.getId() == id) {

                System.out.println("Student found!");
                student.displayStudent();

                return;
            }
        }

        System.out.println("Student not found.");
    }


    // Update Student
    public static void updateStudent() {

        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student student : students) {

            if (student.getId() == id) {

                System.out.print("Enter New Name: ");
                String name = sc.nextLine();

                System.out.print("Enter New Age: ");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter New Course: ");
                String course = sc.nextLine();

                student.setName(name);
                student.setAge(age);
                student.setCourse(course);

                System.out.println("Student updated successfully!");

                return;
            }
        }

        System.out.println("Student not found.");
    }


    // Delete Student
    public static void deleteStudent() {

        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getId() == id) {

                students.remove(i);

                System.out.println("Student deleted successfully!");

                return;
            }
        }

        System.out.println("Student not found.");
    }


    // Display All Students
    public static void displayAllStudents() {

        if (students.isEmpty()) {

            System.out.println("No students available.");

            return;
        }

        System.out.println("\n===== All Students =====");

        for (Student student : students) {

            student.displayStudent();
        }
    }


    // Main Method
    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    searchStudent();
                    break;

                case 3:
                    updateStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    displayAllStudents();
                    break;

                case 6:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}