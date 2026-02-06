package org.spring.dailyProblem;

import java.util.Arrays;

public class MinimumRemovalsToBalanaceArray3634 {

    public int minRemoval(int[] nums, int k) {

        int n = nums.length;
        int i = 0;
        int j = 0;
        int max = nums[0];
        int min = nums[0];
        int len = 1;
        Arrays.sort(nums);

        while(j  < n){
            max = nums[j];
            min = nums[i];

            while(i < j && max > (long)k * min){
                i++;
                min = nums[i];
            }
            len = Math.max(len, j - i + 1);
            j++;
        }

        return n - len;



    }

    public static void main(String[] args) {

        MinimumRemovalsToBalanaceArray3634 m = new MinimumRemovalsToBalanaceArray3634();

        int[] nums = {10,30,11};
        int k = 2;

        System.out.println(m.minRemoval(nums, k));
    }
}
