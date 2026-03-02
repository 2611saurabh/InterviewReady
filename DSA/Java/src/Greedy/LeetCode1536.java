package Greedy;

class MinSwaps {

    // Utility function to swap two elements in an array
    // Time Complexity: O(1), Space Complexity: O(1)
    public void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public int minSwaps(int[][] grid) {

        int n = grid.length;       // number of rows
        int m = grid[0].length;    // number of columns (same as n since it's n x n)
        int count = 0;
        int[] endZero = new int[n]; // stores trailing zeros count for each row
        // Space Complexity: O(n) for endZero array

        // Step 1: Calculate trailing zeros for each row
        // Time Complexity: O(n^2) because we scan each row fully
        for(int i = 0; i < n; i++){

            for(int j = m - 1; j > 0; j--){

                if(grid[i][j] == 1){
                    // Stop counting when we hit a 1
                    break;
                }
                else{
                    // Count trailing zeros
                    count++;
                }
            }
            endZero[i] = count; // store trailing zeros for row i
            count = 0;          // reset for next row
        }

        int steps = 0; // total swaps required

        // Step 2: Greedy placement of rows
        // Time Complexity: O(n^2) in worst case (nested while loops + swaps)
        for(int i = 0; i < n; i++){

            int need = n - i - 1;   // how many trailing zeros this row must have

            int j = i;

            // Find the first row below i that satisfies the requirement
            while(j < n && endZero[j] < need){
                j++;
            }

            // If no such row exists, it's impossible
            if(j == n){
                return -1;
            }

            // Add the number of swaps needed to bring row j up to position i
            steps += j - i;

            // Simulate bubbling row j upwards by swapping
            while(j > i){
                swap(endZero, j, j - 1);
                j--;
            }
        }

        return steps; // return total swaps
    }
}


public class LeetCode1536 {
}
