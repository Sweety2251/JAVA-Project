import java.io.*;
import java.util.*;
import java.util.HashMap;

public class textanalyzer {

    public static void main(String[] args) {

        String filePath = "input.txt"; // your file name

        int lineCount = 0;
        int wordCount = 0;

        Map<String, Integer> wordFreq = new HashMap<>();
        String longestWord = "";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = br.readLine()) != null) {
                lineCount++;

                // Remove punctuation + convert to lowercase
                line = line.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase();

                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (word.isEmpty()) continue;

                    wordCount++;

                    // Count frequency
                    wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);

                    // Check longest word
                    if (word.length() > longestWord.length()) {
                        longestWord = word;
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Find most frequent word
        String mostFrequentWord = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : wordFreq.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequentWord = entry.getKey();
            }
        }

        // Sort top 5 words
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordFreq.entrySet());

        list.sort((a, b) -> b.getValue() - a.getValue());

        // OUTPUT
        System.out.println("Total Lines: " + lineCount);
        System.out.println("Total Words: " + wordCount);
        System.out.println("Most Frequent Word: " + mostFrequentWord + " (" + maxCount + ")");
        System.out.println("Longest Word: " + longestWord);

        System.out.println("\nTop 5 Words:");
        for (int i = 0; i < Math.min(5, list.size()); i++) {
            System.out.println(list.get(i).getKey() + " -> " + list.get(i).getValue());
        }
    }
}