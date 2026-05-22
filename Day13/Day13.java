import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Day13 {
    public static void main(String[] args) {
        String fileName = "logs.txt"; // Change this to your log file path
        HashMap<String, Integer> logCount = new HashMap<>();
        StringBuilder errorLines = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = br.readLine()) != null) {
               
                String[] parts = line.split(" ", 2);
                if (parts.length > 0) {
                    String logType = parts[0];

                    
                    logCount.put(logType, logCount.getOrDefault(logType, 0) + 1);

                   
                    if (logType.equals("ERROR")) {
                        errorLines.append(line).append("\n");
                    }
                }
            }
            br.close();

           
            String mostFrequentLog = "";
            int maxCount = 0;
            for (String type : logCount.keySet()) {
                if (logCount.get(type) > maxCount) {
                    maxCount = logCount.get(type);
                    mostFrequentLog = type;
                }
            }

           
            System.out.println("Log Counts:");
            for (String type : logCount.keySet()) {
                System.out.println(type + ": " + logCount.get(type));
            }

            System.out.println("\nMost Frequent Log Type: " + mostFrequentLog);

            System.out.println("\nAll ERROR Lines:");
            System.out.println(errorLines.toString());

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
