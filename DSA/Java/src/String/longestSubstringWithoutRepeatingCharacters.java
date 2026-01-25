package String;

import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();
        int max_size = 0;

        for(int i = 0;  i < s.length(); i++){

            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                max_size = Math.max(max_size,set.size());
            }
            else{
                set.clear();
                if(s.charAt(i - 1) != s.charAt(i)){
                    set.add(s.charAt(i - 1));
                }
                set.add(s.charAt(i));
            }
        }

        return max_size;

    }
}

public class longestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        Solution s1 = new Solution();
        String s = "pwwkew";
        System.out.println(s1.lengthOfLongestSubstring(s));
    }
}
