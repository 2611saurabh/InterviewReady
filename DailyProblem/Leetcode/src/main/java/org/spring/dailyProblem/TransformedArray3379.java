package org.spring.dailyProblem;

import java.util.Arrays;

public class TransformedArray3379 {

    public int[] constructTransformedArray(int[] nums) {
        int[] res = new int[nums.length];

        int n = nums.length;

        for(int i = 0; i < nums.length; i++){

            //if value to large then we put witing range
            int shift = nums[i] % n;

            int newIndex = (i + shift) % n;

            if(newIndex < 0){
                newIndex += n;
            }
            res[i] = nums[newIndex];
        }

        return res;

    }

    public static void main(String[] args) {
        TransformedArray3379 t = new TransformedArray3379();
        int[] nums = {3,-2,1,1};
        System.out.println(Arrays.toString(t.constructTransformedArray(nums)));
    }
}
