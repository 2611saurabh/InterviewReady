package Stack;

import java.util.Arrays;
import java.util.Stack;

// Helper class to store both value and index in the stack
/*
class Pair {
    public int value;  // stock price
    public int index;  // day index

    public Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }
}
*/


public class StockSpan {

    public int[] stockSpan(int nums[]) {
        int n = nums.length;
        int[] arr = new int[n];           // result array to store spans
        Stack<Pair> st = new Stack<>();   // stack to keep track of previous prices

        // Iterate through each day
        for (int i = 0; i < n; i++) {
            // Step 1: Pop all elements from stack that are <= current price
            // Because they are part of the span (current price is higher)
            while (!st.isEmpty() && st.peek().value <= nums[i]) {
                st.pop();
            }

            // Step 2: If stack is empty, it means all previous prices are smaller
            // So span = i + 1 (all days till now)
            if (st.isEmpty()) {
                arr[i] = i + 1;
            } else {
                // Step 3: Otherwise, span = distance between current day and last greater price
                arr[i] = i - st.peek().index;
            }

            // Step 4: Push current price and index onto stack
            st.push(new Pair(nums[i], i));

            // Debugging/iteration explanation:
            // At this point, arr[i] contains the span for day i
            // Stack contains useful "previous greater" elements for future iterations
        }
        return arr;
    }

    public static void main(String[] args) {
        StockSpan s = new StockSpan();
        int[] nums = {100, 80, 60, 70, 60, 75, 85};

        // Expected output: [1, 1, 1, 2, 1, 4, 6]
        System.out.println(Arrays.toString(s.stockSpan(nums)));
    }
}
