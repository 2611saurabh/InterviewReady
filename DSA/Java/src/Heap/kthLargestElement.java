package Heap;

import java.util.PriorityQueue;

public class kthLargestElement {

    public int kthLargestElement(int[] nums, int k) {

        // Step 1: Create a min-heap (default PriorityQueue)
        // Time Complexity: O(1) -> initialization
        // Space Complexity: O(1) -> empty heap initially
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Step 2: Iterate through all elements in nums[]
        // Loop runs n times (n = nums.length)
        for (int num : nums) {

            // Step 2a: Add element to heap
            // Time Complexity: O(log k) -> insertion into heap of size at most k
            // Space Complexity: O(k) -> heap stores at most k elements
            pq.add(num);

            // Step 2b: If heap size exceeds k, remove smallest element
            // Time Complexity: O(log k) -> removal from heap
            // Space Complexity: O(k) -> still bounded by k
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Step 3: Return the root of heap (kth largest element)
        // Time Complexity: O(1) -> peek operation
        // Space Complexity: O(1) -> no extra space used
        return pq.peek();
    }

    public static void main(String[] args) {
        kthLargestElement obj = new kthLargestElement();

        int[] nums = {7, 10, 3, 4, 20, 15};
        int k = 3;

        // Step 4: Print result
        // Time Complexity: O(1)
        // Space Complexity: O(1)
        System.out.println("Kth largest Element -> " + obj.kthLargestElement(nums, k));
    }
}
