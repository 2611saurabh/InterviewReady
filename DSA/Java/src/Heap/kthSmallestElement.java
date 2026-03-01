package Heap;

import java.util.PriorityQueue;

public class kthSmallestElement {

    public int kthSmallestElement(int[] nums, int k){

        // Step 1: Create a maxHeap using custom comparator
        // Time Complexity: O(1) -> just initialization
        // Space Complexity: O(1) -> empty heap initially
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        // Step 2: Iterate through all elements in nums[]
        // Loop runs n times (n = nums.length)
        for(int i = 0; i < nums.length; i++){

            // Step 2a: Add element to heap
            // Time Complexity: O(log k) -> insertion into heap of size at most k
            // Space Complexity: O(k) -> heap stores at most k elements
            pq.add(nums[i]);

            // Step 2b: If heap size exceeds k, remove largest element
            // Time Complexity: O(log k) -> removal from heap
            // Space Complexity: O(k) -> still bounded by k
            if(pq.size() > k){
                pq.poll();
            }
        }

        // Step 3: Return the root of heap (kth smallest element)
        // Time Complexity: O(1) -> peek operation
        // Space Complexity: O(1) -> no extra space used
        return pq.peek();
    }

    public static void main(String[] args) {

        kthSmallestElement obj = new kthSmallestElement();

        int[] nums = {7,10,4,3,20,15};
        int k = 3;

        // Step 4: Print result
        // Time Complexity: O(1)
        // Space Complexity: O(1)
        System.out.println("Kth Smallest Element in Array -> " + (obj.kthSmallestElement(nums, k)));
    }
}

/*
Time Complexity:

Heap insertion/removal happens at most n times.

Each operation costs O(log k) since heap size is bounded by k.

Overall = O(n log k)

Space Complexity:

Heap stores at most k elements.

Overall = O(k)
 */