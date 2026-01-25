package SlidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class maxOfSubarray {
    public int[] maxOfAllSubarrayOfSizeK(int[] nums, int k) {

        Deque<Integer> q = new ArrayDeque<>();  // ✅ Deque to store indices of useful elements (potential max values)
        List<Integer> res = new ArrayList<>();  // ✅ Result list to store maximums of each window

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {

            // Step 1: Remove all smaller elements from the back of deque
            // Because they can never be maximum if current element is larger
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast();
            }

            // Step 2: Add current element's index to the deque
            q.addLast(i);

            // Step 3: Remove the front element if it is outside the current window
            // Window size is k, so if front index == i - k, it means it's too old
            if (q.getFirst() == i - k) {
                q.removeFirst();
            }

            // Step 4: Once we have processed at least k elements (i >= k-1),
            // the front of deque is the maximum of the current window
            if (i >= k - 1) {
                res.add(nums[q.peek()]);
            }
        }

        // Convert result list to array
        return res.stream().mapToInt(i -> i).toArray();
    }
}

public class Maximumofallsubarraysofsizek {
    public static void main(String[] args) {
        maxOfSubarray m = new maxOfSubarray();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = m.maxOfAllSubarrayOfSizeK(nums, k);

        // Expected output: [3, 3, 5, 5, 6, 7]
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
