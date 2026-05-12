import java.util.HashMap;
import java.util.Scanner;

public class Day7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input sentence
        System.out.println("Enter a sentence:");
        String input = sc.nextLine();

        input = input.toLowerCase();

        String[] words = input.split(" ");

        HashMap<String, Integer> freqMap = new HashMap<>();

        for (String word : words) {
            if (freqMap.containsKey(word)) {
                freqMap.put(word, freqMap.get(word) + 1);
            } else {
                freqMap.put(word, 1);
            }
        }

        System.out.println("\nWord Frequencies:");
        for (String key : freqMap.keySet()) {
            System.out.println(key + " : " + freqMap.get(key));
        }

        String mostFrequent = "";
        int maxCount = 0;
        for (String key : freqMap.keySet()) {
            if (freqMap.get(key) > maxCount) {
                maxCount = freqMap.get(key);
                mostFrequent = key;
            }
        }

        System.out.println("\nMost Frequent Word: " + mostFrequent + " (appeared " + maxCount + " times)");

        sc.close();
    }
}
