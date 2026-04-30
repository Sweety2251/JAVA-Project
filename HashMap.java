import java.util.*;

public class HashMap {
    
    public static void main(String[] args) {
        
        String input = "THIS IS A TEST THIS IS A SIMPLE TEST";
        input = input.toLowerCase();
        String[] word = input.split(" ");
 
        java.util.HashMap<String, Integer> map = new java.util.HashMap<>();

        for (String words : word) {
            if (map.containsKey(words)) {
                map.put(words, map.get(words) + 1);
            } else {
                map.put(words, 1);
            }
        }
       System.out.println("Word Frequency");
       for (String key : map.keySet()) {
           System.out.println("key : " + map.get(key));
       }

       String maxWord = " ";
       int maxCount = 0;
       for (String key : map.keySet()) {
           if (map.get(key) > maxCount) {
               maxCount = map.get(key);
               maxWord = key;
           }
       }
        
       System.out.println("Max frequency : " + maxCount);
       System.out.println("Word : " + maxWord);
    }
}
