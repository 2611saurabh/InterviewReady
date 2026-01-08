package DP.LIS;

class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {


        int n = nums1.length;
        int m = nums2.length;
        Integer[][] dp = new Integer[n + 1][m + 1];

        return solve(nums1, nums2, 0, 0,dp);

    }

    public int solve(int[] nums1, int[] nums2, int i, int j,Integer[][] dp){

        int n = nums1.length;
        int m = nums2.length;

        if(i == n || j == m){
            return Integer.MIN_VALUE;

        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        //four posibility
        int val = nums1[i] * nums2[j];
        int take_both_i_j = val + Math.max(0,solve(nums1, nums2, i + 1, j + 1,dp));
        int take_i = solve(nums1, nums2, i, j + 1,dp);
        int take_j = solve(nums1, nums2, i + 1, j,dp);

        int max1 = Math.max(val, take_both_i_j);
        int max2 = Math.max(take_i, take_j);
        return dp[i][j] = Math.max(max1, max2);


    }
}
public class maxDotProductOfTwoSubsequence1458 {
    public static void main(String[] args) {

        Solution s = new Solution();
        //Input: nums1 = [2,1,-2,5], nums2 = [3,0,-6]
        int[] nums1 = {2,1,-2,5};
        int[] nums2 = {3,0,-6};
        System.out.println(s.maxDotProduct(nums1, nums2));

    }
}
