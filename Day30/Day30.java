```java
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Course {
    int id;
    String name;

    Course(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Register {
    int studentId;
    int courseId;

    Register(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }
}

public class Day30 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Register> register = new ArrayList<>();

        int choice = 0;

        while (choice != 7) {

            System.out.println("1. Register Student");
            System.out.println("2. Create Course");
            System.out.println("3. Enroll Student");
            System.out.println("4. Drop Course");
            System.out.println("5. Show Enrolled Courses");
            System.out.println("6. Enrollment Summary");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("Enter student id: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter student name: ");
                String name = sc.nextLine();

                Student s = new Student(id, name);
                students.add(s);

                System.out.println("Student added");

            } else if (choice == 2) {

                System.out.print("Enter course id: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter course name: ");
                String name = sc.nextLine();

                Course c = new Course(id, name);
                courses.add(c);

                System.out.println("Course added");

            } else if (choice == 3) {

                System.out.print("Enter student id: ");
                int sid = sc.nextInt();

                System.out.print("Enter course id: ");
                int cid = sc.nextInt();

                boolean s = false;
                boolean c = false;

                for (Student x : students) {
                    if (x.id == sid) {
                        s = true;
                    }
                }

                for (Course x : courses) {
                    if (x.id == cid) {
                        c = true;
                    }
                }

                if (s == true && c == true) {

                    Register r = new Register(sid, cid);
                    register.add(r);

                    System.out.println("Student enrolled");

                } else {

                    System.out.println("Student or course not found");
                }

            } else if (choice == 4) {

                System.out.print("Enter student id: ");
                int sid = sc.nextInt();

                System.out.print("Enter course id: ");
                int cid = sc.nextInt();

                boolean found = false;

                for (int i = 0; i < register.size(); i++) {

                    Register r = register.get(i);

                    if (r.studentId == sid && r.courseId == cid) {

                        register.remove(i);
                        found = true;

                        System.out.println("Course dropped");
                        break;
                    }
                }

                if (found == false) {
                    System.out.println("Record not found");
                }

            } else if (choice == 5) {

                System.out.print("Enter student id: ");
                int sid = sc.nextInt();

                String studentName = "";

                for (Student s : students) {

                    if (s.id == sid) {
                        studentName = s.name;
                    }
                }

                if (studentName.equals("")) {

                    System.out.println("Student not found");

                } else {

                    System.out.println("Student: " + studentName);

                    boolean found = false;

                    for (Register r : register) {

                        if (r.studentId == sid) {

                            for (Course c : courses) {

                                if (c.id == r.courseId) {

                                    System.out.println(
                                            c.id + " " + c.name
                                    );

                                    found = true;
                                }
                            }
                        }
                    }

                    if (found == false) {
                        System.out.println("No courses");
                    }
                }

            } else if (choice == 6) {

                for (Student s : students) {

                    System.out.println("Student id: " + s.id);
                    System.out.println("Student name: " + s.name);

                    int count = 0;

                    for (Register r : register) {

                        if (r.studentId == s.id) {

                            for (Course c : courses) {

                                if (c.id == r.courseId) {

                                    System.out.println("Course: " + c.name);
                                    count++;
                                }
                            }
                        }
                    }

                    System.out.println("Number of courses: " + count);
                    System.out.println();
                }

            } else if (choice == 7) {

                System.out.println("Program ended");

            } else {

                System.out.println("Wrong choice");
            }
        }

        sc.close();
    }
}
```
