package String;

import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        // HashMap to store frequency of characters in current window
        HashMap<Character, Integer> map = new HashMap<>();

        int n = s.length();   // length of input string
        int i = 0;            // left pointer of sliding window
        int j = 0;            // right pointer of sliding window
        int max = 0;          // result: length of longest substring without repeating characters

        // Sliding window traversal
        while (j < n) {
            // Step 1: Add current character to map (increase frequency)
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

            // Step 2: If window size equals number of unique characters → valid substring
            if (map.size() == j - i + 1) {
                max = Math.max(max, j - i + 1); // update max length
                j++; // expand window
            }
            // Step 3: If duplicates exist (map.size() < window size)
            else if (map.size() < j - i + 1) {
                // Shrink window until valid
                while (map.size() < j - i + 1) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1); // decrement frequency
                    if (map.get(s.charAt(i)) == 0) {
                        map.remove(s.charAt(i)); // remove character if count becomes 0
                    }
                    i++; // move left pointer forward
                }
                j++; // expand window
            }
        }
        return max; // return longest substring length
    }
}

public class longestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        String s = "pwwkew";
        System.out.println(s1.lengthOfLongestSubstring(s));
        // Expected output: 3 ("wke")
    }
}
 lll
/*
-----------------------------------------
⏱ Time Complexity:
- Each character is processed at most twice (once by j, once by i).
- Total: O(n), where n = length of string.

💾 Space Complexity:
- HashMap stores at most all unique characters in the string.
- Worst case: O(min(n, charset)), for ASCII → O(1), for Unicode → bounded by charset size.
-----------------------------------------
*/
