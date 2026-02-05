package SlidingWindow;

import java.util.HashMap;

public class PickToys {
    public int picToys(String s, int k){

        int i = 0; // left pointer
        int j = 0; // right pointer
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while (j < s.length()){
            // Add current character to map
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            // Case 1: fewer than k distinct chars → expand window
            if(map.size() < k){
                j++;
            }
            // Case 2: exactly k distinct chars → valid window
            else if (map.size() == k) {
                max = Math.max(max, j - i + 1);
                j++;
            }
            // Case 3: more than k distinct chars → shrink window
            else {
                while (map.size() > k){
                    char ch = s.charAt(i); // update character each time
                    map.put(ch, map.get(ch) - 1);
                    if(map.get(ch) == 0){
                        map.remove(ch);
                    }
                    i++; // move left pointer
                }
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        PickToys p1 = new PickToys();
        String s = "abaccaabbccccc";
        int k = 2;
        System.out.println(p1.picToys(s,k));
        // Expected output: 7 (substring "aabbcccc" or "abbccccc")
    }
}
