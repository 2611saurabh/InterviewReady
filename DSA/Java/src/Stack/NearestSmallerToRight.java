package Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NearestSmallerToRight {

    // Function to find nearest smaller element to the right for each element
    public ArrayList<Integer> nearestSmallerToRight(int[] nums){
        ArrayList<Integer> arr = new ArrayList<>(); // Result list
        Stack<Integer> st = new Stack<>(); // Stack to track candidates

        // Traverse array from right to left
        for(int i = nums.length - 1; i >= 0; i--){

            // Step 1: Pop all elements greater or equal to current nums[i]
            // Ensures stack only keeps smaller elements
            while(st.size() > 0 && st.peek() >= nums[i]){
                st.pop();
            }

            // Step 2: If stack is empty, no smaller element exists to the right
            if(st.size() == 0){
                arr.add(-1);
            }
            // Step 3: Otherwise, top of stack is nearest smaller to right
            else if(st.size() > 0 && st.peek() < nums[i]){
                arr.add(st.peek());
            }

            // Step 4: Push current element into stack for future comparisons
            st.add(nums[i]);
        }

        // Step 5: Reverse result list because we traversed from right to left
        Collections.reverse(arr);
        return arr;
    }

    public static void main(String[] args) {
        NearestSmallerToRight n = new NearestSmallerToRight();
        int[] nums = {4,5,2,10,8};

        // Expected output: [2,2,-1,8,-1]
        System.out.println(n.nearestSmallerToRight(nums));
    }
}
