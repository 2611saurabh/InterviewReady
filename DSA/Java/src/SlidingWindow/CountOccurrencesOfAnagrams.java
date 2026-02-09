package SlidingWindow;

import java.util.HashMap;

class anagrm {
    public int countOccurrenceOfAnagrams(String s, String sub) {
        // Create a frequency map for characters in 'sub'
        HashMap<Character, Integer> map = new HashMap<>();

        // Fill the map with counts of each character in 'sub'
        for (int i = 0; i < sub.length(); i++) {
            map.put(sub.charAt(i), map.getOrDefault(sub.charAt(i), 0) + 1);
        }

        int i = 0, j = 0;          // i = left pointer, j = right pointer of sliding window
        int count = map.size();    // Number of distinct characters we need to match
        int k = sub.length();      // Window size = length of substring
        int ans = 0;               // Final answer = number of anagram occurrences

        // Traverse the string 's' using sliding window
        while (j < s.length()) {

            // Step 1: Process the new character entering the window
            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1); // Decrease frequency
                if (map.get(ch) == 0) {
                    count--; // One character fully matched
                }
            }

            // Step 2: If window size is smaller than k, just expand
            if (j - i + 1 < k) {
                j++;
            }
            // Step 3: If window size equals k, check for an anagram
            else if (j - i + 1 == k) {
                if (count == 0) {
                    ans++; // Found one valid anagram
                }

                // Step 4: Before sliding window forward, remove leftmost char
                char left = s.charAt(i);
                if (map.containsKey(left)) {
                    map.put(left, map.get(left) + 1); // Restore frequency
                    if (map.get(left) == 1) {
                        count++; // Character requirement restored
                    }
                }

                // Step 5: Slide window forward
                i++;
                j++;
            }
        }
        return ans; // Return total count of anagram occurrences
    }
}

public class CountOccurrencesOfAnagrams {
    public static void main(String[] args) {
        anagrm a = new anagrm();
        String s = "aabaabaa";   // Input string
        String sub = "aaba";     // Substring to check anagrams of
        System.out.println(a.countOccurrenceOfAnagrams(s, sub));
        // Expected output: 4 (because "aaba" appears as an anagram 4 times)
    }
}
