import java.util.*;

class Student {
    String name;
    int marks;

    // Constructor
    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    // For easy printing
    public String toString() {
        return name + " - " + marks;
    }
}

public class Day9 {
    public static void main(String[] args) {
        // Step 1: Create a list of students
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 85));
        students.add(new Student("Bob", 92));
        students.add(new Student("Charlie", 78));
        students.add(new Student("David", 90));
        students.add(new Student("Eva", 88));

        // Step 2: Sort students by marks (descending)
        Collections.sort(students, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s2.marks - s1.marks; // descending order
            }
        });

        // Step 3: Display ranking
        System.out.println("Student Rankings:");
        int rank = 1;
        for (Student s : students) {
            System.out.println("Rank " + rank + ": " + s);
            rank++;
        }
    }
}
