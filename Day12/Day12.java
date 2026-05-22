import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Day12 {
    public static void main(String[] args) {
        String fileName = "employees.csv"; 
        HashMap<String, Integer> deptSalarySum = new HashMap<>();
        HashMap<String, Integer> deptCount = new HashMap<>();

        String highestPaidName = "";
        String highestPaidDept = "";
        int highestSalary = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 4) {
                    String id = parts[0];
                    String name = parts[1];
                    String department = parts[2];
                    int salary = Integer.parseInt(parts[3]);

                    
                    deptSalarySum.put(department, deptSalarySum.getOrDefault(department, 0) + salary);
                    deptCount.put(department, deptCount.getOrDefault(department, 0) + 1);

                   
                    if (salary > highestSalary) {
                        highestSalary = salary;
                        highestPaidName = name;
                        highestPaidDept = department;
                    }
                }
            }
            br.close();

            
            System.out.println("Average Salary per Department:");
            for (String dept : deptSalarySum.keySet()) {
                int total = deptSalarySum.get(dept);
                int count = deptCount.get(dept);
                double average = (double) total / count;
                System.out.println(dept + ": " + average);
            }

            
            System.out.println("\nHighest Paid Employee:");
            System.out.println(highestPaidName + " (" + highestPaidDept + ") - " + highestSalary);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
