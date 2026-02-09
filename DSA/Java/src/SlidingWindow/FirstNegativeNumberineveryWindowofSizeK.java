package SlidingWindow;

import java.util.ArrayList;

class solution{
    public ArrayList<Integer> firstNegativeinEverywindow(int[] nums, int k){
        ArrayList<Integer> ans = new ArrayList<>();

        int n = nums.length;

        /** Brute force approach
        for(int i = 0; i < n - k; i++){

            for(int j = i; j < k + i; j++){
                if(nums[j] < 0){
                    ans.add(nums[j]);
                    break;
                }
            }
        }
         **/
        int i = 0;
        int j = 0;
        ArrayList<Integer> res = new ArrayList<>();
        //sliding window Approach
        while(j < n){
            if(nums[j] < 0){
                ans.add(nums[j]);

            }
            if(j - i + 1 < k){
                j++;
            }
            else if(j - i + 1 == k){
                if(ans.size() == 0){
                    res.add(0);
                }
                else {
                    res.add(ans.getFirst());
                    if(ans.getFirst() == nums[i]){
                        ans.remove(ans.getFirst());
                    }

                }
                i++;
                j++;

            }
        }

        return res;
    }
}

public class FirstNegativeNumberineveryWindowofSizeK {

    public static void main(String[] args) {
        solution s1 = new solution();

        int[] nums = {12,-1,-7,8,-16,30,16,28};
        int k = 3;
        System.out.println(s1.firstNegativeinEverywindow(nums, k));
    }
}
