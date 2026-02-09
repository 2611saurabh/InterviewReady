package Stack;

import java.util.*;

public class NearestGreatertoright {
    public ArrayList<Integer> nearestGreaterToRight(int[] nums){

        ArrayList<Integer> ans = new ArrayList<>(); // Stores final answers
        Stack<Integer> st = new Stack<>(); // Stack to keep track of "next greater elements"

        // Traverse array from right to left
        for(int i = nums.length - 1; i >= 0; i--){

            // Case 1: Stack is empty → no greater element to the right
            if(st.size() == 0){
                ans.add(-1);
            }
            // Case 2: Top of stack is greater than current element → next greater found
            else if(st.size() > 0 && st.peek() > nums[i]){
                ans.add(st.peek());
            }
            // Case 3: Top of stack <= current element → pop until greater element found
            else if(st.size() > 0 && st.peek() <= nums[i]){

                // Pop smaller/equal elements
                while(st.size() > 0 && st.peek() <= nums[i]){
                    st.pop(); // O(1) per pop
                }

                // After popping, check if stack is empty
                if(st.size() == 0){
                    ans.add(-1); // No greater element
                }
                else{
                    ans.add(st.peek()); // Found greater element
                }
            }

            // Push current element into stack for future comparisons
            st.push(nums[i]);
        }

        // Reverse answer list since we traversed from right to left
        Collections.reverse(ans);

        return ans;
    }

    public static void main(String[] args) {
        NearestGreatertoright n = new NearestGreatertoright();
        int[] nums = {1,3,0,0,1,2,4};
        System.out.println(n.nearestGreaterToRight(nums));
        // Output: [3, 4, 1, 1, 2, 4, -1]
    }
}
/*
⚙️ Time Complexity Analysis (Step by Step)
st.size() == 0 check: O(1)

st.peek() comparison: O(1)

st.pop() inside while loop: Each element is pushed and popped at most once → amortized O(1) per element.

st.push(nums[i]): O(1)

Collections.reverse(ans): O(n)

👉 Overall Time Complexity:

Each element is processed once (push + pop at most once).

Total = O(n), where n = nums.length.

💾 Space Complexity Analysis
Stack st: At most n elements → O(n).

Answer list ans: Stores n results → O(n).

Auxiliary variables: O(1).

👉 Overall Space Complexity: O(n).

✅ Final Complexity
Time Complexity: O(n)

Space Complexity: O(n)
 */