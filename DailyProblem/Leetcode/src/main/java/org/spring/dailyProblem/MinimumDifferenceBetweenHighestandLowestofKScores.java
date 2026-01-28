package org.spring.dailyProblem;

import java.util.Arrays;

public class MinimumDifferenceBetweenHighestandLowestofKScores {

    public int minimumDifference(int[] nums, int k) {

        // Case 1: If array has only one element, difference is 0 → O(1)
        if(nums.length == 1){
            return 0;
        }

        // Case 2: If array has exactly two elements → O(1)
        if(nums.length == 2){
            int max = Math.max(nums[0], nums[1]);   // O(1)
            int min = Math.min(nums[0], nums[1]);   // O(1)
            if(nums[0] == nums[1]){                 // O(1)
                return 0;
            }
            else{
                return max - min;                   // O(1)
            }
        }

        // Step 1: Sort the array so that elements are in ascending order
        // Time Complexity: O(n log n), Space Complexity: O(1) (in-place sort for primitive arrays)
        Arrays.sort(nums);

        // Step 2: Initialize variables → O(1)
        int min = Integer.MAX_VALUE;   // to store minimum value in current window
        int max = Integer.MIN_VALUE;   // to store maximum value in current window
        int j = k - 1;                 // right pointer of window (size k)
        int ans = Integer.MAX_VALUE;   // final answer (minimum difference found)
        int i = 0;                     // left pointer of window

        // Step 3: Sliding window of size k across sorted array
        // Time Complexity: O(n), Space Complexity: O(1)
        while(j < nums.length){

            min = nums[i];             // O(1)
            max = nums[j];             // O(1)
            ans = Math.min(ans, max - min); // O(1)

            i++;                       // O(1)
            j++;                       // O(1)
        }

        // Step 4: Return the minimum difference found → O(1)
        return ans;
    }


    public static void main(String[] args) {

        MinimumDifferenceBetweenHighestandLowestofKScores m = new MinimumDifferenceBetweenHighestandLowestofKScores();

        // Example input
        int[] nums = {41900,69441,94407,37498,20299,10856,36221,2231,54526,79072,84309,76765,92282,13401,44698,17586,98455,47895,98889,65298,32271,23801,83153,12186,7453,79460,67209,54576,87785,47738,40750,31265,77990,93502,50364,75098,11712,80013,24193,35209,56300,85735,3590,24858,6780,50086,87549,7413,90444,12284,44970,39274,81201,43353,75808,14508,17389,10313,90055,43102,18659,20802,70315,48843,12273,78876,36638,17051,20478};
        int value = m.minimumDifference(nums,5);

        // Output result
        System.out.println(value);
        System.gc();
    }
}

/*
-----------------------------------------
⏱ Time Complexity:
- Sorting: O(n log n)
- Sliding window: O(n)
- Total: O(n log n)

💾 Space Complexity:
- Sorting (primitive array): O(1) extra space
- Variables: O(1)
- Total: O(1)
-----------------------------------------
*/
