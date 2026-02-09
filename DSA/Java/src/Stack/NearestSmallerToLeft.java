package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class NearestSmallerToLeft {

    // Function to find nearest smaller element to the left for each element in the array
    public ArrayList<Integer> nearestSmallerToLeft(int[] nums){
        ArrayList<Integer> arr = new ArrayList<>(); // Result list to store answers
        Stack<Integer> st = new Stack<>(); // Stack to keep track of potential smaller elements

        // Iterate through each element in the array → O(n)
        for(int i = 0; i < nums.length; i++){

            // Pop elements from stack until we find a smaller element or stack becomes empty
            // Each element is pushed and popped at most once → Amortized O(1) per operation, total O(n)
            while(st.size() > 0 && st.peek() > nums[i]){
                st.pop();
            }

            // If stack is empty, no smaller element exists to the left
            if(st.size() == 0){
                arr.add(-1);
            }
            // If stack top is smaller, that is the nearest smaller to left
            else if(st.peek() < nums[i]){
                arr.add(st.peek());
            }

            // Push current element to stack for future comparisons → O(1)
            st.add(nums[i]);
        }

        // Return the result list → O(1)
        return arr;
    }

    public static void main(String[] args) {
        NearestSmallerToLeft n = new NearestSmallerToLeft();
        int[] nums = {4,5,2,10,8};

        // Expected output: [-1, 4, -1, 2, 2]
        System.out.println(n.nearestSmallerToLeft(nums));
    }
}
