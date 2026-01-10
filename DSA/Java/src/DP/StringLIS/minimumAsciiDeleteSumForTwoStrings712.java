package DP.StringLIS;

import java.util.Arrays;

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(s1,s2,0,0,dp);


    }

    public int solve(String s1, String s2, int i, int j,int[][] dp){

        if(i >= s1.length() && j >= s2.length()){
            return 0;
        }
        if(i >= s1.length()){
            return s2.charAt(j) + solve(s1,s2,i,j+1,dp);
        }
        if(j >= s2.length()){
            return s1.charAt(i) + solve(s1,s2,i + 1, j,dp);
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = solve(s1,s2,i + 1, j + 1,dp);
        }



        int delete_i = s1.charAt(i) + solve(s1,s2,i + 1, j,dp);
        int delete_j = s2.charAt(j) + solve(s1,s2,i, j + 1,dp);

        return dp[i][j] = Math.min(delete_i,delete_j);
    }
}

public class minimumAsciiDeleteSumForTwoStrings712 {
}
