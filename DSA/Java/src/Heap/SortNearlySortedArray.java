package Heap;

import java.util.*;

public class SortNearlySortedArray {

    public List<Integer> sortNearlySortedArray(int[] nums, int k) {

        // Step 1: Create a min-heap
        // Time Complexity: O(1) -> initialization
        // Space Complexity: O(1) -> empty heap initially
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        List<Integer> result = new ArrayList<>();

        // Step 2: Add first k+1 elements to heap
        // Time Complexity: O((k+1) log (k+1)) ≈ O(k log k)
        // Space Complexity: O(k)
        for (int i = 0; i <= k && i < nums.length; i++) {
            pq.add(nums[i]);
        }

        // Step 3: Process remaining elements
        // Loop runs (n - (k+1)) times
        for (int i = k + 1; i < nums.length; i++) {

            // Step 3a: Extract min (next sorted element)
            // Time Complexity: O(log k)
            result.add(pq.poll());

            // Step 3b: Add current element to heap
            // Time Complexity: O(log k)
            pq.add(nums[i]);
        }

        // Step 4: Extract remaining elements from heap
        // Time Complexity: O(k log k)
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        // Step 5: Return sorted result
        // Time Complexity: O(1)
        // Space Complexity: O(n)
        return result;
    }

    public static void main(String[] args) {
        SortNearlySortedArray obj = new SortNearlySortedArray();

        int[] nums = {6, 5, 3, 2, 8, 10, 4};
        int k = 3;

        System.out.println("Sorted Array -> " + obj.sortNearlySortedArray(nums, k));
    }
}
