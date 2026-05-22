import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;

public class Day14 {
    public static void main(String[] args) {
        String fileName = "sample.txt"; 
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter search word: ");
        String query = sc.nextLine();

        int totalOccurrences = 0;
        HashMap<Integer, Integer> lineOccurrences = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) {
                lineNumber++;
                String[] words = line.split(" ");

                int countInLine = 0;
                for (String word : words) {
                    if (word.equals(query)) {
                        totalOccurrences++;
                        countInLine++;
                    }
                }

                if (countInLine > 0) {
                    lineOccurrences.put(lineNumber, countInLine);
                }
            }
            br.close();

            
            System.out.println("\nSearch Results for: " + query);
            System.out.println("Total Occurrences: " + totalOccurrences);

            System.out.println("\nLine Numbers and Occurrences:");
            for (int lineNum : lineOccurrences.keySet()) {
                System.out.println("Line " + lineNum + " -> " + lineOccurrences.get(lineNum));
            }

            
            int maxLine = -1;
            int maxCount = 0;
            for (int lineNum : lineOccurrences.keySet()) {
                if (lineOccurrences.get(lineNum) > maxCount) {
                    maxCount = lineOccurrences.get(lineNum);
                    maxLine = lineNum;
                }
            }

            if (maxLine != -1) {
                System.out.println("\nHighest Frequency: Line " + maxLine + " with " + maxCount + " occurrences");
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        sc.close();
    }
}
