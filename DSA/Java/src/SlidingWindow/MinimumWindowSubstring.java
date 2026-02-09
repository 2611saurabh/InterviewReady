package SlidingWindow;

import java.util.HashMap;

public class MinimumWindowSubstring {

    public int minimumWindwoSubstring(String s, String t){
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int i = 0;
        int j = 0;
        int count = map.size();
        int max = 0;

        while (j < s.length());

        return 1;

    }

    public static void main(String[] args) {
        MinimumWindowSubstring m1 = new MinimumWindowSubstring();

        String s = "foxxofssdodfofdogdddoogggeedog";
        String t = "ogdd";

        System.out.println(m1.minimumWindwoSubstring(s,t));
    }
}
