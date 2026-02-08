package Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class Pair{
    public int value;
    public int index;

    public Pair(int value, int index){
        this.value = value;
        this.index = index;
    }
}

public class largestRectangleInHistogram {

    public int[] nearestSmallerToLeft(int[] nums){
        int n = nums.length;
        int[] arr = new int[n]; // Result list to store answers
        Stack<Pair> st = new Stack<>(); // Stack to keep track of potential smaller elements

        // Iterate through each element in the array → O(n)
        for(int i = 0; i < nums.length; i++){

            // Pop elements from stack until we find a smaller element or stack becomes empty
            // Each element is pushed and popped at most once → Amortized O(1) per operation, total O(n)
            while(st.size() > 0 && st.peek().value > nums[i]){
                st.pop();
            }

            // If stack is empty, no smaller element exists to the left
            if(st.size() == 0){
                arr[i] = -1;
            }
            // If stack top is smaller, that is the nearest smaller to left
            else if(st.peek().value < nums[i]){
                arr[i] = st.peek().index;
            }

            // Push current element to stack for future comparisons → O(1)
            st.add(new Pair(nums[i], i));
        }

        // Return the result list → O(1)
        return arr;

    }

    public int[] nearestSmallerToRight(int[] nums){

        Stack<Pair> st = new Stack<>();
        int n = nums.length;
        int[] right = new int[n];

        for(int i = n - 1; i >= 0; i--){

            while(st.size() > 0 && st.peek().value > nums[i]){
                st.pop();
            }

            if(st.size() == 0){
                right[i] = n;
            }
            else{
                right[i] = st.peek().index;
            }
            st.add(new Pair(nums[i], i));
        }

        return right;
    }

/*
Brute force approach


    public int largestRectangleArea(int[] nums) {

        int n = nums.length;
        int[] left = new int[n];//store count of maximum elemenet from left
        int[] right = new int[n];//store count of maximum element from right

        int count = 0;
        int right_count = -1;
        int max = 0;

        //traverse in left from curr_element;

        for(int i = 0; i < n; i++){
            count = 0;
            for(int j = i; j >= 0; j--){
                if(nums[i] <= nums[j]){
                    count++;
                }
                else {
                    break;
                }
            }
            left[i] = count;
        }

        //traverse in right
        for(int i = 0; i < n; i++){
            count = 0;
            for(int j = i; j < n; j++){
                if(nums[i] <= nums[j]){
                    count++;
                }
                else{
                    break;
                }
            }
            right[i] = count - 1;
        }

        for(int i = 0; i < n; i++){
            int val = nums[i] * left[i] + nums[i] * right[i];
            max = Math.max(max, val);
        }

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        return max;

    }

 */

/*
Optemize soluntion
 */

    public int largestRectangelArea(int[] nums){

        int max = 0;
        int n = nums.length;
        int[] left = new int[n];
        left = nearestSmallerToLeft(nums);
        int[] right = nearestSmallerToRight(nums);

        for(int i = 0;i < n; i++){

            int val = right[i] - left[i] - 1;

            max = Math.max(max, val * nums[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        largestRectangleInHistogram l = new largestRectangleInHistogram();

        int[] nums = {2,5,6,2,3};
        //System.out.println(l.largestRectangleArea(nums));
        System.out.println(Arrays.toString(l.nearestSmallerToLeft(nums)));
        System.out.println(Arrays.toString(l.nearestSmallerToRight(nums)));
        System.out.println(l.largestRectangelArea(nums));
    }
}
