package Stack;

import java.util.Stack;

public class MaxAreaRectangleinbinarymatrix {

    // Nearest Smaller to Left (NSL)
    public int[] nsl(int[] nums) {
        Stack<Pair> st = new Stack<>();
        int[] arr = new int[nums.length];

        for (int j = 0; j < nums.length; j++) {
            // Pop until we find a smaller element
            while (!st.isEmpty() && st.peek().value >= nums[j]) {
                st.pop();
            }

            // If stack empty, no smaller element to left
            arr[j] = st.isEmpty() ? -1 : st.peek().index;

            // Push current element
            st.push(new Pair(nums[j], j));
        }
        return arr;
    }
    // Time Complexity: O(n)
    // Space Complexity: O(n)

    // Nearest Smaller to Right (NSR)
    public int[] nsr(int[] nums) {
        Stack<Pair> st = new Stack<>();
        int n = nums.length;
        int[] right = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            // Pop until we find a smaller element
            while (!st.isEmpty() && st.peek().value >= nums[i]) {
                st.pop();
            }

            // If stack empty, no smaller element to right
            right[i] = st.isEmpty() ? n : st.peek().index;

            // Push current element
            st.push(new Pair(nums[i], i));
        }
        return right;
    }
    // Time Complexity: O(n)
    // Space Complexity: O(n)

    // Largest Rectangle Area in Histogram
    public int largestRectangleArea(int[] nums) {
        int n = nums.length;
        int[] left = nsl(nums);   // nearest smaller to left
        int[] right = nsr(nums);  // nearest smaller to right

        int max = 0;
        for (int i = 0; i < n; i++) {
            // width = right boundary - left boundary - 1
            int width = right[i] - left[i] - 1;
            int area = nums[i] * width;
            max = Math.max(max, area);
        }
        return max;
    }
    // Time Complexity: O(n)
    // Space Complexity: O(n)

    // Maximal Rectangle in Binary Matrix
    public int maximalRectangle(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[] heights = new int[m]; // histogram heights
        int maxArea = 0;

        // Process each row
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                // Update histogram height
                if (mat[row][col] == 1) {
                    heights[col] += 1; // accumulate consecutive 1s
                } else {
                    heights[col] = 0;  // reset if 0
                }
            }
            // Compute largest rectangle for current histogram
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }
    // Time Complexity: O(n * m) → each row processed with O(m) histogram calculation
    // Space Complexity: O(m) → heights array + O(m) for stacks

    public static void main(String[] args) {
        MaxAreaRectangleinbinarymatrix solver = new MaxAreaRectangleinbinarymatrix();

        int[][] mat = {
                {0,1,1,0},
                {1,1,1,1},
                {1,1,1,1},
                {1,1,0,0}
        };

        System.out.println("Maximal Rectangle Area = " + solver.maximalRectangle(mat));
    }
}
/*
/*
Time Complexity:

For each of n rows, we update m columns → O(n * m).
For each row, we compute largest rectangle in histogram → O(m).
Total = O(n * m).

Space Complexity:

Heights array = O(m).
Stack in NSL/NSR = O(m).
Total = O(m).
*/

 */