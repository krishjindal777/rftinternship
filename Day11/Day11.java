import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Day11 {
    public static void main(String[] args) {
        String fileName = "sample.txt"; 
        int lineCount = 0;
        int wordCount = 0;
        String longestWord = "";
        HashMap<String, Integer> wordFrequency = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = br.readLine()) != null) {
                lineCount++;

                String[] words = line.split(" ");
                wordCount += words.length;

                for (String word : words) {
                    // Track longest word
                    if (word.length() > longestWord.length()) {
                        longestWord = word;
                    }

                    
                    if (wordFrequency.containsKey(word)) {
                        wordFrequency.put(word, wordFrequency.get(word) + 1);
                    } else {
                        wordFrequency.put(word, 1);
                    }
                }
            }
            br.close();

    
            String mostFrequentWord = "";
            int maxCount = 0;
            for (String w : wordFrequency.keySet()) {
                if (wordFrequency.get(w) > maxCount) {
                    maxCount = wordFrequency.get(w);
                    mostFrequentWord = w;
                }
            }

          
            System.out.println("Total Lines: " + lineCount);
            System.out.println("Total Words: " + wordCount);
            System.out.println("Longest Word: " + longestWord);
            System.out.println("Most Frequent Word: " + mostFrequentWord);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
