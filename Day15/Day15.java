import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Day15 {
    public static void main(String[] args) {
        String inputFile = "data.csv";   
        String outputFile = "filtered.csv"; 

        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            FileWriter fw = new FileWriter(outputFile);

            String line;

            if ((line = br.readLine()) != null) {
                fw.write(line + "\n");
            }

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length >= 4) {
                    String id = parts[0];
                    String name = parts[1];
                    String department = parts[2];
                    int salary = Integer.parseInt(parts[3]);

                    if (salary > 50000) {
                        fw.write(line + "\n");
                    }
                }
            }

            br.close();
            fw.close();

            System.out.println("Filtered data saved to " + outputFile);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
